public class DSAao {
    static class UnionFind {
        private final int[] parent;
        private final int[] size;

        UnionFind(int count) {
            parent = new int[count];
            size = new int[count];

            for (int i = 0; i < count; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        int find(int computer) {
            if (parent[computer] != computer) {
                parent[computer] = find(parent[computer]);
            }

            return parent[computer];
        }

        void union(int first, int second) {
            int firstRoot = find(first);
            int secondRoot = find(second);

            if (firstRoot == secondRoot) {
                return;
            }

            // Attach the smaller group to the larger group.
            if (size[firstRoot] < size[secondRoot]) {
                int temp = firstRoot;
                firstRoot = secondRoot;
                secondRoot = temp;
            }

            parent[secondRoot] = firstRoot;
            size[firstRoot] += size[secondRoot];
        }
    }

    public static void main(String[] args) {
        UnionFind network = new UnionFind(5);

        network.union(0, 1);
        network.union(1, 2);
        network.union(3, 4);

        System.out.println(network.find(0) == network.find(2));
        System.out.println(network.find(0) == network.find(4));
    }
}