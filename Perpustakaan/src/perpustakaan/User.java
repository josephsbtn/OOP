package perpustakaan;

import java.util.ArrayList;
import java.util.Scanner;

public class User {

    private String nama;
    private int nomorAnggota;
    private ArrayList<Object> listPinjam = new ArrayList<Object>();

    public User(String nama, int nomorAnggota) {
        this.nama = nama;
        this.nomorAnggota = nomorAnggota;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getNomorAnggota() {
        return nomorAnggota;
    }

    public void setNomorAnggota(int nomorAnggota) {
        this.nomorAnggota = nomorAnggota;
    }

    public void addPinjam(BukuFiksi pinjam) {
        listPinjam.add(pinjam);
    }

    public void addPinjam(BukuNonFiksi pinjam) {
        listPinjam.add(pinjam);
    }

    public ArrayList<Object> getListPinjam() {
        return listPinjam;
    }

    public void deletePinjam(Buku pinjam) {
        listPinjam.remove(pinjam);
    }

    public void printBorrowedBook() {
        Scanner pause = new Scanner(System.in);
        System.out.println("---- My Borrowed Book Collection ----");

        if (listPinjam.isEmpty()) {
            System.out.println("You dont have any borrowed book yet");
            pause.nextLine();
            return;
        }

        for (Object buku : listPinjam) {
            if (buku instanceof BukuFiksi) {
                ((BukuFiksi) buku).tampilkanInformasi();
            } else if (buku instanceof BukuNonFiksi) {
                ((BukuNonFiksi) buku).tampilkanInformasi();
            }
        }
        pause.nextLine();
    }
}
