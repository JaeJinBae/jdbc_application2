package kr.or.dgit.jdbc_application2.view;

import javax.swing.JPanel;

import kr.or.dgit.jdbc_application2.content.DepartmentContent;
import kr.or.dgit.jdbc_application2.list.AbstractList;
import kr.or.dgit.jdbc_application2.list.ListDepartment;
import kr.or.dgit.jdbc_application2.service.DepartmentService;

@SuppressWarnings("serial")
public class ViewDepartment extends AbstractView {
	private DepartmentService service;
	
	public ViewDepartment(String title) {
		super(title);		
	}

	@Override
	protected AbstractList createList() {
		ListDepartment pList = new ListDepartment(service);
		pList.loadData();
		return pList;
	}

	@Override
	protected JPanel createContent() {
		DepartmentContent pContent = new DepartmentContent();
		return pContent;
	}

	@Override
	protected void createService() {
		service = new DepartmentService();		
	}

}
