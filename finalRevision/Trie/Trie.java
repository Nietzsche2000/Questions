import java.util.HashMap;

public class Trie {

    public class Node {
        HashMap<Character, Node> data;
        boolean isEnd;

        public Node() {
            this.data = new HashMap<>();
        }

        public void insert(Character c, boolean isEnd) {
            this.data.put(c, new Node());
            this.isEnd = isEnd;
        }
    }

    private Node root;

    public Trie() {
        this.root = new Node();
    }

    public void insert(String s) {
        Node ptr = this.root;
        for (int i = 0; i < s.length(); i++) {
            Character val = s.charAt(i);
            if (!ptr.data.containsKey(val)) {
                ptr.insert(val, i == s.length() - 1);
            }
            ptr = ptr.data.get(val);
        }
    }

    public boolean contains(String s) {
        Node ptr = this.root;
        for (int i = 0; i < s.length(); i++) {
            Character val = s.charAt(i);
            if (!ptr.data.containsKey(val))
                return false;
            if (i == s.length() - 1)
                return ptr.isEnd;
            ptr = ptr.data.get(val);
        }
        return false;
    }
}