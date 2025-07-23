class Solution {
    public int maximumGain(String s, int x, int y) {
        // Determine which to remove first
        if (x > y) {
            return removeAndCalculate(s, "ab", x, y);
        } else {
            return removeAndCalculate(s, "ba", y, x);
        }
    }

    private int removeAndCalculate(String s, String highPattern, int highValue, int lowValue) {
        // Step 1: Remove high priority pattern first
        StringBuilder sb = new StringBuilder();
        int score = 0;

        for (char ch : s.toCharArray()) {
            int len = sb.length();
            if (len > 0 && sb.charAt(len - 1) == highPattern.charAt(0) && ch == highPattern.charAt(1)) {
                sb.deleteCharAt(len - 1);  // remove matched first char
                score += highValue;       // add points
            } else {
                sb.append(ch);            // keep character
            }
        }

        // Step 2: Remove the remaining low priority pattern from sb
        String lowPattern = highPattern.equals("ab") ? "ba" : "ab";
        StringBuilder sb2 = new StringBuilder();
        for (char ch : sb.toString().toCharArray()) {
            int len = sb2.length();
            if (len > 0 && sb2.charAt(len - 1) == lowPattern.charAt(0) && ch == lowPattern.charAt(1)) {
                sb2.deleteCharAt(len - 1);
                score += lowValue;
            } else {
                sb2.append(ch);
            }
        }

        return score;
    }
}
