package kr.or.dgit.jdbc_application2.view;

import java.awt.event.ActionEvent;

import kr.or.dgit.jdbc_application2.content.AbstractContent;
import kr.or.dgit.jdbc_application2.content.DepartmentContent;
import kr.or.dgit.jdbc_application2.dto.Department;
import kr.or.dgit.jdbc_application2.list.AbstractList;
import kr.or.dgit.jdbc_application2.list.ListDepartment;
import kr.or.dgit.jdbc_application2.service.DepartmentService;

@SuppressWarnings("serial")
public class ViewDepartment extends AbstractView {
	private DepartmentService service;
	private DepartmentContent pContent;
	
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
	protected AbstractContent<Department> createContent() {
		pContent = new DepartmentContent();
		return pContent;
	}

	@Override
	protected void createService() {
		service = new DepartmentService();		
	}



}
