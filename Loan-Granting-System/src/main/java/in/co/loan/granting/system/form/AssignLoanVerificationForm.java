package in.co.loan.granting.system.form;

import javax.validation.constraints.Min;

import in.co.loan.granting.system.dto.AssignLoanVerificationDTO;
import in.co.loan.granting.system.dto.BaseDTO;
import in.co.loan.granting.system.util.DataUtility;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AssignLoanVerificationForm extends BaseForm {
	
	@Min(value=1,message = "Loan Officer is required")
	private long loanOfficerId;
	
	public long getLoanOfficerId() {
		return loanOfficerId;
	}

	public void setLoanOfficerId(long loanOfficerId) {
		this.loanOfficerId = loanOfficerId;
	}

	public long getLoanId() {
		return loanId;
	}

	public void setLoanId(long loanId) {
		this.loanId = loanId;
	}

	public String getLoanRequestId() {
		return loanRequestId;
	}

	public void setLoanRequestId(String loanRequestId) {
		this.loanRequestId = loanRequestId;
	}

	public String getLoanOfficerName() {
		return loanOfficerName;
	}

	public void setLoanOfficerName(String loanOfficerName) {
		this.loanOfficerName = loanOfficerName;
	}

	@Min(value=1,message = "Loan User Name is required")
	private long loanId;
	
	private String loanRequestId;
	
	private String loanOfficerName;

	@Override
	public BaseDTO getDTO() {
		AssignLoanVerificationDTO bean=new AssignLoanVerificationDTO();
		bean.setId(id);
		bean.setLoanOfficerId(loanOfficerId);
		bean.setLoanId(loanId);
		bean.setLoanRequestId(DataUtility.getLong(loanRequestId));
		bean.setLoanOfficerName(loanOfficerName);
		bean.setCreatedBy(createdBy);
		bean.setModifiedBy(modifiedBy);
		bean.setCreatedDatetime(createdDateTime);
		bean.setModifiedDatetime(modifiedDateTime);
		return bean;
	}

	@Override
	public void populate(BaseDTO bDto) {
		AssignLoanVerificationDTO bean=(AssignLoanVerificationDTO)bDto;
		id=bean.getId();
		loanOfficerId=bean.getLoanOfficerId();
		loanRequestId=String.valueOf(loanRequestId);
		loanOfficerName=bean.getLoanOfficerName();
		loanId=bean.getLoanId();
		createdBy=bean.getCreatedBy();
		modifiedBy=bean.getModifiedBy();
		createdDateTime=bean.getCreatedDatetime();
		modifiedDateTime=bean.getModifiedDatetime();
	}

}
