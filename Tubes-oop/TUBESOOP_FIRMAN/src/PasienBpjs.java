class PasienBPJS extends Pasien {
    public String nomorBPJS;

    PasienBPJS(String nama, String alamat, String tanggalLahir, String jenisKelamin, String nomorBPJS) {
        super(nama, alamat, tanggalLahir, jenisKelamin);
        this.nomorBPJS = nomorBPJS;
    }

    @Override
    void displayInfo() {
        System.out.println("Data Pasien BPJS:");
        System.out.println("Nama: " + nama);
        System.out.println("Alamat: " + alamat);
        System.out.println("Tanggal Lahir: " + tanggalLahir);
        System.out.println("Jenis Kelamin: " + jenisKelamin);
        System.out.println("Nomor BPJS: " + nomorBPJS);
        System.out.println("---------------------------");
    }
}
