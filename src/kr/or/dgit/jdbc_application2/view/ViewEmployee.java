package kr.or.dgit.jdbc_application2.view;

import javax.swing.JPanel;

import kr.or.dgit.jdbc_application2.content.EmployeeContent;
import kr.or.dgit.jdbc_application2.list.AbstractList;
import kr.or.dgit.jdbc_application2.list.ListEmployee;

@SuppressWarnings("serial")
public class ViewEmployee extends AbstractView {

	public ViewEmployee(String title) {
		super(title);		
	}

	@Override
	protected AbstractList createList() {
		ListEmployee pList = new ListEmployee();
		return pList;
	}

	@Override
	protected JPanel createContent() {
		EmployeeContent pContent = new EmployeeContent();
		return pContent;
	}

}
