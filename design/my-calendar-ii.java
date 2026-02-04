class MyCalendarTwo {

    private List<int[]> bookings;// 所有已预订的事件
    private List<int[]> overlapBookings;// 所有「已经双重预订」的时间段
    //如果新事件与「已经双重预订的区间」重叠，那就变成三重预订了！
    public MyCalendarTwo() {
        bookings = new ArrayList<>();//(10, 20) (50, 60)
        overlapBookings = new ArrayList<>();
    }
    //// 判断两个区间是否重叠
    private boolean doesOverlap(int startTime1, int endTime1, int startTime2, int endTime2){
        return Math.max(startTime1, startTime2) < Math.min(endTime1, endTime2);
    }

    private int[] getOverlapped(int start1, int end1, int start2, int end2) {
        return new int[] { Math.max(start1, start2), Math.min(end1, end2)};
    }
    
    public boolean book(int startTime, int endTime) {
        for(int[] overBooking : overlapBookings) {//检查是否会三重预订
            if(doesOverlap(startTime, endTime, overBooking[0], overBooking[1])){
                return false;
            }
        }

        for(int[] booking : bookings) {
            if(doesOverlap( startTime,endTime,  booking[0],  booking[1])){
                overlapBookings.add(getOverlapped(startTime, endTime, booking[0], booking[1]));
            }
        }
        bookings.add(new int[]{startTime, endTime});
        return true;
    }
}

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(startTime,endTime);
 */


