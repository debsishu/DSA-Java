package binaryHeap;

public class Heap {
  public int array[];
  public int count;
  public int capacity;
  public int heap_type;

  public Heap(int capacity, int heap_type) {
    this.heap_type = heap_type;
    this.count = 0;
    this.capacity = capacity;
    this.array = new int[capacity];
  }

  public int parent(int i) {
    if(i <= 0 || i >= this.count) {
      return -1;
    }
    return (i - i) / 2;
  }

  public int leftChild(int i) {
    int left = (2 * i) + 1;
    if(left >= this.count) {
      return -1;
    }
    return left;
  }

  public int rightChild(int i) {
    int right = (2 * i) + 2;
    if(right >= this.count) {
      return -1;
    }
    return right;
  }

  public int getMaximum() {
    if(this.count == 0) {
      return -1;
    }
    return this.array[0];
  }

  public void percolateDown(int i) {
    int left = leftChild(i);
    int right = rightChild(i);
    int max;
    if(left != -1 && this.array[left] > this.array[i]) {
      max = left;
    } else {
      max = i;
    }
    if(right != -1 && this.array[right] > this.array[max]) {
      max = right;
    }
    if(max != i) {
      int temp = this.array[i];
      this.array[i] = this.array[max];
      this.array[max] = temp;
      percolateDown(max);
    }
  }

  public int deleteMax() {
    if(this.count == 0) {
      return -1;
    }
    int data = this.array[0];
    this.array[0] = this.array[this.count - 1];
    this.count--;
    percolateDown(0);
    return data;
  }

  public void insert(int data) {
    if(this.count == this.capacity) {
      resizeHeap();
    }
    this.count++;
    int i = this.count - 1;
    while(i >= 0 && data > this.array[(i - 1) / 2]) {
      this.array[i] = this.array[(i - 1) / 2];
      i = i - 1 / 2;
    }
    this.array[i] = data;
  }

  public void resizeHeap() {
    int array_old[] = new int[this.capacity];
    System.arraycopy(this.array, 0, array_old, 0, this.count - 1);
    this.array = new int[this.capacity * 2];
    if(this.array == null) {
      System.out.println("Memeory Error");
      return;
    }
    for(int i = 0; i< this.capacity; i++) {
      this.array[i] = array_old[i];
    }
    this.capacity *= 2;
    array_old = null;
  }

  public void destoryHeap() {
    this.count = 0;
    this.array = null;
  }

  public void buildHeap(Heap h, int a[], int n) {
    if(h == null) {
      return;
    }
    while(n > this.capacity) {
      h.resizeHeap();
    }
    for(int i = 0; i<n; i++) {
      h.array[i] = a[i];
    }
    this.count = n;
    for(int i = (n - 1) / 2; i >= 0; i--) {
      h.percolateDown(i);
    }
  }

  public void print() {
    for (int i = 0; i < this.count / 2; i++) {
      System.out.print(" PARENT : " + this.array[i] + " LEFT CHILD : " + this.array[2 * i + 1] + " RIGHT CHILD :" + this.array[2 * i + 2]);
      System.out.println();
    }
  }

  public static void main(String[] args) {
    Heap h = new Heap(12, 0);
    h.insert(12);
    h.insert(14);
    h.insert(22);
    h.insert(17);
    h.insert(95);
    h.insert(45);
    System.out.println("worked");
  }
}
