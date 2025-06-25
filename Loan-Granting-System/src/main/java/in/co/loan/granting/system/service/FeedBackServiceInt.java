package in.co.loan.granting.system.service;

import java.util.List;

import in.co.loan.granting.system.dto.FeedBackDTO;
import in.co.loan.granting.system.exception.DuplicateRecordException;




public interface FeedBackServiceInt {

	public long add(FeedBackDTO dto) throws DuplicateRecordException;

	public void delete(FeedBackDTO dto);

	public FeedBackDTO findBypk(long pk);

	public FeedBackDTO findByIssue(String issue);

	public void update(FeedBackDTO dto) throws DuplicateRecordException;

	public List<FeedBackDTO> list();

	public List<FeedBackDTO> list(int pageNo, int pageSize);

	public List<FeedBackDTO> search(FeedBackDTO dto);

	public List<FeedBackDTO> search(FeedBackDTO dto, int pageNo, int pageSize);

	

}
