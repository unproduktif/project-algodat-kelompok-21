public class LinkedListNasabah {
    NodeNasabah head, tail;




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
    public boolean daftar(String newName, String newAddress, String newUsername, String newPassword){
        if(head == null){
            head = tail = new NodeNasabah(new Nasabah (newName, newAddress, newUsername, newPassword));
            return true;
        }
        NodeNasabah temp = head;
        while (temp != null){
            if(temp.data.username.equals(newUsername)){
                return false;
            }
            temp = temp.next;
        }
        tail.next = new NodeNasabah(new Nasabah (newName, newAddress, newUsername, newPassword));
        tail = tail.next;
        return true;
    }
}
