package JavaCodingTestStudy.week3;

import java.util.Scanner;

public class SEA9780 {
    static long max(int a,int b) {
        return a > b ? a : b;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        for (int i = 0; i < n; i++) {
            long  number = 0;
            number = sc.nextLong();
            long list[] = new long[3];
            long box;
            list[1] = sc.nextLong();;
            for (int j = 1; j < number; j++) {
                list[2] = sc.nextLong();
                box = max((int) (list[0] + list[2]), (int) list[1]);
                list[0] = list[1];
                list[1] = box;
                list[2] = 0;
            }
            System.out.println((i+1) + max((int) list[0], (int) list[1]));
        }
    }
}
