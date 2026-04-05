public class GamingComputerBuilder implements ComputerBuilder {
    private final Computer computer;
    private final ComponentGrade grade;

    public GamingComputerBuilder() {
        this(ComponentGrade.ENTHUSIAST);
    }

    public GamingComputerBuilder(ComponentGrade grade) {
        this.computer = new Computer();
        this.grade = grade;
    }

    public GamingComputerBuilder buildCpu() {
        switch (grade) {
            case STANDARD -> computer.setCpu("Intel Core i5-14400F");
            case PREMIUM -> computer.setCpu("Intel Core i7-14700K");
            case ENTHUSIAST -> computer.setCpu("Intel Core i9-14900K");
        }
        return this;
    }

    public GamingComputerBuilder buildHardDrive() {
        switch (grade) {
            case STANDARD -> computer.setHardDrive("512 GB NVMe SSD");
            case PREMIUM -> computer.setHardDrive("2 TB NVMe SSD");
            case ENTHUSIAST -> computer.setHardDrive("Kingston Technology 4T FURY RENEGADE G5 M.2 2280 NVMe SSD");
        }
        return this;
    }

    public GamingComputerBuilder buildOperatingSystem() {
        computer.setOperatingSystem("Windows 11 Home");
        return this;
    }

    public GamingComputerBuilder buildRam() {
        switch (grade) {
            case STANDARD -> computer.setRam(16);
            case PREMIUM -> computer.setRam(32);
            case ENTHUSIAST -> computer.setRam(128);
        }
        return this;
    }

    public GamingComputerBuilder buildGpu() {
        switch (grade) {
            case STANDARD -> computer.setGpu("GeForce RTX 4060 8GB");
            case PREMIUM -> computer.setGpu("GeForce RTX 4070 Ti SUPER 16GB");
            case ENTHUSIAST -> computer.setGpu("GeForce RTX 5080 AERO OC 16GB");
        }
        return this;
    }

    public GamingComputerBuilder buildComponentGrade() {
        computer.setComponentGrade(grade.name());
        return this;
    }

    public GamingComputerBuilder buildAccessories() {
        computer.addAccessory("RGB mechanical keyboard");
        computer.addAccessory("Gaming mouse");
        switch (grade) {
            case STANDARD -> computer.addAccessory("Stereo headset");
            case PREMIUM -> computer.addAccessory("7.1 surround headset");
            case ENTHUSIAST -> computer.addAccessory("Elite wireless headset + mousepad");
        }
        return this;
    }

    public Computer getComputer() {
        return this.computer;
    }
}
