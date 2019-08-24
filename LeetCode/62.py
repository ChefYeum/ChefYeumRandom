class Solution:
    # how many ways can one arrange (m-1) rights and (n-1) downs?
    # Variant: f(a,b) = f(b,a)
    #Recursive version; too slow
    """
    def uniquePaths(self, m: int, n: int) -> int:
        if m == 2:
            return n
        elif  n == 1:
            return m
        else:
            h, l = max(m,n), min(m,n)
            return self.uniquePaths(h-1,l) + self.uniquePaths(h,l-1)
    """
    #Iterative version 1; matrix
    """
    def uniquePaths(self, m: int, n: int) -> int:
        if m == 1 or n == 1:
            return 1

        # Generate (m-1) by (n-1) matrix
        matrix = [([k] + [None]*(m-2))for k in range(2,n+1)]
        matrix[0] = list(range(2,m+1))

        for i in range(1, n-1):
            for j in range(1, m-1):
                matrix[i][j] = matrix[i-1][j] + matrix[i][j-1]

        return matrix[n-2][m-2]
    """

    #Iterative version 2; Generalised; no special case of m,n = 1
    def uniquePaths(self, m: int, n: int) -> int:
        # Generate matrix
        matrix = [([k] + [None]*(m-1)) for k in range(1,n+1)]
        matrix[0] = list(range(1,m+1))

        # Fill matrix
        for i in range(1, n):
            for j in range(1, m):
                matrix[i][j] = matrix[i-1][j] + matrix[i][j-1]

        return matrix[n-2][m-2]


if __name__ == '__main__':
    s = Solution()
    ans = s.uniquePaths(1,2)
    ans = s.uniquePaths(6,7)
    print(ans)
