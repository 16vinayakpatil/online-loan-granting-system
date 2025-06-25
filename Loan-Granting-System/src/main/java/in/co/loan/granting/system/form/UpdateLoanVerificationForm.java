package in.co.loan.granting.system.form;

import javax.validation.constraints.NotEmpty;

import org.springframework.web.multipart.MultipartFile;

import in.co.loan.granting.system.dto.BaseDTO;
import in.co.loan.granting.system.dto.UpdateLoanVerificationDTO;
import in.co.loan.granting.system.util.DataUtility;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateLoanVerificationForm extends BaseForm {
	
	@NotEmpty(message = "Verification Update is required")
	private String verificationUpdate;
	@NotEmpty(message = "Description is required")
	private String description;
	
	private MultipartFile report;
	
	@NotEmpty(message = "Status is required")
	private String status;
	
	private String loanRequestId;
	
	private String loanOfficerName;

	@Override
	public BaseDTO getDTO() {
		UpdateLoanVerificationDTO bean=new UpdateLoanVerificationDTO();
		bean.setId(id);
		bean.setVerificationUpdate(verificationUpdate);
		bean.setDescription(description);
		bean.setLoanRequestId(DataUtility.getLong(loanRequestId));
		bean.setLoanOfficerName(loanOfficerName);
		bean.setStatus(status);
		bean.setCreatedBy(createdBy);
		bean.setModifiedBy(modifiedBy);
		bean.setCreatedDatetime(createdDateTime);
		bean.setModifiedDatetime(modifiedDateTime);
		return bean;
	}

	@Override
	public void populate(BaseDTO bDto) {
		UpdateLoanVerificationDTO bean=(UpdateLoanVerificationDTO)bDto;
		id=bean.getId();
		verificationUpdate=bean.getVerificationUpdate();
		description=bean.getDescription();
		loanRequestId=String.valueOf(loanRequestId);
		loanOfficerName=bean.getLoanOfficerName();
		status=bean.getStatus();
		createdBy=bean.getCreatedBy();
		modifiedBy=bean.getModifiedBy();
		createdDateTime=bean.getCreatedDatetime();
		modifiedDateTime=bean.getModifiedDatetime();
	}

}
