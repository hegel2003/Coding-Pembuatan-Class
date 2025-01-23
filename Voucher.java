import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

abstract class Voucher {
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

    public LocalDate getTglSelesai() {
        return tglSelesai;
    }

    public abstract int getNominal();

    public abstract void displayInfo();
}

class DiskonVoucher extends Voucher {
    private int nominal;

    public DiskonVoucher(String tglMulai, String tglSelesai, int nominal) {
        super(tglMulai, tglSelesai);
        this.nominal = nominal;
    }

    @Override
    public int getNominal() {
        return nominal;
    }

    @Override
    public void displayInfo() {
        System.out.println("Tanggal Mulai Voucher: " + getTglMulai());
        System.out.println("Tanggal Selesai Voucher: " + getTglSelesai());
        System.out.println("Nominal Diskon: Rp " + nominal);
    }
}
