package tugas5;

public class Barang {

    private int stok = 0;
    private double hargaBarang;
    private String namaBarang;

    public Barang(int stok, double hargaBarang, String namaBarang) {
        this.stok = stok;
        this.hargaBarang = hargaBarang;
        this.namaBarang = namaBarang;
    }

    public void addStock(int add) {
        this.stok += add;
    }

    public void jualStock(int jual) {
        this.stok -= jual;
    }

    public String getNamaBarang() {
        return this.namaBarang;
    }

    public double getHargaBarang() {
        return this.hargaBarang;
    }

    public int getStok() {
        return this.stok;
    }

}
