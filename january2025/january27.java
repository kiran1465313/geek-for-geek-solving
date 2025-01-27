import java.util.LinkedHashMap;
import java.util.Map;

class LRUCache {
    private final int cap;
    private final Map<Integer, Integer> cache;

    // Constructor for initializing the cache capacity with the given value.
    public LRUCache(int cap) {
        this.cap = cap;
        this.cache = new LinkedHashMap<Integer, Integer>(cap, 0.75f, true) {
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                return size() > LRUCache.this.cap;
            }
        };
    }

    // Function to return value corresponding to the key.
    public int get(int key) {
        return cache.getOrDefault(key, -1);
    }

    // Function for storing key-value pair.
    public void put(int key, int value) {
        cache.put(key, value);
    }
}

// Driver Code
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int capacity = sc.nextInt();
            LRUCache cache = new LRUCache(capacity);
            int queries = sc.nextInt();
            while (queries-- > 0) {
                String command = sc.next();
                int key = sc.nextInt();
                if (command.equals("PUT")) {
                    int value = sc.nextInt();
                    cache.put(key, value);
                } else {
                    System.out.print(cache.get(key) + " ");
                }
            }
            System.out.println();
            System.out.println("~");
        }
        sc.close();
    }
}

