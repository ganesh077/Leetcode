class Solution:
    def validPath(self, n: int, edges: List[List[int]], source: int, destination: int) -> bool:
        if not edges:
            return True
        adj = defaultdict(list)
        for u,v in edges:
            adj[u].append(v)
            adj[v].append(u)
        #print(adj)

        stack = [adj[source]]
        seen = set()

        while stack:
            val = stack.pop()
            if destination in val:
                return True
            for i in val:
                if i not in seen:
                    stack.append(adj[i])
                seen.add(i)
        return False

        
            
        
        
