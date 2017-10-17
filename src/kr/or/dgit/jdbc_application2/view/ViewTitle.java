package kr.or.dgit.jdbc_application2.view;

import kr.or.dgit.jdbc_application2.content.AbstractContent;
import kr.or.dgit.jdbc_application2.content.TitleContent;
import kr.or.dgit.jdbc_application2.dto.Title;
import kr.or.dgit.jdbc_application2.list.AbstractList;
import kr.or.dgit.jdbc_application2.list.ListTitle;
import kr.or.dgit.jdbc_application2.service.TitleService;

@SuppressWarnings("serial")
public class ViewTitle extends AbstractView {
	private TitleService service;
	
	public ViewTitle(String title) {
		super(title);		
	}

	@Override
	protected AbstractList createList() {
		pList = new ListTitle(service);
		pList.loadData();
		return pList;
	}

	@Override
	protected AbstractContent<Title> createContent() {
		pContent = new TitleContent();
		return (AbstractContent<Title>) pContent;
	}

	@Override
	protected void createService() {
		service = new TitleService();		
	}

	@Override
	protected void insertContent(Object content) {
		service.insertTitle((Title) content);
		pContent.clear();
		
	}

	@Override
	protected void deleteContent(Object content) {
		service.deleteTitle((Title) content);
		
	}

	@Override
	protected void updateContent(Object item) {
		service.updateTitle((Title) item);
		pContent.clear();
	}

	@Override
	protected Object searchContent(int num) {
		return service.selectTitleByNo(new Title(num));
	}

}
