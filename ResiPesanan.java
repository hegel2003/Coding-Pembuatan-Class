package src;


import java.util.ArrayList;



public class ResiPesanan {
    public ArrayList<ItemPesanan> dataItemPesanan;

    public ResiPesanan() {
        dataItemPesanan = new ArrayList<>();
    }

    public void addItemPesanan(ItemPesanan item) {
        if (dataItemPesanan.size() < 10) {
            dataItemPesanan.add(item);
        } else {
            System.out.println("Maksimal item pesanan adalah 10.");
        }
    }

    public void printResi() {
        for (ItemPesanan item : dataItemPesanan) {
            System.out.println("Makanan: " + item.makanan.nama);
            System.out.println("Harga: " + item.makanan.harga);
            System.out.println("Jumlah Pembelian: " + item.jmlPembelian);
            if (item.voucher != null) {
                System.out.println("Voucher Mulai: " + item.voucher.tglMulai);
                System.out.println("Voucher Selesai: " + item.voucher.tglSelesai);
                System.out.println("Nominal Voucher: " + item.voucher.nominal);
            }
            System.out.println();
        }
    }
}