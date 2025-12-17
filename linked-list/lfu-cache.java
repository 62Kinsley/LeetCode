class LFUCache {
    class Node{
        int key, val;
        Node prev, next;
        public Node(int key, int value) {
            this.key = key;
            this.val = value;
        }
    }
    
    int cap;
    Node head = new Node(0,0);
    Node tail = new Node(0,0);
    Map<Integer, Integer> cnt = new HashMap<>();
    Map<Integer, Node> map = new HashMap<>();
    public LFUCache(int capacity) {
        cap = capacity;
        head.next = tail;
        tail.prev = head;
    }
    
   

    public int get(int key) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            remove(node);
            addInHead(node);
            cnt.put(key, cnt.getOrDefault(key, 0)+1);
            return node.val;
        }else{
            return -1;
        }
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            node.val = value;
            cnt.put(key, cnt.getOrDefault(key, 0)+1);
            remove(node);
            addInHead(node);
        }else{
            Node newnode = new Node(key, value);
            map.put(key, newnode);
            addInHead(newnode);
            cnt.put(key, cnt.getOrDefault(key, 0)+1);
            if(map.size() > cap){
                Node lastnode = tail.prev;
                Node lastSecondNode = lastnode.prev;
                int cnt1 = cnt.get(lastnode.val);
                int cnt2 = cnt.get(lastSecondNode.val);
                if(cnt2 >= cnt1){
                    remove(lastnode);
                    map.remove(lastnode.key);
                }
            }
        }
        
    }

    private void addInHead(Node node){
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;

    }

    private void remove( Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */