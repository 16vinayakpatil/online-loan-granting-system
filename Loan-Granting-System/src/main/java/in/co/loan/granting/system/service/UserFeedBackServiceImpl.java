package in.co.loan.granting.system.service;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import in.co.loan.granting.system.dao.UserFeedBackDAOInt;
import in.co.loan.granting.system.dto.UserFeedBackDTO;
import in.co.loan.granting.system.exception.DuplicateRecordException;







@Service
public class UserFeedBackServiceImpl implements UserFeedBackServiceInt {

	private static Logger log = Logger.getLogger(UserFeedBackServiceImpl.class.getName());

	@Autowired
	private UserFeedBackDAOInt dao;

	

	@Override
	@Transactional
	public long add(UserFeedBackDTO dto) throws DuplicateRecordException {
		log.info("UserFeedBackServiceImpl Add method start");
		long pk = dao.add(dto);
		log.info("UserFeedBackServiceImpl Add method end");
		return pk;
	}

	@Override
	@Transactional
	public void delete(UserFeedBackDTO dto) {
		log.info("UserFeedBackServiceImpl Delete method start");
		dao.delete(dto);
		log.info("UserFeedBackServiceImpl Delete method end");

	}

	@Override
	@Transactional
	public UserFeedBackDTO findBypk(long pk) {
		log.info("UserFeedBackServiceImpl findBypk method start");
		UserFeedBackDTO dto = dao.findBypk(pk);
		log.info("UserFeedBackServiceImpl findBypk method end");
		return dto;
	}

	@Override
	@Transactional
	public UserFeedBackDTO findByIssue(String issue) {
		log.info("UserFeedBackServiceImpl findByUserFeedBackName method start");
		UserFeedBackDTO dto = dao.findByIssue(issue);
		log.info("UserFeedBackServiceImpl findByUserFeedBackName method end");
		return dto;
	}

	@Override
	@Transactional
	public void update(UserFeedBackDTO dto) throws DuplicateRecordException {
		log.info("UserFeedBackServiceImpl update method start");
		dao.update(dto);
		log.info("UserFeedBackServiceImpl update method end");
	}

	@Override
	@Transactional
	public List<UserFeedBackDTO> list() {
		log.info("UserFeedBackServiceImpl list method start");
		List<UserFeedBackDTO> list = dao.list();
		log.info("UserFeedBackServiceImpl list method end");
		return list;
	}

	@Override
	@Transactional
	public List<UserFeedBackDTO> list(int pageNo, int pageSize) {
		log.info("UserFeedBackServiceImpl list method start");
		List<UserFeedBackDTO> list = dao.list(pageNo, pageSize);
		log.info("UserFeedBackServiceImpl list method end");
		return list;
	}

	@Override
	@Transactional
	public List<UserFeedBackDTO> search(UserFeedBackDTO dto) {
		log.info("UserFeedBackServiceImpl search method start");
		List<UserFeedBackDTO> list = dao.search(dto);
		log.info("UserFeedBackServiceImpl search method end");
		return list;
	}

	@Override
	@Transactional
	public List<UserFeedBackDTO> search(UserFeedBackDTO dto, int pageNo, int pageSize) {
		log.info("UserFeedBackServiceImpl search method start");
		List<UserFeedBackDTO> list = dao.search(dto, pageNo, pageSize);
		log.info("UserFeedBackServiceImpl search method end");
		return list;
	}

	
}
