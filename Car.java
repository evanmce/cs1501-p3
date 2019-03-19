public class Car {
    private String VIN;
    private String Make;
    private String Model;
    private String Color;
    private int Price;
    private int Mileage;

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
}