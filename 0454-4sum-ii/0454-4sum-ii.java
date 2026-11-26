class Solution {
    public int fourSumCount(
            int[] a,
            int[] b,
            int[] c,
            int[] d
    ) {
        final int capacity = 1 << 16;
        final int mask = capacity - 1;

        int[] keys = new int[capacity];
        int[] freq = new int[capacity];

        for (int x : a) {
            for (int y : b) {
                int key = x + y;
                int slot = key & mask;

                while (freq[slot] != 0 && keys[slot] != key) {
                    slot = (slot + 1) & mask;
                }

                keys[slot] = key;
                freq[slot]++;
            }
        }

        int answer = 0;

        for (int x : c) {
            for (int y : d) {
                int key = -(x + y);
                int slot = key & mask;

                while (freq[slot] != 0 && keys[slot] != key) {
                    slot = (slot + 1) & mask;
                }

                answer += freq[slot];
            }
        }

        return answer;
    }
}