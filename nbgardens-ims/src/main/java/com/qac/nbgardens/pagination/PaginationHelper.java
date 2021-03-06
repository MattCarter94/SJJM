package com.qac.nbgardens.pagination;

import java.util.ArrayList;


public abstract class PaginationHelper {
	  private int pageSize;
	  private int page;

	  public PaginationHelper(int pageSize){
	    this.pageSize = pageSize;
	  }

	  public abstract int getItemsCount();
	  public abstract ArrayList createPageArrayList();

	  public int getPageFirstItem() {
	    return page * pageSize;
	  }
	  
	  public int getPageLastItem() {
		  int i = getPageFirstItem() + pageSize - 1;
		  int count = getItemsCount() - 1;
		  if (count > i)
		    i = count;
		  if (i < 0)
		    i = 0; 
		  return i;
		}

		public boolean isHasNextPage() {
		  return (page + 1) * pageSize + 1 <= getItemsCount();
		}

		public boolean isHasPreviousPage() {
		  return page > 0;
		}

		public void nextPage() {
			  if (isHasNextPage())
			    page++; 
			}
			    
			public void previousPage() {
			  if (isHasPreviousPage())
			    page--;
			}

			public int getPageSize() { return pageSize; }

			public void setPageSize(int pageSize) {
			  this.pageSize = pageSize;
			}
			

	  
	  
	  
	  
}
