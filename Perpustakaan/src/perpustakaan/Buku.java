package perpustakaan;

public class Buku {

    protected String Judul;
    protected String Pengarang;
    protected int tahunTerbit;
    protected int stock;
    protected double dendaPerHari;
    protected double denda = 0;
    protected int tanggalPinjam = 0;
    protected int tanggalKembali = 0;
    protected int deadlineReturn = 0;

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
        System.out.println();
        System.out.println("|---- BOOK INFORMATION ----|");
        System.out.println("Book title : " + this.Judul);
        System.out.println("Writer : " + this.Pengarang);
        System.out.println("Year of Publication : " + this.tahunTerbit);
        System.out.println("Stock : " + this.stock);
    }

    public int getStock() {
        return stock;
    }

    public void setBorrowedStock() {
        this.stock += 1;
    }

    public void setBorrowStock() {
        this.stock -= 1;
    }

    public double getDendaPerHari() {
        return dendaPerHari;
    }

    public void setTanggalPinjam(int tanggalPinjam) {
        this.tanggalPinjam = tanggalPinjam;
    }

    public void setTanggalKembali(int tanggalKembali) {
        this.tanggalKembali = tanggalKembali;
    }

    public void setDeadlineReturn() {
        if (tanggalPinjam + 7 > 31) {
            deadlineReturn = (tanggalPinjam + 7) - 31;
        } else {
            deadlineReturn = tanggalPinjam + 7;
        }
    }

    public int getTanggalPinjam() {
        return tanggalPinjam;
    }

    public int getTanggalKembali() {
        return tanggalKembali;
    }

    public int getDeadlineReturn() {
        return deadlineReturn;
    }

    public double getDenda() {
        this.denda = (this.tanggalKembali - this.deadlineReturn) * this.dendaPerHari;
        return this.denda;
    }
}
