import java.util.*;
public class Monkey_food{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int k = s.nextInt();
        int j = s.nextInt();
        int m = s.nextInt();
        int p = s.nextInt();
        if(k>m || j>p){
            System.out.println("Invalid Output");
            return;
        }
        int no_money_banana = m/k;
        int no_money_peanut = p/j;
        int total = no_money_banana+ no_money_peanut;
        System.out.println(n -total);
    }
}