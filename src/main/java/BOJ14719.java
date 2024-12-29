import java.io.*;
import java.util.*;

public class BOJ14719 {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int [] arr = new int[W];
        int maxH = Integer.MIN_VALUE;
        ArrayList<Integer> maxHeightPoint = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<W; i++){
            int height = Integer.parseInt(st.nextToken());
            arr[i] = height;
            maxH = Math.max(maxH, height);
        }

        int [] prefix = new int [W+1];
        int [] middle = new int [W+1];
        int [] suffix = new int [W+1];

        //prefix 계산
        int h = 0;
        for(int i = 0; i<W; i++){
            if(arr[i] == maxH){
                maxHeightPoint.add(i);
                break;
            }
            h = Math.max(h,arr[i]);
            prefix[i+1] = prefix[i] + h - arr[i];
        }

        //suffix 계산
        h = 0;
        for(int i = W-1; i>0; i--){
            if(arr[i] == maxH){
                maxHeightPoint.add(i);
                break;
            }
            h = Math.max(h,arr[i]);
            suffix[i-1] = suffix[i] + h - arr[i];
        }

        //middle 계산
        if(maxHeightPoint.size() != 1){
            h = 0;
            for(int i = maxHeightPoint.get(0); i<maxHeightPoint.get(maxHeightPoint.size()-1); i++){
                h = Math.max(h,arr[i]);
                middle[i+1] =  middle[i] + h - arr[i];
            }
        }



        int answer = 0;
        int maxP = 0;
        int maxM = 0;
        int maxS = 0;
        for(int i = 0; i<W; i++){
            maxP = Math.max(maxP, prefix[i]);
            maxM = Math.max(maxM, middle[i]);
            maxS = Math.max(maxS, suffix[i]);
        }
        answer = maxP + maxS + maxM;
        System.out.println(answer);


    }
}
