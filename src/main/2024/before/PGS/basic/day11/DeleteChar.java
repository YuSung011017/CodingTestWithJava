
public class DeleteChar {
    public static String solution(String my_string, int[] indices) {
        char[] temp = my_string.toCharArray();
        for(int i = 0; i< indices.length; i++){
            int k = indices[i];
            temp[k] = '0';
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<temp.length; i++){
            if(temp[i] != '0'){
                sb.append(temp[i]);
            }
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        System.out.println(solution("apporoograpemmemprs",new int [] {1, 16, 6, 15, 0, 10, 11, 3}));
    }
}
