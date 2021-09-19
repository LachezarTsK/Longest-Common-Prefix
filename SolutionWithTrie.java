
public class SolutionWithTrie {

    String longestCommonPrefix;
    TrieNode root;

    public String longestCommonPrefix(String[] strs) {

        root = new TrieNode();
        longestCommonPrefix = strs[0];
        addFirstWord(strs[0]);

        for (int i = 1; i < strs.length; i++) {
            searchForCommonPrefix(strs[i]);
            if (longestCommonPrefix.isEmpty()) {
                break;
            }
        }
        return longestCommonPrefix;
    }

    public void searchForCommonPrefix(String word) {

        StringBuilder currentCommonPrefix = new StringBuilder();
        TrieNode current = root;
        int n = word.length();
        int prefix;

        for (prefix = 0; prefix < n; prefix++) {
            char ch = word.charAt(prefix);
            if (current.alphabet[ch - 'a'] == null) {
                break;
            }
            current = current.alphabet[ch - 'a'];
            currentCommonPrefix.append(ch);
        }

        if (currentCommonPrefix.length() < longestCommonPrefix.length()) {
            longestCommonPrefix = currentCommonPrefix.toString();
        }
    }

    public void addFirstWord(String word) {

        TrieNode current = root;
        int n = word.length();

        for (int i = 0; i < n; i++) {
            char ch = word.charAt(i);
            if (current.alphabet[ch - 'a'] == null) {
                current.alphabet[ch - 'a'] = new TrieNode();
            }
            current = current.alphabet[ch - 'a'];
        }
    }
}

class TrieNode {

    TrieNode[] alphabet;

    public TrieNode() {
        alphabet = new TrieNode[26];
    }
}
