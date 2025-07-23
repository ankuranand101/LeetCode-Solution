import java.util.Arrays;

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length + nums2.length;
        int[] arr = new int[n];
        int count = 0;

        // Merging both arrays
        for (int i = 0; i < nums1.length; i++) {
            arr[count++] = nums1[i];
        }
        for (int i = 0; i < nums2.length; i++) {
            arr[count++] = nums2[i];
        }

        
        Arrays.sort(arr);

        
        if (n % 2 == 1) {
            return arr[n / 2]; 
        } else {
            return (arr[n / 2 - 1] + arr[n / 2]) / 2.0; 
        }
    }
}