package perpustakaan;

public class BukuNonFiksi extends Buku {

    private String topik;

    public BukuNonFiksi(String Judul, String Pengarang, int tahunTerbit, String topik, double dendaPerHari, int stock) {
        super(Judul, Pengarang, tahunTerbit, dendaPerHari, stock);
        this.topik = topik;
    }

    @Override
    public void tampilkanInformasi() {
        super.tampilkanInformasi();
        System.out.println("Topik : " + this.topik);
    }

    public String getTopik() {
        return topik;
    }

    public void setTopik(String topik) {
        this.topik = topik;
    }

}
