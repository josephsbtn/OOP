package perpustakaan;

import java.util.ArrayList;

public class User {

    private String nama;
    private int nomorAnggota;
    private ArrayList<Buku> listPinjam = new ArrayList<Buku>();

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

    public void addPinjam(Buku pinjam) {
        listPinjam.add(pinjam);
    }

    public ArrayList<Buku> getListPinjam() {
        return listPinjam;
    }

    public void deletePinjam(Buku pinjam) {
        listPinjam.remove(pinjam);
    }
}
