package perpustakaan;

public class BukuFiksi extends Buku {

    private String genre;

    public BukuFiksi(String judul, String Pengarang, int tahunTerbit, String genre) {
        super(judul, Pengarang, tahunTerbit);
        this.genre = genre;
    }

    @Override
    public void tampilkanInformasi() {
        super.tampilkanInformasi();
        System.out.println("Genre : " + this.genre);
        System.out.println("------------------------");
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

}
