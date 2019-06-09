from typing import List

class Solution:
    def letterCombinations(self, digits: str) -> List[str]:
        letters = {
                '2':"abc",
                '3':"def",
                '4':"ghi",
                '5':"jkl",
                '6':"mno",
                '7':"pqrs",
                '8':"tuv",
                '9':"wxyz"
                }
        import itertools
        return list(map(lambda x: "".join(x),itertools.product(*[letters[d] for d in digits])))


        

if __name__ == '__main__':
    s = Solution()
    print(s.letterCombinations("23"))



    # Cartesian product implementation
    """
    def product(*args):
        if not args:
            return iter(((),)) # yield tuple()
        return (items + (item,) 
                for items in product(*args[:-1]) for item in args[-1])
    """

    
