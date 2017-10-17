package kr.or.dgit.jdbc_application2;

import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import kr.or.dgit.jdbc_application2.view.AbstractView;
import kr.or.dgit.jdbc_application2.view.ViewDepartment;
import kr.or.dgit.jdbc_application2.view.ViewEmployee;
import kr.or.dgit.jdbc_application2.view.ViewTitle;

public class ErpApplication extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btnTitle;
	private JButton btnDepartment;
	private JButton btnEmployee;

	private AbstractView titleFr;
	private AbstractView deptFr;
	private AbstractView empFr;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ErpApplication frame = new ErpApplication();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ErpApplication() {
		setTitle("회사 ERP");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 135);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(1, 0, 0, 0));

		btnEmployee = new JButton("사원관리");
		btnEmployee.addActionListener(this);
		contentPane.add(btnEmployee);

		btnDepartment = new JButton("부서관리");
		btnDepartment.addActionListener(this);
		contentPane.add(btnDepartment);

		btnTitle = new JButton("직책관리");
		btnTitle.addActionListener(this);
		contentPane.add(btnTitle);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnEmployee) {
			do_btnEmployee_actionPerformed(e);
		}
		if (e.getSource() == btnDepartment) {
			do_btnDepartment_actionPerformed(e);
		}
		if (e.getSource() == btnTitle) {
			do_btnTitle_actionPerformed(e);
		}
	}

	protected void do_btnTitle_actionPerformed(ActionEvent e) {
		if(titleFr==null){
			titleFr = new ViewTitle("직책관리");
		}
		titleFr.setVisible(true);
	}

	protected void do_btnDepartment_actionPerformed(ActionEvent e) {
		if(deptFr==null){
			deptFr = new ViewDepartment("부서관리");
		}
		deptFr.setVisible(true);
	}

	protected void do_btnEmployee_actionPerformed(ActionEvent e) {
		if(empFr==null){
			empFr = new ViewEmployee("사원관리");
		}
		empFr.setVisible(true);
	}
}
