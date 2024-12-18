import java.time.LocalDate;

public class Transaksi {
    LocalDate tanggal;
    String deskripsi;
    double nominal;
    double saldoSetelahTransaksi;

    public Transaksi(LocalDate tanggal, String deskripsi, double nominal, double saldoSetelahTransaksi) {
        this.tanggal = tanggal;
        this.deskripsi = deskripsi;
        this.nominal = nominal;
        this.saldoSetelahTransaksi = saldoSetelahTransaksi;
    }
}