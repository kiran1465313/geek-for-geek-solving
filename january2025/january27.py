#User function Template for python3

# design the class in the most optimal way
from collections import OrderedDict

class LRUCache:
      
    #Constructor for initializing the cache capacity with the given value.  
    def __init__(self, cap):
        #code here
        self.cap=cap
        self.cache=OrderedDict()
        
        
    #Function to return value corresponding to the key.
    def get(self, key):
        #code here
        if key not in self.cache:
            return -1
        self.cache.move_to_end(key)
        return self.cache[key]
        
        
    #Function for storing key-value pair.   
    def put(self, key, value):
        #code here
        if key in self.cache:
            self.cache.move_to_end(key)
        self.cache[key]=value
        if len(self.cache)>self.cap:
            self.cache.popitem(last=False)




#{ 
 # Driver Code Starts
#Initial Template for Python 3


def inputLine():
    return input().strip().split()


if __name__ == "__main__":
    t = int(input())
    for _ in range(t):
        capacity = int(input())
        cache = LRUCache(capacity)

        queries = int(input())
        for __ in range(queries):
            vec = inputLine()
            if vec[0] == "PUT":
                key = int(vec[1])
                value = int(vec[2])
                cache.put(key, value)
            else:
                key = int(vec[1])
                print(cache.get(key), end=" ")
        print()
        print("~")

# } Driver Code Ends
