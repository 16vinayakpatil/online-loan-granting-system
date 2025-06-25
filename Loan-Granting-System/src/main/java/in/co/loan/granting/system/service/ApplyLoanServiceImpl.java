package in.co.loan.granting.system.service;

import java.sql.Blob;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Logger;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.sql.rowset.serial.SerialException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import in.co.loan.granting.system.dao.ApplyLoanDAOInt;
import in.co.loan.granting.system.dto.ApplyLoanDTO;
import in.co.loan.granting.system.exception.DuplicateRecordException;
import in.co.loan.granting.system.util.EmailBuilder;



@Service
public class ApplyLoanServiceImpl implements ApplyLoanServiceInt {

	private static Logger log = Logger.getLogger(ApplyLoanServiceImpl.class.getName());

	@Autowired
	private ApplyLoanDAOInt dao;

	

	@Override
	@Transactional
	public long add(ApplyLoanDTO dto) throws DuplicateRecordException {
		log.info("ApplyLoanServiceImpl Add method start");
		/*
		 * ApplyLoanDTO existDTO = dao.findByName(dto.getName()); if (existDTO != null)
		 * throw new DuplicateRecordException("Loan Is is Already Apply");
		 */
		long pk = dao.add(dto);
		log.info("ApplyLoanServiceImpl Add method end");
		return pk;
	}

	@Override
	@Transactional
	public void delete(ApplyLoanDTO dto) {
		log.info("ApplyLoanServiceImpl Delete method start");
		dao.delete(dto);
		log.info("ApplyLoanServiceImpl Delete method end");

	}

	@Override
	@Transactional
	public ApplyLoanDTO findBypk(long pk) {
		log.info("ApplyLoanServiceImpl findBypk method start");
		ApplyLoanDTO dto = dao.findBypk(pk);
		log.info("ApplyLoanServiceImpl findBypk method end");
		return dto;
	}

	@Override
	@Transactional
	public ApplyLoanDTO findByName(String name) {
		log.info("ApplyLoanServiceImpl findByApplyLoanName method start");
		ApplyLoanDTO dto = dao.findByName(name);
		log.info("ApplyLoanServiceImpl findByApplyLoanName method end");
		return dto;
	}

	@Override
	@Transactional
	public void update(ApplyLoanDTO dto) throws DuplicateRecordException {
		log.info("ApplyLoanServiceImpl update method start");
		/*
		 * ApplyLoanDTO existDTO = dao.findByName(dto.getName()); if (existDTO != null
		 * && dto.getId() != existDTO.getId()) throw new
		 * DuplicateRecordException("Loan is Already Exist");
		 */
		dao.update(dto);
		log.info("ApplyLoanServiceImpl update method end");
	}

	@Override
	@Transactional
	public List<ApplyLoanDTO> list() {
		log.info("ApplyLoanServiceImpl list method start");
		List<ApplyLoanDTO> list = dao.list();
		log.info("ApplyLoanServiceImpl list method end");
		return list;
	}

	@Override
	@Transactional
	public List<ApplyLoanDTO> list(int pageNo, int pageSize) {
		log.info("ApplyLoanServiceImpl list method start");
		List<ApplyLoanDTO> list = dao.list(pageNo, pageSize);
		log.info("ApplyLoanServiceImpl list method end");
		return list;
	}

	@Override
	@Transactional
	public List<ApplyLoanDTO> search(ApplyLoanDTO dto) {
		log.info("ApplyLoanServiceImpl search method start");
		List<ApplyLoanDTO> list = dao.search(dto);
		log.info("ApplyLoanServiceImpl search method end");
		return list;
	}

	@Override
	@Transactional
	public List<ApplyLoanDTO> search(ApplyLoanDTO dto, int pageNo, int pageSize) {
		log.info("ApplyLoanServiceImpl search method start");
		List<ApplyLoanDTO> list = dao.search(dto, pageNo, pageSize);
		log.info("ApplyLoanServiceImpl search method end");
		return list;
	}

	@Override
	@Transactional
	public Blob getFile(long id, String fieldName) throws SerialException, SQLException {
		return dao.getFile(id, fieldName);
	}

	
}
