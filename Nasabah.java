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
        this.mutasi = new LLTranksaksi();
    }
    public void menuNasabah(Scanner scanner, LinkedListNasabah LLnasabah){
        boolean running=true;
        while(running){
            System.out.println("\n===========================================");
            System.out.println("||            MENU NASABAH               ||");
            System.out.println("===========================================");
            System.out.println("Selamat datang, "+ nama+"\n");
            System.out.println("1. Isi Saldo\t\t5. Info Saldo");
            System.out.println("2. Tarik Tunai\t\t6. Info Akun");
            System.out.println("3. Transfer\t\t7. Hubungi CS");
            System.out.println("4. Cek Mutasi\t\t8. Kantor Cabang");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu: ");
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
                    mutasi.cekMutasi(scanner);
                    break;
                case 5:
                    infoSaldo(scanner);
                    break;
                case 6:
                    infoAkun(scanner, LLnasabah);
                    break;
                case 7:
                hubungiCS(scanner, LLnasabah);
                    break;
                case 8:
                kantorCabang(scanner);
                    break;
                case 0:
                    return; 
                default:
                    break;
            }
        }
    }
    private void isiSaldo(Scanner scanner){
        System.out.println("\n===========================================");
        System.out.println("||            ISI SALDO                  ||");
        System.out.println("===========================================");
        System.out.print("Masukkan jumlah saldo: ");
        double isisaldo=scanner.nextDouble();
        if(isisaldo>0){
            saldo+=isisaldo;
            System.out.println("Saldo berhasil ditambahkan sebesar Rp. "+isisaldo);
            mutasi.push(LocalDate.now(), "Isi saldo", isisaldo, saldo);
        }else{
            System.out.println("Jumlah saldo tidak valid!");
        }
        scanner.nextLine();
        scanner.nextLine();
    }
    private void tarikTunai(Scanner scanner) {
        System.out.println("\n===========================================");
        System.out.println("||            TARIK TUNAI                ||");
        System.out.println("===========================================");
        System.out.print("Masukkan jumlah tarik tunai: ");
        double tarikTunai = scanner.nextDouble();
        if (tarikTunai > 0 && tarikTunai <= saldo) {
            saldo -= tarikTunai;
            System.out.println("Tarik tunai berhasil sebesar Rp. " + tarikTunai);
            mutasi.push(LocalDate.now(), "Tarik tunai", tarikTunai, saldo);
        } else {
            System.out.println("Tarik tunai gagal! Saldo tidak mencukupi.");
        }
        scanner.nextLine();
        scanner.nextLine();
    }
    private void transfer(Scanner scanner, LinkedListNasabah LLnasabah) {
        System.out.println("\n===========================================");
        System.out.println("||            TRANSFER                   ||");
        System.out.println("===========================================");
        System.out.print("Masukkan nomor rekening tujuan: ");
        String rekTujuan = scanner.nextLine();
        if (rekTujuan.equals(noRekening)) {
            System.out.println("Anda tidak bisa mentransfer uang ke rekening Anda sendiri.");
            return;
        }
        
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
                    System.out.println("Saldo Anda Sekarang: Rp. " + saldo);
                    mutasi.push(LocalDate.now(), "Transfer uang menuju nomor rekening"+rekTujuan, jumlahTransfer, saldo);
                    
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
        scanner.nextLine();
    }
    private void infoSaldo(Scanner scanner){
        System.out.println("\n===========================================");
        System.out.println("||            INFO SALDO                 ||");
        System.out.println("===========================================");
        System.out.println("Saldo Anda saat ini Rp. "+ saldo);
        scanner.nextLine();
    }
    private void infoAkun(Scanner scanner, LinkedListNasabah LLnasabah) {
        System.out.println("\n===========================================");
        System.out.println("||            INFO AKUN                  ||");
        System.out.println("===========================================");
        System.out.println("Nama        : " + nama);
        System.out.println("Alamat      : " + alamat);
        System.out.println("Username    : " + username);
        System.out.println("Saldo       : Rp. " + saldo);
        System.out.println("No Rekening : " + noRekening);
        System.out.println("\n=========================================");
        System.out.println("1. Hapus Akun");
        System.out.println("2. Kembali");
        System.out.print("Pilih menu: ");
        int pilih =scanner.nextInt();
        scanner.nextLine();
        switch (pilih) {
            case 1:
                LLnasabah.hapusAkun(username);
                scanner.nextLine();
                MenuAwal.tampilkanMenu(LLnasabah, scanner);
                return;
            case 2:
                return;
            default:
                System.out.println("Pilihan tidak valid.");
                break;
        }
    }

    private void hubungiCS(Scanner scanner, LinkedListNasabah LLnasabah){
        System.out.println("\n===========================================");
        System.out.println("||            HUBUNGI CS                 ||");
        System.out.println("===========================================");
        System.out.println("Anda akan masuk ke dalam antrian CS");
        LLnasabah.addAntrianCS(this);
        scanner.nextLine();
        System.out.println("Anda telah masuk ke dalam antrian CS");
    }
    
    private void kantorCabang(Scanner scanner) {
        System.out.println("\n===========================================");
        System.out.println("||            KANTOR CABANG              ||");
        System.out.println("===========================================");
        System.out.print("Masukkan lokasi Anda saat ini: ");
        String lokasi=scanner.nextLine();
        Dijkstra dijkstra=new Dijkstra();

        dijkstra.graph.add("Cabang Utama");
        dijkstra.graph.add("Cabang A");
        dijkstra.graph.add("Cabang B");
        dijkstra.graph.add("Pagutan Barat");
        dijkstra.graph.add("Pagutan Timur");
        dijkstra.graph.add("Kekalik Jaya");
        dijkstra.graph.add("Punia");
        dijkstra.graph.add("Jempong Baru");
        dijkstra.graph.add("Karang Pule");
        dijkstra.graph.add("Pegasengan Barat");
        dijkstra.graph.add("Pejanggik");
        dijkstra.graph.add("Pegasengan Timur");
        dijkstra.graph.add("Mataram Timur");
        dijkstra.graph.add("Pagutan");

        dijkstra.tandaiCabang("Cabang A");
        dijkstra.tandaiCabang("Cabang B");
        dijkstra.tandaiCabang("Cabang Utama");

        dijkstra.addEdge("Cabang A", "Pagutan Barat",175);
        dijkstra.addEdge("Pagutan Barat", "Pagutan Timur",150);
        dijkstra.addEdge("Pagutan Barat", "Kekalik Jaya",145);
        dijkstra.addEdge("Pagutan Timur", "Punia",330);
        dijkstra.addEdge("Kekalik Jaya", "Jempong Baru",70);
        dijkstra.addEdge("Kekalik Jaya", "Karang Pule",325);
        dijkstra.addEdge("Karang Pule", "Pegasengan Barat",150);
        dijkstra.addEdge("Karang Pule", "Jempong Baru",400);
        dijkstra.addEdge("Punia", "Jempong Baru",50);
        dijkstra.addEdge("Punia", "Cabang B",400);
        dijkstra.addEdge("Punia", "Pejanggik",250);
        dijkstra.addEdge("Jempong Baru", "Pejanggik",100);
        dijkstra.addEdge("Pejanggik", "Pegasengan Barat",500);
        dijkstra.addEdge("Pejanggik", "Mataram Timur",150);
        dijkstra.addEdge("Pejanggik", "Pagutan",950);
        dijkstra.addEdge("Pejanggik", "Cabang Utama",150);
        dijkstra.addEdge("Pegasengan Barat", "Cabang Utama",1000);
        dijkstra.addEdge("Cabang Utama", "Pegasengan Timur",300);
        dijkstra.addEdge("Mataram Timur", "Pegasengan Timur",400);
        dijkstra.addEdge("Mataram Timur", "Pagutan",300);
        dijkstra.addEdge("Mataram Timur", "Cabang B",90);
        dijkstra.ruteterpendek(lokasi);
        scanner.nextLine();
    }
}