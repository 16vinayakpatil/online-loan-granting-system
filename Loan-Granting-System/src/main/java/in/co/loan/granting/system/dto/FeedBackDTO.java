package in.co.loan.granting.system.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="FEED_BACK")
@Getter
@Setter
public class FeedBackDTO extends BaseDTO{
	
	@Column(name="QUESTION",length = 225)
	private String question;	
	
	
	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	@Override
	public String getKey() {
		return null;
	}
	
	@Override
	public String getValue() {
		return null;
	}

}
