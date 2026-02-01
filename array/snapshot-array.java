class SnapshotArray {

    
    int snapTimes = 0;
    List<int[]>[] arr;

    public SnapshotArray(int length) {
        arr = new ArrayList[length];
        for (int i = 0; i < length; i++) {
            arr[i] = new ArrayList<>();
            
        }
    }
    
    public void set(int index, int val) {
        arr[index].add(new int[]{snapTimes, val});
    }
    
    public int snap() {
        return  snapTimes++;
    }
    
    // [0,1,2]
    // 0,5
    // 1,6
    // 2,7
    // 3,4
    public int get(int index, int snap_id) {
        int l=0, r=arr[index].size()-1;
        int result = -1;
        while(l <= r){
            int mid = l+(r-l)/2;
            if(arr[index].get(mid)[0] <= snap_id){
                result = mid;
                l = mid + 1;
            }else{
                r = mid - 1;
            }
        }
        if(result < 0){
            return 0;
        }else{
            return arr[index].get(result)[1];
        }

    }
}


// class SnapshotArray {

    
//     int snapTimes = 0;
//     TreeMap<Integer, Integer>[] map = new TreeMap[];//index, [snap_id, val]

//     public SnapshotArray(int length) {
//         for(int i=0; i<length; i++){
//             map[i] = new TreeMap<>();
//             map[i].put(0,0);// snap_id = 0  for 0
//         }
//     }
    
//     public void set(int index, int val) {
//            map[index].put(snapTimes, val);
//     }
    
//     public int snap() {
//         return snapTimes++;
//     }
    
//     public int get(int index, int snap_id) {
//         map[index].floorEntry(snap_id).getValue();
//     }
// }
/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */