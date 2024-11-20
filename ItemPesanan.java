package src;


class ItemPesanan {
    private Makanan makanan;
    private int jmlPembelian;
    private Voucher voucher;

    public ItemPesanan(Makanan makanan, int jmlPembelian, Voucher voucher) {
        this.makanan = makanan;
        this.jmlPembelian = jmlPembelian;
        this.voucher = voucher;
    }

    public Makanan getMakanan() {
        return makanan;
    }

    public void setMakanan(Makanan makanan) {
        this.makanan = makanan;
    }

    public int getJmlPembelian() {
        return jmlPembelian;
    }

    public void setJmlPembelian(int jmlPembelian) {
        this.jmlPembelian = jmlPembelian;
    }

    public Voucher getVoucher() {
        return voucher;
    }

    public void setVoucher(Voucher voucher) {
        this.voucher = voucher;
    }
}
