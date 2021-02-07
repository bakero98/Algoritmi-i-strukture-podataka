package deveti;

import java.util.LinkedList;

class Graph {

    private int num;

    //Niz listi - svaki element niza odgovara cvoru, tj. to je lista njegovih suseda
    private LinkedList<Integer> adj[];

    Graph(int v) {
        num = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i) {
            adj[i] = new LinkedList();
        }
    }


    void addEdge(int v, int w) {
        adj[v].add(w);
    }

    // Rekurzivni DFS
    void DFSUtil(int v, boolean visited[]) {
        //Trenutni cvor je posecen i stampa se
        visited[v] = true;
        System.out.print(v + " ");

        // Uradi sve to rekurzivno za njegove susede
        for (int n : adj[v]) {
            if (!visited[n]) {
                DFSUtil(n, visited);
            }
        }

    }

    //Pomocna metoda koja vrsi inicijalizaciju
    void DFS(int v) {
        //inicijalno, nema posecenih cvorova
        boolean visited[] = new boolean[num];

        //poziv rekurzivne metode
        DFSUtil(v, visited);
    }

    //BFS pomocu reda
    void BFS(int s) {

        boolean visited[] = new boolean[num];

        //Kreira se red struktura potrebna za BFS
        LinkedList<Integer> queue = new LinkedList<Integer>();

        //trenutni cvor se poseti i stavi u red
        visited[s] = true;
        queue.add(s);

        while (queue.size() != 0) {
            //skini iz reda i stampaj
            s = queue.poll();
            System.out.print(s + " ");

            //uzme svaki susedni cvor trenutnog, ako nije posecen, oznaci
            //da jeste i stavi u red
            for (int n : adj[s]) {
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }

}
