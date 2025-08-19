import java.io.*;
import java.util.*;

public class BOJ2503 {
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int answer = 0;
        int n = Integer.parseInt(br.readLine());
        int [][] baseball = new int [n][5];
        for(int i = 0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            int temp = Integer.parseInt(st.nextToken());
            int h = temp/100;
            int t = (temp-h*100)/10;
            int o = temp-(h*100)-(t*10);
            baseball[i][0] = h;
            baseball[i][1] = t;
            baseball[i][2] = o;
            baseball[i][3] = Integer.parseInt(st.nextToken());
            baseball[i][4] = Integer.parseInt(st.nextToken());
        }
        for(int i = 100; i<=999; i++){
            int h = i/100;
            int t = (i-h*100)/10;
            int o = i-(h*100)-(t*10);
            int j = 0;
            if(h==t || t==o || o==h) continue;
            if(h==0 || t==0 || o==0) continue;
            while(true){
                if(j==n){
                    answer++;
                    break;
                }
                int s = 0;
                int b = 0;
                if(h == baseball[j][0]){
                    s++;
                }else if(h == baseball[j][1] || h == baseball[j][2]){
                    b++;
                }
                if(t == baseball[j][1]){
                    s++;
                }else if(t == baseball[j][0] || t == baseball[j][2]){
                    b++;
                }
                if(o == baseball[j][2]){
                    s++;
                }else if(o == baseball[j][1] || o == baseball[j][0]){
                    b++;
                }
                if(s == baseball[j][3] && b == baseball[j][4]){
                    j++;
                }else{
                    break;
                }
            }
        }
        System.out.println(answer);
    }
}
