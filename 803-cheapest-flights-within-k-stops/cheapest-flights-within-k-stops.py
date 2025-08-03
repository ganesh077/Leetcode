class Solution:
    def findCheapestPrice(self, n: int, flights: List[List[int]], src: int, dst: int, k: int) -> int:
        adj = defaultdict(list)
        for u,v,price in flights:
            adj[u].append((v,price))
        
        dist = [float('inf')]*n
        dist[src] = 0
        que = deque([(src,0)])
        level = 0

        while que and level <= k:
            size = len(que)
            for _ in range(size):
                path ,price = que.popleft()
                for neighbor_path,neighbor_price in adj[path]:
                    if neighbor_price  + price < dist[neighbor_path]:
                        dist[neighbor_path] = neighbor_price  + price
                        que.append((neighbor_path,dist[neighbor_path]))
            level += 1 
        return dist[dst] if dist[dst] != float('inf') else -1


 