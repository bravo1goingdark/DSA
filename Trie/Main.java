public class Main {
    public static void main(String[] args) {
        Trie tree = new Trie();
        tree.insert("apple");
        System.out.println(tree.search("apple"));
        System.out.println(tree.startsWith("app"));

        TrieII trieII = new TrieII();
        trieII.insertMany("aadsfasf");
        trieII.insertMany("absbs");
        trieII.insertMany("bbab");
        trieII.insertMany("cadsfafs");
        
        System.out.println(trieII.countWordsEqualTo("apple"));
        System.out.println(trieII.countWordsStartingWith("a"));
    }
}
