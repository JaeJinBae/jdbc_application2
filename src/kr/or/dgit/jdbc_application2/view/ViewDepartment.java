package kr.or.dgit.jdbc_application2.view;

import javax.swing.JPanel;

import kr.or.dgit.jdbc_application2.content.DepartmentContent;
import kr.or.dgit.jdbc_application2.list.AbstractList;
import kr.or.dgit.jdbc_application2.list.ListDepartment;

@SuppressWarnings("serial")
public class ViewDepartment extends AbstractView {

	public ViewDepartment(String title) {
		super(title);		
	}

	@Override
	protected AbstractList createList() {
		ListDepartment pList = new ListDepartment();
		return pList;
	}

	@Override
	protected JPanel createContent() {
		DepartmentContent pContent = new DepartmentContent();
		return pContent;
	}

}
