import java.util.*;

class Solution {
    public List<Integer> countDistinct(int[] arr, int k) {
        List<Integer> result = new ArrayList<>();
        if (arr.length < k) {
            return result;
        }
        
        Map<Integer, Integer> freq = new HashMap<>();
        
        // Initial window
        for (int i = 0; i < k; i++) {
            freq.put(arr[i], freq.getOrDefault(arr[i], 0) + 1);
        }
        result.add(freq.size());
        
        // Sliding window
        for (int i = k; i < arr.length; i++) {
            int removeElement = arr[i - k];
            freq.put(removeElement, freq.get(removeElement) - 1);
            if (freq.get(removeElement) == 0) {
                freq.remove(removeElement);
            }
            
            freq.put(arr[i], freq.getOrDefault(arr[i], 0) + 1);
            result.add(freq.size());
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();  // Consume newline
        
        while (t-- > 0) {
            String[] arrStr = sc.nextLine().split(" ");
            int[] arr = Arrays.stream(arrStr).mapToInt(Integer::parseInt).toArray();
            int k = sc.nextInt();
            sc.nextLine();  // Consume newline
            
            Solution sol = new Solution();
            List<Integer> res = sol.countDistinct(arr, k);
            
            for (int element : res) {
                System.out.print(element + " ");
            }
            System.out.println("~");
        }
        
        sc.close();
    }
}
