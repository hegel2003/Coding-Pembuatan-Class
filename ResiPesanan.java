package src;

import java.util.ArrayList;

class ResiPesanan {
    private ArrayList<ItemPesanan> dataItemPesanan;

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
            System.out.println("Makanan: " + item.getMakanan().getNama());
            System.out.println("Harga: " + item.getMakanan().getHarga());
            System.out.println("Jumlah Pembelian: " + item.getJmlPembelian());
            
            if (item.getVoucher() != null) {
                item.getVoucher().displayInfo(); 
            } else {
                System.out.println("Voucher: Tidak ada voucher.");
            }
            System.out.println();
        }
    }
}
