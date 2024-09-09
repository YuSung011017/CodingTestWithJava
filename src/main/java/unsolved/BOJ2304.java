package unsolved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2304 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Location location [] = new Location[n];
        for(int i = 0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            location[i] = new Location(p,h);
        }
        Arrays.sort(location);
        int maxIndex = 0;
        for(int i = 1; i<n; i++ ){ //높이를 최대로 가지는 index를 찾음
            if(location[i].h>location[maxIndex].h){
                maxIndex = i;
            }
        }
        int area = 0;
        int tempIndex;
        for(int i = 0; i<=maxIndex; i++){ //가장 큰 기둥의 왼쪽
            if(location[i].h<=location[i+1].h){ //다음 기둥이 더 크다면 다음 기둥까지의 면적은 현재 자신의 높이로 채움
                area += location[i].h * (location[i+1].p - location[i].p);
            }else{
                for(int j = i+1; j<=maxIndex; j++){
                    if(location[i].h<=location[j].h){
                        area += location[i].h * (location[j].p - location[i].p);
                        i = j;
                    }
                }
            }
        }
        area += location[maxIndex].h;

        int rightMax=0;
        for(int i = maxIndex; i<n; i++){
            for(int j = maxIndex+1; j<n; j++){
                if(j+1 != n && location[j].h < location[j+1].h){
                    rightMax = j+1;
                }
            }
            area += location[rightMax].h * (location[rightMax].p - location[i].p);
            i = rightMax;
        }
       System.out.println(area);
    }
}
class Location implements Comparable<Location> {
    int p, h;
    public Location(int p, int h) {
        this.p = p;
        this.h = h;
    }
    @Override
    public int compareTo(Location o) {
        return p-o.p;
    }
}