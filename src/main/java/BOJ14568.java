import java.io.*;

public class BOJ14568 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int answer = 0;
        for(int i = 1; i<=N-2; i++){
            for(int j = 1; j<=N-2; j++){
                for(int k = 1; k<=N-2; k++){
                    if(i+j+k == N && k >= j+2 && i%2 == 0){
                        answer++;
                    }
                }
            }
        }
        System.out.println(answer);
    }
}
