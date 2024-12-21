public class Dijkstra{
    LLgraph graph;

    public Dijkstra(){
        this.graph = new LLgraph();
    }

    public void addEdge(String asal, String tujuan, int jarak){
        Nodegraph nodeAsal = graph.cariNodegraph(asal);
        Nodegraph nodeTujuan = graph.cariNodegraph(tujuan);
        if(nodeAsal != null && nodeTujuan != null){
            nodeAsal.addNeighbor(nodeTujuan, jarak);
            nodeTujuan.addNeighbor(nodeAsal, jarak);
        }
    }

    public void tandaiCabang(String namaLokasi) {
        Nodegraph node = graph.cariNodegraph(namaLokasi);
        if (node != null) {
            node.isCabang = true;
        }
    }

    public void ruteterpendek(String namaLokasiNasabah) {
        Nodegraph nodeAwal = graph.cariNodegraph(namaLokasiNasabah);
        if (nodeAwal == null) {
            System.out.println("Lokasi tidak ditemukan!");
            return;
        }
 
        Nodegraph current = graph.head;
        while (current != null) {
            current.jarak = Integer.MAX_VALUE;
            current.visited = false;
            current.prev = null;
            current = current.next;
        }
        nodeAwal.jarak = 0;
    
        for (int i = 0; i < graph.size(); i++) {
            Nodegraph nodeterdekat = findNodeTerdekat();
            if (nodeterdekat == null) break;
    
            nodeterdekat.visited = true;
            Edgegraph edgegraph = nodeterdekat.neighbors;
            while (edgegraph != null) {
                Nodegraph neighbor = edgegraph.target;
                if (!neighbor.visited && nodeterdekat.jarak + edgegraph.jarak < neighbor.jarak) {
                    neighbor.jarak = nodeterdekat.jarak + edgegraph.jarak;
                    neighbor.prev = nodeterdekat;
                }
                edgegraph = edgegraph.next;
            }
        }
  
        Nodegraph cabangTerdekat = null;
        int jarakTerdekat = Integer.MAX_VALUE;
    
        current = graph.head;
        while (current != null) {
            if (current.isCabang && current.jarak < jarakTerdekat) {
                jarakTerdekat = current.jarak;
                cabangTerdekat = current;
            }
            current = current.next;
        }
    
        if (cabangTerdekat != null) {
            printRoute(cabangTerdekat);
        } else {
            System.out.println("Tidak ada cabang bank yang ditemukan.");
        }
    }

    private Nodegraph findNodeTerdekat(){
        Nodegraph nodeterdekat = null;
        int jarakmin = Integer.MAX_VALUE;

        Nodegraph current = graph.head;
        while(current != null){
            if(!current.visited && current.jarak < jarakmin){
                jarakmin = current.jarak;
                nodeterdekat = current;
            }
            current = current.next;
        }
        return nodeterdekat;
    }

    public void printRoute(Nodegraph nodeTujuan) {
        Nodegraph current = nodeTujuan;
        String route = "";
        while (current != null) {
            route = current.namaLokasi + " -> " + route;
            current = current.prev;
        }
        route = route.substring(0, route.length() - 4);

        System.out.println("Cabang terdekat: " + nodeTujuan.namaLokasi + " dengan jarak " + nodeTujuan.jarak+" Meter");
        System.out.println("Melalui rute: " + route);
    }
}