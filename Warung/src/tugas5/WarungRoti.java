package tugas5;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class WarungRoti implements Warung {

    private ArrayList<Barang> listRoti = new ArrayList<Barang>();
    private double omset = 0;

    @Override
    public ArrayList<Barang> getListBarang() {
        return listRoti;
    }

    @Override
    public boolean jualBarang(Barang roti, int stok) {
        roti.jualStock(stok);
        return false;
    }

    @Override
    public boolean tambahBarang(Barang roti) {
        listRoti.add(roti);
        return false;
    }

    @Override
    public boolean tambahStock(Barang roti, int stok) {
        roti.addStock(stok);
        return false;
    }

    public void menu() {
        Scanner scanner = new Scanner(System.in);
        Scanner hold = new Scanner(System.in);
        while (true) {
            System.out.print("\033[H\033[2J");
            System.out.flush();
            try {
                System.out.println("----- Toki Roti -----");
                System.out.println("1. Liat Stock");
                System.out.println("2. Tambah Barang");
                System.out.println("3. Tambah Stock");
                System.out.println("4. Jual Barang");
                System.out.println("5. Omset");
                System.out.println("6. Exit");
                System.out.print("Pilih menu: ");
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        lihatStock();
                        break;
                    case 2:
                        tambahBarang();
                        break;
                    case 3:
                        tambahStock();
                        break;
                    case 4:
                        jualBarang();
                        break;
                    case 5:
                        lihatOmset();
                        hold.nextLine();
                        break;
                    case 6:
                        return;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.out.println("Pilihan tidak valid!");
                scanner.nextLine();
            }
        }

    }

    private void printAllItems() {
        int i = 1;
        for (Barang barang : getListBarang()) {
            System.out.println((i) + "." + barang.getNamaBarang() + " : " + barang.getStok() + " - Rp." + barang.getHargaBarang());
            i++;
        }
    }

    private void lihatOmset() {
        System.out.println("----- Omset -----");
        System.out.println("Omset: Rp." + omset);
    }

    private void lihatStock() {
        Scanner hold = new Scanner(System.in);
        System.out.println("----- Lihat Stock -----");

        if (getListBarang().isEmpty()) {
            System.out.println("Belum ada roti dalam Toko!!");
            hold.nextLine();
            return;
        }
        printAllItems();

        hold.nextLine();
    }

    private void tambahBarang() {
        Scanner scanner = new Scanner(System.in);
        String tambahLagi = "y";

        while (true) {
            System.out.print("\033[H\033[2J");
            System.out.flush();
            try {
                System.out.println("----- Tambah Roti -----");
                System.out.print("Nama Roti: ");
                String namaBarang = scanner.next();

                System.out.print("Harga Roti: ");
                double hargaBarang = scanner.nextDouble();

                System.out.print("Jumlah Roti: ");
                int jumlahBarang = scanner.nextInt();

                tambahBarang(new Barang(jumlahBarang, hargaBarang, namaBarang));

                scanner.nextLine();

                System.out.print("Apakah ingin menambahkan lagi? (y/n): ");
                tambahLagi = scanner.nextLine().trim();

                if (tambahLagi.equalsIgnoreCase("n")) {
                    break;
                } else if (!tambahLagi.equalsIgnoreCase("y")) {
                    throw new Exception("Input tidak bisa selain y / n");
                }

            } catch (InputMismatchException e) {
                System.out.println("Input tidak sesuai!!!");
                scanner.nextLine();
                scanner.nextLine();
            } catch (Exception e) {
                System.out.println(e.getMessage());
                scanner.nextLine();
                scanner.nextLine();
            }
        }
    }

    private void tambahStock() {
        Scanner hold = new Scanner(System.in);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("\033[H\033[2J");
            System.out.flush();
            try {
                printAllItems();
                System.out.println("----- Tambah Stock -----");

                if (getListBarang().isEmpty()) {
                    System.out.println("Belum ada roti dalam Toko!!");
                    hold.nextLine();
                    return;
                }
                System.out.println("Pilih nomor :");
                int index = scanner.nextInt();
                if (index > listRoti.size() || index < 1) {
                    throw new Exception("TIDAK ADA ITEM ITU!!");

                }
                System.out.println("Tambah Stock :");
                int tambahStock = scanner.nextInt();
                tambahStock(listRoti.get(index - 1), tambahStock);

                System.out.println("Berhasil menambah Stock!!");

                printAllItems();

                System.out.print("Apakah ingin menambahkan lagi? (y/n): ");
                String tambahLagi = scanner.nextLine().trim();

                if (tambahLagi.equalsIgnoreCase("n")) {
                    break;
                } else if (!tambahLagi.equalsIgnoreCase("y")) {
                    throw new Exception("Input tidak bisa selain y / n");
                }

                hold.nextLine();

            } catch (InputMismatchException e) {
                System.out.println("Input tidak sesuai!!!");
                scanner.nextLine();
                hold.nextLine();

            } catch (Exception e) {
                System.out.println(e.getMessage());
                scanner.nextLine();
                hold.nextLine();
            }
        }
    }

    private void jualBarang() {
        Scanner scanner = new Scanner(System.in);
        Scanner hold = new Scanner(System.in);

        while (true) {
            System.out.print("\033[H\033[2J");
            System.out.flush();
            try {
                printAllItems();
                System.out.println("----- Jual Barang -----");

                if (getListBarang().isEmpty()) {
                    System.out.println("Belum ada Item dalam Toko!!");
                    return;
                }

                System.out.print("Pilih nomor : ");
                int index = scanner.nextInt();

                if (index < 1 || index > listRoti.size()) {
                    throw new Exception("TIDAK ADA ITEM ITU!!");
                }

                System.out.print("Jumlah : ");
                int jual = scanner.nextInt();

                jualBarang(listRoti.get(index - 1), jual);

                double totalTransaksi = jual * listRoti.get(index - 1).getHargaBarang();
                omset += totalTransaksi;

                System.out.println("Berhasil Melakukan Penjualan");
                System.out.println("Total transaksi : Rp." + totalTransaksi);
                hold.nextLine();
                break;

            } catch (InputMismatchException e) {
                System.out.println("Input tidak sesuai!!!");
                scanner.nextLine();
                hold.nextLine();
            } catch (Exception e) {
                System.out.println(e.getMessage());
                scanner.nextLine();
                hold.nextLine();
            }
        }

    }

}
