package perpustakaan;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class perpustakaan {

    private ArrayList<Object> Koleksi = new ArrayList<Object>();
    private int borrowDate;
    private int returnDate;
    private int deadlineReturn;

    public void tambahBuku(BukuFiksi buku) {
        Koleksi.add(buku);
    }

    public void tambahBuku(BukuNonFiksi buku) {
        Koleksi.add(buku);
    }

    public void displayBook() {
        Scanner pause = new Scanner(System.in);
        System.out.print("\033[H\033[2J");
        System.out.flush();

        System.out.println("|------ Book Collection ------|");
        for (Object buku : Koleksi) {
            if (buku instanceof BukuFiksi) {
                ((BukuFiksi) buku).tampilkanInformasi();
            } else if (buku instanceof BukuNonFiksi) {
                ((BukuNonFiksi) buku).tampilkanInformasi();
            }
        }
        pause.nextLine();
    }

    public void pinjamBuku(User user) {
        Scanner pause = new Scanner(System.in);
        Scanner scanner = new Scanner(System.in);
        boolean found = false;
        char another = 'Y';
        while (!found && another == 'Y') {
            found = false;
            another = 'Y';

            System.out.print("\033[H\033[2J");
            System.out.flush();

            System.out.println("---- BORROW BOOK -----");
            System.out.println("Title Book :");
            String title = scanner.nextLine();
            for (Object buku : Koleksi) {
                if (buku instanceof BukuFiksi) {
                    BukuFiksi book = (BukuFiksi) buku;
                    if (book.getJudul().equalsIgnoreCase(title)) {
                        if (book.getStock() == 0) {
                            System.out.println(("----ALERT----"));
                            System.out.println("Book is out of stock");
                            pause.nextLine();
                            return;
                        }
                        int date = BorrowDate();
                        book.setTanggalPinjam(date);
                        book.setDeadlineReturn();
                        user.addPinjam(book);
                        System.out.print("\033[H\033[2J");
                        System.out.flush();
                        System.out.println("---- SUCCESSFULLY BORROWED ----");
                        System.out.println();
                        book.tampilkanInformasi();
                        System.out.println("Deadline Return : " + book.getDeadlineReturn());
                        book.setBorrowStock();
                        found = true;
                        break;
                    }
                } else if (buku instanceof BukuNonFiksi) {
                    BukuNonFiksi book = (BukuNonFiksi) buku;
                    if (book.getJudul().equalsIgnoreCase(title)) {
                        if (book.getStock() == 0) {
                            System.out.println(("----ALERT----"));
                            System.out.println("Book is out of stock");
                            pause.nextLine();
                            return;
                        }
                        int date = BorrowDate();
                        book.setTanggalPinjam(date);
                        book.setDeadlineReturn();
                        user.addPinjam(book);
                        System.out.print("\033[H\033[2J");
                        System.out.flush();
                        System.out.println("---- SUCCESSFULLY BORROWED ----");
                        book.tampilkanInformasi();
                        System.out.println("Deadline Return : " + book.getDeadlineReturn());
                        book.setBorrowStock();
                        found = true;
                        break;
                    }
                }

            }
            if (!found) {
                System.out.println("----ALERT----");
                System.out.println("BOOK NOT FOUND");
                System.out.println("Want to find another book? (Y/N)");
                another = scanner.nextLine().toUpperCase().charAt(0);
            } else {
                pause.nextLine();
                return;
            }
        }

    }

    public void kembalikanBuku(User user) {
        Scanner scanner = new Scanner(System.in);
        Scanner pause = new Scanner(System.in);
        boolean found = false;
        char another = 'Y';

        while (!found && another == 'Y') {

            System.out.print("\033[H\033[2J");
            System.out.flush();
            if (user.getListPinjam().isEmpty()) {
                System.out.println("---- ALERT ----");
                System.out.println("YOU HAVE NOT BORROWED ANY BOOK");
                pause.nextLine();
                return;
            }
            System.out.println("---- RETURN BOOK -----");
            System.out.println("Title Book :");
            String title = scanner.nextLine();

            for (Object buku : user.getListPinjam()) {
                if (buku instanceof BukuFiksi) {
                    BukuFiksi book = (BukuFiksi) buku;
                    if (book.getJudul().equalsIgnoreCase(title)) {
                        System.out.println("Borrow Date : " + book.getTanggalPinjam());
                        System.out.println("Deadline Return : " + book.getDeadlineReturn());
                        int date = ReturnDate();
                        book.setTanggalKembali(date);

                        if (date > book.getDeadlineReturn()) {
                            paymnentDenda(book.getDenda(), book.getDeadlineReturn() - book.getTanggalKembali());
                        }

                        user.deletePinjam(book);
                        book.setBorrowedStock();
                        System.out.println("--- BOOK HAS SUCCESSFULLY DELETED ---");
                        book.tampilkanInformasi();

                        found = true;
                        break;
                    }
                } else if (buku instanceof BukuNonFiksi) {
                    BukuNonFiksi book = (BukuNonFiksi) buku;
                    if (book.getJudul().equalsIgnoreCase(title)) {
                        System.out.println("Borrow Date : " + book.getTanggalPinjam());
                        System.out.println("Deadline Return : " + book.getDeadlineReturn());
                        int date = ReturnDate();
                        book.setTanggalKembali(date);

                        if (date > deadlineReturn) {
                            paymnentDenda(book.getDenda(), book.getTanggalKembali() - book.getDeadlineReturn());
                        }

                        user.deletePinjam(book);
                        book.setBorrowedStock();
                        System.out.println("--- BOOK HAS SUCCESSFULLY DELETED ---");
                        book.tampilkanInformasi();

                        found = true;
                        break;
                    }
                }
            }
            if (!found) {
                System.out.println("----ALERT----");
                System.out.println("BOOK NOT FOUND");
                System.out.println("Want to find another book? (Y/N)");
                another = scanner.nextLine().toUpperCase().charAt(0);
            } else {
                pause.nextLine();
                break;
            }

        }

    }

    private int BorrowDate() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("Borrowing Date : ");
                borrowDate = scanner.nextInt();
                if (borrowDate >= 1 && borrowDate <= 31) {
                    break;
                } else {
                    System.out.println("INVALID INPUT DATE ( 1 - 31)!!");
                }
            } catch (InputMismatchException e) {
                System.out.println("INVALID INPUT DATE ( 1 - 31)");
                System.out.println("Borrowing Date : ");
                scanner.next();
            }
        }

        return borrowDate;
    }

    private int ReturnDate() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("Return Date : ");
                returnDate = scanner.nextInt();
                if (returnDate >= borrowDate && returnDate <= 31 && returnDate > 0) {
                    break;
                } else {
                    System.out.println("INVALID INPUT DATE ( 1 - 31)!!");
                }

            } catch (InputMismatchException e) {
                System.out.println("INVALID INPUT DATE ( 1 - 31)");
                System.out.println("Return Date : ");
                scanner.next();
            }
        }
        return returnDate;
    }

    private void paymnentDenda(double denda, int dayLate) {
        Scanner scanner = new Scanner(System.in);
        double payment = 0;
        double change = 0;
        while (payment < denda) {
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println("---- PENALTY PAYMENT ----");
            System.out.println("Late Return Days : " + (dayLate));
            System.out.println("Penalty : Rp " + denda);
            System.out.print("Money : ");
            payment = scanner.nextDouble();
            if (payment < denda) {
                System.out.println("MONEY NOT ENOUGH");
            } else if (payment > denda) {
                change = payment - denda;
                System.out.println("---- PAYMENT SUCCESSFUL ----");
                System.out.println("Money Change : " + change);
            } else {
                System.out.println("---- PAYMENT SUCCESSFUL ----");
            }
        }
    }

}
