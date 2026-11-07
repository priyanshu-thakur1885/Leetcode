
class Solution {
    public int minCostConnectPoints(int[][] points) {

        int n = points.length;

        boolean[] visited = new boolean[n];

        // {cost, point}
        PriorityQueue<int[]> pq =
            new PriorityQueue<>((a, b) ->
                Integer.compare(a[0], b[0])
            );

        // Start from point 0
        pq.offer(new int[]{0, 0});

        int totalCost = 0;
        int connected = 0;

        while (!pq.isEmpty() && connected < n) {

            int[] current = pq.poll();

            int cost = current[0];
            int point = current[1];

            // Already included in MST
            if (visited[point]) {
                continue;
            }

            // Add this point to MST
            visited[point] = true;

            totalCost += cost;
            connected++;

            // Try connecting every unvisited point
            for (int next = 0; next < n; next++) {

                if (!visited[next]) {

                    int distance =
                        Math.abs(
                            points[point][0] -
                            points[next][0]
                        )
                        +
                        Math.abs(
                            points[point][1] -
                            points[next][1]
                        );

                    pq.offer(new int[]{
                        distance,
                        next
                    });
                }
            }
        }

        return totalCost;
    }
}