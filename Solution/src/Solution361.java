/**
 * Created by JOKER on 8/9/16.
 */
public class Solution361 {
    public int maxKilledEnemies(char[][] grid) {
        int max = 0;
        for(int i = 0; i < grid.length; i ++){
            for(int j = 0; j < grid[0].length; j++){
                //find all '0'
                int tmp = 0;
                if(grid[i][j] != '0') continue;
                //else check up down left right
                for(int up = i-1; up >= 0; up--){
                    if(grid[up][j] == '0') continue;
                    else if(grid[up][j] == 'E') tmp+=1;
                    else break;
                }
                for(int down = i+1; down < grid.length; down++){
                    if(grid[down][j] == '0') continue;
                    else if(grid[down][j] == 'E') tmp+=1;
                    else break;
                }
                for(int left = j-1; left >= 0; left--){
                    if(grid[i][left] == '0') continue;
                    else if(grid[i][left] == 'E') tmp+=1;
                    else break;
                }
                for(int right = j+1; right < grid[0].length; right++){
                    if(grid[i][right] == '0') continue;
                    else if(grid[i][right] == 'E') tmp+=1;
                    else break;
                }
                if(tmp > max){
                    max = tmp;
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Solution361 test = new Solution361();
        char[][] grid = {"0E00".toCharArray(),"E0WE".toCharArray(),"0E00".toCharArray()};
        System.out.println(test.maxKilledEnemies(grid));
    }
}
