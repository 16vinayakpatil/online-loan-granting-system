package in.co.loan.granting.system.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="ASSIGN_LOAN_VERIFICATION")
@Getter
@Setter
public class AssignLoanVerificationDTO  extends BaseDTO{

	@Column(name="LOAN_OFFICER_ID")
	private long loanOfficerId;
	
	public long getLoanOfficerId() {
		return loanOfficerId;
	}

	public void setLoanOfficerId(long loanOfficerId) {
		this.loanOfficerId = loanOfficerId;
	}

	public String getLoanOfficerName() {
		return loanOfficerName;
	}

	public void setLoanOfficerName(String loanOfficerName) {
		this.loanOfficerName = loanOfficerName;
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

	public UserDTO getLoanOfficer() {
		return loanOfficer;
	}

	public void setLoanOfficer(UserDTO loanOfficer) {
		this.loanOfficer = loanOfficer;
	}

	public ApplyLoanDTO getLoan() {
		return loan;
	}

	public void setLoan(ApplyLoanDTO loan) {
		this.loan = loan;
	}

	@Column(name="FIELD_OFFICER_NAME",length = 225)
	private String loanOfficerName;
	
	@Column(name="LOAN_ID")
	private long loanId;
	
	@Column(name="LOAN_REQUEST_ID")
	private long loanRequestId;
	
	@ManyToOne
	@JoinColumn(name = "FIELD_OFFICER",nullable = false)
	private UserDTO loanOfficer;
	
	@ManyToOne
	@JoinColumn(name = "LOAN",nullable = false)
	private ApplyLoanDTO loan;
	
	@Override
	public String getKey() {
		return null;
	}

	@Override
	public String getValue() {
		return null;
	}

}
