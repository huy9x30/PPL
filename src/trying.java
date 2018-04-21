import objects.PC;
import objects.Set;

import java.util.Scanner;

/**
 * @author Huy
 */
public class trying {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set components = new Set();

        System.out.println("Input Model");
        String model = scanner.nextLine();

        System.out.println("Input Produce Year");
        int year = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Input Manufacturer");
        String manufacturer = scanner.nextLine();

        System.out.println("How many components in this objects.PC?");
        int numberOfComponent = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < numberOfComponent; i++) {
            System.out.println("Input component " + (i+1) + ": " );
            components.add(scanner.nextLine());
        }

        PC a = new PC(model, year, manufacturer, components);
        System.out.println(a.toString());
    }
}
