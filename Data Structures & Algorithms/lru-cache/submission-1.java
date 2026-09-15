class LRUCache {
    private Map<Integer, Node> map;
    private Node head;
    private Node tail;
    private int capacity;
    

    public LRUCache(int capacity) {
        this.capacity=capacity;
        map = new HashMap<>();

        // Dummy nodes
        head = new Node(0, 0);
        tail = new Node(0, 0);

        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }

        Node node = map.get(key);

        // This node was just used → make it MRU
        remove(node);
        addToEnd(node);

        return node.value;
        
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node node=map.get(key);
            node.value= value;
            remove(node);
            addToEnd(node);
            return;
        }
        Node node = new Node(key,value);
        map.put(key,node);
        addToEnd(node);
        if(map.size()>capacity){
            map.remove(head.next.key);
            remove(head.next);
        }
        
    }
    public void remove(Node node){
        node.prev.next=node.next;
        node.next.prev=node.prev;
    }

    public void addToEnd(Node node){
        node.next=tail;
        tail.prev.next=node;
        node.prev=tail.prev;
        tail.prev=node;
    }


}


class Node {
    int key;
    int value;

    Node prev;
    Node next;

    Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}
