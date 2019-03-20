public class CarNode {

    private Car car;
    private char value;
    private CarNode child;
    private CarNode sibling;
    
    public CarNode() { }
    
    public CarNode(char val) {
        this(null, val, null, null);
    }

    public CarNode(Car car, char value, CarNode child, CarNode sibling) {
        this.car = car;
        this.value = value;
        this.child = child;
        this.sibling = sibling;
    }

    public Car getCar() {
        return car;
    }
    
    public char getValue() {
        return value;
    }

    public CarNode getChildNode() {
        return child;
    }

    public CarNode getSiblingNode() {
        return sibling;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public void setValue(char val) {
        this.value = value;
    }

    public void setChildNode(CarNode child) {
        this.child = child;
    }

    public void setSiblingNode(CarNode sibling) {
        this.sibling = sibling;
    }

}