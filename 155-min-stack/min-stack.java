class MinStack {
    private int top;
    private int min;
    private int origin;
    ArrayDeque<Integer> stck;

    public MinStack() {
        stck = new ArrayDeque<>();
    }
    
    public void push(int val) {
        if(stck.isEmpty()) {
            //origin = val;
            stck.addFirst(val);
            top = val;
            min = val;
        }
        else {
            if(min >= val) {
                min = val;
                stck.addLast(min);
            }
            stck.addFirst(val);
            top = val;
        }
    }
    
    public void pop() {
        //if(stck.peek() == origin) stck.clear();
        int val = stck.pop();
        if(min == val && !stck.isEmpty()) {
            stck.removeLast();
            min = stck.getLast();
        }
        
    }
    
    public int top() {
        return stck.peek();
    }
    
    public int getMin() {
        return min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */