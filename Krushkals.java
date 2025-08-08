import java.util.*;
class Edge{
    int src,dest,weight;
    
    Edge(int src, int dest, int weight){
        this.src=src;
        this.dest = dest;
        this.weight = weight;
    }
}

class DisjointSet{
    int[] parent;
    
    DisjointSet(int n){
        parent = new int[n];
        for(int i=0; i<n;i++){
           parent[i] = i;
        }
    }
    
    // find the root of edges
    
    int find(int x){
        if(parent[x] != x){
           parent[x]=find(parent[x]);
        }
        
        return parent[x];
    }
    
    // find the union 
    
    boolean union(int a, int b){
        int rootA = find(a);
        int rootB = find(b);
    if(rootA == rootB){
        return false;
    }
    parent[rootA]= rootB;
    return true;
    }
    
}


public class Krushkals{
    public static void main(String[] args){
       int V = 5;
       
       List<Edge> edges = new ArrayList<>();
     
       edges.add(new Edge(0,1,2));
       edges.add(new Edge(0,3,6));
       edges.add(new Edge(3,1,8));
       edges.add(new Edge(1,2,3));
       edges.add(new Edge(4,2,7));
       edges.add(new Edge(1,4,5));
       
       edges.sort(Comparator.comparing(e->e.weight));
     
     DisjointSet ds = new DisjointSet(V);
     
     int sum = 0;
     
     System.out.println("Minimum Spanning cost");
     
     
     for(Edge ed : edges){
         if(ds.union(ed.src,ed.dest)) {
             System.out.println(ed.src+" -> "+ed.dest+" Edge Weight "+ed.weight);
             sum+=ed.weight;
         }
         
     }
     System.out.print("Minimum cost of the tree: "+sum);
       
     }
}