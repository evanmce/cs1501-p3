public class CarNode {
    private Car car;
    private char value;
    private CarNode children;
    private CarNode sibling;
    
    public CarNode(char val) {
        this.value = val;
    }

    public Car getCar() {
        return car;
    }
    
    public char getValue() {
        return value;
    }

    public CarNode getChildren() {
        return children;
    }

    public CarNode getSibling() {
        return sibling;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public void setValue(char val) {
        this.value = value;
    }

    public void setChildren(CarNode children) {
        this.children = children;
    }

    public void setSibling(CarNode sibling) {
        this.sibling = sibling;
    }

}