public class NodeTransaksi {
    Transaksi data;
    NodeTransaksi next;
    
    public NodeTransaksi(Transaksi data){
        this.data = data;
        this.next=null;
    }
}
