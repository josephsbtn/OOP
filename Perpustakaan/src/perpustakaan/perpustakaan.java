package perpustakaan;

import java.util.ArrayList;
import java.util.Scanner;

public class perpustakaan {

    private ArrayList<Object> Koleksi = new ArrayList<Object>();
    Scanner scanner = new Scanner(System.in);

    public void tambahBuku(BukuFiksi buku) {
        Koleksi.add(buku);
    }

    public void tambahBuku(BukuNonFiksi buku) {
        Koleksi.add(buku);
    }

    public void displayBook() {
        System.out.println("-- Book Collection --");
        for (Object buku : Koleksi) {
            if (buku instanceof BukuFiksi) {
                ((BukuFiksi) buku).tampilkanInformasi();
            } else if (buku instanceof BukuNonFiksi) {
                ((BukuNonFiksi) buku).tampilkanInformasi();
            }
        }
    }

    public void pinjamBuku(User user) {
        boolean found = false;
        System.out.println("---- BORROW BOOK -----");
        System.out.println("Title Book :");
        String title = scanner.nextLine();
        for (Object buku : Koleksi) {
            //Checking by Buku Fiksi in Collection
            if (buku instanceof BukuFiksi) {
                BukuFiksi book = (BukuFiksi) buku;
                if (book.getJudul().equalsIgnoreCase(title)) {
                    user.addPinjam(book);
                    book.tampilkanInformasi();
                    book.setBorrowedStock();
                    found = true;
                    break;
                }
                //Checking by Buku NonFiksi in Collection
            } else if (buku instanceof BukuNonFiksi) {
                BukuNonFiksi book = (BukuNonFiksi) buku;
                if (book.getJudul().equalsIgnoreCase(title)) {
                    user.addPinjam(book);
                    book.tampilkanInformasi();
                    book.setBorrowedStock();
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

    }
}
