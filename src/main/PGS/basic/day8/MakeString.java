public class MakeString {
    public static StringBuilder solution(String my_string, int[] index_list) {
        StringBuilder sb = new StringBuilder();
       for(int i = 0; i<index_list.length; i++){
           char ch = my_string.charAt(index_list[i]);
           sb.append(ch);
       }
        return sb;
    }
    public static void main(String[] args) {
        System.out.println(solution("cvsgiorszzzmrpaqpe",new int[]{16, 6, 5, 3, 12, 14, 11, 11, 17, 12, 7}));
    }
}
