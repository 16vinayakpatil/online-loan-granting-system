package in.co.loan.granting.system.dao;

import java.util.List;

import in.co.loan.granting.system.dto.UserFeedBackDTO;


public interface UserFeedBackDAOInt {

	public long add(UserFeedBackDTO dto);
	
	public void delete(UserFeedBackDTO dto);
	
	public UserFeedBackDTO findBypk(long pk);
	
	public UserFeedBackDTO findByIssue(String issue);
	
	public void update(UserFeedBackDTO dto);
	
	public List<UserFeedBackDTO> list();
	
	public List<UserFeedBackDTO>list(int pageNo,int pageSize);
	
	public List<UserFeedBackDTO> search(UserFeedBackDTO dto);
	
	public List<UserFeedBackDTO> search(UserFeedBackDTO dto,int pageNo,int pageSize);
	
	
}
