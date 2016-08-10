/**
 * Created by JOKER on 8/3/16.
 */
public class Solution74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0 || matrix == null){
            return false;
        }
        for(int i = matrix.length-1; i >= 0; ){
            //from the last row
            //go to the previous row
            if(target < matrix[i][0]){
                i--;
            }else{
                for(int j = 0; j < matrix[i].length; j++){
                    if(matrix[i][j] == target){
                        return true;
                    }
                }
                return false;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution74 test = new Solution74();
        int[][] array = {{0},{3}};
        System.out.println(test.searchMatrix(array,1));
    }
}
