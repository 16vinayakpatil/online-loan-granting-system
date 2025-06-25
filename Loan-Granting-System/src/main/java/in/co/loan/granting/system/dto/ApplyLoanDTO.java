package in.co.loan.granting.system.dto;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="APPLY_LOAN")
@Getter
@Setter
public class ApplyLoanDTO extends BaseDTO {

	@Column(name="NAME",length = 225)
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

	public byte[] getResume() {
		return resume;
	}

	public void setResume(byte[] resume) {
		this.resume = resume;
	}

	public byte[] getProjectPlan() {
		return projectPlan;
	}

	public void setProjectPlan(byte[] projectPlan) {
		this.projectPlan = projectPlan;
	}

	public byte[] getPersonalCreditReport() {
		return personalCreditReport;
	}

	public void setPersonalCreditReport(byte[] personalCreditReport) {
		this.personalCreditReport = personalCreditReport;
	}

	public byte[] getBusinessCreditReport() {
		return businessCreditReport;
	}

	public void setBusinessCreditReport(byte[] businessCreditReport) {
		this.businessCreditReport = businessCreditReport;
	}

	public byte[] getFinancialStatement() {
		return financialStatement;
	}

	public void setFinancialStatement(byte[] financialStatement) {
		this.financialStatement = financialStatement;
	}

	public byte[] getBankStatement() {
		return bankStatement;
	}

	public void setBankStatement(byte[] bankStatement) {
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

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Set<AssignBGVerificationDTO> getAssignBGVerifications() {
		return assignBGVerifications;
	}

	public void setAssignBGVerifications(Set<AssignBGVerificationDTO> assignBGVerifications) {
		this.assignBGVerifications = assignBGVerifications;
	}

	public Set<AssignLoanVerificationDTO> getAssignLoanVerifications() {
		return assignLoanVerifications;
	}

	public void setAssignLoanVerifications(Set<AssignLoanVerificationDTO> assignLoanVerifications) {
		this.assignLoanVerifications = assignLoanVerifications;
	}

	public Set<UpdateBGVerificationDTO> getUpdateBGVerifications() {
		return updateBGVerifications;
	}

	public void setUpdateBGVerifications(Set<UpdateBGVerificationDTO> updateBGVerifications) {
		this.updateBGVerifications = updateBGVerifications;
	}

	public Set<UpdateLoanVerificationDTO> getUpdateLoanVerifications() {
		return updateLoanVerifications;
	}

	public void setUpdateLoanVerifications(Set<UpdateLoanVerificationDTO> updateLoanVerifications) {
		this.updateLoanVerifications = updateLoanVerifications;
	}

	public long getRequestLoanId() {
		return requestLoanId;
	}

	public void setRequestLoanId(long requestLoanId) {
		this.requestLoanId = requestLoanId;
	}

	@Column(name="ADDRESS",length = 1500)
	private String address;
	
	@Column(name="PHONE_NO",length = 225)
	private String phoneNo;
	
	@Column(name="EMAIL_ID",length = 225)
	private String emailId;
	
	@Column(name="RESUME",columnDefinition = "LONGBLOB")
	private byte[] resume;
	
	@Column(name="PROJECT_PLAN",columnDefinition = "LONGBLOB")
	private byte[] projectPlan;

	@Column(name="PERSONAL_CREDIT_REPORT",columnDefinition = "LONGBLOB")
	private byte[] personalCreditReport;
	
	@Column(name="BUSINESS_CREDIT_REPORT",columnDefinition = "LONGBLOB")
	private byte[] businessCreditReport;
	
	@Column(name="FINANCIAL_STATEMENT",columnDefinition = "LONGBLOB")
	private byte[] financialStatement;
	
	@Column(name="BANK_STATEMENT",columnDefinition = "LONGBLOB")
	private byte[] bankStatement;
	
	@Column(name="LOAN_AMOUNT",length = 225)
	private String loanAmount;
	
	@Column(name="LOAN_TENURE",length = 225)
	private String loanTenure;
	
	@Column(name="EMI_OPTION",length = 225)
	private String EMIOption;
	
	private long userId;
	
	@Column(name="APPLY_DATE")
	@Temporal(TemporalType.DATE)
	private Date date;
	
	@Column(name="STATUS",length = 225)
	private String status;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "loan")
	private Set<AssignBGVerificationDTO> assignBGVerifications;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "loan")
	private Set<AssignLoanVerificationDTO> assignLoanVerifications;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "loan")
	private Set<UpdateBGVerificationDTO> updateBGVerifications;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "loan")
	private Set<UpdateLoanVerificationDTO> updateLoanVerifications;
	
	@Column(name="REQUEST_LOAN_ID")
	private long requestLoanId;
	
	@Override
	public String getKey() {
		return String.valueOf(id);
	}

	@Override
	public String getValue() {
		return String.valueOf(requestLoanId);
	}

}
