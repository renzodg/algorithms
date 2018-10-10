package examples.tries;

import java.util.HashMap;

public class Trie {

    public TrieNode root;

    public Trie() {
        this.root = new TrieNode();
    };

    public void insert(String word) {
        TrieNode current = this.root;

        for (int i = 0; i < word.length(); i++) {
            current = current.children.computeIfAbsent(word.charAt(i), c -> new TrieNode());
        }

        current.isWord = true;
    }

    public boolean find(String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            TrieNode node = current.children.get(ch);
            if (node == null) {
                return false;
            }
            current = node;
        }
        return current.isWord;
    }

    public void delete(String word) {
        delete(root, word, 0);
    }

    private boolean delete(TrieNode current, String word, int index) {
        if (index == word.length()) {
            if (!current.isWord) {
                return false;
            }
            current.isWord = false;
            return current.children.isEmpty();
        }
        char ch = word.charAt(index);
        TrieNode node = current.children.get(ch);
        if (node == null) {
            return false;
        }
        boolean shouldDeleteCurrentNode = delete(node, word, index + 1) && !node.isWord;

        if (shouldDeleteCurrentNode) {
            current.children.remove(ch);
            return current.children.isEmpty();
        }
        return false;
    }

    public boolean isEmpty() {
        return root != null;
    }

    static class TrieNode {
        public HashMap<Character, TrieNode> children = new HashMap<>();
        public String content;
        public boolean isWord;

    }

}
