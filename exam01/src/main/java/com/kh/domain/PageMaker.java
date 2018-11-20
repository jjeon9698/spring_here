package com.kh.domain;

public class PageMaker {
	private int totalCount;
	private int startPage;
	private int endPage;
	private boolean prev;
	private boolean next;
	private int displayPageNum = 10;
	private PagingDto pagingDto;

	public PageMaker() {
		super();
	}

	public PageMaker(int totalCount, int startPage, int endPage, boolean prev, boolean next, int displayPageNum,
			PagingDto pagingDto) {
		super();
		this.totalCount = totalCount;
		this.startPage = startPage;
		this.endPage = endPage;
		this.prev = prev;
		this.next = next;
		this.displayPageNum = displayPageNum;
		this.pagingDto = pagingDto;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
		calcData();
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public boolean isPrev() {
		return prev;
	}

	public void setPrev(boolean prev) {
		this.prev = prev;
	}

	public boolean isNext() {
		return next;
	}

	public void setNext(boolean next) {
		this.next = next;
	}

	public int getDisplayPageNum() {
		return displayPageNum;
	}

	public void setDisplayPageNum(int displayPageNum) {
		this.displayPageNum = displayPageNum;
	}

	public PagingDto getPagingDto() {
		return pagingDto;
	}

	public void setPagingDto(PagingDto pagingDto) {
		this.pagingDto = pagingDto;
	}
	
	private void calcData() {
		int page = pagingDto.getPage();
		startPage = (int) ((page - 1) / displayPageNum) * displayPageNum + 1;
		endPage = startPage + displayPageNum - 1;
		int maxPage = totalCount / displayPageNum;
		if (totalCount % displayPageNum > 0) {
			maxPage += 1;
		}
		if (endPage > maxPage) {
			endPage = maxPage;
		}
		
		if (!(page >= 1 && page <= displayPageNum)) {
			prev = true;
		}
		
		if (endPage < maxPage) {
			next = true;
		} 
	}

	@Override
	public String toString() {
		return "PageMaker [totalCount=" + totalCount + ", startPage=" + startPage + ", endPage=" + endPage + ", prev="
				+ prev + ", next=" + next + ", displayPageNum=" + displayPageNum + ", pagingDto=" + pagingDto + "]";
	}

}
