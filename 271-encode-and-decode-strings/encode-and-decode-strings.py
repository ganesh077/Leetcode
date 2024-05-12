class Codec:
    def encode(self, strs: List[str]) -> str:
        encode_str = ""
        for i in range(len(strs)-1):
            encode_str+=strs[i]+"venti"
        encode_str+=strs[len(strs)-1]
        print(encode_str)
        return encode_str
        

        

    def decode(self, s: str) -> List[str]:
        res = s.split("venti")
        return res
        


# Your Codec object will be instantiated and called as such:
# codec = Codec()
# codec.decode(codec.encode(strs))