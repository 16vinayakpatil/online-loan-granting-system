package in.co.loan.granting.system.service;

import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;

import javax.sql.rowset.serial.SerialException;

import in.co.loan.granting.system.dto.AssignBGVerificationDTO;
import in.co.loan.granting.system.exception.DuplicateRecordException;




public interface AssignBGVerificationServiceInt {

	public long add(AssignBGVerificationDTO dto) throws DuplicateRecordException;

	public void delete(AssignBGVerificationDTO dto);

	public AssignBGVerificationDTO findBypk(long pk);

	public AssignBGVerificationDTO findByName(String name);

	public void update(AssignBGVerificationDTO dto) throws DuplicateRecordException;

	public List<AssignBGVerificationDTO> list();

	public List<AssignBGVerificationDTO> list(int pageNo, int pageSize);

	public List<AssignBGVerificationDTO> search(AssignBGVerificationDTO dto);

	public List<AssignBGVerificationDTO> search(AssignBGVerificationDTO dto, int pageNo, int pageSize);

	
}
