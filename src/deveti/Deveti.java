package deveti;

public class Deveti {
    private static Deveti instance;

    public static Deveti getInstance() {
        if(instance == null){
            instance = new Deveti();
        }
        return instance;
    }

    public void deveti(){

        Graph g = new Graph(6);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 4);
        g.addEdge(5, 4);

        System.out.println("DFS iz cvora 2: ");

        g.DFS(2);
        System.out.println("BFS iz cvora 3: ");
        g.BFS(1);

    }
}
