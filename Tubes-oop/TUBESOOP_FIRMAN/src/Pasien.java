abstract class Pasien {
    public String nama;
    public String alamat;
    public String tanggalLahir;
    public String jenisKelamin;

    Pasien(String nama, String alamat, String tanggalLahir, String jenisKelamin) {
        this.nama = nama;
        this.alamat = alamat;
        this.tanggalLahir = tanggalLahir;
        this.jenisKelamin = jenisKelamin;
    }
    
    abstract void displayInfo(); 
    
}

