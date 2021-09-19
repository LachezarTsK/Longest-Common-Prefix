
public class SolutionWithoutAdditionalDataStructures {

    public String longestCommonPrefix(String[] strs) {

        String longestCommonPrefix = strs[0];
        int n = strs.length;

        for (int i = 1; i < n; i++) {

            int index = 0;
            int n_01 = longestCommonPrefix.length();
            int n_02 = strs[i].length();

            while (index < n_01 && index < n_02) {
                if (longestCommonPrefix.charAt(index) != strs[i].charAt(index)) {
                    break;
                }
                index++;
            }

            if (index < n_01) {
                longestCommonPrefix = longestCommonPrefix.substring(0, index);
                if (index == 0) {
                    break;
                }
            }
        }

        return longestCommonPrefix;
    }
}
