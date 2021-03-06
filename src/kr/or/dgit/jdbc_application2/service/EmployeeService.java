package kr.or.dgit.jdbc_application2.service;

import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;

import kr.or.dgit.jdbc_application2.dao.DepartmentDao;
import kr.or.dgit.jdbc_application2.dao.EmployeeDao;
import kr.or.dgit.jdbc_application2.dao.SqlDao;
import kr.or.dgit.jdbc_application2.dao.TitleDao;
import kr.or.dgit.jdbc_application2.dto.Department;
import kr.or.dgit.jdbc_application2.dto.Employee;
import kr.or.dgit.jdbc_application2.dto.Title;

public class EmployeeService {
	private SqlDao<Employee> empDao;
	private SqlDao<Department> deptDao;
	private SqlDao<Title> titleDao;

	
	public EmployeeService() {
		this.empDao = EmployeeDao.getInstance();
		this.deptDao = DepartmentDao.getInstance();
		this.titleDao = TitleDao.getInstance();
	}


	public void insertEmployee(Employee employee){
		try {
			empDao.insertItem(employee);
			showMessage("추가 완료");
		} catch (SQLException e) {
			e.printStackTrace();
			showMessage(e.getMessage());
		}
	}
	
	public void updateEmployee(Employee employee){
		try {
			empDao.updateItem(employee);
			showMessage("수정 완료");
		} catch (SQLException e) {
			e.printStackTrace();
			showMessage(e.getMessage());
		}
	}
	
	private void showMessage(String msg) {
		JOptionPane.showMessageDialog(null, msg);		
	}

	public void deleteEmployee(Employee employee){
		try {
			empDao.deleteItem(employee);
			showMessage("삭제 완료");
		} catch (SQLException e) {
			e.printStackTrace();
			showMessage(e.getMessage());
		}
	}
	
	public Employee selectEmployeeByNo(Employee employee){
		try {
			return empDao.selectItemByNo(employee);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Employee> selectEmployeeByAll(){
		try {
			return empDao.selectItemByAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	
	public List<Title> selectTitleByAll() {
		try {
			return titleDao.selectItemByAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Title selectTitleByNo(Title item){
		try {
			return titleDao.selectItemByNo(item);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Department> selectDepartmentByAll() {
		try {
			return deptDao.selectItemByAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Department selectDepartmentByNo(Department item){
		try {
			return deptDao.selectItemByNo(item);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Employee> selectManagerByDno(Department dno){
		try {
			return EmployeeDao.getInstance().selectItemByDno(dno);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
