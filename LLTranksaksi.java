import java.time.LocalDate;
import java.util.Scanner;


public class LLTranksaksi {
    NodeTransaksi top;

    public LLTranksaksi(){
        top = null;
    }

    public void push(LocalDate tanggal, String deskripsi, double nominal, double saldoSetelahTransaksi){
        NodeTransaksi newNode = new NodeTransaksi(new Transaksi(tanggal, deskripsi, nominal, saldoSetelahTransaksi));
        if(top==null){
            top = newNode;
        } else {
            newNode.next = top;
            top = newNode;
        }
    }
    public void cekMutasi(Scanner scanner){
        System.out.println("\n===========================================");
        System.out.println("||            CEK MUTASI                 ||");
        System.out.println("===========================================");
        if(top==null){
            System.out.println("Mutasi kosong");
            scanner.nextLine();
            return;
        } else{
            System.out.println("--- Mutasi Saldo ---");
            NodeTransaksi temp = top;
            while(temp!=null){
                System.out.println("Tanggal: "+temp.data.tanggal+", Deskripsi: "+temp.data.deskripsi+", Nominal: Rp. "+temp.data.nominal+", Saldo Setelah Transaksi: Rp. "+temp.data.saldoSetelahTransaksi);
                temp=temp.next;
            }
            scanner.nextLine();
        }
    }
}