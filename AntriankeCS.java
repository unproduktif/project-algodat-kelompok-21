public class AntriankeCS {
    private NodeAntrian front, rear;

    private static class NodeAntrian{
        Nasabah nasabah;
        NodeAntrian next;

        NodeAntrian(Nasabah nasabah){
            this.nasabah=nasabah;
            this.next=null;
        }
    }
    public AntriankeCS(){
        this.front=this.rear=null;
    }
    public boolean isEmpty(){
        return front==null;
    }
    public void enqueue(Nasabah nasabah){
        NodeAntrian antrianBaru= new NodeAntrian(nasabah);
        if(rear==null){
            front=rear=antrianBaru;
        }else{
            rear.next=antrianBaru;
            rear=antrianBaru;
        }
        System.out.println("Nasabah "+nasabah.nama);
    }
    public Nasabah dequeue(){
        if(isEmpty()){
            System.out.println("Antrian kosong");
            return null;
        }
        Nasabah nasabah =front.nasabah;
        front=front.next;
        if(front==null){
            rear=null;
        }
        return nasabah;
    }

    public void displayAntrian(){
        if(isEmpty()){
            System.out.println("Antrian ke CS kosong");
            return;
        }
        System.out.println("--- Daftar Antrian ke CS");
        NodeAntrian temp=front;
        while(temp !=null){
            System.out.println("- "+temp.nasabah.nama+" No. Rekening "+temp.nasabah.noRekening);
            temp=temp.next;
        }
    }
}
