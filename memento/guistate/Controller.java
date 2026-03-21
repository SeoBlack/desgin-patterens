package guistate;

import java.util.ArrayList;
import java.util.List;

public class Controller {
    private final Model model;
    private final Gui gui;
    public final List<IMemento> history;
    private final List<IMemento> redoList;

    public Controller(Gui gui) {
        this.model = new Model();
        this.gui = gui;
        this.history = new ArrayList<>();
        this.redoList = new ArrayList<>();
        history.add(model.createMemento()); // initial snapshot
    }

    public List<String> getHistoryIds() {
        List<String> ids = new ArrayList<>();
        for (IMemento m : history) {
            ids.add(m.getId());
        }
        return ids;
    }

    public List<String> getHistoryDisplayLabels() {
        List<String> labels = new ArrayList<>();
        for (IMemento m : history) {
            labels.add(m.getTimeStamp());
        }
        return labels;
    }

    public void setOption(int optionNumber, int choice) {
        redoList.clear();
        model.setOption(optionNumber, choice);
        history.add(model.createMemento());
        gui.updateGui();
    }

    public int getOption(int optionNumber) {
        return model.getOption(optionNumber);
    }

    public void setIsSelected(boolean isSelected) {
        redoList.clear();
        model.setIsSelected(isSelected);
        history.add(model.createMemento());
        gui.updateGui();
    }

    public boolean getIsSelected() {
        return model.getIsSelected();
    }

    public void undo() {
        if (history.size() <= 1) {
            return;
        }
        IMemento current = history.remove(history.size() - 1);
        redoList.add(current);
        model.restoreState(history.get(history.size() - 1));
        gui.updateGui();
    }

    public void redo() {
        if (redoList.isEmpty()) {
            return;
        }
        IMemento next = redoList.remove(redoList.size() - 1);
        history.add(next);
        model.restoreState(next);
        gui.updateGui();
    }

    public void goToHistoryItem(String mementoId) {
        int index = -1;
        for (int i = 0; i < history.size(); i++) {
            if (history.get(i).getId().equals(mementoId)) {
                index = i;
                break;
            }
        }
        if (index < 0) {
            return;
        }
        // Move the trimmed tail of history onto redo.
        List<IMemento> tailFromHistory = new ArrayList<>();
        for (int i = history.size() - 1; i > index; i--) {
            tailFromHistory.add(history.get(i));
        }
        List<IMemento> merged = new ArrayList<>(redoList);
        merged.addAll(tailFromHistory);
        redoList.clear();
        redoList.addAll(merged);
        while (history.size() > index + 1) {
            history.remove(history.size() - 1);
        }
        model.restoreState(history.get(index));
        gui.updateGui();
    }
}
