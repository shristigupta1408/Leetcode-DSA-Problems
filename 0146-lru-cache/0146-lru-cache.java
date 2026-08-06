class ListNode {
    int key;
    int val;
    ListNode prev;
    ListNode next;

    public ListNode(int key, int val) {
        this.key = key;
        this.val = val;
    }
}


class LRUCache {
    // Thoughts -
    // Clarify - any case where the LRU priority is the same?
    // Edge cases - negative or 0 capacity, key doesn't exist -> -1, equally least recently used
    // LRU - when get was last called on it? also refers to put
    // Options -
    // Priority Queue -> how would we compare elements?
    // FIFO Structure - Queue
    // Can't access elements of queue directly
    // Array/HashMap and a Queue?

    Map<Integer, ListNode> cache = new HashMap<>();
    ListNode head;
    ListNode tail;
    int cap;

    public LRUCache(int capacity) {
        this.cap = capacity;
        head = new ListNode(-1, -1);
        tail = new ListNode(-1, -1);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }

        ListNode node = cache.get(key);
        remove(node);
        add(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            ListNode oldNode = cache.get(key);
            remove(oldNode);
        }

        ListNode node = new ListNode(key, value);
        cache.put(key, node);
        add(node);

        if (cache.size() > cap) {
            ListNode nodeToDelete = head.next;
            remove(nodeToDelete);
            cache.remove(nodeToDelete.key);
        }
    }

    public void add(ListNode node) {
        ListNode previousEnd = tail.prev;
        previousEnd.next = node;
        node.prev = previousEnd;
        node.next = tail;
        tail.prev = node;
    }

    public void remove(ListNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */