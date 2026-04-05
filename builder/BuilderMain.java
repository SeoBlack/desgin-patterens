import java.util.Scanner;

public class BuilderMain {

    public static void main(String[] args) {
        ComputerDirector director = new ComputerDirector();

        System.out.println("=== Preset builds (Director + concrete builders) ===\n");

        ComputerBuilder gamingBuilder = new GamingComputerBuilder();
        director.constructComputer(gamingBuilder);
        Computer gamingPC = gamingBuilder.getComputer();
        System.out.println("Gaming PC (default enthusiast grade):");
        System.out.println(gamingPC);

        ComputerBuilder officeBuilder = new OfficeComputerBuilder();
        director.constructComputer(officeBuilder);
        Computer officePC = officeBuilder.getComputer();
        System.out.println("\nOffice PC (default standard grade):");
        System.out.println(officePC);

        ComputerBuilder premiumOffice = new OfficeComputerBuilder(ComponentGrade.PREMIUM);
        director.constructComputer(premiumOffice);
        System.out.println("\nOffice PC (premium grade):");
        System.out.println(premiumOffice.getComputer());

        System.out.println("\n=== Interactive configurator ===\n");
        try (Scanner scanner = new Scanner(System.in)) {
            runInteractiveConfigurator(director, scanner);
        }
    }

    private static void runInteractiveConfigurator(ComputerDirector director, Scanner scanner) {
        System.out.println("Choose base profile:");
        System.out.println("  1) Gaming");
        System.out.println("  2) Office");
        int profile = readIntInRange(scanner, 1, 2);

        System.out.println("\nChoose component grade:");
        System.out.println("  1) STANDARD");
        System.out.println("  2) PREMIUM");
        System.out.println("  3) ENTHUSIAST");
        int gradeChoice = readIntInRange(scanner, 1, 3);
        ComponentGrade grade = ComponentGrade.values()[gradeChoice - 1];

        ComputerBuilder builder = profile == 1
                ? new GamingComputerBuilder(grade)
                : new OfficeComputerBuilder(grade);

        director.constructComputer(builder);
        Computer built = builder.getComputer();

        System.out.println("\nOptional extras (enter name, empty line to finish):");
        while (true) {
            System.out.print("Accessory: ");
            String line = scanner.nextLine();
            if (line == null || line.isBlank()) {
                break;
            }
            built.addAccessory(line.trim());
        }

        System.out.println("\n--- Your configuration ---");
        System.out.println(built);
    }

    private static int readIntInRange(Scanner scanner, int min, int max) {
        while (true) {
            System.out.print("Enter choice (" + min + "-" + max + "): ");
            String raw = scanner.nextLine().trim();
            try {
                int v = Integer.parseInt(raw);
                if (v >= min && v <= max) {
                    return v;
                }
            } catch (NumberFormatException ignored) {
                // loop
            }
            System.out.println("Invalid choice, try again.");
        }
    }
}
