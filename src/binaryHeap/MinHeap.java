package binaryHeap;

public class MinHeap {

  int arr[];
  int size;
  int capacity;

  public MinHeap(int capacity) {
    this.capacity = capacity;
    arr = new int[capacity];
    size = 0;
  }

  public int left(int i) {
    return (2 * i + 1);
  }

  public int right(int i) {
    return (2 * i + 2);
  }

  public int parent(int i) {
    return (i - 1) / 2;
  }

  public void insert(int x) {
    if (size == capacity) {
      return;
    }
    size++;
    arr[size - 1] = x;
    for (int i = size - 1; i != 0 && arr[parent(i)] > arr[i];) {
      int temp = arr[i];
      arr[i] = arr[parent(i)];
      arr[parent(i)] = temp;
      i = parent(i);
    }
  }

  public void minHeapify(int i) {
    int left = left(i);
    int right = right(i);
    int smallest = i;
    if (left < size && arr[left] < arr[i]) {
      smallest = left;
    }
    if (right < size && arr[right] < arr[i]) {
      smallest = right;
    }
    if (smallest != i) {
      int temp = arr[i];
      arr[i] = arr[smallest];
      arr[smallest] = temp;
      minHeapify(smallest);
    }
  }

  public int getMinimum() {
    if (size == 0) {
      return Integer.MAX_VALUE;
    }
    if (size == 1) {
      size--;
      return arr[0];
    }
    int minimum = arr[0];
    arr[0] = arr[size - 1];
    arr[size - 1] = minimum;
    size--;
    minHeapify(0);
    return arr[size];
  }

  public void decreaseKey(int i, int x) {
    arr[i] = x;
    while (i != 0 && arr[parent(i)] > arr[i]) {
      int temp = arr[i];
      arr[i] = arr[parent(i)];
      arr[parent(i)] = temp;
      i = parent(i);
    }
  }

  public void delete(int index) {
    decreaseKey(index, Integer.MIN_VALUE);
    getMinimum();
  }

  public void buildHeap() {
    // for finding the last most right parent node we use the last leaf node and
    // and determine its parent the formula is (i - 1) / 2
    // so in this case the last parent is ((size - 1) - 1) / 2;
    for (int i = (size - 2) / 2; i >= 0; i--) {
      minHeapify(i);
    }
  }

}
