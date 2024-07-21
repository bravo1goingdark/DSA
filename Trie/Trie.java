public class Trie {

    private Node root;

    public Trie() {
        this.root = new Node();
    }

    public void insert(String word) {
        Node node = root;
        for (int index = 0; index < word.length(); index++) {
            if (!node.containsKey(word.charAt(index))) {
                node.put(word.charAt(index), new Node());
            }

            node = node.get(word.charAt(index));
        }
        node.setEnd();
    }

    public boolean search(String word) {
        Node node = root;

        for (int index = 0; index < word.length(); index++) {
            if (!node.containsKey(word.charAt(index))) {
                return false;
            }
            node = node.get(word.charAt(index));
        }
        return node.isEnd();
    }

    public boolean startsWith(String prefix) {
        Node node = root;

        for (int index = 0; index < prefix.length(); index++) {
            if (!node.containsKey(prefix.charAt(index))) {
                return false;
            }
            node = node.get(prefix.charAt(index));
        }
        return true;
    }

    private class Node {
        private Node[] links;
        private boolean flag;

        public Node() {
            this.links = new Node[26];
            this.flag = false;
        }

        public Node get(char ch) {
            return this.links[ch - 'a'];
        }

        public void put(char ch, Node node) {
            this.links[ch - 'a'] = node;
        }

        public boolean containsKey(char ch) {
            return this.links[ch - 'a'] != null;
        }

        public void setEnd() {
            this.flag = true;
        }

        public boolean isEnd() {
            return this.flag;
        }

    }
}