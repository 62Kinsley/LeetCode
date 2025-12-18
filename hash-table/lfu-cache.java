class LFUCache {
    class Node{
        int key, val;
        int freq = 1;
        Node prev, next;
        public Node(int key, int value) {
            this.key = key;
            this.val = value; 
        }
    }
    
    int capacity;
    int minFreq = 1;
    Map<Integer, Node> freqToNode = new HashMap<>();
    Map<Integer, Node> keyToNode = new HashMap<>();

    public LFUCache(int capacity) {
        this.capacity = capacity;

    }
    
//    [4,4][3,3][2,2][1,1] c(1)=2 c(2)=3 c(3)=1 c(4)=1

    public int get(int key) {
       Node node = getNode(key);
       return node == null? -1: node.val;
    }
    
    public void put(int key, int value) {

        Node node = getNode(key);

        //node存在,更新node.val
        if(node != null){
            node.val = value;
            return ;
        }

        //node 不存在
        //判断： cap达到上限/ 没到上限
        if(keyToNode.size() == capacity){
            //移除(1)频率次数最低的(2)最后一个
            Node dummy = freqToNode.get(minFreq);
            Node lastNode = dummy.prev;
            keyToNode.remove(lastNode.key);
            remove(lastNode);
            if(dummy.next == dummy){
                freqToNode.remove(minFreq);//移除空表
            }
        }
        Node newNode = new Node(key, value);
        keyToNode.put(key, newNode);
        addInHead(1, newNode);
        minFreq = 1;

    }

    private Node getNode(int key) {
        if(!keyToNode.containsKey(key)){
            return null;
        }
        Node node = keyToNode.get(key);
        //移除
        remove(node);
        Node dummy = freqToNode.get(node.freq);

        //如果移除以后，这个freq的链表为空的话，要移除这个freq，同时minFreq也要增加
        if(dummy.next == dummy){
            freqToNode.remove(node.freq);
            if(minFreq == node.freq){
                minFreq++;
            }
        }
        //增加频率
        node.freq++;
        addInHead(node.freq, node);
        return node;

    }

     private Node newList() {
        Node dummy = new Node(0, 0); // 哨兵节点
        dummy.prev = dummy;
        dummy.next = dummy;
        return dummy;
    }


    private void addInHead(int freq, Node node){
        Node dummy = freqToNode.computeIfAbsent(freq, k -> newList());
        node.prev = dummy;
        node.next = dummy.next;
        dummy.next.prev = node;
        dummy.next = node;

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