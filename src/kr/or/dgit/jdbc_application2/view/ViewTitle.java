package kr.or.dgit.jdbc_application2.view;

import java.awt.event.ActionEvent;

import kr.or.dgit.jdbc_application2.content.AbstractContent;
import kr.or.dgit.jdbc_application2.content.TitleContent;
import kr.or.dgit.jdbc_application2.dto.Title;
import kr.or.dgit.jdbc_application2.list.AbstractList;
import kr.or.dgit.jdbc_application2.list.ListTitle;
import kr.or.dgit.jdbc_application2.service.TitleService;

@SuppressWarnings("serial")
public class ViewTitle extends AbstractView {
	private TitleService service;
	TitleContent pContent;
	
	public ViewTitle(String title) {
		super(title);		
	}

	@Override
	protected AbstractList createList() {
		ListTitle pList = new ListTitle(service);
		pList.loadData();
		return pList;
	}

	@Override
	protected AbstractContent<Title> createContent() {
		pContent = new TitleContent();
		return pContent;
	}

	@Override
	protected void createService() {
		service = new TitleService();		
	}

}
