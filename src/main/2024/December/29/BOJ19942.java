import java.io.*;
import java.util.*;

public class BOJ19942 {
    static int N;
    static int [] standard;
    static int [][] ingre;
    static List<Integer>cart;
    static List<Integer>tempCart;
    static int cost;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        standard = new int [4];
        for(int i = 0; i<4; i++){
            standard[i] = Integer.parseInt(st.nextToken());
        }

        ingre = new int [N][5];
        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            ingre[i][0] = Integer.parseInt(st.nextToken());
            ingre[i][1] = Integer.parseInt(st.nextToken());
            ingre[i][2] = Integer.parseInt(st.nextToken());
            ingre[i][3] = Integer.parseInt(st.nextToken());
            ingre[i][4] = Integer.parseInt(st.nextToken());
        }

        cost = Integer.MAX_VALUE;
        cart = new ArrayList<>();
        tempCart = new ArrayList<>();

        recur(0,0,0,0,0,0);

        if(cost == Integer.MAX_VALUE){
            System.out.println("-1");
        }else{
            System.out.println(cost);
            for(int num : cart){
                System.out.print(num + " ");
            }
        }

    }

    static void recur(int idx, int mp, int mf, int ms, int mv, int money){
        if(mp>=standard[0] && mf>=standard[1] && ms>=standard[2] && mv>=standard[3]){
            if(cost>money){
                cost=money;
                cart = new ArrayList<>(tempCart);
            }
        }
        if(idx == N) return;

        //담기
        tempCart.add(idx+1);
        recur(idx+1,mp+ingre[idx][0],
                mf+ingre[idx][1],ms+ingre[idx][2],mv+ingre[idx][3],money+ingre[idx][4]);
        tempCart.remove(tempCart.size()-1);

        //안담기
        recur(idx+1,mp,mf,ms,mv,money);
    }
}
