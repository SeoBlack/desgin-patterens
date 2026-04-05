import java.util.Calendar;

public class CalendarToNewDateAdapter implements NewDateInterface {

    Calendar calendar;

    public CalendarToNewDateAdapter(Calendar calendar) {
        this.calendar = calendar;
    }
    @Override
    public int getMonth() {
        return this.calendar.get(Calendar.MONTH);
    }
    @Override
    public int getYear() {
        return this.calendar.get(Calendar.YEAR);
    }
    @Override
    public int getDay() {
        return this.calendar.get(Calendar.DAY_OF_MONTH);
    }
    @Override
    public void advanceDay(int days) {
        this.calendar.add(Calendar.DAY_OF_MONTH, days);

    }

    @Override
    public void setDay(int day) {
        this.calendar.set(Calendar.DAY_OF_MONTH, day);

    }
    @Override
    public void setMonth(int month) {
        this.calendar.set(Calendar.MONTH, month);
    }
    @Override
    public void setYear(int year) {
        this.calendar.set(Calendar.YEAR, year);
    }
    @Override
    public String toString() {
        return this.getDay() + "/" + this.getMonth() + "/" + this.getYear();
    }

}
