
class Solution:
    def maxWater(self, arr):
        # code here
        if not arr:
            return 0
        n=len(arr)
        leftmax=[0]*n
        rightmax=[0]*n
        
        #left maximum for the array
        leftmax[0]=arr[0]
        for i in range(1,n):
            leftmax[i]=max(leftmax[i-1],arr[i])
            
        #right max
        rightmax[n-1]=arr[n-1]
        for i in range(n-2,-1,-1):
            rightmax[i]=max(rightmax[i+1],arr[i])
        
        # finding the water trapped
        water=0
        for i in range(n):
            water+=min(leftmax[i],rightmax[i])-arr[i]
            
        
        return water

#{ 
 # Driver Code Starts
#Initial template for Python 3

import math


def main():
    t = int(input())
    while (t > 0):

        arr = [int(x) for x in input().strip().split()]
        obj = Solution()
        print(obj.maxWater(arr))

        t -= 1
        print("~")


if __name__ == "__main__":
    main()

# } Driver Code Ends
