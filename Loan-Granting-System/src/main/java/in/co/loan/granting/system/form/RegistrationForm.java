package in.co.loan.granting.system.form;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import in.co.loan.granting.system.dto.BaseDTO;
import in.co.loan.granting.system.dto.UserDTO;
import in.co.loan.granting.system.util.DataUtility;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegistrationForm extends BaseForm {

	@NotEmpty(message = "First Name is required")
	private String firstName;

	@NotEmpty(message = "Last Name is required")
	private String lastName;

	@NotEmpty(message = "User Id is required")
	private String userId;

	@NotEmpty(message = "Password is required")
	private String password;

	@NotEmpty(message = "Confirm Password is required")
	private String confirmPassword;

	@NotEmpty(message = "ContactNo is required")
	private String contactNo;
	
	@NotEmpty(message = "Gender is required")
	private String gender;
	
	@NotEmpty(message = "Date of birth is required")
	private String dob;
	
	@NotEmpty(message = "Email Id is required")
	private String email;
	
	@NotEmpty(message = "PAN is required")
	private String pan;
	
	@NotEmpty(message = "Designation is required")
	private String designation;
	
	@NotEmpty(message = "Role Name is required")	
	private String roleName;
	
	@Min(value = 1,message = "User Category is required")
	private String roleId;

	@Override
	public BaseDTO getDTO() {
		UserDTO bean=new UserDTO();
		bean.setId(id);
		bean.setFirstName(firstName);
		bean.setLastName(lastName);
		bean.setUserId(userId);
		bean.setDesignation(designation);
		bean.setRoleName(roleName);
		bean.setPassword(password);
		bean.setContactNo(contactNo);
		bean.setRoleId(DataUtility.getLong(roleId));
		bean.setGender(gender);
		bean.setDob(DataUtility.getDate(dob));
		bean.setPan(pan);
		bean.setEmail(email);
		bean.setCreatedBy(createdBy);
		bean.setModifiedBy(modifiedBy);
		bean.setCreatedDatetime(createdDateTime);
		bean.setModifiedDatetime(modifiedDateTime);
		return bean;
	}
	@Override
	public void populate(BaseDTO baseBean) {
		UserDTO bean=(UserDTO)baseBean;
		id=bean.getId();
		firstName=bean.getFirstName();
		lastName=bean.getLastName();
		roleId=String.valueOf(bean.getRoleId());
		userId=bean.getUserId();
		password=bean.getPassword();
		contactNo=bean.getContactNo();
		designation=bean.getDesignation();
		roleName=bean.getRoleName();
		gender=bean.getGender();
		pan=bean.getPan();
		dob=DataUtility.getDateString(bean.getDob());
		email=bean.getEmail();
		createdBy=bean.getCreatedBy();
		modifiedBy=bean.getModifiedBy();
		createdDateTime=bean.getCreatedDatetime();
		modifiedDateTime=bean.getModifiedDatetime();
	}
}
