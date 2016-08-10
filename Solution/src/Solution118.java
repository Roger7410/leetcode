import java.util.ArrayList;
import java.util.List;

/**
 * Created by JOKER on 8/6/16.
 */
public class Solution118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> up = new ArrayList<>();
        List<Integer> down = new ArrayList<>();
        up.add(1);
        result.add(up);
        int index = 0;
        for(int i = 1; i < numRows; i++){
            down.add(1);
            while(up.size() > index +1){
                down.add(up.get(index)+up.get(index+1));
                index++;
            }
            down.add(1);
            index = 0;
            up = down;
            result.add(up);
            down = new ArrayList<>();
        }
        return result;
    }

    public static void main(String[] args) {
        Solution118 test = new Solution118();
        List<List<Integer>> result = test.generate(5);
        for(List<Integer> list: result){
            for(int i: list){
                System.out.print(i);
                System.out.print(",");
            }
            System.out.println();
        }
    }
}
