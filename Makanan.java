class Makanan {
    private String nama;
    private int harga;
    private String Restoran;

    public Makanan(String nama, int harga, String Restoran) {
        this.nama = nama;
        this.harga = harga;
        this.Restoran = Restoran;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    public String getRestoran(){
        return Restoran;
    }

    public void setRestoran(String Restoran){
        this.Restoran = Restoran;
    }
}
