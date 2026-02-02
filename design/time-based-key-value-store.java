//https://leetcode.cn/problems/time-based-key-value-store/solutions/868550/981-ji-yu-shi-jian-de-jian-zhi-cun-chu-g-ehvm/
//!!!!!看1146@@@！！！
// class TimeMap {

//     // 构建一个内部类，用于存储 key, value, timestamp
//     class Node{
//         String k;
//         String v;
//         int t;
        
//         Node(String key, String value,  int timestamp){
//             this.k = key;
//             this.v = value;
//             this.t = timestamp;
//         }
//     }


//      // 定义一个数据结构：hash套数组，因为一个hash主键可能有多个值，那么则使用List将那些值存起来
//     Map<String, List<Node>> map = new HashMap();

//     public TimeMap() {

//     }
    
//     public void set(String key, String value, int timestamp) {
//          // 寻找是否已经存在Hash主键，没有就创建一个
//         //如果有，可以get这个value（List），然后加入新的Node(KEY, VALUE, timestamp)进去
//         //如果没有这个key，可以给它重新建立一个list
//         List<Node> list = map.getOrDefault(key, new ArrayList<>());
//         //给list加入这个新的Node
//         list.add(new Node(key, value, timestamp));
//         //map也要更新哦
//         map.put(key,list);   
//     }
    
//     public String get(String key, int timestamp) {
//          // 寻找是否已经存在Hash主键，没有就创建一个
//          List<Node> list = map.getOrDefault(key, new ArrayList<>());
//          //如果list是新建的话，那就是空的，就要返回“”
//          if(list.isEmpty()){
//             return "";
//          }
//          //如果不是新建的话，可以用二分法对list进行操作
//          //因为list 是按时间戳递增顺序存储的，因此可以直接在其上使用二分查找。这里的 set 方法确保了时间戳的顺序
//          int l=0, r=list.size() - 1;//list相当于[Node1(key, value, 1), Node2(key, value, 2),...]
//          while(l < r){
//              int mid = l + r + 1 >> 1;//比如，当 l = 0 和 r = 1 时： int mid = l + (r - l) / 2; 会得到 0（向下取整）。int mid = l + r + 1 >> 1;（l+r+1）/2 会得到 1（向上取整）。
//             if(list.get(mid).t <= timestamp){
//                 //因为我们要找的是无限接近timestamp的，就算小于它但也要靠近他(左向右偏)，所以左要往mid收
//                     l = mid;
//             }else{
//                 r = mid - 1;
//             }
//          }
//          return list.get(l).t <= timestamp? list.get(l).v : "";

      
//     }
// }

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */

class TimeMap{
    Map<String, TreeMap<Integer, String>> map; //key- (time, value)
    public TimeMap(){
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp){
        if(!map.containsKey(key)) {
            map.put(key,new TreeMap<>());
        }
        
        map.get(key).put(timestamp, value);

    }

    public String get(String key, int timestamp){
        TreeMap<Integer, String> treeMap = map.get(key);
        // if(treeMap == null) {
        //     return "";
        // }
        // Integer floor = treeMap.floorKey(timestamp);
        // if(floor==null) {
        //     return "";
        // }
        // return treeMap.get(floor);

        return treeMap.floorEntry(timestamp).getValue() == null? "" :  treeMap.floorEntry(timestamp).getValue() ;
    }
}