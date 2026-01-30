//因为题目说要 The functions 
//get and put must each run in O(1) average time complexity
//查找(get)要o(1),考虑hashmap
// 增加(put)要o(1)， 考虑linkedlist 结合两者来用
//这道题就是要考察 linkedhashmap
//https://leetcode.cn/problems/lru-cache/solutions/2456294/tu-jie-yi-zhang-tu-miao-dong-lrupythonja-czgt/

//下面这样写会比较好理解



/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

// class LRUCache{
//     //hashmap(key, value), doublelinkedlist(node: pre, next), dummy

//     class Node{

//         private int key, value;
//         private Node prev, next;
//         Node(int key, int value){
//             this.key = key;
//             this.value = value;
//         }
//     }

//     int capacity;
//     Node head = new Node(0, 0);
//     Node tail = new Node(0, 0);
//     HashMap<Integer, Node> map = new HashMap<>();
    


//     public LRUCache(int capacity){
//         this.capacity = capacity;
//         head.next = tail;
//         tail.prev = head;
       
//     }
    
//     public int get(int key){

//         if(map.containsKey(key)){
//            Node node = map.get(key);
//            remove(node);
//            addInHead(node);
//            return node.value;
//         }else{
//             return -1;
//         }

//     }

//     public void put(int key, int value){

//         if(map.containsKey(key)){
//             Node node = map.get(key);
//             node.value = value;
//             remove(node);
//             addInHead(node);
//         }else{
//             Node node = new Node(key, value);
//             map.put(key, node);
//             addInHead(node);
//             if(map.size() > capacity){
//                 Node back = tail.prev;
//                 remove(back);
//                 map.remove(back.key);
//             }
//         }

//     }

//     private void addInHead(Node node){
//         node.prev= head;
//         node.next = head.next;
//         head.next = node;
//         node.next.prev = node;
//     }

//     private void remove(Node node){
//         node.prev.next = node.next;
//         node.next.prev = node.prev;

//     }
// }
//get: o(1)->hashmap\
//put: -> add/delete   double linkedlist 

class LRUCache{
   
    class ListNode{
        ListNode prev;
        ListNode next;
        int key, val;
        public ListNode(int key, int val){
            this.key = key;
            this.val = val;
        }
    }

    int capacity;
    Map<Integer, ListNode> map;  //key-value 
    ListNode head;
    ListNode tail;

    public LRUCache(int capacity){
        this.capacity = capacity;
        map = new HashMap<>();
        head = new ListNode(0, 0);
        tail = new ListNode(0, 0);
        head.next = tail;
        tail.prev = head;// head<- -> tail
    }

    public int get(int key){
        //get: if key exist return the value, else return -1
        //still move the node(key,val) in the head of linkedlist, and remember to remove origin place
        if(map.containsKey(key)){
            ListNode node = map.get(key);
            remove(node);
            addInHead(node);
            return node.val;
        }else{
            return -1;
        }

    }

    public void put(int key, int value){
        if(map.containsKey(key)){
            ListNode node = map.get(key);
            node.val = value;
            remove(node);
            addInHead(node);
        }else{
            //add pair int map and the node in linkedlist
            ListNode newnode = new ListNode(key, value);
            addInHead(newnode);
            map.put(key, newnode);
            //If the number of keys exceeds the capacity
            //remove the key-pair in map, and remove the lastnode in linkedlist
            if(map.size() > capacity){
                ListNode lastnode = tail.prev;
                remove(lastnode);
                map.remove(lastnode.key);
            }

        }

    }

    private void addInHead(ListNode node){
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    private void remove(ListNode node){
        node.prev.next = node.next;
        node.next.prev = node.prev;

    }
}
