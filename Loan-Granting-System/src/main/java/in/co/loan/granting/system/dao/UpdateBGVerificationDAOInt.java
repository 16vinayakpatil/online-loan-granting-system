package in.co.loan.granting.system.dao;

import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;

import javax.sql.rowset.serial.SerialException;

import in.co.loan.granting.system.dto.UpdateBGVerificationDTO;

public interface UpdateBGVerificationDAOInt {

	public long add(UpdateBGVerificationDTO dto);
	
	public void delete(UpdateBGVerificationDTO dto);
	
	public UpdateBGVerificationDTO findBypk(long pk);
	
	public UpdateBGVerificationDTO findByName(String name);
	
	public void update(UpdateBGVerificationDTO dto);
	
	public List<UpdateBGVerificationDTO> list();
	
	public List<UpdateBGVerificationDTO>list(int pageNo,int pageSize);
	
	public List<UpdateBGVerificationDTO> search(UpdateBGVerificationDTO dto);
	
	public List<UpdateBGVerificationDTO> search(UpdateBGVerificationDTO dto,int pageNo,int pageSize);
	
	public Blob getFile(long id) throws SerialException, SQLException;
	
	
	
}
