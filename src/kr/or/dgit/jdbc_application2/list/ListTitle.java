package kr.or.dgit.jdbc_application2.list;

import javax.swing.SwingConstants;

import kr.or.dgit.jdbc_application2.dto.Title;

@SuppressWarnings("serial")
public class ListTitle extends AbstractList {
	
	@Override
	protected void setAlignWidth() {
		setAlign(SwingConstants.CENTER, 0,1);
		setCellWidth(100, 150);
	}

	@Override
	protected Object[][] getData() {
		Object[][] data = {{1,"사장"},{2,"부장"}};
		return data;
	}

	@Override
	protected String[] getColumnNames() {
		return new String[] {"직책 번호", "직책 명"};
	}

	@Override
	public Object getSelectedItem() {
		int selectedIndex=table.getSelectedRow();
		int titleNo=(int) table.getValueAt(selectedIndex, 0);
		String titleName=(String) table.getValueAt(selectedIndex, 1);
		return new Title(titleNo, titleName);
	}

}
