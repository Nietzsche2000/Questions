import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

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

    public List<String> prefix(String pre) {
        return this.prefix(this.root, pre, "");
    }

    /* helper */
    private LinkedList<String> prefix(Node node, String pre, String soFar) {
        LinkedList<String> result = new LinkedList<>();
        for (int i = 0; i < pre.length(); i++) {
            node = node.data.get(pre.charAt(i));
        }
        if (node == null)
            return result;
        if (node.isEnd && pre.length() == 0)
            result.addLast(soFar);
        if (pre.length() == 0) {
            for (Character c : node.data.keySet()) {
                LinkedList<String> inn = this.prefix(node.data.get(c), "", c + soFar);
                result.addAll(inn);
            }
        }
        return result;
    }
}