package in.co.loan.granting.system.service;

import java.util.List;

import in.co.loan.granting.system.dto.HelpDTO;
import in.co.loan.granting.system.exception.DuplicateRecordException;




public interface HelpServiceInt {

	public long add(HelpDTO dto) throws DuplicateRecordException;

	public void delete(HelpDTO dto);

	public HelpDTO findBypk(long pk);

	public HelpDTO findByIssue(String issue);

	public void update(HelpDTO dto) throws DuplicateRecordException;

	public List<HelpDTO> list();

	public List<HelpDTO> list(int pageNo, int pageSize);

	public List<HelpDTO> search(HelpDTO dto);

	public List<HelpDTO> search(HelpDTO dto, int pageNo, int pageSize);

	

}
