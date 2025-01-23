import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

    
class ResiPesanan {
    private ArrayList<ItemPesanan> dataItemPesanan;

    public ResiPesanan() {
        dataItemPesanan = new ArrayList<>();
    }

    public void addItemPesanan(ItemPesanan item) {
        if (dataItemPesanan.size() < 10) {
            dataItemPesanan.add(item);
        } else {
            System.out.println("Maksimal jumlah item pesanan adalah 10.");
        }
    }

    public ItemPesanan tambahPesanan(Scanner scanner, ArrayList<Makanan> daftarMakanan, String namaPengguna) {
        try {
            System.out.println("\n--- Daftar Makanan ---");
            for (int i = 0; i < daftarMakanan.size(); i++) {
                System.out.println((i + 1) + ". " + daftarMakanan.get(i).getNama() + " - Rp " + daftarMakanan.get(i).getHarga());
            }

            System.out.print("\nPilih nomor makanan: ");
            int pilihanMakanan = scanner.nextInt() - 1;
            scanner.nextLine();

            if (pilihanMakanan < 0 || pilihanMakanan >= daftarMakanan.size()) {
                System.out.println("Pilihan tidak valid.");
                return null;
            }

            Makanan makanan = daftarMakanan.get(pilihanMakanan);

            System.out.print("Masukkan jumlah makanan yang dipesan: ");
            int jumlah = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Apakah Anda memiliki voucher? (ya/tidak): ");
            String punyaVoucher = scanner.nextLine();
            Voucher voucherDiskon = null;

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

            return new ItemPesanan(namaPengguna, makanan, jumlah, voucherDiskon);
        } catch (InputMismatchException e) {
            System.out.println("Input tidak valid. Silakan masukkan angka yang benar.");
            scanner.nextLine(); 
        } catch (Exception e) {
            System.out.println("Terjadi kesalahan: " + e.getMessage());
        }
        return null;
    }

    public void printResi() {
        System.out.println("\n--- Resi Pesanan ---");
        int totalHarga = 0;

        for (ItemPesanan item : dataItemPesanan) {
            int subtotal = item.getMakanan().getHarga() * item.getJumlahPembelian();
            if (item.getVoucher() != null) {
                subtotal -= item.getVoucher().getNominal();
                if (subtotal < 0) {
                    subtotal = 0;
                }
            }
            totalHarga += subtotal;

            System.out.println("Nama Pengguna: " + item.getNamaPengguna());
            System.out.println("Makanan: " + item.getMakanan().getNama());
            System.out.println("Harga Satuan: Rp " + item.getMakanan().getHarga());
            System.out.println("Jumlah: " + item.getJumlahPembelian());
            System.out.println("Subtotal: Rp " + subtotal);
            if (item.getVoucher() != null) {
                System.out.println("Diskon: Rp " + item.getVoucher().getNominal());
            } else {
                System.out.println("Diskon: Tidak ada");
            }
            System.out.println();
        }

        System.out.println("Total Harga: Rp " + totalHarga);
    }
}
