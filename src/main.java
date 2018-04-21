import java.io.IOException;
import java.util.ArrayList;

public class main{
    public static void main(String[] args) throws IOException {
        PCProg pcProgram = new PCProg("", new ArrayList<>());

        while(true) {
            System.out.println(
                            "--------------------------\n" +
                            "        PcProgram         \n" +
                            "--------------------------\n" +
                            "1. Create new PC record. \n" +
                            "2. Display report. \n" +
                            "3. Save report. \n" +
                            "q. Quit \n" +
                            "Your option: "
            );
            String userChoice = TextIO.getWord();
            TextIO.getln();
            switch (userChoice) {
                case "1":
                    pcProgram.createObject();
                    break;
                case "2":
                    pcProgram.displayReport();
                    break;
                case "3":
                    pcProgram.saveReport();
                    break;
                case "q":
                    System.out.println("Good bye!");
                    System.exit(0);
                default:
                    System.out.println("You have input an unavailable option!\n");
            }

        }
    }
}