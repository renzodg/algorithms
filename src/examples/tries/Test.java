package examples.tries;

public class Test {

    public static void main(String[] args) {
        Trie trie = new Trie();
        
        trie.insert("Programming");
        trie.insert("is");
        trie.insert("a");
        trie.insert("way");
        trie.insert("of");
        trie.insert("life");
        
        System.out.println(trie.find("Programming"));
        trie.delete("Programming");
        System.out.println(trie.find("Programming"));
    }
    
}
