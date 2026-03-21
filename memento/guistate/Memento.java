package guistate;

import java.util.Arrays;
import java.util.Date;
import java.util.UUID;

public class Memento implements IMemento {
    private final String id;
    private int[] options;
    private boolean isSelected;
    private String timeStamp;

    public Memento(int[] options, boolean isSelected) {
        this.id = UUID.randomUUID().toString();
        this.options = options.clone(); // Copy options array
        this.isSelected = isSelected;
        this.timeStamp = new Date().toString();
        System.out.println("Memento created");
    }

    @Override
    public String getId() {
        return id;
    }

    public int[] getOptions() {
        return options;
    }

    public boolean isSelected() {
        return isSelected;
    }
    public String printMemento() {
        return "Options: " + Arrays.toString(options) + " isChecked "+ isSelected + "Time: " + getTimeStamp() ;
    }
    public String getTimeStamp() {
        return timeStamp;
    }
    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }
}