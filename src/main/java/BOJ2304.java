import java.io.*;
import java.util.*;

public class BOJ2304 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int [] graph = new int [1001];
        List<Integer>xList = new ArrayList<>();
        List<Integer>yList = new ArrayList<>();
        for(int i = 0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph[x] = y;
            xList.add(x);
            yList.add(y);
        }

        int maxWidth = Collections.max(xList);
        int maxHeight = Collections.max(yList);

        int[] prefix = new int[maxWidth + 2];
        int[] suffix = new int[maxWidth + 2];
        List<Integer> maxPoint = new ArrayList<>();

        //prefix 계산 가장 큰 기둥 왼쪽
        int h = 0;
        for(int i = 1; i<=maxWidth+2; i++){
            if(graph[i] == maxHeight){
                maxPoint.add(i);
                break;
            }
            h = Math.max(h, graph[i]);
            prefix[i] = prefix[i-1] + h;
        }

        //suffix 계산 가장 큰 기둥 오른쪽
        h = 0;
        for(int i = maxWidth; i>0; i--){
            if(graph[i] == maxHeight){
                maxPoint.add(i);
                break;
            }
            h = Math.max(h, graph[i]);
            suffix[i] = suffix[i+1] + h;
        }
        int maxP = 0;
        int maxS = 0;
        for(int i = 0; i<prefix.length; i++){
            maxP = Math.max(prefix[i],maxP);
            maxS = Math.max(suffix[i],maxS);
        }
        int answer = maxP + maxS;
        answer += (maxPoint.get(maxPoint.size()-1)-maxPoint.get(0)+1) * maxHeight;
        System.out.println(answer);
    }
}
