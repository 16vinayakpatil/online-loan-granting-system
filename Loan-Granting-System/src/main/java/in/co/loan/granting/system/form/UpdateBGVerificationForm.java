package in.co.loan.granting.system.form;

import javax.validation.constraints.NotEmpty;

import org.springframework.web.multipart.MultipartFile;

import in.co.loan.granting.system.dto.BaseDTO;
import in.co.loan.granting.system.dto.UpdateBGVerificationDTO;
import in.co.loan.granting.system.util.DataUtility;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateBGVerificationForm extends BaseForm {
	
	@NotEmpty(message = "Verification Update is required")
	private String verificationUpdate;
	@NotEmpty(message = "Description is required")
	private String description;
	
	private MultipartFile report;
	
	
    private String loanRequestId;
	
	private String fieldOfficerName;

	@Override
	public BaseDTO getDTO() {
		UpdateBGVerificationDTO bean=new UpdateBGVerificationDTO();
		bean.setId(id);
		bean.setVerificationUpdate(verificationUpdate);
		bean.setDescription(description);
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
		UpdateBGVerificationDTO bean=(UpdateBGVerificationDTO)bDto;
		id=bean.getId();
		verificationUpdate=bean.getVerificationUpdate();
		description=bean.getDescription();
		loanRequestId=String.valueOf(loanRequestId);
		fieldOfficerName=bean.getFieldOfficerName();
		createdBy=bean.getCreatedBy();
		modifiedBy=bean.getModifiedBy();
		createdDateTime=bean.getCreatedDatetime();
		modifiedDateTime=bean.getModifiedDatetime();
	}

}
