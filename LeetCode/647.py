class Solution:
    def countSubstrings(self, s: str) -> int:
        count = 0

        def palin(word):
            return word == reversed(word)

        for n in range(len(s)):
            if palin(s[n:n+len(s)]):
                count += 1

        return count
