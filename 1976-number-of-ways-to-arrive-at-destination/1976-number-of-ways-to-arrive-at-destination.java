import java.util.*;

class Solution {
    public int countPaths(int n, int[][] roads) {


        List<List<int[]>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] road : roads) {

            int u = road[0];
            int v = road[1];
            int time = road[2];

            graph.get(u).add(new int[]{v, time});
            graph.get(v).add(new int[]{u, time});
        }

        long[] dist = new long[n];

        Arrays.fill(dist, Long.MAX_VALUE);

        long[] ways = new long[n];

        dist[0] = 0;
        ways[0] = 1;

        PriorityQueue<long[]> pq =
            new PriorityQueue<>(
                (a, b) -> Long.compare(a[0], b[0])
            );

        pq.offer(new long[]{0, 0});

        long MOD = 1_000_000_007;

        while (!pq.isEmpty()) {

            long[] current = pq.poll();

            long currentDist = current[0];
            int node = (int) current[1];

            if (currentDist > dist[node]) {
                continue;
            }

            for (int[] edge : graph.get(node)) {

                int next = edge[0];
                long time = edge[1];

                long newDist = currentDist + time;

                // Found a shorter path
                if (newDist < dist[next]) {

                    dist[next] = newDist;

                    ways[next] = ways[node];

                    pq.offer(new long[]{
                        newDist,
                        next
                    });
                }

                else if (newDist == dist[next]) {

                    ways[next] =
                        (ways[next] + ways[node]) % MOD;
                }
            }
        }

        return (int) ways[n - 1];
    }
}