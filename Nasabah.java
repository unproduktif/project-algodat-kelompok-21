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
    public void menuNasabah(Scanner scanner, LinkedListNasabah LLnasabah){
        boolean running=true;
        while(running){
            System.out.println("\n=== MENU NASABAH ===");
            System.out.println("1. Isi Saldo\t5. Info Saldo");
            System.out.println("2. Tarik Tunai\t6. Info Akun");
            System.out.println("3. Transfer\t7. Hubungi CS");
            System.out.println("4. Cek Mutasi\t8. Kantor Cabang");
            System.out.println("0. Keluar");
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
                    transfer(scanner, LLnasabah);;
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
                hubungiCS(LLnasabah);;
                    break;
                case 8:
                    break;
                case 0:
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
    private void transfer(Scanner scanner, LinkedListNasabah LLnasabah) {
        System.out.print("Masukkan nomor rekening tujuan: ");
        String rekTujuan = scanner.nextLine();
        
        System.out.print("Masukkan jumlah transfer: ");
        double jumlahTransfer = scanner.nextDouble();
        scanner.nextLine(); 
        
        if (jumlahTransfer > 0 && jumlahTransfer <= saldo) {
            NodeNasabah tempDest = LLnasabah.head;
            boolean found = false;
            
            while (tempDest != null) {
                if (tempDest.data.noRekening.equals(rekTujuan)) {
                    saldo -= jumlahTransfer;
                    
                    tempDest.data.saldo += jumlahTransfer;
                    
                    System.out.println("Transfer berhasil!");
                    System.out.println("Nomor Rekening Tujuan: " + rekTujuan);
                    System.out.println("Jumlah Transfer: Rp. " + jumlahTransfer);
                    
                    found = true;
                    break;
                }
                tempDest = tempDest.next;
            }
            
            if (!found) {
                System.out.println("Nomor rekening tujuan tidak ditemukan!");
            }
        } else {
            System.out.println("Transfer gagal!");
            if (jumlahTransfer <= 0) {
                System.out.println("Jumlah transfer tidak valid.");
            } else {
                System.out.println("Saldo tidak mencukupi.");
            }
        }
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

    private void hubungiCS(LinkedListNasabah LLnasabah){
        System.out.println("Anda akan masuk ke dalam antrian CS");
        LLnasabah.addAntrianCS(this);
        System.out.println("Anda telah masuk ke dalam antrian CS");
    }
}
