package src;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

class Voucher {
    private LocalDate tglMulai;
    private LocalDate tglSelesai;

    public Voucher(String tglMulai, String tglSelesai) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        this.tglMulai = LocalDate.parse(tglMulai, formatter);
        this.tglSelesai = LocalDate.parse(tglSelesai, formatter);
    }

    public LocalDate getTglMulai() {
        return tglMulai;
    }

    public void setTglMulai(String tglMulai) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        this.tglMulai = LocalDate.parse(tglMulai, formatter);
    }

    public LocalDate getTglSelesai() {
        return tglSelesai;
    }

    public void setTglSelesai(String tglSelesai) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        this.tglSelesai = LocalDate.parse(tglSelesai, formatter);
    }

    public void displayInfo() {
        System.out.println("Tanggal Mulai Voucher: " + tglMulai);
        System.out.println("Tanggal Selesai Voucher: " + tglSelesai);
    }
}

class DiskonVoucher extends Voucher {
    private int nominal;

    public DiskonVoucher(String tglMulai, String tglSelesai, int nominal) {
        super(tglMulai, tglSelesai); 
        this.nominal = nominal;
    }

    public int getNominal() {
        return nominal;
    }

    public void setNominal(int nominal) {
        this.nominal = nominal;
    }

    @Override
    public void displayInfo() {
        super.displayInfo(); 
        System.out.println("Nominal Diskon: " + nominal);
    }
}
