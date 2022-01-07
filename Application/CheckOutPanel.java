package Application;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import java.awt.event.* ;

public class CheckOutPanel extends JPanel
{
	public CheckOutPanel()
	{
		giorno = new JComboBox<Integer>() ;
		for (int i=1 ; i<32 ; i++)
			giorno.addItem(i); 

		mese = new JComboBox<String>() ;
		mese.addActionListener(new MesiListener());
		for (int i=0 ; i<12 ; i++)
			mese.addItem(NOMI_MESI[i]); 
		
		anno = new JComboBox<Integer>() ;
		for (int i=2022 ; i<2026 ; i++)
			anno.addItem(i);

		add(giorno) ;
		add(mese) ;
		add(anno) ;
	}

	class MesiListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e) 
		{
			adeguaGiorni() ;
		}		
	}

	public void adeguaGiorni() 
	{
		String meseSelezionato = (String) mese.getSelectedItem() ;
		int i=0 ;

		giorno.removeItem(29) ;
		giorno.removeItem(30) ;
		giorno.removeItem(31) ;

		for (i=0 ; 	!(MESI_ORDINE[i].equals(meseSelezionato)) ; i++)
		 	;

		if (i != 0)
		{
			giorno.addItem(29) ;
			giorno.addItem(30) ;

			if (i < 8)
				giorno.addItem(31) ;
		}
	}
	
	private JComboBox<Integer> giorno, anno ;
	private JComboBox<String> mese ;

	private static final String[] NOMI_MESI = new String[]{"Gennaio", "Febbraio", "Marzo", "Aprile", "Maggio", "Giugno", "Luglio", "Agosto", "Settembre", "Ottobre", "Novembre", "Dicembre"} ;
	private static final String[] MESI_ORDINE = new String[]{"Febbraio", "Gennaio", "Marzo", "Maggio", "Luglio", "Agosto", "Ottobre", "Dicembre", "Aprile", "Giugno", "Settembre", "Novembre"} ;
}
