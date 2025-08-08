import java.util.*;
public class cycle_in_undirected_graph {
    public static void main(String[] args){
        un_graph g = new un_graph(5);
        g.add(0,1);
        g.add(0,2);
        g.add(2,1);
        System.out.println(g.is_cycle());

    }
    
}
class Pair{
    int v ; 
    int parent ;
    Pair(int v , int parent){
        this.v = v;
        this.parent = parent;
    }
}
class un_graph{
    List<List<Integer>> adj = new ArrayList<>();
    int V ;
    un_graph(int V){
        this.V = V;
        for(int i =0; i<V ;i++){
            adj.add(new ArrayList<>());
        }
    }

    void add( int u , int v){
        adj.get(u).add(v);
        adj.get(v).add(u);
    }
    boolean is_cycle(){
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(0,-1));
        boolean[] vis = new boolean[V];
        vis[0] = true;
        while(!q.isEmpty()){
            Pair cur = q.poll();
            for(int neigh : adj.get(cur.v)){
                if(!vis[neigh]){
                    vis[neigh] = true;
                    q.offer(new Pair(neigh , cur.v));
                }
                else if(neigh!=cur.parent){
                    return true;
                }
            }
        }
        return false;
    }

}
