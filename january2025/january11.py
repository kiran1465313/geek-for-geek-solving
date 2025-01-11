#User function Template for python3

class Solution:
    def longestUniqueSubstr(self, s):
        # code here
        char_index_map={}
        start=0
        maxi=0
        for i in range(len(s)):
            if s[i] in char_index_map:
                start=max(start,char_index_map[s[i]]+1)
            char_index_map[s[i]]=i
            maxi=max(maxi,i-start+1)
        return maxi

#{ 
 # Driver Code Starts
#Initial Template for Python 3

if __name__ == '__main__':

    t = int(input())

    for _ in range(t):
        s = input()

        solObj = Solution()

        ans = solObj.longestUniqueSubstr(s)

        print(ans)

        print("~")
# } Driver Code Ends
