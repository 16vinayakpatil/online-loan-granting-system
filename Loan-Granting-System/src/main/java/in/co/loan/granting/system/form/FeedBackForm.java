package in.co.loan.granting.system.form;

import javax.validation.constraints.NotEmpty;

import in.co.loan.granting.system.dto.BaseDTO;
import in.co.loan.granting.system.dto.FeedBackDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FeedBackForm extends BaseForm {

	
	
	@NotEmpty(message = "Question is required")
	private String question;
	

	

	@Override
	public BaseDTO getDTO() {
		FeedBackDTO bean=new FeedBackDTO();
		bean.setId(id);
		bean.setQuestion(question);
		bean.setCreatedBy(createdBy);
		bean.setModifiedBy(modifiedBy);
		bean.setCreatedDatetime(createdDateTime);
		bean.setModifiedDatetime(modifiedDateTime);
		return bean;
	}

	@Override
	public void populate(BaseDTO bDto) {
		FeedBackDTO bean=(FeedBackDTO)bDto;
		id=bean.getId();
		question=bean.getQuestion();
		createdBy=bean.getCreatedBy();
		modifiedBy=bean.getModifiedBy();
		createdDateTime=bean.getCreatedDatetime();
		modifiedDateTime=bean.getModifiedDatetime();
	}

}
