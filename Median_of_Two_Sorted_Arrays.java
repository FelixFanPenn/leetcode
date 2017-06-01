public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length, len2 = nums2.length;
        //if ((len1 + len2) % 2 == 0){
          //  return (findKth(nums1, nums2, (len1 + len2) / 2) + findKth(nums1, nums2, (len1 + len2 + 1) / 2)) / 2;
        //} else {
          //  return findKth(nums1, nums2, (len1 + len2) / 2);
        //}
        return (findKth(nums1, nums2, (len1 + len2 + 1) / 2) + findKth(nums1, nums2, (len1 + len2 + 2) / 2)) / 2;
    }
    
    public double findKth(int[] nums1, int[] nums2, int k){
        int len1 = nums1.length, len2 = nums2.length;
        if (len1 > len2) return findKth(nums2, nums1, k);
        if (len1 == 0) return nums2[k-1];
        if (k == 1) {
            return Math.min(nums1[0], nums2[0]);
        }
        
        int i = Math.min(len1, k / 2), j = Math.min(len2, k / 2);
        if (nums1[i-1] > nums2[j-1]){
            return findKth(nums1, Arrays.copyOfRange(nums2, j, len2), k - j);
        } else {
            return findKth(Arrays.copyOfRange(nums1, i, len1), nums2, k - i);
        }
        
    }
}