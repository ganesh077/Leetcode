class Solution:
    def chalkReplacer(self, chalk: List[int], k: int) -> int:
        i = 0
        total = sum(chalk)

        if len(chalk) < 2:
            return len(chalk) - 1
        while k >= total:
            k -= total
        
        while k >= chalk[i]:
            k -= chalk[i]
            i += 1
            if i == len(chalk):
                i = 0
        return i
            