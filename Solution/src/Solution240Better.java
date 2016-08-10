/**
 * Created by JOKER on 8/3/16.
 */
public class Solution240Better {
    public boolean searchMatrix(int[][] matrix, int target) {
        int i = matrix.length - 1;
        int j = 0;
        while(i>=0 && j < matrix[0].length){
            if(matrix[i][j] > target){
                i--;
            }else if(matrix[i][j] < target){
                j++;
            }else {
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
