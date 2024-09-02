package JavaCodingTestStudy.week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class B1863 {
    static Stack<Integer>building;
    static int [] locate;
    public static void main(String[] args) throws IOException {
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        locate = new int[50001];
        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int tempx = Integer.parseInt(st.nextToken());
            int tempy = Integer.parseInt(st.nextToken());
           locate[i] = tempy;
        }
        building = new Stack<>();
        int buildingCount = 0;
        for(int i =0; i<=n; i++){
            while(!building.isEmpty() && building.peek() > locate[i]){
                building.pop();
                buildingCount++;
            }
            if(!building.isEmpty() && building.peek() == locate[i]){
                continue;
            }
            building.push(locate[i]);
        }
        System.out.println(buildingCount);

    }
}
