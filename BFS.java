import java.lang.reflect.Array;
import java.util.*;
public class BFS{
    public static void main(String[] args){
        solve b = new solve();
        b.addEdge('P','Q');
        b.addEdge('P','R');
        b.addEdge('Q','S');
        b.addEdge('R','T');
        b.addEdge('T','U');
        b.print();
        b.bfs('P');

    }
    
}
class solve {
    HashMap<Character, ArrayList<Character>> map = new HashMap<>();
    void addEdge(char u, char v) {
        map.putIfAbsent(u, new ArrayList<>());
        map.putIfAbsent(v, new ArrayList<>());
        map.get(u).add(v);
        map.get(v).add(u);
    } 
    void print(){
        System.out.println(map);
    }
    void bfs(char src) {
        Queue<Character> q = new LinkedList<>();
        boolean[] vis = new boolean[26];
        q.offer(src);
        vis[src-'A']=true;
        while(!q.isEmpty()){
            char cur = q.poll();
            System.out.print(cur+" ");
            ArrayList<Character> arr =map.get(cur); 
            for(int i =0; i< arr.size() ;i++){
                if(!vis[arr.get(i)-'A']){
                    q.offer(arr.get(i));
                    vis[arr.get(i)-'A'] = true;
                }
            }
        }

    }  
}