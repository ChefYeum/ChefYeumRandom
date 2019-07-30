from typing import List

class Solution:
def nextGreatestLetter(self, letters: List[str], target: str) -> str:
    mapLetters = dict(zip("abcdefghijklmnopqrstuvwxyz",range(0,26)))
    targetIndex = mapLetters[target]
    for n in letters:
        if mapLetters[n] > targetIndex:
            return n
    else:
        return letters[0]
