class MyCircularQueue {
    private int[] arr;
    private int capacity;
    private int front;
    private int rear;
    private int count;      // 当前元素个数
    public MyCircularQueue(int k) {
        capacity = k;
        arr = new int[capacity];

        // 在 front 出队，故设计在数组的头部，方便删除元素
        // 删除元素的时候，只索引 +1（注意取模）
         // 在 rear 入队，故设计在数组的尾部，方便插入元素
        // 插入元素的时候，先赋值，后索引 +1（注意取模）
        front = 0;
        rear = 0;
    }
    
    public boolean enQueue(int value) {//1,2,3
        if (isFull()) {
            return false;
        }
        arr[rear] = value;
        rear = (rear+1) % capacity;
        count++;
        return true;
    }
    
    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }
        front = (front+1)% capacity;
        count--;
        return true;
    }
    
    public int Front() {
        if (isEmpty()) {
            return -1;
        }
        return arr[front];
    }
    
    public int Rear() {
        if (isEmpty()) {
            return -1;
        }
        return arr[(rear-1+ capacity)% capacity];
    }
    
    public boolean isEmpty() {
        return count == 0;
        
    }
    
    public boolean isFull() {
        return count == capacity;
    }

}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */