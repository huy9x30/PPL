/**
 * @author Huy
 */
public class trying {
    public static void main(String[] args) {
        Set b = new Set();
        b.add("Desktop");
        b.add("Keyboard");
        PC a = new PC("Astronaut-2018", 2018, "DELL", b);
        System.out.println(a.toString());
        System.out.println("------------------------------------------------------------------------------");
        System.out.println("                        PC PROGRAM REPORT               ");
        System.out.println("------------------------------------------------------------------------------");
        System.out.printf("%5d %20s %5s %10s %30s \n", a.getId(), a.getModel(), a.getYear(), a.getManufacturer(), a.getComponents());
        System.out.println("------------------------------------------------------------------------------");

    }
}
