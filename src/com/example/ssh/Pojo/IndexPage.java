package com.example.ssh.Pojo;

import java.util.List;

/**
 * 
*<p>Title: IndexPage</p>
*<p>Description: </p>
*<p>Company: </p> 
*@author * @date
 * @param <T>
 */
public class IndexPage<T> {
	private int indexPage;/*当前的页数*/
	private int pageSize;/*每页显示的数目*/
	private int pageCount;/*总的记录数*/
	private int indexCount;/*页数总数*/
	private List<T> list;/*集合*/
	
	
	public int getIndexPage() {
		return indexPage;
	}
	public void setIndexPage(int indexPage) {
		this.indexPage = indexPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getPageCount() {
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	public int getIndexCount() {
		return indexCount;
	}
	public void setIndexCount(int indexCount) {
		this.indexCount = indexCount;
	}
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
	

}
