package Application;
import javax.swing.* ;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import java.awt.* ;
import java.awt.event.* ;

public class FormFrame extends JFrame
{
	public FormFrame()
	{
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
		setLayout(new GridLayout(5, 1));

		namePanel = new CognomePanel() ;

		checkInPanel = new CheckOutPanel() ;
		checkInPanel.setBorder(new TitledBorder(new EtchedBorder(), "Check IN")); 

		checkOutPanel = new CheckOutPanel() ;
		checkOutPanel.setBorder(new TitledBorder(new EtchedBorder(), "Check OUT")); 

		roomsPanel = new CheckStanze() ;
		roomsPanel.setBorder(new TitledBorder(new EtchedBorder(), "Tipologia Camera"));

		convalidaBottone = new BottoneConvalida() ;
		convalidaBottone.setSize(100, 100);
		listener = new PrenotazioneListener() ;
		convalidaBottone.addActionListener(listener);
			
		add(namePanel) ;
		add(checkInPanel) ;
		add(checkOutPanel) ;
		add(roomsPanel) ;
		add(convalidaBottone) ;
	}

	class PrenotazioneListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			getInfoPrenotazione() ;
		}
	}

	public void getInfoPrenotazione()
	{
		arrivo = componiDataArrivo() ;
		partenza = componiDataPartenza() ;
		String nomePrenotazione = namePanel.getNomePrenotazione() ;

		if (nomePrenotazione != null)
		{
			if (arrivo.before(partenza)) 
			{
				String tipoCamera = roomsPanel.tipologia() ;

				if (tipoCamera == null)
					JOptionPane.showInternalMessageDialog(null, "Errore nella prenotazione");
				else
				{
					System.out.println("\nPrenotazione convalidata\nCognome: " + nomePrenotazione + "\nArrivo: " + arrivo.dataFormat() + "\nPartenza: " + partenza.dataFormat() + "\nTipologia Camera: " + tipoCamera + "\n") ;
				}
			}
			else
			{
				JOptionPane.showInternalMessageDialog(null, "Errore nella prenotazione");
			}
		}
		else
		{
			JOptionPane.showInternalMessageDialog(null, "Errore nella prenotazione");
			namePanel.rendiEditabile() ;
		}
	}

	public DataPrenotazione componiDataArrivo()
	{
		JComboBox<Integer> giorno = (JComboBox<Integer>) checkInPanel.getComponent(0) ;
		JComboBox<String> mese = (JComboBox<String>) checkInPanel.getComponent(1) ;
		JComboBox<Integer> anno = (JComboBox<Integer>) checkInPanel.getComponent(2) ;
		int i=0 ;

		for (i=0 ; !(mese.getSelectedItem().equals(NOMI_MESI[i])) ; i++)
			;

		return new DataPrenotazione((int) giorno.getSelectedItem(), i+1, (int) anno.getSelectedItem()) ;
	}

	public DataPrenotazione componiDataPartenza()
	{
		JComboBox<Integer> giorno = (JComboBox<Integer>) checkOutPanel.getComponent(0) ;
		JComboBox<String> mese = (JComboBox<String>) checkOutPanel.getComponent(1) ;
		JComboBox<Integer> anno = (JComboBox<Integer>) checkOutPanel.getComponent(2) ;
		int i=0 ;

		for (i=0 ; !(mese.getSelectedItem().equals(NOMI_MESI[i])) ; i++)
			;

		return new DataPrenotazione((int) giorno.getSelectedItem(), i+1, (int) anno.getSelectedItem()) ;
	}

	private PrenotazioneListener listener ;
	private DataPrenotazione arrivo, partenza ;
	private CognomePanel namePanel ;
	private JPanel checkInPanel ;
	private JPanel checkOutPanel ;
	private JButton convalidaBottone ;
	private CheckStanze roomsPanel ;

	private static final String[] NOMI_MESI = new String[]{"Gennaio", "Febbraio", "Marzo", "Aprile", "Maggio", "Giugno", "Luglio", "Agosto", "Settembre", "Ottobre", "Novembre", "Dicembre"} ;
	private static final int FRAME_WIDTH = 600 ;
	private static final int FRAME_HEIGHT = 400 ;
}
