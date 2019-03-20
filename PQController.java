
public class PQController {

    private static CarPQ priceHeap;
    private static CarPQ mileageHeap;

    public PQController() {
        priceHeap = new CarPQ("Price", false);
        mileageHeap = new CarPQ("Mileage", false);
    }

    public static Car getLowestPriceCar() {
        return priceHeap.min();
    }

    public static Car getLowestMileageCar() {
        return mileageHeap.min();
    }

    public static void insert(Car car) {
        priceHeap.insert(car);
        mileageHeap.insert(car);
    }

    public static void update(Car car, String heapMode) {
        if (heapMode == "Price") {
            int priceIndex = car.getPriceIndex();
            priceHeap.update(priceIndex);
        } else if (heapMode == "Mileage") {
            int mileageIndex = car.getMileageIndex();
            mileageHeap.update(mileageIndex);
        } 
    }

    public static void remove(Car car) {
        int priceIndex = car.getPriceIndex();
        int mileageIndex = car.getMileageIndex();
        priceHeap.remove(priceIndex);
        mileageHeap.remove(mileageIndex);
    }
}