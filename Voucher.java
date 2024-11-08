package src;


public class Voucher {
    public String tglMulai;
    public String tglSelesai;
    public int nominal;

    public Voucher(String tglMulai, String tglSelesai, int nominal) {
        this.tglMulai = tglMulai;
        this.tglSelesai = tglSelesai;
        this.nominal = nominal;
    }
}
