import java.util.HashMap;
import java.util.Scanner;

class Solution {
    public int longestUniqueSubstr(String s) {
        HashMap<Character, Integer> charIndexMap = new HashMap<>();
        int start = 0;
        int max = 0;

        for (int i = 0; i < s.length(); i++) {
            if (charIndexMap.containsKey(s.charAt(i))) {
                start = Math.max(start, charIndexMap.get(s.charAt(i)) + 1);
            }
            charIndexMap.put(s.charAt(i), i);
            max = Math.max(max, i - start + 1);
        }

        return max;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            String s = sc.next();
            Solution obj = new Solution();
            int ans = obj.longestUniqueSubstr(s);
            System.out.println(ans);
            System.out.println("~");
        }
    }
}
