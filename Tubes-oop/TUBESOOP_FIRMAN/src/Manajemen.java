import java.util.ArrayList;
import java.util.Scanner;

class Manajemen {
    ArrayList<Pasien> daftarPasien = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    public void registrasiPasien() {
        System.out.print("Masukkan nama pasien: ");
        String nama = scanner.nextLine();
        System.out.print("Masukkan alamat pasien: ");
        String alamat = scanner.nextLine();
        System.out.print("Masukkan tanggal lahir pasien: ");
        String tanggalLahir = scanner.nextLine();
        System.out.print("Masukkan jenis kelamin pasien: ");
        String jenisKelamin = scanner.nextLine();
        System.out.print("Masukkan nomor BPJS pasien: ");
        String nomorBPJS = scanner.nextLine();

        Pasien pasien = new PasienBPJS(nama, alamat, tanggalLahir, jenisKelamin, nomorBPJS);
        daftarPasien.add(pasien);

        System.out.println("Registrasi pasien berhasil!");
    }

    public void pemeriksaan() {
        if (daftarPasien.isEmpty()) {
            System.out.println("Belum ada pasien terdaftar.");
            return;
        }

        System.out.println("Daftar Pasien:");
        for (int i = 0; i < daftarPasien.size(); i++) {
            System.out.println((i + 1) + ". " + daftarPasien.get(i).nama);
        }

        System.out.print("Pilih pasien (nomor urut): ");
        int nomorPasien = scanner.nextInt();
        scanner.nextLine(); 

        if (nomorPasien < 1 || nomorPasien > daftarPasien.size()) {
            System.out.println("Nomor pasien tidak valid.");
            return;
        }

        Pasien pasien = daftarPasien.get(nomorPasien - 1);
        System.out.println("Jenis Pemeriksaan:");
        System.out.println("1. Pemeriksaan Darah");
        System.out.println("2. Pemeriksaan Mata");
        System.out.print("Pilih jenis pemeriksaan (1-2): ");
        int jenisPemeriksaan = scanner.nextInt();

        switch (jenisPemeriksaan) {
            case 1:
                System.out.println("Hasil Pemeriksaan Darah untuk " + pasien.nama + ": ");
                String hasilDarah = scanner.next();
                System.out.println("Hasil Pemeriksaan Darah untuk " + pasien.nama + ": " + hasilDarah);
                break;
            case 2:
                System.out.println("Hasil Pemeriksaan Mata untuk " + pasien.nama + ": ");
                String hasilMata = scanner.next();
                System.out.println("Hasil Pemeriksaan Mata untuk " + pasien.nama + ": " + hasilMata);
                break;
            default:
                System.out.println("Jenis pemeriksaan tidak valid.");
        }
    }

    public void rekamMedis() {
        if (daftarPasien.isEmpty()) {
            System.out.println("Belum ada pasien terdaftar.");
            return;
        }

        System.out.print("Masukkan nama pasien atau nomor BPJS: ");
        String input = scanner.nextLine();

        for (Pasien pasien : daftarPasien) {
            if (pasien instanceof PasienBPJS) {
                if (((PasienBPJS) pasien).nomorBPJS.equals(input) || pasien.nama.equals(input)) {
                    pasien.displayInfo();
                    System.out.print("Masukkan Riwayat Pemeriksaan: ");
                    String riwayat = scanner.nextLine();
                    System.out.print("Masukkan Penyakit: ");
                    String penyakit = scanner.nextLine();
                    System.out.print("Masukkan Resep Obat: ");
                    String resepObat = scanner.nextLine();
                    System.out.println("---------------------------");
                    System.out.println("Riwayat Pemeriksaan " + pasien.nama + " : " + riwayat);
                    System.out.println("Penyakit " + pasien.nama + " : " + penyakit);
                    System.out.println("Resep Obat " + pasien.nama + " : " + resepObat);
                    return;
                }
            }
        }

        System.out.println("Pasien tidak ditemukan.");
    }

    public void pembayaran() {
        if (daftarPasien.isEmpty()) {
            System.out.println("Belum ada pasien terdaftar.");
            return;
        }

        System.out.print("Pilih pasien (nomor urut): ");
        int nomorPasien = scanner.nextInt();
        scanner.nextLine(); 

        if (nomorPasien < 1 || nomorPasien > daftarPasien.size()) {
            System.out.println("Nomor pasien tidak valid.");
            return;
        }

        Pasien pasien = daftarPasien.get(nomorPasien - 1);

        System.out.print("Masukkan data tagihan untuk " + pasien.nama + ": ");
        double tagihan = scanner.nextDouble();

        System.out.println("Konfirmasi pembayaran untuk " + pasien.nama + " sebesar " + tagihan + " berhasil.");
    }
}