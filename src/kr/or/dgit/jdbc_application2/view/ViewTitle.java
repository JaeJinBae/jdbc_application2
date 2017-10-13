package kr.or.dgit.jdbc_application2.view;

import javax.swing.JPanel;

import kr.or.dgit.jdbc_application2.content.TitleContent;
import kr.or.dgit.jdbc_application2.list.AbstractList;
import kr.or.dgit.jdbc_application2.list.ListTitle;

@SuppressWarnings("serial")
public class ViewTitle extends AbstractView {

	public ViewTitle(String title) {
		super(title);		
	}

	@Override
	protected AbstractList createList() {
		ListTitle pList = new ListTitle();
		return pList;
	}

	@Override
	protected JPanel createContent() {
		TitleContent pContent = new TitleContent();
		return pContent;
	}

}
