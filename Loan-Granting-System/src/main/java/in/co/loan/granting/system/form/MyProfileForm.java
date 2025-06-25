package in.co.loan.granting.system.form;
import javax.validation.constraints.NotEmpty;

import in.co.loan.granting.system.dto.BaseDTO;
import in.co.loan.granting.system.dto.UserDTO;
import in.co.loan.granting.system.util.DataUtility;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MyProfileForm extends BaseForm {

	@NotEmpty(message = "First Name is required")
	private String firstName;

	@NotEmpty(message = "Last Name is required")
	private String lastName;

	@NotEmpty(message = "User Id is required")
	private String userId;

	@NotEmpty(message = "ContactNo is required")
	private String contactNo;
	
	@NotEmpty(message = "Date of birth is required")
	private String dob;
	
	@NotEmpty(message = "Email Id is required")
	private String email;
	
	
	
	public BaseDTO getDTO() {
		UserDTO bean = new UserDTO();
		bean.setId(id);
		bean.setFirstName(firstName);
		bean.setLastName(lastName);
		bean.setUserId(userId);
		bean.setContactNo(contactNo);
		bean.setDob(DataUtility.getDate(dob));
		bean.setEmail(email);
		bean.setCreatedBy(createdBy);
		bean.setModifiedBy(modifiedBy);
		bean.setCreatedDatetime(createdDateTime);
		bean.setModifiedDatetime(modifiedDateTime);
		return bean;
	}

	
	public void populate(BaseDTO bDto) {
		UserDTO bean = (UserDTO) bDto;
		id=bean.getId();
		firstName=bean.getFirstName();
		lastName=bean.getLastName();
		userId=bean.getUserId();
		contactNo=bean.getContactNo();
		dob=DataUtility.getDateString(bean.getDob());
		email=bean.getEmail();
		createdBy=bean.getCreatedBy();
		modifiedBy=bean.getModifiedBy();
		createdDateTime=bean.getCreatedDatetime();
		modifiedDateTime=bean.getModifiedDatetime();

	}

	

}
