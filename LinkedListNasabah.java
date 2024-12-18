public class LinkedListNasabah {
    NodeNasabah head, tail;
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
        Nasabah nasabahBaru=new Nasabah(newName, noRekening, newUsername, newPassword, saldo, noRekening);
        if(head == null){
            head = tail = new NodeNasabah(nasabahBaru);
        }else{
            tail.next= new NodeNasabah(nasabahBaru);
            tail=tail.next;
        }
        counter++;
        return true;
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
}
