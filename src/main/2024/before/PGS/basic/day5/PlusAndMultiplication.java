package day5;

public class PlusAndMultiplication {
    public static int solution(int[] num_list) {
      int hap = 0;
      int gop = 1;
      for(int i = 0; i < num_list.length; i++) {
          hap += num_list[i];
          gop *= num_list[i];
      }
      if(hap*hap > gop)
          return 1;
      else
          return 0;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int []{5,7,8,3}));
    }
}
