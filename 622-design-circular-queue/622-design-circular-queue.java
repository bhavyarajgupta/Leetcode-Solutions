class MyCircularQueue {
    int queue[];
    int size;
    int front;
    int rear;

    public MyCircularQueue(int k) {
        queue = new int[k];
        size = 0;
        rear = front = -1;
    }
    
    public boolean enQueue(int value) {
         if(!isFull()) {
            rear = (rear + 1) % queue.length;
            queue[rear] = value;
            size++;
            if(size == 1)
                front = rear;
            return true;
        }
        
        return false;
    }
    
    public boolean deQueue() {
        if(!isEmpty()) {
            front = (front + 1) % queue.length;
            size--;
            return true;
        }
        
        return false;
    }
    
    public int Front() {
        if(isEmpty()) return -1;
        
        return queue[front];
    }
    
    public int Rear() {
        if(isEmpty()) return -1;
        
        return queue[rear];
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public boolean isFull() {
        return queue.length == size;
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