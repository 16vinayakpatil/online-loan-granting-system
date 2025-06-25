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

import in.co.loan.granting.system.dao.AssignBGVerificationDAOInt;
import in.co.loan.granting.system.dto.AssignBGVerificationDTO;
import in.co.loan.granting.system.exception.DuplicateRecordException;
import in.co.loan.granting.system.util.EmailBuilder;



@Service
public class AssignBGVerificationServiceImpl implements AssignBGVerificationServiceInt {

	private static Logger log = Logger.getLogger(AssignBGVerificationServiceImpl.class.getName());

	@Autowired
	private AssignBGVerificationDAOInt dao;

	

	@Override
	@Transactional
	public long add(AssignBGVerificationDTO dto) throws DuplicateRecordException {
		log.info("AssignBGVerificationServiceImpl Add method start");
		/*
		 * AssignBGVerificationDTO existDTO = dao.findByName(dto.getName()); if (existDTO != null)
		 * throw new DuplicateRecordException("Loan Is is Already Apply");
		 */
		long pk = dao.add(dto);
		log.info("AssignBGVerificationServiceImpl Add method end");
		return pk;
	}

	@Override
	@Transactional
	public void delete(AssignBGVerificationDTO dto) {
		log.info("AssignBGVerificationServiceImpl Delete method start");
		dao.delete(dto);
		log.info("AssignBGVerificationServiceImpl Delete method end");

	}

	@Override
	@Transactional
	public AssignBGVerificationDTO findBypk(long pk) {
		log.info("AssignBGVerificationServiceImpl findBypk method start");
		AssignBGVerificationDTO dto = dao.findBypk(pk);
		log.info("AssignBGVerificationServiceImpl findBypk method end");
		return dto;
	}

	@Override
	@Transactional
	public AssignBGVerificationDTO findByName(String name) {
		log.info("AssignBGVerificationServiceImpl findByAssignBGVerificationName method start");
		AssignBGVerificationDTO dto = dao.findByName(name);
		log.info("AssignBGVerificationServiceImpl findByAssignBGVerificationName method end");
		return dto;
	}

	@Override
	@Transactional
	public void update(AssignBGVerificationDTO dto) throws DuplicateRecordException {
		log.info("AssignBGVerificationServiceImpl update method start");
		/*
		 * AssignBGVerificationDTO existDTO = dao.findByName(dto.getName()); if (existDTO != null
		 * && dto.getId() != existDTO.getId()) throw new
		 * DuplicateRecordException("Loan is Already Exist");
		 */
		dao.update(dto);
		log.info("AssignBGVerificationServiceImpl update method end");
	}

	@Override
	@Transactional
	public List<AssignBGVerificationDTO> list() {
		log.info("AssignBGVerificationServiceImpl list method start");
		List<AssignBGVerificationDTO> list = dao.list();
		log.info("AssignBGVerificationServiceImpl list method end");
		return list;
	}

	@Override
	@Transactional
	public List<AssignBGVerificationDTO> list(int pageNo, int pageSize) {
		log.info("AssignBGVerificationServiceImpl list method start");
		List<AssignBGVerificationDTO> list = dao.list(pageNo, pageSize);
		log.info("AssignBGVerificationServiceImpl list method end");
		return list;
	}

	@Override
	@Transactional
	public List<AssignBGVerificationDTO> search(AssignBGVerificationDTO dto) {
		log.info("AssignBGVerificationServiceImpl search method start");
		List<AssignBGVerificationDTO> list = dao.search(dto);
		log.info("AssignBGVerificationServiceImpl search method end");
		return list;
	}

	@Override
	@Transactional
	public List<AssignBGVerificationDTO> search(AssignBGVerificationDTO dto, int pageNo, int pageSize) {
		log.info("AssignBGVerificationServiceImpl search method start");
		List<AssignBGVerificationDTO> list = dao.search(dto, pageNo, pageSize);
		log.info("AssignBGVerificationServiceImpl search method end");
		return list;
	}



	
}
