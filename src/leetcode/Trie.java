package leetcode;

public class Trie {

    private TrieNode root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode(' ');
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode currNode = root;
        int len = word.length();
        for(int i = 0; i < len; ++i) {
            if(currNode.children[indexOfChar(word.charAt(i))] == null) {
                TrieNode tmpNode = new TrieNode(word.charAt(i));
                if(i == len - 1) {
                    tmpNode.isWord = true;
                }
                currNode.children[indexOfChar(word.charAt(i))] = tmpNode;
                currNode = tmpNode;
            } else {
                currNode = currNode.children[indexOfChar(word.charAt(i))];
                if(i == len -1) {
                    currNode.isWord = true;
                }
            }
        }
    }

    private int indexOfChar(char c) {
        return ((int) c) % 26;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        int len = word.length();
        TrieNode tmpNode = root;
        for (int i = 0; i < len; ++i) {
            if(tmpNode.children[indexOfChar(word.charAt(i))] == null) {
                return false;
            } else {
                tmpNode = tmpNode.children[indexOfChar(word.charAt(i))];
                if(i == len - 1) {
                    if(tmpNode.isWord){
                        return true;
                    } else {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        int len = prefix.length();
        TrieNode tmpNode = root;
        for (int i = 0; i < len; ++i) {
            if(tmpNode.children[indexOfChar(prefix.charAt(i))] == null) {
                return false;
            } else {
                tmpNode = tmpNode.children[indexOfChar(prefix.charAt(i))];
            }
        }
        return true;
    }

    private static class TrieNode {
        char val;
        boolean isWord;
        TrieNode[] children = new TrieNode[26];
        TrieNode(char val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("zzh");
        System.out.println(trie.search("zzh"));
        trie.insert("zz");
        System.out.println(trie.search("zz"));
    }
}
/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */