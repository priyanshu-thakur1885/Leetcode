import java.util.Arrays;

class Solution {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;
        int max = Integer.MIN_VALUE;
        boolean rowIsLarger = m > n;
        int outerBound = rowIsLarger ? n : m;
        int innerBound = rowIsLarger ? m : n;
        for (int left = 0; left < outerBound; left++) {
            int[] sums = new int[innerBound];
            for (int right = left; right < outerBound; right++) {
                for (int i = 0; i < innerBound; i++) {
                    sums[i] += rowIsLarger ? matrix[i][right] : matrix[right][i];
                }
                int kadaneMax = Integer.MIN_VALUE;
                int currentKadane = 0;
                for (int sum : sums) {
                    currentKadane = Math.max(sum, currentKadane + sum);
                    kadaneMax = Math.max(kadaneMax, currentKadane);
                }
                if (kadaneMax <= k) {
                    max = Math.max(max, kadaneMax);
                    if (max == k)
                        return k;
                    continue;
                }
                int currentSum = 0;
                int count = 1;
                int[] prefixSums = new int[innerBound + 1];
                for (int sum : sums) {
                    currentSum += sum;
                    int target = currentSum - k;
                    int idx = Arrays.binarySearch(prefixSums, 0, count, target);
                    if (idx < 0) {
                        idx = -(idx + 1);
                    }
                    if (idx < count) {
                        max = Math.max(max, currentSum - prefixSums[idx]);
                        if (max == k)
                            return k;
                    }
                    int insertIdx = Arrays.binarySearch(prefixSums, 0, count, currentSum);
                    if (insertIdx < 0) {
                        insertIdx = -(insertIdx + 1);
                    }
                    for (int j = count; j > insertIdx; j--) {
                        prefixSums[j] = prefixSums[j - 1];
                    }
                    prefixSums[insertIdx] = currentSum;
                    count++;
                }
            }
        }
        return max;
    }
}