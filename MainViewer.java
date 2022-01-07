import javax.swing.JFrame;

import Application.FormFrame;

public class MainViewer
{
	public static void main(String[] args)
	{
		JFrame frame = new FormFrame() ;
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true); 
	}
}