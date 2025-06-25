package in.co.loan.granting.system.service;

import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;

import javax.sql.rowset.serial.SerialException;

import in.co.loan.granting.system.dto.UpdateLoanVerificationDTO;
import in.co.loan.granting.system.exception.DuplicateRecordException;




public interface UpdateLoanVerificationServiceInt {

	public long add(UpdateLoanVerificationDTO dto) throws DuplicateRecordException;

	public void delete(UpdateLoanVerificationDTO dto);

	public UpdateLoanVerificationDTO findBypk(long pk);

	public UpdateLoanVerificationDTO findByName(String name);

	public void update(UpdateLoanVerificationDTO dto) throws DuplicateRecordException;

	public List<UpdateLoanVerificationDTO> list();

	public List<UpdateLoanVerificationDTO> list(int pageNo, int pageSize);

	public List<UpdateLoanVerificationDTO> search(UpdateLoanVerificationDTO dto);

	public List<UpdateLoanVerificationDTO> search(UpdateLoanVerificationDTO dto, int pageNo, int pageSize);
	
	public Blob getFile(long id) throws SerialException, SQLException;

	
}
