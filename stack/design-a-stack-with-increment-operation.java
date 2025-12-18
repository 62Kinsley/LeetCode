class CustomStack {
    int maxSize;
    int[] arr;
    int i = 0;
    public CustomStack(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
    }
    
    public void push(int x) {
        if(i < maxSize){
            arr[i++] = x;
        }
        
    }
    
    public int pop() {
        if(i == 0){
            return -1;
        }
        int top = arr[--i];
        arr[i] = 0;
        return top;
    }
    
    public void increment(int k, int val) {
        //[1, 2, 3]
        if(k>= i){
            for(int j=0; j<i; j++){
                arr[j] += val;
            }
        }else{
            for(int j=0; j<k; j++){
                arr[j] += val;
            }
        }
       
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */