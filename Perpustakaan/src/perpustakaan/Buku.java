package perpustakaan;

public class Buku {

    private String Judul;
    private String Pengarang;
    private int tahunTerbit;

    public Buku(String judul, String Pengarang, int tahunTerbit) {
        this.Judul = judul;
        this.Pengarang = Pengarang;
        this.tahunTerbit = tahunTerbit;
    }

    public String getJudul() {
        return Judul;
    }

    public void setJudul(String judul) {
        Judul = judul;
    }

    public String getPengarang() {
        return Pengarang;
    }

    public void setPengarang(String pengarang) {
        Pengarang = pengarang;
    }

    public int getTahunTerbit() {
        return tahunTerbit;
    }

    public void setTahunTerbit(int tahunTerbit) {
        this.tahunTerbit = tahunTerbit;
    }

    public void tampilkanInformasi() {
        System.out.println("---- INFORMASI BUKU ----");
        System.out.println("Judul : " + this.Judul);
        System.out.println("Penulis : " + this.Pengarang);
        System.out.println("Tahun terbit : " + this.tahunTerbit);

    }
}
