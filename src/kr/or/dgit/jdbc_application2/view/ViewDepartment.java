package kr.or.dgit.jdbc_application2.view;

import javax.swing.JOptionPane;

import com.sun.scenario.effect.AbstractShadow.ShadowMode;

import kr.or.dgit.jdbc_application2.content.AbstractContent;
import kr.or.dgit.jdbc_application2.content.DepartmentContent;
import kr.or.dgit.jdbc_application2.dto.Department;
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
		pList = new ListDepartment(service);
		pList.loadData();
		return pList;
	}

	@Override
	protected AbstractContent<Department> createContent() {
		pContent = new DepartmentContent();
		return (AbstractContent<Department>) pContent;
	}

	@Override
	protected void createService() {
		service = new DepartmentService();		
	}

	@Override
	protected void insertContent(Object content) {
		service.insertDepartment((Department) content);
		pContent.clear();
		
	}

	@Override
	protected void deleteContent(Object content) {
		service.deleteDepartment((Department) content);
		
	}

	@Override
	protected void updateContent(Object item) {
		service.updateDepartment((Department) item);
		pContent.clear();
	}

	@Override
	protected Object searchContent(int num) {
		return service.selectDepartmentByNo(new Department(num));
	}


}
