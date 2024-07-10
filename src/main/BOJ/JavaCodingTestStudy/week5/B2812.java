package JavaCodingTestStudy.week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class B2812 {
    public static void main(String[] args) throws IOException {
        int N,K;
        Stack<Integer>stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        String str = br.readLine();
        char[] chars = str.toCharArray();
        int popCount = 0;
        for (int i = 0; i < N; i++) {
            while (!stack.isEmpty() && stack.peek()<chars[i]-'0' && popCount<K) {
                stack.pop();
                popCount++;
            }
            stack.push(chars[i]-'0');
        }
        while(popCount < K) {
            stack.pop();
            popCount++;
        }
        for(int i = 0; i < stack.size(); i++) {
            sb.append(Integer.toString(stack.get(i)));
        }
        System.out.println(sb);



    }
}
