class MyStack {
    private Queue<Integer> q1;
    private Queue<Integer> q2;
    private Queue<Integer> top;

    
    public MyStack() {
        this.q1 = new LinkedList<Integer>();
        this.q2 = new LinkedList<Integer>();
        this.top = q1;
        
    }
    
    public void push(int x) {
        top.add(x);
        int size = top.size();

        while(size > 1) {
            top.add(top.remove());
            size--;
        }

    }
    
    public int pop() {
        return top.remove();
    }
    
    public int top() {
        return top.peek();
    }
    
    public boolean empty() {
        return top.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */