package perpustakaan;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.function.Function;

public class perpustakaan {

    private ArrayList<Object> Koleksi = new ArrayList<Object>();
    Scanner scanner = new Scanner(System.in);
    private Buku Book = null;
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

        System.out.println("-- Book Collection --");
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
        boolean found = false;
        while (!found) {
            System.out.print("\033[H\033[2J");
            System.out.flush();
        }
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
                        return;
                    }
                    int date = BorrowDate();
                    deadlineReturn = date + 7;
                    book.setTanggalPinjam(date);
                    book.setDeadlineReturn(deadlineReturn);
                    user.addPinjam(book);
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    System.out.println("---- SUCCESSFULLY BORROWED ----");
                    System.out.println();
                    book.tampilkanInformasi();
                    System.out.println("Deadline Return : " + deadlineReturn);
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
                        return;
                    }
                    int date = BorrowDate();
                    deadlineReturn = date + 7;
                    book.setTanggalPinjam(date);
                    book.setDeadlineReturn(deadlineReturn);
                    user.addPinjam(book);
                    System.out.println("---- SUCCESSFULLY BORROWED ----");
                    System.out.println();
                    book.tampilkanInformasi();
                    System.out.println("Deadline Return : " + deadlineReturn);
                    book.setBorrowStock();
                    found = true;
                    break;
                }
            }

        }
        if (!found) {
            System.out.println("BOOK NOT FOUND");
        }
        pause.nextLine();
    }

    public void kembalikanBuku(User user) {
        Scanner pause = new Scanner(System.in);
        boolean found = false;
        while (!found) {
            System.out.print("\033[H\033[2J");
            System.out.flush();
        }
        System.out.println("---- RETURN BOOK -----");
        System.out.println("Title Book :");
        String title = scanner.nextLine();
        System.out.println("");

        for (Object buku : user.getListPinjam()) {
            if (buku instanceof BukuFiksi) {
                BukuFiksi book = (BukuFiksi) buku;
                if (book.getJudul().equalsIgnoreCase(title)) {
                    int date = ReturnDate();
                    book.setTanggalKembali(date);
                    user.deletePinjam(book);
                    book.tampilkanInformasi();
                    book.setBorrowedStock();
                    found = true;
                    break;
                }
            } else if (buku instanceof BukuNonFiksi) {
                BukuNonFiksi book = (BukuNonFiksi) buku;
                if (book.getJudul().equalsIgnoreCase(title)) {
                    int date = ReturnDate();

                    book.setTanggalKembali(date);
                    if (date > deadlineReturn) {
                        book.setDenda();
                    }
                    user.deletePinjam(book);
                    book.tampilkanInformasi();
                    book.setBorrowedStock();
                    found = true;
                    break;
                }
            }
        }
        if (!found) {
            System.out.println("----ALERT----");
            System.out.println("BOOK NOT FOUND");
        }
        pause.nextLine();
    }

    private int BorrowDate() {
        try {
            System.out.println("Borrowing Date : ");
            borrowDate = scanner.nextInt();
            if (borrowDate < 1 || borrowDate > 31) {
                throw new InputMismatchException();
            }
        } catch (InputMismatchException e) {
            System.out.println("INVALID INPUT DATE ( 1 - 31)");
            System.out.println("Borrowing Date : ");
            scanner.next();
        }
        return borrowDate;
    }

    private int ReturnDate() {
        try {
            System.out.println("Return Date : ");
            returnDate = scanner.nextInt();
            if (returnDate > borrowDate && (returnDate < 1 || returnDate > 31)) {
                throw new InputMismatchException();
            }
        } catch (InputMismatchException e) {
            System.out.println("INVALID INPUT DATE ( 1 - 31)");
            System.out.println("Return Date : ");
            scanner.next();
        }
        return returnDate;
    }

    private void paymnentDenda(double denda) {
        double payment = 0;
        double change = 0;
        while (payment < denda) {
            System.out.println("---- PENALTY PAYMENT ----");
            System.out.println("Penalty : " + denda);
            System.out.println("Money : ");
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
