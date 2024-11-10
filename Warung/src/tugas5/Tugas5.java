package tugas5;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Tugas5 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        WarungRoti warRoti = new WarungRoti();
        warRoti.tambahBarang(new Barang(90, 15000, "Donut"));
        warRoti.tambahBarang(new Barang(70, 12000, "Croissant"));
        warRoti.tambahBarang(new Barang(60, 17000, "Cupcake"));
        warRoti.tambahBarang(new Barang(30, 19000, "Roti Tawar"));
        WarungMakan warMakan = new WarungMakan();
        warMakan.tambahBarang(new Barang(20, 10000, "Nasi Goreng"));
        warMakan.tambahBarang(new Barang(20, 15000, "Nasi Geprek"));
        warMakan.tambahBarang(new Barang(50, 8000, "Indomie"));

        while (true) {
            System.out.print("\033[H\033[2J");
            System.out.flush();

            try {
                System.out.println("----- KANTIN FTI -----");
                System.out.println("1. Warung Roti");
                System.out.println("2. Warung Makan");
                System.out.println("3. Exit");
                System.out.print("Pilih menu: ");
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        scanner.nextLine();
                        warRoti.menu();
                        break;
                    case 2:
                        scanner.nextLine();
                        warMakan.menu();
                        break;
                    case 3:
                        System.out.println("Terima kasih telah berkunjung!");
                        scanner.close();
                        System.exit(0);
                    default:
                        System.out.println("Pilihan tidak valid! Silakan coba lagi.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Input tidak valid! Harap masukkan angka sesuai pilihan menu.");
                scanner.nextLine();
                scanner.nextLine();
            }
        }
    }

}
