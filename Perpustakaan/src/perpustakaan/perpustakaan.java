package perpustakaan;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class perpustakaan {

    private ArrayList<Object> Koleksi = new ArrayList<Object>();
    Scanner scanner = new Scanner(System.in);
    private BukuFiksi fictionBook = null;
    private int borrowDate;
    private int returnDate;

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
        boolean found = false;
        System.out.println("---- BORROW BOOK -----");
        System.out.println("Title Book :");
        String title = scanner.nextLine();
        for (Object buku : Koleksi) {
            if (buku instanceof BukuFiksi) {
                fictionBook = (BukuFiksi) buku;
                if (fictionBook.getJudul().equalsIgnoreCase(title)) {
                    if (fictionBook.getStock() == 0) {
                        System.out.println(("----ALERT----"));
                        System.out.println("Book is out of stock");
                        return;
                    }

                    try {
                        System.out.println("Borrowing Date : ");
                        borrowDate = scanner.nextInt();
                        if (borrowDate < 1 || borrowDate > 31) {
                            throw new InputMismatchException("INVALID INPUT DATE ( 1 - 31)");
                        }
                    } catch (InputMismatchException e) {

                    }

                    user.addPinjam(fictionBook);
                    fictionBook.tampilkanInformasi();
                    fictionBook.setBorrowStock();
                    found = true;
                    break;
                }
            } else if (buku instanceof BukuNonFiksi) {
                BukuNonFiksi book = (BukuNonFiksi) buku;
                if (book.getJudul().equalsIgnoreCase(title)) {
                    user.addPinjam(book);
                    book.tampilkanInformasi();
                    book.setBorrowStock();
                    found = true;
                    break;
                }
            }
        }

        if (!found) {
            System.out.println("BOOK NOT FOUND");
        }

    }

    public void kembalikanBuku(User user) {
        boolean found = false;
        System.out.println("---- RETURN BOOK -----");
        System.out.println("Title Book :");
        String title = scanner.nextLine();
        System.out.println("");

        for (Object buku : user.getListPinjam()) {
            if (buku instanceof BukuFiksi) {
                BukuFiksi book = (BukuFiksi) buku;
                if (book.getJudul().equalsIgnoreCase(title)) {

                    user.deletePinjam(book);
                    book.tampilkanInformasi();
                    book.setBorrowedStock();
                    found = true;
                    break;
                }
            } else if (buku instanceof BukuNonFiksi) {
                BukuNonFiksi book = (BukuNonFiksi) buku;
                if (book.getJudul().equalsIgnoreCase(title)) {
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
    }

    private double hitungDenda(Object buku) {
        double denda = 0;

        return denda;
    }
}
