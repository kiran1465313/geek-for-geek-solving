import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public List<String> findPermutation(String s) {
        char[] charArray = s.toCharArray();
        Arrays.sort(charArray);
        String sortedS = new String(charArray);
        List<String> res = new ArrayList<>();
        
        while (sortedS != null) {
            res.add(sortedS);
            sortedS = next(sortedS);
        }
        return res;
    }

    private String next(String s) {
        char[] sArray = s.toCharArray();
        int i = sArray.length - 2;
        while (i >= 0 && sArray[i] >= sArray[i + 1]) {
            i--;
        }
        if (i < 0) {
            return null;
        }
        int j = sArray.length - 1;
        while (sArray[j] <= sArray[i]) {
            j--;
        }
        char temp = sArray[i];
        sArray[i] = sArray[j];
        sArray[j] = temp;
        StringBuilder sb = new StringBuilder();
        for (int k = 0; k <= i; k++) {
            sb.append(sArray[k]);
        }
        for (int k = sArray.length - 1; k > i; k--) {
            sb.append(sArray[k]);
        }
        return sb.toString();
    }
}

