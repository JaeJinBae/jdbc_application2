package kr.or.dgit.jdbc_application2.view;

import kr.or.dgit.jdbc_application2.content.AbstractContent;
import kr.or.dgit.jdbc_application2.content.EmployeeContent;
import kr.or.dgit.jdbc_application2.dto.Employee;
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
		pList = new ListEmployee(es);
		pList.loadData();
		return pList;
	}

	@Override
	protected AbstractContent<Employee> createContent() {
		pContent = new EmployeeContent(es);
		return (AbstractContent<Employee>) pContent;
	}

	@Override
	protected void createService() {
		es = new EmployeeService();
	}

	@Override
	protected void insertContent(Object content) {
		es.insertEmployee((Employee) content);
		pContent.clear();
		
	}

	@Override
	protected void deleteContent(Object content) {
		es.deleteEmployee((Employee) content);
	}

	@Override
	protected void updateContent(Object item) {
		es.updateEmployee((Employee) item);
		pContent.clear();
		
	}

	@Override
	protected Object searchContent(int num) {
		return es.selectEmployeeByNo(new Employee(num));
	}

}
