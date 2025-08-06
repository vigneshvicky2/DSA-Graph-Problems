import java.util.*;
public class Mst {
    public static void main(String[] args) {
        System.out.println((int)'A');
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        prims p = new prims(n);
        while (true) { 
            char u = s.next().charAt(0);
            char v = s.next().charAt(0);
            int w = s.nextInt();
            if(u!='1') {
                p.add_edge(u, v, w);
            }
            else break;      
        }         
        p.mst();
    }
}

class Node{
    char v,p;
    int w;
    Node(char v , char p , int w){
        this.v = v;
        this.p = p;
        this.w = w;
    }
}

class prims{
    ArrayList<ArrayList<char[]>>  ad_list = new ArrayList<>();
    int size;
    prims(int v){
        size = v;
        for(int i = 0; i<v;i++){
            ad_list.add(new ArrayList<>());
        }
    }
    void add_edge(char u , char v , int w){
        ad_list.get(u-'A').add(new char[] {v , String.valueOf(w).charAt(0)});
        ad_list.get(v-'A').add(new char[] {u , String.valueOf(w).charAt(0)});
    }
    void print(){
        for(int i =0; i<ad_list.size() ;i++){
            for(int j =0; j < ad_list.get(i).size() ;j++){
                System.out.println(Arrays.toString(ad_list.get(i).get(j)));
            }
        }
    }

    void mst() {
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(a->a.w));
        boolean[] vis = new boolean[size];
        int sum =0;
        pq.offer(new Node('A','/' , 0));
        System.out.println("MST: ");
        while(!pq.isEmpty()){
            Node cur = pq.poll();
            if(vis[cur.v-'A']) continue;
            if(cur.p!='/'){
                System.out.println(cur.v +" -> "+cur.p +" = "+ cur.w);
                sum+=cur.w;
            }
            vis[cur.v-'A'] = true;
            for(char[] neigh : ad_list.get(cur.v-'A')){
                if(!vis[neigh[0]-'A']){
                    pq.offer(new Node(neigh[0], cur.v, Character.getNumericValue(neigh[1])));
                }
          }
        }
        System.out.println(sum);

    }
}