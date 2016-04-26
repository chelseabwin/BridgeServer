package global.tool;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

public class QueryItems {
	
	private List<QueryObject> queryObjects;
	private Date startDate;
	private Date endDate;
	private Integer pageNo;
	private Integer pageSize;
	
	public QueryItems(List<QueryObject> queryObjects, Date startDate,
			Date endDate, Integer pageNo, Integer pageSize) {
		super();
		this.queryObjects = queryObjects;
		this.startDate = startDate;
		this.endDate = endDate;
		this.pageNo = pageNo;
		this.pageSize = pageSize;
	}
	
	public Integer getPageNo() {
		return pageNo;
	}
	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public List<QueryObject> getQueryObjects() {
		return queryObjects;
	}
	public void setQueryObjects(List<QueryObject> queryObjects) {
		this.queryObjects = queryObjects;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	public Timestamp getSQLStartDate(){
		if(this.getStartDate()!=null){
			return new Timestamp(this.getStartDate().getTime());
		}
		return null;
	}
	public Timestamp getSQLEndDate(){
		if(this.getEndDate()!=null){
			return new Timestamp(this.getEndDate().getTime());
		}
		return null;
	}

}
