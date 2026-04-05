import java.util.Calendar;

public class AdapterMain {
    public static void main(String[] args) {
        CalendarToNewDateAdapter adapter = new CalendarToNewDateAdapter(Calendar.getInstance());
        //setting the dAte
        System.out.println("Date Before: " + adapter.toString());
        adapter.setDay(5);
        adapter.setMonth(4);
        adapter.setYear(2026);
        System.out.println("Date After: " + adapter.toString());
        //advancing date by sIX DAys
        adapter.advanceDay(6);
        System.out.println("Date After advancing 6 days : " + adapter.toString());

    }

}
