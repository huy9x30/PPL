import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        PCProg pcs = new PCProg();
        while(true) {
            Scanner userInput = new Scanner(System.in);
            System.out.println("" +
                    "PcProgram \n" +
                    "1. Create object PC. \n" +
                    "2. Display report. \n" +
                    "3. Save report. \n" +
                    "q. Quit \n" +
                    "Your option: "
            );
            switch (userInput.next(".").charAt(0)) {
                case '1':
                    pcs.createObject();
                    System.out.println(pcs.abcString());
                case '2': pcs.displayReport();
                case '3': pcs.saveReport();
                case 'q': System.exit(0);
                default:
                    System.out.println("You have input an unavailable option!");
            }
        }
    }
}
