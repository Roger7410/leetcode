import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by JOKER on 8/1/16.
 */
public class DateTest {
    public static int dayForWeek(String pTime) throws Throwable {

        SimpleDateFormat format = new SimpleDateFormat("dd/mm/yyyy");

        Date tmpDate = format.parse(pTime);

        Calendar cal = new GregorianCalendar();

        cal.set(tmpDate.getYear(), tmpDate.getMonth(), tmpDate.getDay());

        return cal.get(Calendar.DAY_OF_WEEK);
    }

    public static void main(String[] args)throws Throwable {
        System.out.println(dayForWeek("01/08/2016"));
    }
}
