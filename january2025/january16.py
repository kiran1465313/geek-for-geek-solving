class Solution:
    def maxLen(self, arr):
        # code here
        hmap={}
        summ,maxlen=0,0
        for i in range(len(arr)):
            summ += -1 if arr[i]==0 else 1
            if summ == 0:
                maxlen=i+1
            elif summ in hmap:
                maxlen = max(maxlen,i-hmap[summ])
            else:
                hmap[summ]=i
        return maxlen


#{ 
 # Driver Code Starts
#Initial Template for Python 3

t = int(input())
for _ in range(0, t):
    a = list(map(int, input().split()))
    s = Solution().maxLen(a)
    print(s)

# } Driver Code Ends
