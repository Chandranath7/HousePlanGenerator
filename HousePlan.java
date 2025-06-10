import java.util.Scanner;

class Room {
    String name;
    int width;
    int length;
    
    // Constructor
    Room(String name, int width, int length) {
        this.name = name;
        this.width = width;
        this.length = length;
    }

    int getArea() {
        return width * length;
    }

    void display() {
        System.out.println(name + " - " + width + " ft x " + length + " ft (Area: " + getArea() + " sq.ft)");
    }
}

public class HousePlanGenerator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("===== Welcome to House Plan Generator =====\n");

        System.out.print("Enter total house area you want (in sq.ft): ");
        int totalArea = scanner.nextInt();

        System.out.print("Enter number of Bedrooms: ");
        int bedrooms = scanner.nextInt();

        System.out.print("Enter number of Bathrooms: ");
        int bathrooms = scanner.nextInt();

        System.out.print("Enter number of Kitchens: ");
        int kitchens = scanner.nextInt();

        System.out.print("Enter number of Living Rooms: ");
        int livingRooms = scanner.nextInt();

        System.out.print("Enter number of Dining Rooms: ");
        int diningRooms = scanner.nextInt();

        System.out.print("Enter number of Study Rooms: ");
        int studyRooms = scanner.nextInt();

        int totalUsedArea = 0;

        System.out.println("\n===== Generated House Plan =====\n");

        totalUsedArea += generateRooms("Bedroom", bedrooms, 12, 14);
        totalUsedArea += generateRooms("Bathroom", bathrooms, 8, 10);
        totalUsedArea += generateRooms("Kitchen", kitchens, 10, 12);
        totalUsedArea += generateRooms("Living Room", livingRooms, 15, 20);
        totalUsedArea += generateRooms("Dining Room", diningRooms, 12, 14);
        totalUsedArea += generateRooms("Study Room", studyRooms, 10, 12);

        System.out.println("\nTotal Area Covered by Rooms: " + totalUsedArea + " sq.ft");

        if (totalUsedArea > totalArea) {
            System.out.println("Warning: Total area of rooms exceeds your specified house area!");
        } else {
            System.out.println("Remaining Area for circulation/open space: " + (totalArea - totalUsedArea) + " sq.ft");
        }

        System.out.println("\n===== Plan Generation Complete =====");

        scanner.close();
    }

    public static int generateRooms(String roomType, int count, int width, int length) {
        int areaSum = 0;
        for (int i = 1; i <= count; i++) {
            Room room = new Room(roomType, width, length);
            room.display();
            areaSum += room.getArea();
        }
        return areaSum;
    }
}
