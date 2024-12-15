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
            System.out.println("\n--- Menu Admin ---");
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
    public void daftarNasabah(){
        NodeNasabah temp=LLnasabah.head;
        if(temp==null){
            System.out.println("Belum ada nasabah yang terdaftar");
        }else{
            System.out.println("--- Daftar Nasabah ---");
            while(temp!=null){
                System.out.println("Nama: "+temp.data.nama+", Username: "+temp.data.username+", Alamat: "+temp.data.alamat);
                temp=temp.next;
            }
        }
    }
    public void antrianCS(){

    }
}
