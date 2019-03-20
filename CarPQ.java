import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class CarPQ {

    private int numCars;
    private Car[] heap;
    private String heapMode;
    private boolean makeModelHeap;

    public CarPQ() {
        this.numCars = 0;
        this.heap = new Car[255];
        this.heapMode = "";
        this.makeModelHeap = false;
    }
    
    public CarPQ(String heapMode, boolean makeModelHeap) {
        this.numCars = 0;
        this.heap = new Car[255];
        this.heapMode = heapMode;
        this.makeModelHeap = makeModelHeap;
    }

    public boolean isEmpty() {
        return numCars == 0;
    }

    public int size() {
        return numCars;
    }

    public Car min() {
        if (isEmpty()) throw new NoSuchElementException("Car priority queue underflow");
        return heap[1];
    }

    private void resize(int capacity) {
        assert capacity > numCars;
        Car[] temp = new Car[capacity];
        for (int i = 1; i <= numCars; i++) {
            temp[i] = heap[i];
        }
        heap = temp;
    }

    public void insert(Car car) {
        if (numCars == heap.length - 1) resize(2 * heap.length);
        heap[++numCars] = car;
        swim(numCars);
        assert isMinHeap();
    }

    public void update(int i) {
        if (isEmpty()) throw new NoSuchElementException("Car priority queue underflow");
        swim(i);
        sink(i);
        assert isMinHeap();
    }

    public void remove(int i) {
        if (isEmpty()) throw new NoSuchElementException("Car priority queue underflow");
        exch(i, numCars--);
        swim(i);
        sink(i);
        heap[numCars+1] = null;
        assert isMinHeap();
    }

    public Car delMin() {
        if (isEmpty()) throw new NoSuchElementException("Car priority queue underflow");
        Car min = heap[1];
        exch(1, numCars--);
        sink(1);
        heap[numCars+1] = null;
        if ((numCars > 0) && (numCars == (heap.length - 1) / 4)) resize(heap.length / 2);
        assert isMinHeap();
        return min;
    }

    /***************************************************************************
    * Helper functions to restore the heap invariant.
    ***************************************************************************/

    private void swim(int k) {
        while (k > 1 && greater(k/2, k)) {
            exch(k, k/2);
            k = k/2;
        }
        setCarHeapIndex(k);
    }

    private void sink(int k) {
        while (2*k <= numCars) {
            int j = 2*k;
            if (j < numCars && greater(j, j+1)) j++;
            if (!greater(k, j)) break;
            exch(k, j);
            k = j;
        }
        setCarHeapIndex(k);
    }

    private void setCarHeapIndex(int i) {
        if (heapMode == "Price") {
            if (makeModelHeap) heap[i].setMakeModelPriceIndex(i);
            else heap[i].setPriceIndex(i);
        } else if (heapMode == "Mileage") {
            if (makeModelHeap) heap[i].setMakeModelMileageIndex(i);
            else heap[i].setMileageIndex(i);
        }
    }

    /***************************************************************************
    * Helper functions for compares and swaps.
    ***************************************************************************/

    private boolean greater(int i, int j) {
        if (heapMode == "Price") return heap[i].getPrice() > heap[j].getPrice();
        else if (heapMode == "Mileage") return heap[i].getMileage() > heap[j].getMileage();
        return false;
    }

    private void exch(int i, int j) {
        Car swap = heap[i];
        heap[i] = heap[j];
        heap[j] = swap;
    }

    private boolean isMinHeap() {
        return isMinHeap(1);
    }

    private boolean isMinHeap(int k) {
        if (k > numCars) return true;
        int left = 2*k;
        int right = 2*k + 1;
        if (left <= numCars && greater(k, left)) return false;
        if (right <= numCars && greater(k, right)) return false;
        return isMinHeap(left) && isMinHeap(right);
    }
}