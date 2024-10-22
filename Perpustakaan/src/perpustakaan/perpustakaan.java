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
        System.out.println("---- BORROW BOOK -----");
        System.out.println("Title Book :");
        String title = scanner.nextLine();
        for (Object buku : Koleksi) {
            if (Koleksi.contains(buku.equals(title)) && buku instanceof BukuFiksi) {
                user.addPinjam((BukuFiksi) buku);
                break;
            }
        }

    }

    public void kembalikanBuku(User user) {

    }
}
