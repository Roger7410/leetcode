public class Solution189 {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        int i = 0;
        int j = nums.length-1;
        int temp;
        while(i<j){
            temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
        i = 0;
        j = k-1;
        while(i<j){
            temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
        i = k;
        j = nums.length-1;
        while(i<j){
            temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        Solution189 test = new Solution189();
        int[] array = {1};
        test.rotate(array,1);
        for(int i:array){
            System.out.println(i);
        }
    }
}