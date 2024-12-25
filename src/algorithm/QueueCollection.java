package algorithm;

public class QueueCollection {
    int front;
    int rear ;
    int capacity;
    int queueArray[];
    QueueCollection(int size){
        capacity = size;
        queueArray = new int[size];
    }

    void enQueue(int value){
        if(rear==capacity){
            System.out.println("Queue is already full and you cannot insert.");
        }
        else {
            queueArray[rear]= value;
            rear++;
        }
    }

    void deQueue() {
        if(front ==rear){
            System.out.println("Queue is empty, nothing to delete");
        }else{
            for(int d =0; d<rear-1;d++){
                queueArray[d]=queueArray[d+1];
            }
            rear--;
        }
    }
    void display(){
        if(rear==0){
            System.out.println("Queue is empty");
        }else
        {
            for (int i =0; i<rear; i++){
                System.out.print(queueArray[i] + " ");
            }
        }
    }

    public static void main(String[] args) {
        QueueCollection que = new QueueCollection(5);
        que.enQueue(4);
        que.enQueue(7);
        que.enQueue(9);
        que.display();
        System.out.println(" ");
        que.deQueue();
        que.display();
    }

}
