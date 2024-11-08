package src;


public class ItemPesanan {
    public Makanan makanan;
    public int jmlPembelian;
    public Voucher voucher;

    public ItemPesanan(Makanan makanan, int jmlPembelian, Voucher voucher) {
        this.makanan = makanan;
        this.jmlPembelian = jmlPembelian;
        this.voucher = voucher;
    }
}
