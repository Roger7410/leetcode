import java.util.ArrayList;
import java.util.List;

/**
 * Created by JOKER on 8/6/16.
 */
public class Solution119 {
    public List<Integer> generate(int numRows) {
        List<Integer> up = new ArrayList<>();
        List<Integer> down = new ArrayList<>();
        up.add(1);
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
            down = new ArrayList<>();
        }
        return up;
    }

    public static void main(String[] args) {
        Solution119 test = new Solution119();
        List<Integer> result = test.generate(5);
            for(int i: result){
                System.out.print(i);
                System.out.print(",");
            }

    }
}
