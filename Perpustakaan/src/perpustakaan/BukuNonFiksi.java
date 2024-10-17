package perpustakaan;

public class BukuNonFiksi extends Buku {

    private String topik;

    public BukuNonFiksi(String judul, String Pengarang, int tahunTerbit, String topik) {
        super(judul, Pengarang, tahunTerbit);
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
