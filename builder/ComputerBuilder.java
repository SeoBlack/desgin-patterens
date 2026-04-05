interface ComputerBuilder {
    ComputerBuilder buildCpu();
    ComputerBuilder buildGpu();
    ComputerBuilder buildRam();
    ComputerBuilder buildHardDrive();
    ComputerBuilder buildOperatingSystem();
    ComputerBuilder buildComponentGrade();
    ComputerBuilder buildAccessories();
    Computer getComputer();
}