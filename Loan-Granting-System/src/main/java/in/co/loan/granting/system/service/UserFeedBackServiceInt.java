package in.co.loan.granting.system.service;

import java.util.List;

import in.co.loan.granting.system.dto.UserFeedBackDTO;
import in.co.loan.granting.system.exception.DuplicateRecordException;


public interface UserFeedBackServiceInt {

	public long add(UserFeedBackDTO dto) throws DuplicateRecordException;

	public void delete(UserFeedBackDTO dto);

	public UserFeedBackDTO findBypk(long pk);

	public UserFeedBackDTO findByIssue(String issue);

	public void update(UserFeedBackDTO dto) throws DuplicateRecordException;

	public List<UserFeedBackDTO> list();

	public List<UserFeedBackDTO> list(int pageNo, int pageSize);

	public List<UserFeedBackDTO> search(UserFeedBackDTO dto);

	public List<UserFeedBackDTO> search(UserFeedBackDTO dto, int pageNo, int pageSize);

	

}
