import java.util.Scanner;

public class HousePlanGenerator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("🏠 Welcome to House Plan Generator!");
        
        System.out.print("Enter total available area (in sqft): ");
        int totalAreaAvailable = sc.nextInt();

        System.out.print("Enter number of bedrooms: ");
        int bedrooms = sc.nextInt();

        System.out.print("Enter number of bathrooms: ");
        int bathrooms = sc.nextInt();

        System.out.print("Do you want a balcony? (yes=1 / no=0): ");
        int balcony = sc.nextInt();

        System.out.print("Do you want a study room? (yes=1 / no=0): ");
        int studyRoom = sc.nextInt();

        System.out.print("Enter number of floors: ");
        int floors = sc.nextInt();

        System.out.println("\n🧱 Generating House Layout...\n");

        // Define fixed room sizes
        int masterBedroomArea = 150;
        int normalBedroomArea = 120;
        int bathroomArea = 60;
        int kitchenArea = 80;
        int livingArea = 150;
        int balconyArea = 50;
        int studyRoomArea = 70;

        int totalUsedArea = 0;

        if (bedrooms > 0) {
            totalUsedArea += masterBedroomArea;
            totalUsedArea += (bedrooms - 1) * normalBedroomArea;
        }

        totalUsedArea += bathrooms * bathroomArea;
        totalUsedArea += kitchenArea;
        totalUsedArea += livingArea;

        if (balcony == 1) totalUsedArea += balconyArea;
        if (studyRoom == 1) totalUsedArea += studyRoomArea;

        int totalUsedAcrossFloors = totalUsedArea * floors;

        System.out.println("------- House Plan Summary -------");
        System.out.println("Total Area Available : " + totalAreaAvailable + " sqft");
        System.out.println("Number of Floors     : " + floors);
        System.out.println("Master Bedroom       : 1 (150 sqft)");
        System.out.println("Normal Bedrooms      : " + (bedrooms - 1) + " (Each 120 sqft)");
        System.out.println("Bathrooms            : " + bathrooms + " (Each 60 sqft)");
        System.out.println("Kitchen              : Included (80 sqft)");
        System.out.println("Living Room          : Included (150 sqft)");
        System.out.println("Balcony              : " + (balcony == 1 ? "Yes (50 sqft)" : "No"));
        System.out.println("Study Room           : " + (studyRoom == 1 ? "Yes (70 sqft)" : "No"));
        System.out.println("Estimated Total Used : " + totalUsedAcrossFloors + " sqft");

        if (totalUsedAcrossFloors > totalAreaAvailable) {
            System.out.println("⚠ Warning: Plan exceeds available area!");
        } else {
            System.out.println("✅ Plan fits within available area.");
        }

        System.out.println("----------------------------------");

        sc.close();
    }
}
