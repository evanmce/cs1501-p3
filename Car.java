public class Car {

    private String VIN;
    private String Make;
    private String Model;
    private String Color;
    private int Price;
    private int Mileage;
    private int PriceIndex;
    private int MileageIndex;
    private int MakeModelPriceIndex;
    private int MakeModelMileageIndex;

    public Car(String vin, String make, String model, String color, int price, int mileage) {
        this.VIN = vin;
        this.Make = make;
        this.Model = model;
        this.Color = color;
        this.Mileage = mileage;
        this.Price = price; 
    }

    public String getVIN() {
        return this.VIN;
    }

    public String getMake() {
        return this.Make;
    }

    public String getModel() {
        return this.Model;
    }

    public String getColor() {
        return this.Color;
    }

    public int getPrice() {
        return this.Price;
    }

    public int getMileage() {
        return this.Mileage;
    }

    public int getPriceIndex() {
        return this.PriceIndex;
    }

    public int getMileageIndex() {
        return this.MileageIndex;
    }

    public int getMakeModelPriceIndex() {
        return this.MakeModelPriceIndex;
    }

    public int getMakeModelMileageIndex() {
        return this.MakeModelMileageIndex;
    }

    public void setVIN(String vin) {
        this.VIN = vin;
    }

    public void setMake(String make) {
        this.Make = make;
    }

    public void setModel(String model) {
        this.Model = model;
    }

    public void setColor(String color) {
        this.Color = color;
    }

    public void setPrice(int price) {
        this.Price = price;
    }

    public void setMileage(int mileage) {
        this.Mileage = mileage;
    }

    public void setPriceIndex(int index) {
        this.PriceIndex = index;
    }

    public void setMileageIndex(int index) {
        this.MileageIndex = index;
    }

    public void setMakeModelPriceIndex(int index) {
        this.MakeModelPriceIndex = index;
    }

    public void setMakeModelMileageIndex(int index) {
        this.MakeModelMileageIndex = index;
    }

    public String toString() {
        String car = "\tVIN: " + this.VIN +
                   "\n\tMake: " + this.Make +
                   "\n\tModel: " + this.Model +
                   "\n\tColor: " + this.Color +
                   "\n\tPrice: " + this.Price +
                   "\n\tMileage: " + this.Mileage;
        return car;
    }
}