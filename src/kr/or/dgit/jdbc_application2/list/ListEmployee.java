package kr.or.dgit.jdbc_application2.list;

import javax.swing.SwingConstants;

import kr.or.dgit.jdbc_application2.dto.Department;
import kr.or.dgit.jdbc_application2.dto.Employee;
import kr.or.dgit.jdbc_application2.dto.Title;

@SuppressWarnings("serial")
public class ListEmployee extends AbstractList {

	@Override
	protected void setAlignWidth() {
		setCellWidth(100,100,100,150, 150, 100);
		setAlign(SwingConstants.CENTER, 0, 1, 2, 3, 5);//
		setAlign(SwingConstants.RIGHT, 4);		
	}

	@Override
	protected Object[][] getData() {
		Object[][] datas = {
				{1, "이성래", new Title(3, "차장"), new Employee("사장"), 5000000, new Department("기획")},
				
				{2, "이성래", "과장", "이사장", 5000000, "기획"}, 
				{3, "이성래", "과장", "이사장", 5000000, "기획"}
		};
		return datas;
	}
	
	@Override
	protected String[] getColumnNames() {
		return new String[]{"사원번호", "사원명", "직책", "관리자", "급여","부서"};
	}

	@Override
	public Object getSelectedItem() {
		int seletedIndex = table.getSelectedRow();
		int empNo=(int) table.getValueAt(seletedIndex, 0);
		String empName=(String) table.getValueAt(seletedIndex, 1);
		Title title= new Title((String) table.getValueAt(seletedIndex, 2));
		Employee manager=new Employee((String) table.getValueAt(seletedIndex, 3));
		int salary=(int) table.getValueAt(seletedIndex, 4);
		Department dno=new Department((String) table.getValueAt(seletedIndex, 5));
		return new Employee(empNo, empName, title, manager, salary, dno);
	}

}
