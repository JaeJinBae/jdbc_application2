package kr.or.dgit.jdbc_application2;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

import kr.or.dgit.jdbc_application2.list.AbstractList;
import kr.or.dgit.jdbc_application2.list.ListDepartment;
import kr.or.dgit.jdbc_application2.list.ListEmployee;
import kr.or.dgit.jdbc_application2.list.ListTitle;

public class TestListMain {

	public static void main(String[] args) {
		JFrame jf = new JFrame();
		jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		jf.setBounds(10, 10, 300, 450);
		
		AbstractList lt = new ListEmployee();
		jf.add(lt);
		
		JButton btn = new JButton("test");
		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Object obj = lt.getSelectedItem();
				JOptionPane.showMessageDialog(null, obj);
			}
		});
		jf.add(btn, BorderLayout.SOUTH);
		jf.setVisible(true);
	}

}
