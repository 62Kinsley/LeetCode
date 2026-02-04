// class MyCalendarTwo {

//     public MyCalendarTwo() {
        
//     }
    
//     public boolean book(int startTime, int endTime) {
        
//     }
// }

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(startTime,endTime);
 */

class MyCalendarTwo {
    TreeMap<Integer, Integer> map;

    public MyCalendarTwo() {
        map = new TreeMap<>((x, y) -> y - x);
    }

    public boolean book(int start, int end) {
        int temp = 0;
        int ans = 0;
        map.put(start, map.getOrDefault(start, 0) + 1);
        map.put(end, map.getOrDefault(end, 0) - 1);
        //恢复所有的值 采取了逆向恢复 和正向恢复都一样
        for (Integer key : map.keySet()) {
            temp = temp - map.get(key);
            ans = Math.max(ans, temp);
            if (ans > 2) {
                map.put(start, map.getOrDefault(start, 0) - 1);
                map.put(end, map.getOrDefault(end, 0) + 1);
                return false;
            }
        }
        return true;
    }

}

