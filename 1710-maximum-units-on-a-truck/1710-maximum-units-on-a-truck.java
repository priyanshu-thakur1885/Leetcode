import java.util.*;

class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {

        Arrays.sort(boxTypes, (a, b) ->
            Integer.compare(b[1], a[1])
        );

        int units = 0;

        for (int[] box : boxTypes) {

            int boxesToTake = Math.min(box[0], truckSize);

            units += boxesToTake * box[1];

            truckSize -= boxesToTake;

            if (truckSize == 0) {
                break;
            }
        }

        return units;
    }
}