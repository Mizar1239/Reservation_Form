package Application;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JPanel;

public class CheckStanze extends JPanel
{
	public CheckStanze()
	{
		singola = new JCheckBox("Singola") ;
		doppia = new JCheckBox("Doppia") ;
		multipla = new JCheckBox("Multipla") ;

		blocco = new ButtonGroup() ;
		blocco.add(singola);
		blocco.add(doppia);
		blocco.add(multipla);

		add(singola) ;
		add(doppia) ;
		add(multipla) ;
	}

	public String tipologia()
	{
		if (singola.isSelected())
			return "Singola" ;
		else if (doppia.isSelected())
			return "Doppia" ;
		else if (multipla.isSelected())
			return "Multipla" ;

		return null ;
	}

	private JCheckBox singola, doppia, multipla ;
	private ButtonGroup blocco ;
}
