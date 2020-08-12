public class WeightedQUPC {

    int[] data;

    public WeightedQUPC(int size) {
        data = new int[size];
        for (int i = 0; i < size; i++) {
            data[i] = -1;
        }
    }

    public void union(int x, int y) {
        if (isConnect(x, y))
            return;
        int sizeX = size(x);
        int sizeY = size(y);
        int rootX = find(x);
        int rootY = find(y);
        if (sizeX > sizeY) {
            this.data[rootY] = rootX;
            this.data[rootX] -= sizeY;
        } else {
            this.data[rootX] = rootY;
            this.data[rootY] -= sizeX;
        }
    }

    public boolean isConnect(int x, int y) {
        return find(x) == find(y);
    }

    public int parent(int x) {
        return this.data[x];
    }

    public int size(int x) {
        return -parent(find(x));
    }

    public int find(int x) {
        if (parent(x) < 0)
            return x;
        int root = find(parent(x));
        this.data[x] = root;
        return root;
    }
}
