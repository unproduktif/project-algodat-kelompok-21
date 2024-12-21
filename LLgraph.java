public class LLgraph {
    Nodegraph head;

    public LLgraph(){
        this.head = null;
    }

    public void add(String namaLokasi){
        Nodegraph node = new Nodegraph(namaLokasi);
        if(head == null){
            head = node;
        } else {
            Nodegraph current = head;
            while(current != null){
                if(current.namaLokasi.equals(namaLokasi)) {
                    return;
                }
                if(current.next == null) {
                    current.next = node;
                    return;
                }
                current = current.next;
            }
        }
    }

    public Nodegraph cariNodegraph(String nama){
        Nodegraph current = head;
        while(current != null){
            if(current.namaLokasi.equals(nama)) return current;
            current = current.next;
        }
        return null;
    }

    public int size(){
        int size = 0;
        Nodegraph current = head;
        while(current != null){
            size++;
            current = current.next;
        }
        return size;
    }
}