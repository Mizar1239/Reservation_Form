package Application;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class DataLeggibile extends GregorianCalendar
{
	public DataLeggibile(int giorno, int month, int year)
	{
		super(giorno, month, year) ;
	}

	public boolean before(DataLeggibile date)
	{
		return super.before(date) ;
	}

	@Override
	public String toString()
	{
		String data = Integer.toString(Calendar.DAY_OF_MONTH) + "/";
		data += Integer.toString(Calendar.MONTH) + "/" ;
		data += Integer.toString(Calendar.YEAR) ;

		return data ;
	}
}
