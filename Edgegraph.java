public class Edgegraph {
    Nodegraph target;
    int jarak;
    Edgegraph next;

    public Edgegraph(Nodegraph target, int jarak){
        this.target = target;
        this.jarak = jarak;
        this.next = null;
    }
}
