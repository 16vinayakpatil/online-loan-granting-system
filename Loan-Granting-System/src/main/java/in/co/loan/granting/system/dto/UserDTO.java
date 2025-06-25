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
import javax.persistence.Transient;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "USER")
@Getter
@Setter
public class UserDTO extends BaseDTO {

	@Column(name = "FIRST_NAME", length = 225)
	private String firstName;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getRoleId() {
		return roleId;
	}

	public void setRoleId(long roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPan() {
		return pan;
	}

	public void setPan(String pan) {
		this.pan = pan;
	}

	public String getUserCategory() {
		return userCategory;
	}

	public void setUserCategory(String userCategory) {
		this.userCategory = userCategory;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
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

	@Column(name = "LAST_NAME", length = 225)
	private String lastName;

	@Column(name = "USER_ID", length = 225)
	private String userId;

	@Column(name = "PASSWORD", length = 225)
	private String password;
	
	@Transient
	private String confirmPassword;
	
	@Column(name="DOB")
	@Temporal(TemporalType.DATE)
	private Date dob;
	
	@Column(name = "GENDER", length = 225)
	private String gender;
	
	@Column(name = "CONTACT_NO", length = 225)
	private String contactNo;
	
	@Column(name = "EMAIL", length = 225)
	private String email;
	
	@Column(name = "ROLE_ID")
	private long roleId;

	@Column(name = "ROLE_NAME", length = 225)
	private String roleName;
	
	@Column(name="STATUS",length = 225)
	private String status;
	
	@Column(name="PAN",length = 225)
	private String pan;

	@Column(name="USER_CATEGORY",length = 225)
	private String userCategory;
	
	@Column(name="DESIGNATION",length = 225)
	private String designation;
	
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "fieldOfficer")
	private Set<AssignBGVerificationDTO> assignBGVerifications;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "loanOfficer")
	private Set<AssignLoanVerificationDTO> assignLoanVerifications;
	
	public String getKey() {
		return id + "";
	}

	public String getValue() {

		return firstName + " " + lastName;
	}


}
