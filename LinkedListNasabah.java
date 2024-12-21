public class LinkedListNasabah {
    NodeNasabah head, tail;
    AntriankeCS antriankeCS=new AntriankeCS();
    private int counter=1;
    public boolean login(String username, String password){
        NodeNasabah temp = head;
        while (temp != null){
            if (temp.data.username.equals(username) && temp.data.password.equals(password)){
                return true;
            }
            temp = temp.next;
        }
        return false;
    }
    public boolean daftar(String newName, String newAddress, String newUsername, String newPassword, double saldo){
        String noRekening=noRek(counter);
        Nasabah nasabahBaru=new Nasabah(newName, newAddress, newUsername, newPassword, saldo, noRekening);
        if(head == null){
            head = tail = new NodeNasabah(nasabahBaru);
        }else{
            tail.next= new NodeNasabah(nasabahBaru);
            tail=tail.next;
        }
        counter++;
        return true;
    }
    public void hapusAkun(String username){
        if(head==null){
            return;
        }
        NodeNasabah temp = head;
        NodeNasabah prev =null;
        if(temp!=null&&temp.data.username.equals(username)){
            head=temp.next;
            System.out.println("Akun " + username + " berhasil dihapus.");
            return;
        }
        while (temp!=null&&!temp.data.username.equals(username)){
            prev=temp;
            temp=temp.next;
        }
        if(temp.next==null){
            prev.next=null;
            System.out.println("Akun " + username + " berhasil dihapus.");
        }else{
            prev.next=temp.next;
            System.out.println("Akun " + username + " berhasil dihapus.");
        }
    }
    public boolean usernameTerdata(String username){
        NodeNasabah temp = head;
        while(temp!=null){
            if(temp.data.username.equals(username)){
                return true;
            }
            temp=temp.next;
        }
        return false;
    }
    private String noRek(int count){
        char huruf=(char)('A'+((count-1)/999));
        int angka=((count-1)%999)+1;
        return huruf+String.format("%03d",angka);
    }

    //untuk Antrian Ke CS
    public void addAntrianCS(Nasabah nasabah ){
        antriankeCS.enqueue(nasabah);
    }
    public void listAntrian(){
        System.out.println("\n===========================================");
        System.out.println("||             DAFTAR ANTRIAN            ||");
        System.out.println("===========================================");
        antriankeCS.displayAntrian();
    }
    public void prosesAntrianCS() {
        System.out.println("\n===========================================");
        System.out.println("||             PROSES ANTRIAN            ||");
        System.out.println("===========================================");
        if (antriankeCS.isEmpty()) {
            System.out.println("Antrian CS kosong.");
            return;
        }
        Nasabah nasabahDiproses = antriankeCS.dequeue();
        System.out.println("Nasabah " + nasabahDiproses.nama + " telah selesai diproses.");

        if (!antriankeCS.isEmpty()) {
            System.out.println("Antrian selanjutnya adalah: " + antriankeCS.peek().nama);
        } else {
            System.out.println("Antrian sudah kosong.");
        }
    }
}
