package kr.or.dgit.jdbc_application2.content;

import javax.swing.JPanel;
import java.awt.GridLayout;
import kr.or.dgit.jdbc_application2.common.TextFieldComponent;
import kr.or.dgit.jdbc_application2.dto.Department;

public class DepartmentContent extends JPanel {

	private TextFieldComponent pDeptNo;
	private TextFieldComponent pDeptName;
	private TextFieldComponent pFloor;

	public DepartmentContent() {
		setLayout(new GridLayout(0, 1, 0, 10));

		pDeptNo = new TextFieldComponent("부서번호");
		add(pDeptNo);

		pDeptName = new TextFieldComponent("부서명");
		add(pDeptName);

		pFloor = new TextFieldComponent("위치");
		add(pFloor);
	}

	public Department getContent() {
		int deptNo = Integer.parseInt(pDeptNo.getTextValue());
		String deptName = pDeptName.getTextValue();
		int floor = Integer.parseInt(pFloor.getTextValue());
		return new Department(deptNo, deptName, floor);
	}

	public void setContent(Department department) {
		pDeptNo.setTextValue(department.getDeptNo() + "");
		pDeptName.setTextValue(department.getDeptName());
		pFloor.setTextValue(department.getFloor() + "");
	}

	public void isEmptyCheck() throws Exception {
		pDeptNo.isEmptyCheck();
		pDeptName.isEmptyCheck();
		pFloor.isEmptyCheck();
	}
}
