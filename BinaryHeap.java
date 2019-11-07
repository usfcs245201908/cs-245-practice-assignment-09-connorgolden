class BinaryHeap {
    private int[] Data;
    private int maxSize;
    private int size;

    public BinaryHeap(){
        maxSize = 10;
        Data = new int[maxSize];
        Data[0] = Integer.MIN_VALUE;
        size = 0;
    }

    public BinaryHeap(int max){
        maxSize = max;
        Data = new int[maxSize];
        Data[0] = Integer.MIN_VALUE;
        size = 0;
    }

    private int leftchild(int pos){
        return 2*pos;
    }

    private int parent(int pos){
        return (pos/2);
    }

    private boolean isleaf(int pos){
        return ((pos>size/2) && (pos <= size));
    }

    private void swap(int position1, int position2){
        int temp;
        temp = Data[position1];
        Data[position1] = Data[position2];
        Data[position2] = temp;
    }

    private void sift(int position){
        int smallest;
        while (!isleaf(position)){
            smallest = leftchild(position);
            if ((smallest<size) && (Data[smallest] > Data[smallest+1])){
                smallest = smallest +1;
            }

            if (Data[position] <= Data[smallest]){
                return;
            }
            swap(position, smallest);
            position = smallest;
        }
    }


    public void add(int item){
        if (size == maxSize-1){

            BinaryHeap newHeap = new BinaryHeap(maxSize*2);
            for (int i = 0; i<maxSize; i++){
                newHeap.Data[i] = Data[i];
            }

            maxSize = maxSize*2;
            Data = newHeap.Data;
        }

        int current = size++;
        Data[size] = item;
        while (Data[current] < Data[parent(current)]){
            swap(current, parent(current));
            current = parent(current);
        }
    }

    public int remove(){
        swap(1,size);
        size--;
        if (size != 0){
            sift(1);
        }
        return Data[size+1];
    }



}
