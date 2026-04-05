import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Computer {
    String cpu;
    String gpu;
    String hardDrive;
    String operatingSystem;
    int ram;
    String componentGrade;
    private final List<String> accessories = new ArrayList<>();
    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public void setHardDrive(String hardDrive) {
        this.hardDrive = hardDrive;
    }

    public void setGpu(String gpu) {
        this.gpu = gpu;
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    public void setComponentGrade(String componentGrade) {
        this.componentGrade = componentGrade;
    }

    public void addAccessory(String accessory) {
        if (accessory != null && !accessory.isBlank()) {
            accessories.add(accessory);
        }
    }

    public List<String> getAccessories() {
        return Collections.unmodifiableList(accessories);
    }

    @Override
    public String toString() {
        return "Computer {" +
                "CPU='" + cpu + '\'' +
                ", RAM=" + ram + "GB" +
                ", Storage='" + hardDrive + '\'' +
                ", GPU='" + gpu + '\'' +
                ", OS='" + operatingSystem + '\'' +
                ", componentGrade='" + componentGrade + '\'' +
                ", accessories=" + accessories +
                '}';
    }
}
