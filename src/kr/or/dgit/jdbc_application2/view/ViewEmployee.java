package kr.or.dgit.jdbc_application2.view;

import javax.swing.JPanel;

import kr.or.dgit.jdbc_application2.content.EmployeeContent;
import kr.or.dgit.jdbc_application2.list.AbstractList;
import kr.or.dgit.jdbc_application2.list.ListEmployee;
import kr.or.dgit.jdbc_application2.service.EmployeeService;

@SuppressWarnings("serial")
public class ViewEmployee extends AbstractView {
	private EmployeeService es;
	
	public ViewEmployee(String title) {
		super(title);		
	}

	@Override
	protected AbstractList createList() {
		ListEmployee pList = new ListEmployee(es);
		pList.loadData();
		return pList;
	}

	@Override
	protected JPanel createContent() {
		EmployeeContent pContent = new EmployeeContent(es);
		return pContent;
	}

	@Override
	protected void createService() {
		es = new EmployeeService();
	}

}
