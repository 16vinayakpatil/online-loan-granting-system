package in.co.loan.granting.system.service;

import java.util.List;

import in.co.loan.granting.system.dto.UserDTO;
import in.co.loan.granting.system.exception.DuplicateRecordException;




public interface UserServiceInt {

	public long add(UserDTO dto) throws DuplicateRecordException;

	public void delete(UserDTO dto);

	public UserDTO findBypk(long pk);

	public UserDTO findByUserId(String userId);

	public void update(UserDTO dto) throws DuplicateRecordException;

	public List<UserDTO> list();

	public List<UserDTO> list(int pageNo, int pageSize);

	public List<UserDTO> search(UserDTO dto);

	public List<UserDTO> search(UserDTO dto, int pageNo, int pageSize);

	public UserDTO authentication(UserDTO dto);

	public boolean changePassword(Long id, String oldPassword, String newPassword);

	public boolean forgetPassword(String login);

	public long register(UserDTO dto) throws DuplicateRecordException;

}
