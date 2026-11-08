from collections import deque

class Solution:
    def checkIfPrerequisite(self, numCourses: int, prerequisites: list[list[int]], queries: list[list[int]]) -> list[bool]:

        adj = [[] for i in range(numCourses)]
        ans = []

        for u, v in prerequisites:
            adj[u].append(v)

        def bfs(dst, start):

            queue = deque([start])
            visited = {start}

            while queue:

                node = queue.popleft()

                if node == dst:
                    return True

                for neigh in adj[node]:

                    if neigh not in visited:
                        visited.add(neigh)
                        queue.append(neigh)

            return False

        for u, v in queries:

            if bfs(v, u):
                ans.append(True)
            else:
                ans.append(False)

        return ans