public class OfficeComputerBuilder implements ComputerBuilder {
    private final Computer computer;
    private final ComponentGrade grade;

    public OfficeComputerBuilder() {
        this(ComponentGrade.STANDARD);
    }

    public OfficeComputerBuilder(ComponentGrade grade) {
        this.computer = new Computer();
        this.grade = grade;
    }

    public OfficeComputerBuilder buildCpu() {
        switch (grade) {
            case STANDARD -> computer.setCpu("AMD Ryzen 5 7520U");
            case PREMIUM -> computer.setCpu("AMD Ryzen 7 7730U");
            case ENTHUSIAST -> computer.setCpu("AMD Ryzen 9 PRO 7940HS");
        }
        return this;
    }

    public OfficeComputerBuilder buildHardDrive() {
        switch (grade) {
            case STANDARD -> computer.setHardDrive("512 GB PCIe NVMe M.2 SSD");
            case PREMIUM -> computer.setHardDrive("1 TB PCIe NVMe M.2 SSD");
            case ENTHUSIAST -> computer.setHardDrive("2 TB PCIe NVMe M.2 SSD");
        }
        return this;
    }

    public OfficeComputerBuilder buildOperatingSystem() {
        computer.setOperatingSystem("Windows 11 Home");
        return this;
    }

    public OfficeComputerBuilder buildRam() {
        switch (grade) {
            case STANDARD -> computer.setRam(16);
            case PREMIUM -> computer.setRam(32);
            case ENTHUSIAST -> computer.setRam(64);
        }
        return this;
    }

    public OfficeComputerBuilder buildGpu() {
        switch (grade) {
            case STANDARD, PREMIUM -> computer.setGpu("Integrated AMD Radeon");
            case ENTHUSIAST -> computer.setGpu("Integrated AMD Radeon (high-wattage iGPU)");
        }
        return this;
    }

    public OfficeComputerBuilder buildComponentGrade() {
        computer.setComponentGrade(grade.name());
        return this;
    }

    public OfficeComputerBuilder buildAccessories() {
        computer.addAccessory("USB-C hub");
        computer.addAccessory("Webcam 1080p");
        switch (grade) {
            case STANDARD -> computer.addAccessory("Basic ergonomic mouse");
            case PREMIUM -> computer.addAccessory("Ergonomic keyboard + vertical mouse");
            case ENTHUSIAST -> computer.addAccessory("Docking station + dual monitors bundle");
        }
        return this;
    }

    public Computer getComputer() {
        return computer;
    }
}
