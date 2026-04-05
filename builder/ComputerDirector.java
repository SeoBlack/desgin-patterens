public class ComputerDirector {
    public ComputerDirector(){
    }
    public void constructComputer(ComputerBuilder computerBuilder) {
        computerBuilder.buildCpu()
                .buildHardDrive()
                .buildGpu()
                .buildRam()
                .buildOperatingSystem()
                .buildComponentGrade()
                .buildAccessories();
    }
}
