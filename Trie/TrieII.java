public class TrieII {

    private Node root;

    public TrieII() {
        this.root = new Node();
    }

    public void insertMany(String word) {
        Node node = root;
        for (int index = 0; index < word.length(); index++) {
            if (!node.containsKey(word.charAt(index))) {
                node.put(word.charAt(index), new Node());
            }

            node = node.get(word.charAt(index));
            node.increasePrefix();;
        }
        node.increaseEnd();
    }

    public int countWordsEqualTo(String word) {
        Node node = root;
        for (int index = 0; index < word.length(); index++) {
            if (node.containsKey(word.charAt(index))) {
                node = node.get(word.charAt(index));
            } else {
                return 0;
            }
        }
        return node.getEnd();

    }

    public int countWordsStartingWith(String word) {
        Node node = root;
        for (int index = 0; index < word.length(); index++) {
            if (node.containsKey(word.charAt(index))) {
                node = node.get(word.charAt(index));
            } else {
                return 0;
            }
        }
        return node.getPrefix();

    }

    public void erase(String word) {
        Node node = root;
        for (int index = 0; index < word.length(); index++) {
            if (node.containsKey(word.charAt(index))) {
                node = node.get(word.charAt(index));
                node.reducePrefix();
            } else {
                return;
            }
        }

        node.reduceEnd();
    }

    private class Node {
        private Node[] links;
        private int countPrefix;
        private int countEnd;

        public Node() {
            this.links = new Node[26];
            this.countPrefix = 0;
            this.countEnd = 0;
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

        public void increasePrefix() {
            this.countPrefix++;
        }

        public void increaseEnd() {
            this.countEnd++;
        }

        public void reducePrefix() {
            this.countPrefix--;
        }

        public void reduceEnd() {
            this.countEnd--;
        }

        public int getPrefix() {
            return this.countPrefix;
        }

        public int getEnd() {
            return this.countEnd;
        }
    }
}