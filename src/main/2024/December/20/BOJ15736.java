import java.io.*;
import java.util.*;

public class BOJ15736 {
    public static void main(String [] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        System.out.println((int)Math.sqrt(N));
    }
}
