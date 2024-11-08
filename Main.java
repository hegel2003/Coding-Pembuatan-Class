package src;


public class Main {
    public static void main(String[] args) {
        Makanan makanan1 = new Makanan("Nasi Goreng", 15000);
        Voucher voucher1 = new Voucher("2024-01-01", "2024-01-31", 5000);
        ItemPesanan itemPesanan1 = new ItemPesanan(makanan1, 2, voucher1);

        ResiPesanan resi = new ResiPesanan();
        resi.addItemPesanan(itemPesanan1);

        resi.printResi();
    }
}
