package perpustakaan;

public class BukuFiksi extends Buku {

    private String genre;

    public BukuFiksi(String Judul, String Pengarang, int tahunTerbit, String genre, double dendaPerHari, int stock) {
        super(Judul, Pengarang, tahunTerbit, dendaPerHari, stock);
        this.genre = genre;
    }

    @Override
    public void tampilkanInformasi() {
        super.tampilkanInformasi();
        System.out.println("Genre : " + this.genre);
    }

    public String getGenre() {;
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

}
