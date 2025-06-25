package in.co.loan.granting.system.service;

import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;

import javax.sql.rowset.serial.SerialException;

import in.co.loan.granting.system.dto.ApplyLoanDTO;
import in.co.loan.granting.system.exception.DuplicateRecordException;




public interface ApplyLoanServiceInt {

	public long add(ApplyLoanDTO dto) throws DuplicateRecordException;

	public void delete(ApplyLoanDTO dto);

	public ApplyLoanDTO findBypk(long pk);

	public ApplyLoanDTO findByName(String name);

	public void update(ApplyLoanDTO dto) throws DuplicateRecordException;

	public List<ApplyLoanDTO> list();

	public List<ApplyLoanDTO> list(int pageNo, int pageSize);

	public List<ApplyLoanDTO> search(ApplyLoanDTO dto);

	public List<ApplyLoanDTO> search(ApplyLoanDTO dto, int pageNo, int pageSize);

	public Blob getFile(long id,String fieldName) throws SerialException, SQLException;
	
}
