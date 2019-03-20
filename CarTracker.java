import java.io.*;
import java.util.Scanner;

public class CarTracker {

    private static Scanner fsc;
    private static Scanner sc;
    private static String[] line;
    private static PQController controller;

    public static void main(String[] args) {
        
        BufferedReader br;
        int input = 0;
        controller = new PQController();
        
        try {
            File file = new File("cars.txt");
            System.out.println("\nImporting cars from " + file.getName() + "...\n");
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
                System.out.println("\tVIN: " + line[0] +
                            "\n\tMake: " + line[1] +
                           "\n\tModel: " + line[2] +
                           "\n\tPrice: " + line[3] +
                         "\n\tMileage: " + line[4] +
                           "\n\tColor: " + line[5] + "\n");
                String vin = line[0];
                String make = line[1];
                String model = line[2];
                int price = Integer.parseInt(line[3]);
                int mileage = Integer.parseInt(line[4]);
                String color = line[5];           
                Car car = new Car(vin, make, model, color, price, mileage);
                controller.insert(car);                           
            }
        }

        System.out.println("\n###################################################\n");
        System.out.println("                 Evan's World of Cars");
        System.out.println("\n###################################################");

        do {

            System.out.println("\n\t--- Menu ---");
            System.out.println("\n\t1. Add Car");
            System.out.println("\t2. Update Car");
            System.out.println("\t3. Remove Car");
            System.out.println("\t4. Get Lowest Priced Car");
            System.out.println("\t5. Get Lowest Priced Car by Make and Model");
            System.out.println("\t6. Get Lowest Mileage Car");
            System.out.println("\t7. Get Lowest Mileage Car by Make and Model");
            System.out.println("\t8. Exit");
            System.out.print("\nEnter Command: ");
            input = Integer.parseInt(sc.nextLine());

            switch (input) {
                case 1:
                    addCar();
                    break;
                case 2:
                    updateCar();
                    break;
                case 3:
                    removeCar();
                    break;
                case 4:
                    getLowestPriceCar();
                    break;
                case 5:
                    getLowestPriceCarByMakeAndModel();
                    break;
                case 6:
                    getLowestMileageCar();
                    break;
                case 7:
                    getLowestMileageCarByMakeAndModel();
                    break;
                case 8:
                    System.exit(0);
                default:
                    System.out.println("\nInvalid input.\n");
            } 
        } while(input != 8);

    } // end main()

    public static void addCar() {
        
        String vin = "";
        String make = "";
        String model = "";
        String color = "";
        int price = 0;
        int mileage = 0;

        System.out.println("\n\t--- Add Car ---");

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

        Car newCar = new Car(vin, make, model, color, price, mileage);

        controller.insert(newCar);

    } // end addCar()

    public static void updateCar() {
        
        String vin = "";
        String color = "";
        int price = 0;
        int mileage = 0;
        int input = 0;

        System.out.println("\n\t--- Update Car ---");

        System.out.print("\nEnter a VIN: ");
        vin = sc.nextLine();

        // Print out Vehicle info

        do {
            System.out.println("\n\t1. Update Price");
            System.out.println("\t2. Update Mileage");
            System.out.println("\t3. Update Color");
            System.out.println("\t4. Exit");
            System.out.print("\nEnter Command: ");
            input = Integer.parseInt(sc.nextLine());

            switch (input) {
                case 1:
                    System.out.print("\nNew Price: $");
                    price = Integer.parseInt(sc.nextLine());
                    break;
                case 2:
                    System.out.print("\nNew Mileage: ");
                    mileage = Integer.parseInt(sc.nextLine());
                    break;
                case 3:
                    System.out.print("\nNew Color: ");
                    color = sc.nextLine();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("\nInvalid input.\n");
            }

        } while(input != 4);

    } // end updateCar()

    public static void removeCar() {

        String vin = "";

        System.out.println("\n\t--- Remove Car ---");

        System.out.print("\nEnter a VIN: ");
        vin = sc.nextLine();

        // print out the details of the removed car

    } // end removeCar()

    public static void getLowestPriceCar() {
        
        System.out.println("\n\t--- Get Lowest Priced Car ---");

        Car lowestPriceCar = PQController.getLowestPriceCar();
        if (lowestPriceCar == null) System.out.println("\n\t--- Car Inventory Empty ---");
        else System.out.println("\n" + lowestPriceCar.toString());

    } // end getLowestPriceCar

    public static void getLowestPriceCarByMakeAndModel() {

        String make = "";
        String model = "";

        System.out.println("\n\t--- Get Lowest Priced Car By Make and Model ---");

        System.out.print("\nEnter a Make: ");
        make = sc.nextLine();

        System.out.print("Enter a Model: ");
        model = sc.nextLine();

        // print out the lowest priced car by make and model

    } // end getLowestPriceCarByMakeAndModel()

    public static void getLowestMileageCar() {

        System.out.println("\n\t--- Get Lowest Mileage Car ---");

        Car lowestMileageCar = PQController.getLowestMileageCar();
        if (lowestMileageCar == null) System.out.println("\n\t--- Car Inventory Empty ---");
        else System.out.println("\n" + lowestMileageCar.toString());

    } // end getLowestMileageCar()

    public static void getLowestMileageCarByMakeAndModel() {

        String make = "";
        String model = "";

        System.out.println("\n\t--- Get Lowest Mileage Car By Make and Model ---");

        System.out.print("\nEnter a Make: ");
        make = sc.nextLine();

        System.out.print("Enter a Model: ");
        model = sc.nextLine();

        // print out the lowest mileage car by make and model


    } // end getLowestMileageCarByMakeAndModel()

}