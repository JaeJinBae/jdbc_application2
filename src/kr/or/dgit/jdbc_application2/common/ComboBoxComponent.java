package kr.or.dgit.jdbc_application2.common;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.GridLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;

public class ComboBoxComponent extends JPanel {
	private JComboBox comboBox;
	
	public ComboBoxComponent(String title) {
		setLayout(new GridLayout(1, 0, 10, 0));
		
		JLabel lblCLabel = new JLabel(title);
		lblCLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lblCLabel);
		
		comboBox = new JComboBox();
		add(comboBox);

	}
	

}
