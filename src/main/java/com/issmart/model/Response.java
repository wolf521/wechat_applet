package com.issmart.model;

public class Response {

	public static final String OK = "1"; // 响应正常码
	public static final String ERROR = "0"; // 校验错误码
	public static final String NOTFOUND = "404"; // 页面找不到错误码
	public static final String UNKNOWN_EERROR = "500"; // 系统错误码
	public static final String BIZERROR = "700"; // 业务错误码
	public static final String PERMERROR = "800"; // 权限错误码

	private Meta meta;
	private Object data;
	private Page page;

	public Response() {
		this.meta = new Meta(OK, OK);
	}

	public Response success() {
		this.meta = new Meta(OK, OK);
		return this;
	}

	public Response success(Object data) {
		this.meta = new Meta(OK, OK);
		this.data = data;
		return this;
	}
	
	public Response diySuccess(Object data,String code,String message) {
		this.meta = new Meta(code, message);
		this.data = data;
		return this;
	}

	public Response failure() {
		this.meta = new Meta(ERROR, ERROR);
		return this;
	}

	/**
	 * 校验错误
	 * 
	 * @param message
	 * @return
	 */
	public Response failure(String message) {
		this.meta = new Meta(ERROR, message);
		return this;
	}

	/**
	 * 自定义错误编码
	 * 
	 * @param code
	 * @param message
	 * @return
	 */
	public Response diyFailure(String code, String message) {
		this.meta = new Meta(code, message);
		return this;
	}

	/**
	 * 未知错误
	 * 
	 * @param message
	 * @return
	 */
	public Response unknownFailure(String message) {
		this.meta = new Meta(UNKNOWN_EERROR, message);
		return this;
	}

	public Meta getMeta() {
		return meta;
	}

	public Object getData() {
		return data;
	}

	public Response setPage(int pageNo, int pageSize, int total) {
		this.page = new Page(pageNo, pageSize, total);
		return this;
	}

	public Response setPage(int pageNo, int pageSize, int pageCount, int total) {
		this.page = new Page(pageNo, pageSize, pageCount, total);
		return this;
	}

	public class Meta {

		private String code;
		private String message;

		public Meta(String code) {
			this.code = code;
		}

		public Meta(String code, String message) {
			this.code = code;
			this.message = message;
		}

		public String getCode() {
			return code;
		}
		
		public void setCode(String code) {
			this.code = code;
		}

		public void setMessage(String message) {
			this.message = message;
		}
		
		public String getMessage() {
			return message;
		}

		public boolean isSuccess() {
			if ("0".equals(this.code)) {
				return false;
			}
			return true;
		}

		@Override
		public String toString() {
			return "Meta [code=" + code + ", message=" + message + "]";
		}
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public class Page {
		private int pageNo;
		private int pageSize;
		private int pageCount;
		private int total;

		public int getPageNo() {
			return pageNo;
		}

		public void setPageNo(int pageNo) {
			this.pageNo = pageNo;
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

		public int getTotal() {
			return total;
		}

		public void setTotal(int total) {
			this.total = total;
		}

		public Page(int pageNo, int pageSize, int total) {
			this.pageNo = pageNo;
			this.pageSize = pageSize;
			this.total = total;
		}

		public Page(int pageNo, int pageSize, int pageCount, int total) {
			this.pageNo = pageNo;
			this.pageSize = pageSize;
			this.pageCount = pageCount;
			this.total = total;
		}
	}
}
