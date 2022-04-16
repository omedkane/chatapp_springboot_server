package mr.gk2ms.chatapp.utilities.classes;

import java.util.List;

public class PageResponse<T> {
	private int currentPage;
	private int totalItems;
	private int totalPages;
	private List<T> items;

	public PageResponse() {
	}

	public PageResponse(int currentPage, int totalItems, int totalPages, List<T> items) {
		this.currentPage = currentPage;
		this.totalItems = totalItems;
		this.totalPages = totalPages;
		this.items = items;
	}

	public int getCurrentPage() {
		return this.currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getTotalItems() {
		return this.totalItems;
	}

	public void setTotalItems(int totalItems) {
		this.totalItems = totalItems;
	}

	public int getTotalPages() {
		return this.totalPages;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	public List<T> getItems() {
		return this.items;
	}

	public void setItems(List<T> items) {
		this.items = items;
	}

	public PageResponse<T> currentPage(int currentPage) {
		setCurrentPage(currentPage);
		return this;
	}

	public PageResponse<T> totalItems(int totalItems) {
		setTotalItems(totalItems);
		return this;
	}

	public PageResponse<T> totalPages(int totalPages) {
		setTotalPages(totalPages);
		return this;
	}

	public PageResponse<T> items(List<T> items) {
		setItems(items);
		return this;
	}

}
