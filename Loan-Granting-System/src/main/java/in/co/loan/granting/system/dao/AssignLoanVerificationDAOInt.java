package in.co.loan.granting.system.dao;

import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;

import javax.sql.rowset.serial.SerialException;

import in.co.loan.granting.system.dto.AssignLoanVerificationDTO;

public interface AssignLoanVerificationDAOInt {

	public long add(AssignLoanVerificationDTO dto);
	
	public void delete(AssignLoanVerificationDTO dto);
	
	public AssignLoanVerificationDTO findBypk(long pk);
	
	public AssignLoanVerificationDTO findByName(String name);
	
	public void update(AssignLoanVerificationDTO dto);
	
	public List<AssignLoanVerificationDTO> list();
	
	public List<AssignLoanVerificationDTO>list(int pageNo,int pageSize);
	
	public List<AssignLoanVerificationDTO> search(AssignLoanVerificationDTO dto);
	
	public List<AssignLoanVerificationDTO> search(AssignLoanVerificationDTO dto,int pageNo,int pageSize);
	
	
	
}
