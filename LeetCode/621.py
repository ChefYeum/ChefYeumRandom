from typing import List
from collections import Counter

class Solution:
    def leastInterval(self, tasks: List[str], n: int) -> int:
        if n == 0:
            return len(tasks)

        lastN = lambda s: s[-n:]

        taskCount = Counter(tasks)
        schedule = []
        
        while sum(taskCount.values()) != 0:
            for task in taskCount:
                if task in lastN(schedule):
                    continue
                elif taskCount[task] > 0:
                    schedule.append(task)
                    taskCount[task] -= 1
                    break
            else:
                schedule.append(None)

            print(schedule)

        return len(schedule) 


if __name__ == "__main__":
    tasks = ["A","A","A","B","B","B"]
    n = 2
    s = Solution()
    print(s.leastInterval(tasks,n))
