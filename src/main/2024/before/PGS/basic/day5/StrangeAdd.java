package day5;

public class StrangeAdd {
    public static int solution(int[] num_list) {
        String hol ="";
        String jak ="";
        for(int i = 0; i < num_list.length; i++) {
            if(num_list[i] % 2 == 1)
                hol += num_list[i] + "";
            else
                jak += num_list[i] + "";
        }
        int hol1 = Integer.parseInt(hol);
        int jak1 = Integer.parseInt(jak);
        return hol1+jak1;
    }
    public static void main(String[] args) {
        System.out.println(solution(new int []{5, 7, 8, 3}));
    }
}
