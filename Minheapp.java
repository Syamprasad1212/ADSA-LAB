import java.util.Scanner;
class Minheapp{
    int []heap;
    int size,capacity;
    Minheapp(int capacity){
        this.capacity=capacity;
        heap=new int[capacity];
        size=0;
    }
    int parent(int i){
        return (i-1)/2;
    }
    int left(int i){
        return 2*i+1;
    }
    int right(int i){
        return 2*i+2;
    }
    int insert(int value){
        if(size==capacity){
            System.out.println("Heap Overflow");
            return -1;
        }
        size++;
        int i=size-1;
        heap[i]=value;
        while(i!=0 && heap[parent(i)]>heap[i]){
             int temp = heap[i];                 

            heap[i] = heap[parent(i)];          

            heap[parent(i)] = temp;             

            i = parent(i);   
        }
    }
        void heapify(int i){
            int l=left(i);
            int r=right(i);
            int smallest=i;
            if(l<size && heap[l]<heap[smallest]){
                smallest=l;
            }
            if(r<size && heap[r]<heap[smallest]){
                smallest=r;
            }
            if(smallest!=i){
                int temp=heap[i];
                heap[i]=heap[smallest];
                heap[smallest]=temp;
                heapify(smallest);
            }
        }
        int delete(int value){
            int index=-1;
            for(int i=0;i<size;i++){
                if(heap[i]==value){
                    index=i;
                    break;
                }
            }
            if(index==-1){
                System.out.println("Value not found");
                return -1;
            }
            int lastElement=heap[size-1];
            heap[index]=lastElement;
            size--;
            heapify(index);
            return 0;
        }
        void display(){
            for(int i=0;i<size;i++){
                System.out.print(heap[i]+" ");
            }
            System.out.println();
        }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        MinHeap h = new MinHeap(n);
        int m=sc.nextInt();
        for(int i=0;i<m;i++){
            int x=sc.nextInt();
            h.insert(x);
        }
        h.display();
        int del=sc.nextInt();
        h.delete(del);
        h.display();
    }
}