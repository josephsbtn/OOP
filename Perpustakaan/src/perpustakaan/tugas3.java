package perpustakaan;

import java.util.InputMismatchException;
import java.util.Scanner;

public class tugas3 {

    public static void main(String[] args) {

        perpustakaan perpus = new perpustakaan();
        //BOOK COLLECTION IN LIBARY
        BukuFiksi buku1 = new BukuFiksi("Singeki no Kyojin", "Hajime Isayama", 2011, "Political", 5000, 5);
        BukuNonFiksi buku2 = new BukuNonFiksi("Bumi itu bulat", "Issac Newton", 1912, "Science", 10000, 2);
        BukuFiksi buku3 = new BukuFiksi("Naruto Shippuden", "Masashi Kishimoto", 1999, "Shounen", 20000, 1);
        BukuNonFiksi buku4 = new BukuNonFiksi("Mindset", "Carol S Dewk", 2013, "Psikologi", 5000, 3);

        //ADDING BOOK TO COLLECTION 
        perpus.tambahBuku(buku1);
        perpus.tambahBuku(buku3);
        perpus.tambahBuku(buku2);
        perpus.tambahBuku(buku4);

        String nama = null;
        int nomorAnggota = 0;

        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                System.out.print("\033[H\033[2J");
                System.out.flush();
                System.out.println("-- PERPUSTAKAAN --");
                System.out.print("nama : ");
                nama = scanner.nextLine().toUpperCase();
                System.out.print("Nomot anggota : ");
                nomorAnggota = scanner.nextInt();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Kesalaahan Input!!");
            }
        }

        User user = new User(nama, nomorAnggota);

        System.out.print("\033[H\033[2J");
        System.out.flush();

        int choice = 0;
        while (choice != 4) {
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println("-- PERPUSTAKAAN --");
            System.out.println("Hai " + user.getNama());
            System.out.println("1. Display Collection");
            System.out.println("2. Pinjam Buku");
            System.out.println("3. Kembalikan Buku");
            System.out.println("4. Exit");
            while (true) {

                try {
                    choice = scanner.nextInt();
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Something wrong with your input!!");
                    scanner.next();
                }
            }

            switch (choice) {
                case 1:
                    perpus.displayBook();
                    break;
                case 2:
                    perpus.pinjamBuku(user);
                default:
                    break;
            }

        }

    }
}
