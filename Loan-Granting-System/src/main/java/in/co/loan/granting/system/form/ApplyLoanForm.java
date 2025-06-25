package in.co.loan.granting.system.form;

import javax.validation.constraints.NotEmpty;

import org.springframework.web.multipart.MultipartFile;

import in.co.loan.granting.system.dto.ApplyLoanDTO;
import in.co.loan.granting.system.dto.BaseDTO;
import in.co.loan.granting.system.util.DataUtility;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApplyLoanForm extends BaseForm {
	
	@NotEmpty(message = "Name is required")
	private String name;
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public MultipartFile getResume() {
		return resume;
	}

	public void setResume(MultipartFile resume) {
		this.resume = resume;
	}

	public MultipartFile getProjectPlan() {
		return projectPlan;
	}

	public void setProjectPlan(MultipartFile projectPlan) {
		this.projectPlan = projectPlan;
	}

	public MultipartFile getPersonalCreditReport() {
		return personalCreditReport;
	}

	public void setPersonalCreditReport(MultipartFile personalCreditReport) {
		this.personalCreditReport = personalCreditReport;
	}

	public MultipartFile getBusinessCreditReport() {
		return businessCreditReport;
	}

	public void setBusinessCreditReport(MultipartFile businessCreditReport) {
		this.businessCreditReport = businessCreditReport;
	}

	public MultipartFile getFinancialStatement() {
		return financialStatement;
	}

	public void setFinancialStatement(MultipartFile financialStatement) {
		this.financialStatement = financialStatement;
	}

	public MultipartFile getBankStatement() {
		return bankStatement;
	}

	public void setBankStatement(MultipartFile bankStatement) {
		this.bankStatement = bankStatement;
	}

	public String getLoanAmount() {
		return loanAmount;
	}

	public void setLoanAmount(String loanAmount) {
		this.loanAmount = loanAmount;
	}

	public String getLoanTenure() {
		return loanTenure;
	}

	public void setLoanTenure(String loanTenure) {
		this.loanTenure = loanTenure;
	}

	public String getEMIOption() {
		return EMIOption;
	}

	public void setEMIOption(String eMIOption) {
		EMIOption = eMIOption;
	}

	public String getRequestLoanId() {
		return requestLoanId;
	}

	public void setRequestLoanId(String requestLoanId) {
		this.requestLoanId = requestLoanId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@NotEmpty(message = "Address is required")
	private String address;
	
	@NotEmpty(message = "Phone No is required")
	private String phoneNo;
	
	@NotEmpty(message = "Email Id is required")
	private String emailId;
	
	private MultipartFile resume;
	
	private MultipartFile projectPlan;

	private MultipartFile personalCreditReport;
	
	private MultipartFile businessCreditReport;
	
	private MultipartFile financialStatement;
	
	private MultipartFile bankStatement;
	
	@NotEmpty(message ="Loan Amount is required")
	private String loanAmount;
	
	@NotEmpty(message ="Loan Tenure is required")
	private String loanTenure;
	
	@NotEmpty(message ="EMI Option is required")
	private String EMIOption;
	
	private String requestLoanId;
	
	private String status;
	

	@Override
	public BaseDTO getDTO() {
		ApplyLoanDTO bean=new ApplyLoanDTO();
		bean.setId(id);
		bean.setName(name);
		bean.setRequestLoanId(DataUtility.getLong(requestLoanId));
		bean.setAddress(address);
		bean.setPhoneNo(phoneNo);
		bean.setEmailId(emailId);
		bean.setStatus(status);
		bean.setLoanAmount(loanAmount);
		bean.setLoanTenure(loanTenure);
		bean.setEMIOption(EMIOption);
		bean.setCreatedBy(createdBy);
		bean.setModifiedBy(modifiedBy);
		bean.setCreatedDatetime(createdDateTime);
		bean.setModifiedDatetime(modifiedDateTime);
		return bean;
	}

	@Override
	public void populate(BaseDTO bDto) {
		ApplyLoanDTO bean=(ApplyLoanDTO)bDto;
		id=bean.getId();
		name=bean.getName();
		requestLoanId=String.valueOf(bean.getRequestLoanId());
		address=bean.getAddress();
		phoneNo=bean.getPhoneNo();
		emailId=bean.getEmailId();
		status=bean.getStatus();
		loanAmount=bean.getLoanAmount();
		loanTenure=bean.getLoanTenure();
		EMIOption=bean.getEMIOption();
		createdBy=bean.getCreatedBy();
		modifiedBy=bean.getModifiedBy();
		createdDateTime=bean.getCreatedDatetime();
		modifiedDateTime=bean.getModifiedDatetime();
	}

}
