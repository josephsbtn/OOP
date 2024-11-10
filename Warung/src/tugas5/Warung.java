package tugas5;

import java.util.ArrayList;

public interface Warung {

    public boolean tambahBarang(Barang barang);

    public boolean tambahStock(Barang barang, int stok);

    public boolean jualBarang(Barang barang, int stok);

    public ArrayList<Barang> getListBarang();

}
