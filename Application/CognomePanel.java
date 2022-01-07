package Application;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class CognomePanel extends JPanel
{
	public CognomePanel()
	{
		label = new JLabel("Inserisci cognome: ") ;
		label.setEnabled(true);

		cognome = new JTextArea("   ") ;
		cognome.setEditable(true);
		
		add(label) ;
		add(cognome) ;
		setBorder(new TitledBorder(new EtchedBorder(), "Cognome Prenotazione")) ;
	}

	public String getNomePrenotazione()
	{
		String tmp = cognome.getText();

		return tmp ;
	}

	public void rendiEditabile()
	{
		cognome.setEditable(true); 
	}

	private JLabel label ;
	private JTextArea cognome ;
}
