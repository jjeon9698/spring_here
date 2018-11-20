package com.kh.domain;

public class PagingDto {
	private int page = 1;
	private int perPage = 10;
	private int startRow = 1;
	private int endRow = 10;
	private String searchType;
	private String keyword;

	public PagingDto() {
		super();
	}
	
	public PagingDto(int page) {
		super();
		this.page = page;
		setRows();
	}

	public PagingDto(int page, int perPage) {
		super();
		this.page = page;
		this.perPage = perPage;
		setRows();
	}

	public PagingDto(int page, int perPage, int startRow, int endRow) {
		super();
		this.page = page;
		this.perPage = perPage;
		this.startRow = startRow;
		this.endRow = endRow;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
		setRows();
	}

	public int getPerPage() {
		return perPage;
	}

	public void setPerPage(int perPage) {
		this.perPage = perPage;
		setRows();
	}

	public int getStartRow() {
		return startRow;
	}

	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}

	public int getEndRow() {
		return endRow;
	}

	public void setEndRow(int endRow) {
		this.endRow = endRow;
	}
	
	private void setRows() {
		startRow = page * perPage - perPage + 1;
		endRow = page * perPage;
	}

	public String getSearchType() {
		return searchType;
	}

	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	@Override
	public String toString() {
		return "PagingDto [page=" + page + ", perPage=" + perPage + ", startRow=" + startRow + ", endRow=" + endRow
				+ ", searchType=" + searchType + ", keyword=" + keyword + "]";
	}

	

}
