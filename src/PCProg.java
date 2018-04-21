import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author huynq
 */
public class PCProg {
    private String report;
    private ArrayList<PC> pcList;

    public PCProg(String report, ArrayList<PC> pcList){
        this.pcList = pcList;
        this.report = report;
    }

    /**
     * Create new object PC and add to Set<PC>
     * @throws InputMismatchException
     */
    public void createObject() throws InputMismatchException{
        try {
        Scanner scanner = new Scanner(System.in);
        PC pc = new PC();
        Set components = new Set();

        System.out.println("Input Model (max length = 25 characters)");
        String model = scanner.nextLine();
        while (!pc.validateModel(model)) {
            System.out.println("Model name has to be not null and shorter than or equal 25 characters. Please re-input: ");
            model = scanner.nextLine();
        }

        System.out.println("Input Produced Year (after 1970)");
        int year = scanner.nextInt();
        scanner.nextLine();
        while (!pc.validateYear(year)) {
            System.out.println("Produced year have to be after 1970. Please re-input: ");
            year = scanner.nextInt();
            scanner.nextLine();
        }


        System.out.println("Input Manufacturer (max length = 50 characters)");
        String manufacturer = scanner.nextLine();
        while (!pc.validateManufacturer(manufacturer)) {
            System.out.println("Manufacturer name have to be not null and shorter than or equal 50 characters. Please re-input: ");
            manufacturer = scanner.nextLine();
        }

        System.out.println("How many components in this PC?");
        int numberOfComponent = scanner.nextInt();
        scanner.nextLine();

        componentLoop : while (numberOfComponent > 5) {
            System.out.println("There will be many components to input. Are you sure? (y/n)");
            switch (scanner.nextLine()) {
                case "y" :
                    System.out.println("Ok. Move on.");
                    continue;
                case "Y" :
                    System.out.println("Ok. Move on.");
                    break componentLoop;
                case "n" :
                    System.out.println("Input number of component: ");
                    numberOfComponent = scanner.nextInt();
                    scanner.nextLine();
                    break;
                case "N":
                    System.out.println("Input number of component: ");
                    numberOfComponent = scanner.nextInt();
                    scanner.nextLine();
                    break;
                default:
                    System.out.println("Please input y/n !");
                    continue;
            }
        }

        for (int i = 0; i < numberOfComponent; i++) {
            System.out.println("Input component " + (i+1) + ": " );
            components.add(scanner.nextLine());
        }

        this.pcList.add(new PC(model, year, manufacturer, components));

        System.out.println("Created object successfully!");
        } catch(InputMismatchException e) {
            System.err.println("Produced year have to be an integer.");
        }
    }

    /**
     *
     */
    public void displayReport() {
        String reportHeader =
                "------------------------------------------------------------------------------------------\n" +
                "                                   PC-PROGRAM REPORT                                      \n" +
                "------------------------------------------------------------------------------------------\n";
        String reportFooter =
                "------------------------------------------------------------------------------------------\n";
        if (pcList.isEmpty()){
            this.report =
                    reportHeader +
                    String.format("%70s", "No PC data available. Please input new PC record!\n") +
                    reportFooter;
        } else {
            String content = "";
            for (PC pc: this.pcList) {
                  content = content +
                        String.format("%5d %20s %5s %10s %40s \n", pc.getId(), pc.getModel(), pc.getYear(), pc.getManufacturer(), pc.getComponents());
            }
            this.report = reportHeader + content + reportFooter;
        }
        System.out.print(this.report);
    }

    /**
     *  @effects
     *      save the report text to file
     */
    public void saveReport() throws IOException {
        try {
            FileWriter fileWriter = new FileWriter("PC_report.txt");
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.println(this.report);
            printWriter.close();
            System.out.println("Saved report to file \"PC_report.txt\" successfully.");
        } catch(IOException e) {
            throw new IOException("Error occur while saving report to file \"PC_report.txt\". " + e.getMessage());
        }
    }
}
