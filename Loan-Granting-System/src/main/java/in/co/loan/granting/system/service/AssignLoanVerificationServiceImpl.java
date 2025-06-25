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

import in.co.loan.granting.system.dao.AssignLoanVerificationDAOInt;
import in.co.loan.granting.system.dto.AssignLoanVerificationDTO;
import in.co.loan.granting.system.exception.DuplicateRecordException;
import in.co.loan.granting.system.util.EmailBuilder;



@Service
public class AssignLoanVerificationServiceImpl implements AssignLoanVerificationServiceInt {

	private static Logger log = Logger.getLogger(AssignLoanVerificationServiceImpl.class.getName());

	@Autowired
	private AssignLoanVerificationDAOInt dao;

	

	@Override
	@Transactional
	public long add(AssignLoanVerificationDTO dto) throws DuplicateRecordException {
		log.info("AssignLoanVerificationServiceImpl Add method start");
		/*
		 * AssignLoanVerificationDTO existDTO = dao.findByName(dto.getName()); if (existDTO != null)
		 * throw new DuplicateRecordException("Loan Is is Already Apply");
		 */
		long pk = dao.add(dto);
		log.info("AssignLoanVerificationServiceImpl Add method end");
		return pk;
	}

	@Override
	@Transactional
	public void delete(AssignLoanVerificationDTO dto) {
		log.info("AssignLoanVerificationServiceImpl Delete method start");
		dao.delete(dto);
		log.info("AssignLoanVerificationServiceImpl Delete method end");

	}

	@Override
	@Transactional
	public AssignLoanVerificationDTO findBypk(long pk) {
		log.info("AssignLoanVerificationServiceImpl findBypk method start");
		AssignLoanVerificationDTO dto = dao.findBypk(pk);
		log.info("AssignLoanVerificationServiceImpl findBypk method end");
		return dto;
	}

	@Override
	@Transactional
	public AssignLoanVerificationDTO findByName(String name) {
		log.info("AssignLoanVerificationServiceImpl findByAssignLoanVerificationName method start");
		AssignLoanVerificationDTO dto = dao.findByName(name);
		log.info("AssignLoanVerificationServiceImpl findByAssignLoanVerificationName method end");
		return dto;
	}

	@Override
	@Transactional
	public void update(AssignLoanVerificationDTO dto) throws DuplicateRecordException {
		log.info("AssignLoanVerificationServiceImpl update method start");
		/*
		 * AssignLoanVerificationDTO existDTO = dao.findByName(dto.getName()); if (existDTO != null
		 * && dto.getId() != existDTO.getId()) throw new
		 * DuplicateRecordException("Loan is Already Exist");
		 */
		dao.update(dto);
		log.info("AssignLoanVerificationServiceImpl update method end");
	}

	@Override
	@Transactional
	public List<AssignLoanVerificationDTO> list() {
		log.info("AssignLoanVerificationServiceImpl list method start");
		List<AssignLoanVerificationDTO> list = dao.list();
		log.info("AssignLoanVerificationServiceImpl list method end");
		return list;
	}

	@Override
	@Transactional
	public List<AssignLoanVerificationDTO> list(int pageNo, int pageSize) {
		log.info("AssignLoanVerificationServiceImpl list method start");
		List<AssignLoanVerificationDTO> list = dao.list(pageNo, pageSize);
		log.info("AssignLoanVerificationServiceImpl list method end");
		return list;
	}

	@Override
	@Transactional
	public List<AssignLoanVerificationDTO> search(AssignLoanVerificationDTO dto) {
		log.info("AssignLoanVerificationServiceImpl search method start");
		List<AssignLoanVerificationDTO> list = dao.search(dto);
		log.info("AssignLoanVerificationServiceImpl search method end");
		return list;
	}

	@Override
	@Transactional
	public List<AssignLoanVerificationDTO> search(AssignLoanVerificationDTO dto, int pageNo, int pageSize) {
		log.info("AssignLoanVerificationServiceImpl search method start");
		List<AssignLoanVerificationDTO> list = dao.search(dto, pageNo, pageSize);
		log.info("AssignLoanVerificationServiceImpl search method end");
		return list;
	}



	
}
