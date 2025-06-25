package in.co.loan.granting.system.form;

import java.util.Date;

import javax.validation.constraints.NotEmpty;

import in.co.loan.granting.system.dto.BaseDTO;
import in.co.loan.granting.system.dto.HelpDTO;
import in.co.loan.granting.system.util.DataUtility;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HelpForm extends BaseForm {

	private String requestId;
	
	public String getRequestId() {
		return requestId;
	}

	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}

	public String getIssue() {
		return issue;
	}

	public void setIssue(String issue) {
		this.issue = issue;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@NotEmpty(message = "Issue is required")
	private String issue;
	
	@NotEmpty(message = "Description is required")
	private String description;
	
	private String comment;
	
	private Date date;
	
	

	@Override
	public BaseDTO getDTO() {
		HelpDTO bean=new HelpDTO();
		bean.setId(id);
		bean.setIssue(issue);
		bean.setRequestId(DataUtility.getLong(requestId));
		bean.setComment(comment);
		bean.setDate(date);
		bean.setDescription(description);
		bean.setCreatedBy(createdBy);
		bean.setModifiedBy(modifiedBy);
		bean.setCreatedDatetime(createdDateTime);
		bean.setModifiedDatetime(modifiedDateTime);
		return bean;
	}

	@Override
	public void populate(BaseDTO bDto) {
		HelpDTO bean=(HelpDTO)bDto;
		id=bean.getId();
		issue=bean.getIssue();
		description=bean.getDescription();
		requestId=String.valueOf(bean.getRequestId());
		comment=bean.getComment();
		date=bean.getDate();
		createdBy=bean.getCreatedBy();
		modifiedBy=bean.getModifiedBy();
		createdDateTime=bean.getCreatedDatetime();
		modifiedDateTime=bean.getModifiedDatetime();
	}

}
