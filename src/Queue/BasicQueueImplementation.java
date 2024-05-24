package Queue;

public class BasicQueueImplementation {
	int front, rear, maxSize;
	int queue[];
	void create_queue(int e){
		maxSize = e;
		rear = -1;
		front = 0;
		queue = new int[maxSize];
	}
	
	void enqueue(int e) {
		rear++;
		queue[rear] = e;
	}
	
	int dequeue(int e) {
		int temp = queue[front];
		front++ ;
		return temp;
	}
	
	boolean isFull() {
		if(rear==maxSize-1)
			return true;
		return false;
	}
	
	boolean isEmpty() {
		if(front>rear)
			return false;
		return true;
	}
	
	void printQueue() {
		for (int i = front; i <= rear; i++) {
			
		}
	}
	
}
