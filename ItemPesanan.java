class ItemPesanan {
    private String namaPengguna;
    private Makanan makanan;
    private int jumlahPembelian;
    private Voucher voucher;

    public ItemPesanan(String namaPengguna, Makanan makanan, int jumlahPembelian, Voucher voucher) {
        this.namaPengguna = namaPengguna;
        this.makanan = makanan;
        this.jumlahPembelian = jumlahPembelian;
        this.voucher = voucher;
    }

    public String getNamaPengguna() {
        return namaPengguna;
    }

    public Makanan getMakanan() {
        return makanan;
    }

    public int getJumlahPembelian() {
        return jumlahPembelian;
    }

    public Voucher getVoucher() {
        return voucher;
    }
}
