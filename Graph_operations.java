import java.util.*;
public class Graph_operations {
  public static void main(String[] args) {
      graph g = new graph(5);
        g.add(0,1);
        g.add(0,2);
        // g.add(1,2);
        g.add(1,3);
        // g.add(2,4);
        // g.add(3,4);
        g.display();
        // g.bfs(0);
        System.out.println();
        //g.solve_bfs(0,3);
        // g.solve_dfs(0,3);
        // g.dfs(0);
  }
}

 class graph{
    ArrayList<ArrayList<Integer>> ad_li = new ArrayList<>();

    graph(int v){
        for(int i =0; i<v ;i++){
            ad_li.add(new ArrayList<>());
        }
    }
    void add(int v ,int u){
        ad_li.get(v).add(u);
        ad_li.get(u).add(v);
    }
    void display(){
        for(int i =0; i< ad_li.size() ;i++){
            System.out.println(i+
            " -> "+ad_li.get(i));
        }
    }

    void bfs(int v){
        Queue<Integer> q = new LinkedList<>();
        boolean visited[] = new boolean[ad_li.size()];
        q.offer(v);
        visited[v] = true;
        System.out.println("BFS: ");
        while(!q.isEmpty()){
            int vertex = q.poll();
            System.out.print(vertex+" ");
            for(int i =0; i<ad_li.get(vertex).size() ;i++){
                int av = ad_li.get(vertex).get(i);
                if(!visited[av]) {
                    q.offer(av);
                    visited[av] = true;
                }
            }
        }
    }

    void dfs(int v){
        Stack<Integer> q = new Stack<>();
        boolean visited[] = new boolean[ad_li.size()];
        q.push(v);
        visited[v] = true;
        System.out.println("DFS: ");
        while(!q.isEmpty()){
            int vertex = q.pop();
            System.out.print(vertex+" ");
            for(int i =0; i<ad_li.get(vertex).size() ;i++){
                int av = ad_li.get(vertex).get(i);
                if(!visited[av]) {
                    q.push(av);
                    visited[av] = true;
                }
            }
        }
    }
    // my approach
    void solve(int s , int d){
        if (s < ad_li.size()) {
        if (ad_li.get(s).contains(d)) {
            System.out.println("Path found");
            return; 
        } 
        else solve(s + 1, d); 
        } 
    else System.out.println("Path not found");
   
    }
    void solve_bfs(int v, int d){
        Queue<Integer> q = new LinkedList<>();
        boolean visited[] = new boolean[ad_li.size()];
        q.offer(v);
        visited[v] = true;
        // System.out.println("BFS: ");
        while(!q.isEmpty()){
            int vertex = q.poll();
            if(vertex==d){
                System.out.println("Path found");
                return;
            }
            // System.out.print(vertex+" ");
            for(int i =0; i<ad_li.get(vertex).size() ;i++){
                int av = ad_li.get(vertex).get(i);
                if(!visited[av]) {
                    q.offer(av);
                    visited[av] = true;
                }
            }
        }
        System.out.println("Path not found");
    }
    void solve_dfs(int v, int d){
        Stack<Integer> q = new Stack<>();
        boolean visited[] = new boolean[ad_li.size()];
        q.push(v);
        visited[v] = true;
        // System.out.println("DFS: ");
        while(!q.isEmpty()){
            int vertex = q.pop();
             if(vertex==d){
                System.out.println("Path found");
                return;
            }
            // System.out.print(vertex+" ");
            for(int i =0; i<ad_li.get(vertex).size() ;i++){
                int av = ad_li.get(vertex).get(i);
                if(!visited[av]) {
                    q.push(av);
                    visited[av] = true;
                }
            }
        }
        System.out.println("Path not found");
    }
}
