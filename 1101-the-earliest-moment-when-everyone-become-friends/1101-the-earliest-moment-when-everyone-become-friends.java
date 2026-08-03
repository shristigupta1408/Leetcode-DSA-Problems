class Solution {
    ArrayList<Integer> parent = new ArrayList<>();
    ArrayList<Integer> size = new ArrayList<>();

    private int findParent(int u) {
        if (parent.get(u) == u) {
            return u;
        }

        return findParent(parent.get(u));
    }

    private boolean union(int u, int v) {
        int uPar = findParent(u);
        int vPar = findParent(v);

        if (uPar == vPar) return false;

        if (size.get(uPar) < size.get(vPar)) {
            parent.set(uPar, vPar);
            size.set(vPar, size.get(vPar) + size.get(uPar));
        } else {
            parent.set(vPar, uPar);
            size.set(uPar, size.get(vPar) + size.get(uPar));
        }

        return true;
    }

    public int earliestAcq(int[][] logs, int n) {
        // Dynamic Graph - Disjoint Set Union - return when we have a redundant connection (no) / all nodes have the same parent
        // Can also say minimum spanning tree? But that is more useful when we need the minimum weight. In this case, we have to go in order anyway.
        // Return -1 if not possible

        Arrays.sort(logs, (a,b) -> Integer.compare(a[0], b[0]));
        
        for (int i = 0; i < n; i++) {
            size.add(1);
            parent.add(i);
        }

        int count = 0;

        for (int[] log : logs) {
            int u = log[1];
            int v = log[2];

            if (union(u, v)) {
                count += 1;
            }

            if (count == n-1) {
                return log[0];
            }
        }

        return -1;
    }
}