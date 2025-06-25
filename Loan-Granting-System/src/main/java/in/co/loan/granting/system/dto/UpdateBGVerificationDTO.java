package in.co.loan.granting.system.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="UPDATE_BG_VERIFICATION")
@Getter
@Setter
public class UpdateBGVerificationDTO  extends BaseDTO{

	@Column(name="FIELD_OFFICER_ID")
	private long fieldOfficerId;
	
	public long getFieldOfficerId() {
		return fieldOfficerId;
	}

	public void setFieldOfficerId(long fieldOfficerId) {
		this.fieldOfficerId = fieldOfficerId;
	}

	public String getFieldOfficerName() {
		return fieldOfficerName;
	}

	public void setFieldOfficerName(String fieldOfficerName) {
		this.fieldOfficerName = fieldOfficerName;
	}

	public long getLoanId() {
		return loanId;
	}

	public void setLoanId(long loanId) {
		this.loanId = loanId;
	}

	public long getLoanRequestId() {
		return loanRequestId;
	}

	public void setLoanRequestId(long loanRequestId) {
		this.loanRequestId = loanRequestId;
	}

	public ApplyLoanDTO getLoan() {
		return loan;
	}

	public void setLoan(ApplyLoanDTO loan) {
		this.loan = loan;
	}

	public String getVerificationUpdate() {
		return verificationUpdate;
	}

	public void setVerificationUpdate(String verificationUpdate) {
		this.verificationUpdate = verificationUpdate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public byte[] getReport() {
		return report;
	}

	public void setReport(byte[] report) {
		this.report = report;
	}

	@Column(name="FIELD_OFFICER_NAME",length = 225)
	private String fieldOfficerName;
	
	@Column(name="LOAN_ID")
	private long loanId;
	
	@Column(name="LOAN_REQUEST_ID")
	private long loanRequestId;
	
	
	@ManyToOne
	@JoinColumn(name = "LOAN",nullable = false)
	private ApplyLoanDTO loan;
	
	@Column(name="VERIFICATION_UPDATE",length = 1500)
	private String verificationUpdate;
	
	@Column(name="DESCRIPTION",length = 1500)
	private String description;
	
	@Column(name ="REPORT",columnDefinition ="LONGBLOB")
	private byte[] report;
	
	@Override
	public String getKey() {
		return null;
	}

	@Override
	public String getValue() {
		return null;
	}

}
