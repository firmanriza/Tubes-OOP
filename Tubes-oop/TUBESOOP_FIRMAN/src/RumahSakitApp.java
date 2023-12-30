import java.util.InputMismatchException;
import java.util.Scanner;

class RumahSakitApp {
    public static void main(String[] args) {
        RumahSakitApp aplikasi = new RumahSakitApp();
        aplikasi.run();
    }

    private Manajemen manajemen;
    private Scanner scanner;

    RumahSakitApp() {
        manajemen = new Manajemen();
        scanner = new Scanner(System.in);
    }

    void run() {
        int menu;
        do {
            try{
            System.out.println("MENU:");
            System.out.println("1. Registrasi Pasien");
            System.out.println("2. Pemeriksaan");
            System.out.println("3. Rekam Medis");
            System.out.println("4. Pembayaran");
            System.out.println("5. Keluar Aplikasi");
            System.out.print("Pilih MENU (1-5)!: ");
            menu = scanner.nextInt();
            scanner.nextLine(); 

            switch (menu) {
                case 1:
                    manajemen.registrasiPasien();
                    break;
                case 2:
                    manajemen.pemeriksaan();
                    break;
                case 3:
                    manajemen.rekamMedis();
                    break;
                case 4:
                    manajemen.pembayaran();
                    break;
                case 5:
                    System.out.println("Terima kasih! Aplikasi ditutup.");
                    break;
                default:
                    System.out.println("Menu tidak valid. Silakan pilih menu 1-5!!");
            }
        } catch (InputMismatchException e) {
                System.out.println("Error: Harap masukkan angka sebagai pilihan menu!!");
                scanner.nextLine();
                menu = 0;
            }   
        } while (menu != 5);
    }
}