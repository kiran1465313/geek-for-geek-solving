import java.util.Scanner;

class Solution {
    // Function to find equilibrium point in the array.
    public int findEquilibrium(int[] arr) {
        int n = arr.length;
        int total = 0;
        
        // Calculate the total sum of the array
        for (int i = 0; i < n; i++) {
            total += arr[i];
        }
        
        int left = 0;
        
        for (int i = 0; i < n; i++) {
            // Right sum is total sum - left sum - current element
            int right = total - left - arr[i];
            
            // If left sum equals right sum, return the index
            if (left == right) {
                return i;
            }
            
            // Update left sum by adding the current element
            left += arr[i];
        }
        
        // If no equilibrium point is found, return -1
        return -1;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int T = sc.nextInt();
        sc.nextLine(); // Consume the newline character
        
        while (T > 0) {
            // Read the array input
            String[] input = sc.nextLine().split(" ");
            int[] arr = new int[input.length];
            for (int i = 0; i < input.length; i++) {
                arr[i] = Integer.parseInt(input[i]);
            }

            Solution ob = new Solution();
            System.out.println(ob.findEquilibrium(arr));
            System.out.println("~");
            T--;
        }
        
        sc.close();
    }
}
