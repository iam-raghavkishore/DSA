public class DSAam {
    static class Node {
        Node[] children = new Node[26];
        boolean endOfWord;
    }

    static class Trie {
        private final Node root = new Node();

        void insert(String word) {
            Node current = root;

            for (int i = 0; i < word.length(); i++) {
                int index = word.charAt(i) - 'a';

                if (current.children[index] == null) {
                    current.children[index] = new Node();
                }

                current = current.children[index];
            }

            current.endOfWord = true;
        }

        boolean contains(String word) {
            Node node = findNode(word);
            return node != null && node.endOfWord;
        }

        boolean startsWith(String prefix) {
            return findNode(prefix) != null;
        }

        private Node findNode(String text) {
            Node current = root;

            for (int i = 0; i < text.length(); i++) {
                int index = text.charAt(i) - 'a';
                current = current.children[index];

                if (current == null) {
                    return null;
                }
            }

            return current;
        }
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("cat");
        trie.insert("car");
        trie.insert("dog");

        System.out.println(trie.contains("car"));  // true
        System.out.println(trie.contains("ca"));   // false
        System.out.println(trie.startsWith("ca")); // true
    }
}