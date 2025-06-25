package in.co.loan.granting.system.service;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import in.co.loan.granting.system.dao.FeedBackDAOInt;
import in.co.loan.granting.system.dto.FeedBackDTO;
import in.co.loan.granting.system.exception.DuplicateRecordException;






@Service
public class FeedBackServiceImpl implements FeedBackServiceInt {

	private static Logger log = Logger.getLogger(FeedBackServiceImpl.class.getName());

	@Autowired
	private FeedBackDAOInt dao;

	

	@Override
	@Transactional
	public long add(FeedBackDTO dto) throws DuplicateRecordException {
		log.info("FeedBackServiceImpl Add method start");
		long pk = dao.add(dto);
		log.info("FeedBackServiceImpl Add method end");
		return pk;
	}

	@Override
	@Transactional
	public void delete(FeedBackDTO dto) {
		log.info("FeedBackServiceImpl Delete method start");
		dao.delete(dto);
		log.info("FeedBackServiceImpl Delete method end");

	}

	@Override
	@Transactional
	public FeedBackDTO findBypk(long pk) {
		log.info("FeedBackServiceImpl findBypk method start");
		FeedBackDTO dto = dao.findBypk(pk);
		log.info("FeedBackServiceImpl findBypk method end");
		return dto;
	}

	@Override
	@Transactional
	public FeedBackDTO findByIssue(String issue) {
		log.info("FeedBackServiceImpl findByFeedBackName method start");
		FeedBackDTO dto = dao.findByIssue(issue);
		log.info("FeedBackServiceImpl findByFeedBackName method end");
		return dto;
	}

	@Override
	@Transactional
	public void update(FeedBackDTO dto) throws DuplicateRecordException {
		log.info("FeedBackServiceImpl update method start");
		dao.update(dto);
		log.info("FeedBackServiceImpl update method end");
	}

	@Override
	@Transactional
	public List<FeedBackDTO> list() {
		log.info("FeedBackServiceImpl list method start");
		List<FeedBackDTO> list = dao.list();
		log.info("FeedBackServiceImpl list method end");
		return list;
	}

	@Override
	@Transactional
	public List<FeedBackDTO> list(int pageNo, int pageSize) {
		log.info("FeedBackServiceImpl list method start");
		List<FeedBackDTO> list = dao.list(pageNo, pageSize);
		log.info("FeedBackServiceImpl list method end");
		return list;
	}

	@Override
	@Transactional
	public List<FeedBackDTO> search(FeedBackDTO dto) {
		log.info("FeedBackServiceImpl search method start");
		List<FeedBackDTO> list = dao.search(dto);
		log.info("FeedBackServiceImpl search method end");
		return list;
	}

	@Override
	@Transactional
	public List<FeedBackDTO> search(FeedBackDTO dto, int pageNo, int pageSize) {
		log.info("FeedBackServiceImpl search method start");
		List<FeedBackDTO> list = dao.search(dto, pageNo, pageSize);
		log.info("FeedBackServiceImpl search method end");
		return list;
	}

	
}
