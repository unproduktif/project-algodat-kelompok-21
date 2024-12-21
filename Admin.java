import java.util.Scanner;
public class Admin{
    LinkedListNasabah LLnasabah;
    Scanner scanner;

    public Admin(LinkedListNasabah LLnasabah, Scanner scanner){
        this.LLnasabah=LLnasabah;
        this.scanner=scanner;
    }
    public void menuAdmin(){
        boolean running=true;
        while(running){
            System.out.println("\n====================[ WELCOME ADMIN ]====================");
            System.out.println("            [===  SYSTEM MANAGEMENT  ===]");
            System.out.println("=========================================================");
            System.out.println("1. Daftar Nasabah");
            System.out.println("2. Antrian CS");
            System.out.println("3. Keluar");
            System.out.print("Pilih menu: ");
            int pilihan = scanner.nextInt();

            switch(pilihan){
                case 1:
                    daftarNasabah();
                    break;
                case 2:
                    antrianCS();
                    break;
                case 3:
                    running=false;
                    return;
            }
        }
    }
    //MENU DAFTAR NASABAH
    public void daftarNasabah(){
        boolean running =true;
        while(running){
            System.out.println("\n===========================================");
            System.out.println("||             DAFTAR NASABAH            ||");
            System.out.println("===========================================");
            System.out.println("1. Cari Nasabah");
            System.out.println("2. Urutkan Nasabah");
            System.out.println("3. Daftar Nasabah");
            System.out.println("4. Kembali");
            System.out.print("Pilih menu: ");
            int pilihan = scanner.nextInt();
            scanner.nextLine();
            switch (pilihan) {
                case 1:
                    cariNasabah();
                    break;
                case 2:
                    urutkanNama();
                    break;
                case 3:
                    tampilkanNasabah();
                    break;
                case 4:
                    running = false;
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
    }

    public void cariNasabah(){
        System.out.println("\n===========================================");
        System.out.println("||             DAFTAR NASABAH            ||");
        System.out.println("===========================================");
        System.out.print("Masukkan username nasabah: ");
        String username = scanner.next();
        NodeNasabah temp = LLnasabah.head;

        while(temp !=null){
            if(temp.data.username.equals(username)){
                System.out.println("Nasabah ditemukan: ");
                System.out.println("Nama        : " + temp.data.nama);
                System.out.println("Username    : " + temp.data.username);
                System.out.println("Alamat      : " + temp.data.alamat);
                System.out.println("No Rekening : " + temp.data.noRekening);
                scanner.nextLine();
                scanner.nextLine();
                return;
            }
            temp=temp.next;
        }
        System.out.println("Nasabah dengan username '" + username + "' tidak ditemukan.");
        scanner.nextLine();
    }

    public void urutkanNama() {
        if (LLnasabah.head == null || LLnasabah.head.next == null) return;

        boolean swapped;
        do {
            swapped = false;
            NodeNasabah current = LLnasabah.head;
            while (current.next != null) {
                if (current.data.nama.compareTo(current.next.data.nama) > 0) {
                    Nasabah temp = current.data;
                    current.data = current.next.data;
                    current.next.data = temp;
                    swapped = true;
                }
                current = current.next;
            }
        } while (swapped);
        tampilkanNasabah();
    }

    public void tampilkanNasabah() {
        System.out.println("\n===========================================");
        System.out.println("||             DAFTAR NASABAH            ||");
        System.out.println("===========================================");
        if (LLnasabah.head == null) {
            System.out.println("Belum ada nasabah yang terdaftar.");
        } else {
            NodeNasabah temp = LLnasabah.head;
            while (temp != null) {
                System.out.println("Nama: " + temp.data.nama + ", No. Rekening: "+temp.data.noRekening+", Username: " + temp.data.username + ", Alamat: " + temp.data.alamat);
                temp = temp.next;
            }
        }
        scanner.nextLine();
    }

    public void antrianCS(){
        boolean running = true;
        while (running) {
            System.out.println("\n===========================================");
            System.out.println("||              ANTRIAN KE CS            ||");
            System.out.println("===========================================");
            System.out.println("1. Lihat Antrian");
            System.out.println("2. Proses Antrian");
            System.out.println("3. Keluar");
            System.out.print("Pilih menu: ");
            int pilihan = scanner.nextInt();
            switch (pilihan) {
                case 1:
                    LLnasabah.listAntrian();
                    break;
                case 2:
                    LLnasabah.prosesAntrianCS();
                    break;
                case 3:
                    running = false;
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
    }
}
