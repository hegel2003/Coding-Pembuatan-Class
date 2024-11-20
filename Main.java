package src;

public class Main {
    public static void main(String[] args) {
       
        Makanan ayam = new Makanan("Ayam Goreng", 25000);
        Makanan nasi = new Makanan("Nasi Putih", 5000);

       
        DiskonVoucher voucherDiskon = new DiskonVoucher("2024-11-01", "2024-11-30", 10000);

        
        ItemPesanan item1 = new ItemPesanan(ayam, 2, voucherDiskon);
        ItemPesanan item2 = new ItemPesanan(nasi, 3, null);

        
        ResiPesanan resi = new ResiPesanan();
        resi.addItemPesanan(item1);
        resi.addItemPesanan(item2);

        
        resi.printResi();
    }
}
