package in.co.loan.granting.system.service;

import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;

import javax.sql.rowset.serial.SerialException;

import in.co.loan.granting.system.dto.AssignLoanVerificationDTO;
import in.co.loan.granting.system.exception.DuplicateRecordException;




public interface AssignLoanVerificationServiceInt {

	public long add(AssignLoanVerificationDTO dto) throws DuplicateRecordException;

	public void delete(AssignLoanVerificationDTO dto);

	public AssignLoanVerificationDTO findBypk(long pk);

	public AssignLoanVerificationDTO findByName(String name);

	public void update(AssignLoanVerificationDTO dto) throws DuplicateRecordException;

	public List<AssignLoanVerificationDTO> list();

	public List<AssignLoanVerificationDTO> list(int pageNo, int pageSize);

	public List<AssignLoanVerificationDTO> search(AssignLoanVerificationDTO dto);

	public List<AssignLoanVerificationDTO> search(AssignLoanVerificationDTO dto, int pageNo, int pageSize);

	
}
