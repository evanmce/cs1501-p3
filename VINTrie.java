import java.text.StringCharacterIterator;

public class VINTrie {
    
    private CarNode root = new CarNode();

    public boolean insert(Car car) {
        String carVIN = car.getVIN();
        CarNode current = root;
        if (carVIN == null) return false;
        for (int i = 0; i < carVIN.length(); i++) {
            char c = carVIN.charAt(i);
            if (current.getChildNode() == null) {
                current.setChildNode(new CarNode(c));
                current = current.getChildNode();
            } else {
                current = current.getChildNode();
                while (current.getSiblingNode() != null) {
                    if (current.getValue() == c) break;
                    current = current.getSiblingNode();
                }
                if (current.getValue() != c) {
                    current.setSiblingNode(new CarNode(c));
                    current = current.getSiblingNode();
                }
            }   
        }
        current.setCar(car);   
        return true;
    }

    public boolean remove(String vin) {
        if (vin == null || root == null) return false;
        CarNode current = root;
        for (int i = 0; i < vin.length(); i++) {
            char c = vin.charAt(i);
            if (current.getChildNode() != null) current = current.getChildNode();
            while (current.getValue() != c) {
                if (current.getSiblingNode() != null) {
                    current = current.getSiblingNode();
                }
            } 
        }
        if (current.getValue() == vin.charAt(vin.length()-1))
            if(current.getCar() != null) {
                current.setCar(null); 
                return true;
            }
        return false;
    }

    public Car getCar(String vin) {
        if (vin == null || root == null) return null;
        CarNode current = root;
        for (int i = 0; i < vin.length(); i++) {
            char c = vin.charAt(i);
            if (current.getChildNode() != null) current = current.getChildNode();
            while (current.getValue() != c) {
                if (current.getSiblingNode() != null) {
                    current = current.getSiblingNode();
                }
            }  
        }
        if (current.getValue() == vin.charAt(vin.length()-1)) 
            if(current.getCar() != null) return current.getCar();
        return null;
    }
}