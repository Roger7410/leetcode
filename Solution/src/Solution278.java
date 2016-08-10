/**
 * Created by JOKER on 8/6/16.
 */
public class Solution278 {
    public int firstBadVersion(int n) {
        int start = 1, end = n;
        while (start < end) {
            int mid = start + (end-start) / 2;
            if (!isBadVersion(mid)) start = mid + 1;
            else end = mid;
        }
        return start;
    }

    public boolean isBadVersion(int version){
        return true;
    }
}
