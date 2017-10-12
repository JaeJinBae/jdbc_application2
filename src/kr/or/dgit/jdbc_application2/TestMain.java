package kr.or.dgit.jdbc_application2;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;

import kr.or.dgit.jdbc_application2.dao.DepartmentDao;
import kr.or.dgit.jdbc_application2.dao.EmployeeDao;
import kr.or.dgit.jdbc_application2.dao.TitleDao;
import kr.or.dgit.jdbc_application2.dto.Department;
import kr.or.dgit.jdbc_application2.dto.Employee;
import kr.or.dgit.jdbc_application2.dto.Title;
import kr.or.dgit.jdbc_application2.jdbc.DBCon;
import kr.or.dgit.jdbc_application2.jdbc.JdbcUtil;

public class TestMain {

	public static void main(String[] args) {
//		testDBCon();
		
//		testDepartmentDao();

//		testTitleDao();
		testEmployeeDao();
	}

	private static void testEmployeeDao() {
		Employee emp = new Employee(1007, "김유신", new Title(4), new Employee(4377), 2000000, new Department(1));
		
		System.out.println("추가");
		try {
			EmployeeDao.getInstance().insertItem(emp);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			System.out.println("목록");
			for(Employee e : EmployeeDao.getInstance().selectItemByAll()){
				System.out.println(e);
			}
			
			System.out.println("수정");
			emp.setEmpName("수지");
			EmployeeDao.getInstance().updateItem(emp);
			
			System.out.println(EmployeeDao.getInstance().selectItemByNo(emp));
			
			System.out.println("삭제");
			EmployeeDao.getInstance().deleteItem(emp);
			for(Employee e : EmployeeDao.getInstance().selectItemByAll()){
				System.out.println(e);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
	}

	private static void testTitleDao() {
		Title title = new Title(6, "인턴");
		
		try {
			TitleDao.getInstance().insertItem(title);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			List<Title> lists = TitleDao.getInstance().selectItemByAll();
			for(Title t : lists){
				System.out.println(t);
			}
			
			title.setTitleName("인턴2");
			TitleDao.getInstance().updateItem(title);
			System.out.println(TitleDao.getInstance().selectItemByNo(title));
			
			
			TitleDao.getInstance().deleteItem(title);
			lists = TitleDao.getInstance().selectItemByAll();
			for(Title t : lists){
				System.out.println(t);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	private static void testDepartmentDao() {
		Department dept = new Department(4, "마케팅", 10);
		
		testInsert(dept);
		testListAll();
		
		dept.setDeptName("마케팅2");
		testUpdate(dept);
		testDeptNo(dept);
		
		testDelete(dept);
		testListAll();
	}

	private static void testUpdate(Department dept) {
		try {
			DepartmentDao.getInstance().updateItem(dept);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private static void testDeptNo(Department dept) {
		try {
			Department searchDept = DepartmentDao.getInstance().selectItemByNo(dept);
			System.out.println(searchDept);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void testListAll() {
		try {
			List<Department> lists = DepartmentDao.getInstance().selectItemByAll();
			for(Department dept : lists){
				System.out.println(dept);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private static void testDelete(Department dept) {
		try {
			DepartmentDao.getInstance().deleteItem(dept);
			JOptionPane.showMessageDialog(null, "부서가 삭제되었습니다.");
		} catch (SQLException e) {
			System.err.printf("%s - %s%n", e.getErrorCode(), e.getMessage());
			JOptionPane.showMessageDialog(null, "삭제실패");
		}
	}

	private static void testInsert(Department dept) {
		try {
			DepartmentDao.getInstance().insertItem(dept);
			JOptionPane.showMessageDialog(null, "부서가 추가되었습니다.");
		} catch (SQLException e) {
			System.err.printf("%s - %s%n", e.getErrorCode(), e.getMessage());
			if (e.getErrorCode()==1062){
				JOptionPane.showMessageDialog(null, "부서번호가 중복");
			}
		}
	}

	private static void testDBCon() {
		DBCon dbCon = DBCon.getInstance();

		Connection connection = dbCon.getConnection();
		System.out.println(connection);
		
		
		JdbcUtil.close(connection);
	}

}
