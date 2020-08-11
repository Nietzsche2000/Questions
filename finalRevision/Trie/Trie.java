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
        }
    }

    private Node root;

    public Trie() {
        this.root = new Node();
    }

    public void insertGarbage(String s) { // abce --> e true, abcdg --> c false
        Node ptr = this.root;
        for (int i = 0; i < s.length(); i++) {
            Character val = s.charAt(i);
            if (!ptr.data.containsKey(val)) {
                ptr.insert(val, i == s.length() - 1);
            }
            ptr = ptr.data.get(val);
        }
    }

    public void insert(String s) {
        Node ptr = this.root;
        for (int i = 0; i < s.length(); i++) {
            Character val = s.charAt(i);
            if (!ptr.data.containsKey(val))
                ptr.insert(val, false);
            ptr = ptr.data.get(val);
        }
        ptr.isEnd = true;
    }

    public boolean containsGarbage(String s) {
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

    public boolean contains(String s) {
        Node ptr = this.root;
        for (int i = 0; i < s.length(); i++) {
            Character val = s.charAt(i);
            if (!ptr.data.containsKey(val))
                return false;
            ptr = ptr.data.get(val);
        }
        return ptr.isEnd;
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
        soFar = soFar + pre;
        if (node.isEnd)
            result.addLast(soFar);
        for (Character c : node.data.keySet()) {
            String ch = String.valueOf(c);
            result.addAll(prefix(node, ch, soFar));
        }
        return result;
    }

    public String longestPrefix(String pre) {
        return this.prefixLongest(this.root, pre, "");
    }

    /* helper */
    private String prefixLongest(Node node, String pre, String result) {
        for (int i = 0; i < pre.length(); i++) {
            node = node.data.get(pre.charAt(i));
        }
        if (node == null)
            return result;
        result = pre;
        for (Character c : node.data.keySet()) {
            String ch = String.valueOf(c);
            String n = pre + prefixLongest(node, ch, result);
            if (n.length() > result.length())
                result = n;
        }
        return result;
    }
}