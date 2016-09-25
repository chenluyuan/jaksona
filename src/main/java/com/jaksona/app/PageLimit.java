package com.jaksona.app;

/**
 * paging
 * @author jaksona
 */
public class PageLimit {
	private Integer start;
	private Integer limit;
	private Sort sortInfo;

	public Integer getStart() {
		return start;
	}

	public void setStart(Integer start) {
		this.start = start;
	}

	public Integer getLimit() {
		return limit;
	}

	public void setLimit(Integer limit) {
		this.limit = limit;
	}

	public Sort getSortInfo() {
		return sortInfo;
	}

	public void setSortInfo(Sort sortInfo) {
		this.sortInfo = sortInfo;
	}

	private class Sort {
		private String field;
		private String direction;

		public String getField() {
			return field;
		}

		public void setField(String field) {
			this.field = field;
		}

		public String getDirection() {
			return direction;
		}

		public void setDirection(String direction) {
			this.direction = direction;
		}
	}
}
