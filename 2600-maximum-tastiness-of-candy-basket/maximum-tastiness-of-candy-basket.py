class Solution:
    def maximumTastiness(self, price: List[int], k: int) -> int:
        price.sort()
        def can_achieve_tastiness(tastiness):
            count = 1
            last_selected = price[0]
        
            for p in price[1:]:
                if p - last_selected >= tastiness:
                    count += 1
                    last_selected = p
                    if count == k:
                        return True
        
            return False
    
    # Binary search
        left, right = 0, price[-1] - price[0]
    
        while left < right:
            mid = (left + right + 1) // 2
            if can_achieve_tastiness(mid):
                left = mid
            else:
                right = mid - 1
    
        return left
    
    
    

        
        