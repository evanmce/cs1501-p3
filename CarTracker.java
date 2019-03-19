import java.io.*;
import java.util.Scanner;

public class CarTracker {
    private static Scanner fsc;
    private static Scanner sc;
    private static String[] line;

    public static void main(String[] args) {
        
        BufferedReader br;
        int input = 0;
        
        try {
            File file = new File("cars.txt");
            fsc = new Scanner(file);
            sc = new Scanner(System.in);
        } catch (IOException e) {
            System.out.println(e);
            System.exit(1);
        }
        
        while(fsc.hasNextLine()) {
            line = fsc.nextLine().split(":");
            char comment = line[0].charAt(0);
            if (comment != '#') {
                // System.out.println("VIN: " + line[0] +
                //             "\nMake: " + line[1] +
                //            "\nModel: " + line[2] +
                //            "\nPrice: " + line[3] +
                //          "\nMileage: " + line[4] +
                //            "\nColor: " + line[5] + "\n");
                String vin = line[0];
                String make = line[1];
                String model = line[2];
                int price = Integer.parseInt(line[3]);
                int mileage = Integer.parseInt(line[4]);
                String color = line[5];           
                Car car = new Car(vin, make, model, color, price, mileage);                           
            }
        }

        do {
            System.out.println("\n\t1. Add Car");
            System.out.println("\t2. Update Car");
            System.out.println("\t3. Remove Car");
            System.out.println("\t4. Get Lowest Priced Car");
            System.out.println("\t4. Get Lowest Priced Car by Make/Model");
            System.out.println("\t6. Get Lowest Mileage Car");
            System.out.println("\t7. Get Lowest Mileage Car by Make/Model");
            System.out.println("\t8. Exit");
            System.out.print("\nEnter Option: ");
            input = Integer.parseInt(sc.nextLine());

            switch (input) {
                case 1:
                    addCar();
                case 2:
                    updateCar();
                case 3:
                    removeCar();
                case 4:
                    getLowestPriceCar();
                case 5:
                    getLowestPriceCarByMakeAndModel();
                case 6:
                    getLowestMileageCar();
                case 7:
                    getLowestMileageCarByMakeAndModel();
                case 8:
                    System.exit(0);
                default:
                    System.out.println("\nInvalid input.\n");
            } 
        } while(true);
    }

    public static void addCar() {
        String vin = "";
        String make = "";
        String model = "";
        String color = "";
        int price = 0;
        int mileage = 0;

        System.out.print("\nEnter a VIN: ");
        vin = sc.nextLine();

        System.out.print("Enter a Make: ");
        make = sc.nextLine();

        System.out.print("Enter a Model: ");
        model = sc.nextLine();

        System.out.print("Enter a Color: ");
        color = sc.nextLine();

        System.out.print("Enter a Price: $");
        price = Integer.parseInt(sc.nextLine());

        System.out.print("Enter a mileage: ");
        mileage = Integer.parseInt(sc.nextLine());

        Car car = new Car(vin, make, model, color, price, mileage);  
    }

    public static void updateCar() {

    }

    public static void removeCar() {

    }

    public static void getLowestPriceCar() {
        
    }

    public static void getLowestPriceCarByMakeAndModel() {

    }

    public static void getLowestMileageCar() {

    }

    public static void getLowestMileageCarByMakeAndModel() {

    }
}