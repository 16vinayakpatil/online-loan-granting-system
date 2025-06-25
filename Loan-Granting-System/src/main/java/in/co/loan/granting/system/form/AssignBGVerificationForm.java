package in.co.loan.granting.system.form;

import javax.validation.constraints.Min;

import in.co.loan.granting.system.dto.AssignBGVerificationDTO;
import in.co.loan.granting.system.dto.BaseDTO;
import in.co.loan.granting.system.util.DataUtility;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AssignBGVerificationForm extends BaseForm {
	
	@Min(value=1,message = "Field Officer is required")
	private long fieldOfficerId;
	
	public long getFieldOfficerId() {
		return fieldOfficerId;
	}

	public void setFieldOfficerId(long fieldOfficerId) {
		this.fieldOfficerId = fieldOfficerId;
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

	public String getFieldOfficerName() {
		return fieldOfficerName;
	}

	public void setFieldOfficerName(String fieldOfficerName) {
		this.fieldOfficerName = fieldOfficerName;
	}

	@Min(value=1,message = "Loan User Name is required")
	private long loanId;
	
	private String loanRequestId;
	
	private String fieldOfficerName;

	@Override
	public BaseDTO getDTO() {
		AssignBGVerificationDTO bean=new AssignBGVerificationDTO();
		bean.setId(id);
		bean.setFieldOfficerId(fieldOfficerId);
		bean.setLoanId(loanId);
		bean.setLoanRequestId(DataUtility.getLong(loanRequestId));
		bean.setFieldOfficerName(fieldOfficerName);
		bean.setCreatedBy(createdBy);
		bean.setModifiedBy(modifiedBy);
		bean.setCreatedDatetime(createdDateTime);
		bean.setModifiedDatetime(modifiedDateTime);
		return bean;
	}

	@Override
	public void populate(BaseDTO bDto) {
		AssignBGVerificationDTO bean=(AssignBGVerificationDTO)bDto;
		id=bean.getId();
		fieldOfficerId=bean.getFieldOfficerId();
		loanId=bean.getLoanId();
		loanRequestId=String.valueOf(loanRequestId);
		fieldOfficerName=bean.getFieldOfficerName();
		createdBy=bean.getCreatedBy();
		modifiedBy=bean.getModifiedBy();
		createdDateTime=bean.getCreatedDatetime();
		modifiedDateTime=bean.getModifiedDatetime();
	}

}
