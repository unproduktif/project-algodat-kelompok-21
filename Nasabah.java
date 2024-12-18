import java.util.Scanner;
import java.time.LocalDate;

public class Nasabah {
    String nama;
    String alamat;
    double saldo;
    String username;
    String password;
    String noRekening;
    LLTranksaksi mutasi;

    public Nasabah(String nama, String alamat, String username, String password, double saldo, String noRekening){
        this.nama = nama;
        this.alamat = alamat;
        this.saldo = saldo;
        this.username = username;
        this.password = password;
        this.noRekening=noRekening;
        this.mutasi = null;
    }
    public void menuNasabah(Scanner scanner){
        boolean running=true;
        while(running){
            System.out.println("\n=== MENU NASABAH ===");
            System.out.println("1. Isi Saldo\t5. Info Saldo");
            System.out.println("2. Tarik Tunai\t6. Info Akun");
            System.out.println("3. Transfer\t7. Hubungi CS");
            System.out.println("4. Cek Mutasi\t8. Keluar");
            int pilih=scanner.nextInt();
            scanner.nextLine();
            switch (pilih) {
                case 1:
                    isiSaldo(scanner);
                    break;
                case 2:
                    tarikTunai(scanner);
                    break;
                case 3:
                    transfer(scanner);
                    break;
                case 4:
                    mutasi.cekMutasi();
                    break;
                case 5:
                    infoSaldo();
                    break;
                case 6:
                    infoAkun();
                    break;
                case 7:
                    break;
                case 8:
                    return; 
                default:
                    break;
            }
        }
    }
    private void isiSaldo(Scanner scanner){
        System.out.print("Masukkan jumlah saldo: ");
        double isisaldo=scanner.nextDouble();
        if(isisaldo>0){
            saldo+=isisaldo;
            System.out.println("Saldo berhasil ditambahkan sebesar Rp. "+isisaldo);
            mutasi.push(LocalDate.now(), "Isi saldo", isisaldo, saldo);
        }else{
            System.out.println("Jumlah saldo tidak valid!");
        }
    }
    private void tarikTunai(Scanner scanner) {
        System.out.print("Masukkan jumlah tarik tunai: ");
        double tarikTunai = scanner.nextDouble();
        if (tarikTunai > 0 && tarikTunai <= saldo) {
            saldo -= tarikTunai;
            System.out.println("Tarik tunai berhasil sebesar Rp. " + tarikTunai);
            mutasi.push(LocalDate.now(), "Tarik tunai", tarikTunai, saldo);
        } else {
            System.out.println("Tarik tunai gagal! Saldo tidak mencukupi.");
        }
    }
    private void transfer(Scanner scanner){
        // System.out.println("Masukkan nomor rekening tujuan: ");
        // String norekTujuan=scanner.next();

        // if(this.noRekening.equals(norekTujuan)){
            
        // }
    }
    private void infoSaldo(){
        System.out.println("Saldo Anda saat ini Rp. "+ saldo);
    }
    private void infoAkun() {
        System.out.println("=========================================");
        System.out.println("             INFO AKUN                  ");
        System.out.println("=========================================");
        System.out.println("Nama    : " + nama);
        System.out.println("Alamat  : " + alamat);
        System.out.println("Username: " + username);
        System.out.println("Saldo   : " + saldo);
    }
}
