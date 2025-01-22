import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        
        ArrayList<Makanan> daftarMakanan = new ArrayList<>();
        daftarMakanan.add(new Makanan("Nasi Goreng", 25000,"nasi goreng pak pri"));
        daftarMakanan.add(new Makanan("Mie Ayam", 20000,"mie ayam joss"));
        daftarMakanan.add(new Makanan("Sate Ayam", 30000,"sate ayam wenak"));
        daftarMakanan.add(new Makanan("Bakso", 22000,"bakso kaki lima"));
        daftarMakanan.add(new Makanan("Ayam Geprek", 27000,"suprek"));

        System.out.println("Masukkan Nama Pengguna: ");
        String nama = scanner.nextLine();

        
        System.out.println("\n--- Daftar Makanan ---");
        for (int i = 0; i < daftarMakanan.size(); i++) {
            System.out.println((i + 1) + ". " + daftarMakanan.get(i).getNama() + " - Rp " + daftarMakanan.get(i).getHarga());
        }

        
        System.out.print("\nPilih nomor makanan: ");
        int pilihanMakanan = scanner.nextInt() - 1;
        scanner.nextLine(); 

        if (pilihanMakanan < 0 || pilihanMakanan >= daftarMakanan.size()) {
            System.out.println("Pilihan tidak valid.");
            return;
        }

        Makanan makanan = daftarMakanan.get(pilihanMakanan);

        System.out.print("Masukkan jumlah makanan yang dipesan: ");
        int jumlah = scanner.nextInt();
        scanner.nextLine(); 

        
        System.out.print("Apakah Anda memiliki voucher? (ya/tidak): ");
        String punyaVoucher = scanner.nextLine();
        DiskonVoucher voucherDiskon = null;

        if (punyaVoucher.equalsIgnoreCase("ya")) {
            System.out.print("Masukkan tanggal mulai voucher (yyyy-mm-dd): ");
            String tglMulai = scanner.nextLine();
            System.out.print("Masukkan tanggal selesai voucher (yyyy-mm-dd): ");
            String tglSelesai = scanner.nextLine();
            System.out.print("Masukkan nominal diskon voucher: ");
            int nominalDiskon = scanner.nextInt();
            scanner.nextLine(); 
            voucherDiskon = new DiskonVoucher(tglMulai, tglSelesai, nominalDiskon);
        }

        
        ItemPesanan itemPesanan = new ItemPesanan(makanan, jumlah, voucherDiskon);

        
        int totalHarga = makanan.getHarga() * jumlah;
        if (voucherDiskon != null) {
            totalHarga -= voucherDiskon.getNominal();
            if (totalHarga < 0) {
                totalHarga = 0; 
            }
        }

        
        System.out.println("\n--- Resi Pesanan ---");
        System.out.println("Nama: " + nama);
        System.out.println("Makanan: " + makanan.getNama());
        System.out.println("Harga Satuan: Rp " + makanan.getHarga());
        System.out.println("Jumlah: " + jumlah);
        System.out.println("Nama Restoran: " + makanan.getRestoran());
        if (voucherDiskon != null) {
            System.out.println("Diskon: % " + voucherDiskon.getNominal());
        } else {
            System.out.println("Diskon: Tidak ada");
        }
        System.out.println("Total Harga: Rp " + totalHarga);

        scanner.close();
    }
}
