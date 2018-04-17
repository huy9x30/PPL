import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author Huy
 */
public class PCProg {
    Set<PC> pcSet;

    /**
     * Create new object PC and add to Set<PC>
     * @throws InputMismatchException
     */
    public void createObject() throws InputMismatchException {
        try{
            Scanner scan = new Scanner(System.in);
                System.out.println("Input Model");
                String model = scan.nextLine();
                System.out.println("Input Produce Year");
                int year = scan.nextInt();
                System.out.println("Input Manufacturer");
                String manufacturer = scan.nextLine();
                System.out.println("How many components in this PC?");
                int length = scan.nextInt();
                Set<String> components = new Set(new String[length]);
                    for (int i = 0; i < length; i++) {
                        System.out.println("Input component " + (i+1) + ": " );
                        components.set(i, scan.nextLine());
                    }
                PC pc = new PC(model, year, manufacturer, components);
                pcSet.add(pc);
        } catch (InputMismatchException e) {
            throw new InputMismatchException("You input an invalid value");
        }
    }

    /**
     *
     */
    public void displayReport() {
        // TODO
    }

    /**
     *
     */
    public void saveReport() {
        // TODO
    }

    public String abcString() {
        return pcSet.toString();
    }
}
