package application;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class GenericPanel extends JPanel {
	
	public GenericPanel(String text){
		this.setName(text);
		this.setBorder(new LineBorder(Color.DARK_GRAY));
		JLabel label = new JLabel(text);
		this.add(label, BorderLayout.CENTER);
		this.setBackground(Color.ORANGE);
	}

}
