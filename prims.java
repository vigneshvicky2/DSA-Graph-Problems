import java.util.*;
public class prims{
    public static void main(String[] args) {
        int V = 5;
        graph g = new graph(V);
        g.add(0,1,2);
        g.add(0,3,6);
        g.add(1,2,3);
        g.add(1,3,8);
        g.add(1,4,5);
        g.add(2,4,7);
    
        g.prims();
    }
}

class Pair{
    int v,p,w;
    Pair(int v , int p , int w){
        this.v = v;
        this.p = p;
        this.w=w;
    }

}

class graph {
    int size;
    List<List<int[]>> adj = new ArrayList<>();
    graph(int V){
        this.size =V;
        for(int i =0; i<V ;i++){
            adj.add(new ArrayList<>());
        }
    }
    void add(int u , int v , int w){
        adj.get(u).add(new int[] {v,w});
        adj.get(v).add(new int[] {u,w});
    }
    
    void prims(){
        boolean[] visited =new boolean[size];
        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(a->a.w));
        pq.offer(new Pair(0, -1, 0));
        int sum =0;
        System.out.println("Minimum Spanning Tree  ");
        while(!pq.isEmpty()){
            Pair cur = pq.poll();
            if(visited[cur.v]) continue;
            if(cur.p!=-1) {
                System.out.println(cur.p +"->" + cur.v +" weight: "+cur.w);
                sum+=cur.w;
            }
            visited[cur.v] = true;
            for(int[] neigh : adj.get(cur.v)){
                if(!visited[neigh[0]]){
                    pq.offer(new Pair(neigh[0] , cur.v , neigh[1]));
                }
            }
        }
        System.out.println("Total sum : "+sum);

    }

}