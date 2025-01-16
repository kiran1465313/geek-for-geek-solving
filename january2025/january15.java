import java.util.*;

class Solution {
    public int longestSubarray(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>(); 
        int sum = 0;
        int res = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            if (sum == k) {
                res = i + 1; 
            }

            if (map.containsKey(sum - k)) {
                res = Math.max(res, i - map.get(sum - k));
            }

            map.putIfAbsent(sum, i); 
        }

        return res;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();

        while (tc-- > 0) {
            int n = sc.nextInt(); 
            int[] arr = new int[n];

            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            int k = sc.nextInt();
            Solution obj = new Solution();
            System.out.println(obj.longestSubarray(arr, k));
            System.out.println("~"); 
        }
    }
}
