package perpustakaan;

public class Buku {

    private String Judul;
    private String Pengarang;
    private int tahunTerbit;
    private int stock;
    private double dendaPerHari;

    public Buku(String judul, String Pengarang, int tahunTerbit, double dendaPerHari, int stock) {
        this.Judul = judul;
        this.Pengarang = Pengarang;
        this.tahunTerbit = tahunTerbit;
        this.dendaPerHari = dendaPerHari;
        this.stock = stock;
    }

    public String getJudul() {
        return Judul;
    }

    public void setJudul(String Judul) {
        this.Judul = Judul;
    }

    public String getPengarang() {
        return Pengarang;
    }

    public void setPengarang(String Pengarang) {
        this.Pengarang = Pengarang;
    }

    public int getTahunTerbit() {
        return tahunTerbit;
    }

    public void setTahunTerbit(int tahunTerbit) {
        this.tahunTerbit = tahunTerbit;
    }

    public void tampilkanInformasi() {
        System.out.println("---- BOOK INFORMATION ----");
        System.out.println("Book title : " + this.Judul);
        System.out.println("Writer : " + this.Pengarang);
        System.out.println("Year of Publication : " + this.tahunTerbit);
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public double getDendaPerHari() {
        return dendaPerHari;
    }

    public void setDendaPerHari(int hariTelat) {
        this.dendaPerHari = this.dendaPerHari * hariTelat;
    }
}
