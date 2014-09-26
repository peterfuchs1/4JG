package calc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextField;

public class Eingabe implements ActionListener {
	public static int MAX_ZIFFERN=22;
	private JTextField erg;

	public Eingabe(JTextField erg){
		this.erg=erg;
	}
	@Override
	public void actionPerformed(ActionEvent ae) {
		JButton button=(JButton) ae.getSource();
		String txt=erg.getText();
		if(txt.length()<MAX_ZIFFERN){
			StringBuilder sb=new StringBuilder();
			if(!txt.equals("0"))
				sb.append(txt);
			sb.append(button.getText());
			txt=sb.toString();

			erg.setText(txt);
		}
			

	}

}
