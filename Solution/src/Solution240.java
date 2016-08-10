/**
 * Created by JOKER on 8/3/16.
 */
public class Solution240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0 || matrix == null){
            return false;
        }
        int begin_row = 0;
        int end_row   = 0;
        for(int i = matrix.length-1; i >= 0; ){
            if(target < matrix[i][0]){
                i--;
            }else{
                end_row = i;
                break;
            }
        }
        for(int i = 0; i < end_row; ){
            if(target > matrix[i][matrix[0].length-1]){
                i++;
            }else{
                begin_row = i;
                break;
            }
        }
        for(int i = begin_row; i <= end_row; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(matrix[i][j] == target)
                    return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution74 test = new Solution74();
        int[][] array = {{1},{3}};
        System.out.println(test.searchMatrix(array,1));
    }
}
