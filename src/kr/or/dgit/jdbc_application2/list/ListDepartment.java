package kr.or.dgit.jdbc_application2.list;

import javax.swing.SwingConstants;

import kr.or.dgit.jdbc_application2.dto.Department;

@SuppressWarnings("serial")
public class ListDepartment extends AbstractList {

	@Override
	protected void setAlignWidth() {
		setCellWidth(100, 150, 50);
		setAlign(SwingConstants.CENTER, 0,1, 2);//
	}

	@Override
	protected Object[][] getData() {
		Object[][] datas = {
				{1, "개발", 10},
				{2, "인사", 20}, 
				{3, "마케팅", 30}
		};
		return datas;
	}
	
	@Override
	protected String[] getColumnNames() {
		return new String[]{"부서번호", "부서명", "위치"};
	}

	@Override
	public Object getSelectedItem() {
		int seletedIndex = table.getSelectedRow();
		int deptNo = (int) table.getValueAt(seletedIndex, 0);
		String deptName = (String) table.getValueAt(seletedIndex, 1);
		int floor = (int) table.getValueAt(seletedIndex, 2);
		return new Department(deptNo, deptName, floor);
	}

}