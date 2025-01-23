import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        
        ArrayList<Makanan> daftarMakanan = new ArrayList<>();
        daftarMakanan.add(new Makanan("Nasi Goreng", 25000));
        daftarMakanan.add(new Makanan("Mie Ayam", 20000));
        daftarMakanan.add(new Makanan("Sate Ayam", 30000));
        daftarMakanan.add(new Makanan("Bakso", 22000));
        daftarMakanan.add(new Makanan("Ayam Geprek", 27000));

        ResiPesanan resiPesanan = new ResiPesanan();

        
        System.out.println("Masukkan Nama Pengguna: ");
        String nama = scanner.nextLine();

        boolean lanjutPesanan = true;
        while (lanjutPesanan) {
            try {
                
                ItemPesanan item = resiPesanan.tambahPesanan(scanner, daftarMakanan, nama);
                if (item != null) {
                    resiPesanan.addItemPesanan(item);
                }

                
                System.out.print("Apakah Anda ingin memesan makanan lain? (ya/tidak): ");
                String jawaban = scanner.nextLine();
                lanjutPesanan = jawaban.equalsIgnoreCase("ya");
            } catch (InputMismatchException e) {
                System.out.println("Input tidak valid. Silakan coba lagi.");
                scanner.nextLine(); 
            } catch (Exception e) {
                System.out.println("Terjadi kesalahan: " + e.getMessage());
            }
        }

        
        resiPesanan.printResi();
        scanner.close();
    }
}
