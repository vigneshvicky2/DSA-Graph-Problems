import java.util.*;

public class pq{
    static class pair{
        int node;
        int weight;
        pair(int node , int weight){
            this.node = node;
            this.weight=weight;
        }
        
    }
    public static void main(String[] args){
        int v = 5;
        ArrayList<ArrayList<pair>> adj_list = new ArrayList<>();
        for(int i =0; i<v;i++){
            adj_list.add(new ArrayList<>());
        }

        adj_list.get(0).add(new pair(1, 2));
        adj_list.get(0).add(new pair(3, 1));
        adj_list.get(1).add(new pair(2, 2));
        adj_list.get(3).add(new pair(4, 2));
        adj_list.get(2).add(new pair(4, 1));
        djikstra(v,0,adj_list);
    }

    static void djikstra(int v ,int source, ArrayList<ArrayList<pair>> adj_list){
        int[] s_p = new int[v];
        Arrays.fill(s_p,Integer.MAX_VALUE);
        s_p[source]=0;
        PriorityQueue<pair> pq = new PriorityQueue<>((a,b) -> a.weight- b.weight);
        pq.offer(new pair(source,0));

        while(!pq.isEmpty()){
            pair cur = pq.poll();
            int node = cur.node;
            for(pair temp : adj_list.get(node)){
                int val = temp.node;
                int weight = temp.weight;
                if(s_p[val] > s_p[node] + weight){
                    s_p[val] = s_p[node] + weight;
                    pq.offer(new pair(val , s_p[node]));
                }
            }
        }
        
        for(int i =0; i<v ;i++){
            System.out.println(s_p[i]+" ");
        }
    }
}