/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int high = n;
        int low = 0;
        while (low + 1 < high) {
            int mid = low + (high - low) / 2;
            if (isBadVersion(mid)) {
                high = mid;
            } else {
                low = mid;
            }
        }
        if (isBadVersion(low)) {
            return low;
        }
        return high;
    }
}

