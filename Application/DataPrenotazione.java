package Application;
public class DataPrenotazione 
{
	public DataPrenotazione(int g, int m, int a)
	{
		this.giorno = g ;
		this.mese = m ;
		this.anno = a ;
	}

	public String toString()
	{
		return "[Giorno: " + this.giorno + "][Mese: " + this.mese + "][Anno: " + this.anno + "]" ;
	}

	public String dataFormat()
	{
		return this.giorno + "/" + this.mese + "/" + this.anno ;
	}

	public boolean before(DataPrenotazione other)
	{
		if (this.anno > other.anno)
			return false ;
		if (this.mese > other.mese)
			return false ;
		if (this.giorno > other.giorno)
			return false ;
		
		return true ;
	}

	private int giorno, mese, anno ;
}
