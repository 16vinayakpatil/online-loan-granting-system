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

import in.co.loan.granting.system.dao.UpdateLoanVerificationDAOInt;
import in.co.loan.granting.system.dto.UpdateLoanVerificationDTO;
import in.co.loan.granting.system.exception.DuplicateRecordException;
import in.co.loan.granting.system.util.EmailBuilder;



@Service
public class UpdateLoanVerificationServiceImpl implements UpdateLoanVerificationServiceInt {

	private static Logger log = Logger.getLogger(UpdateLoanVerificationServiceImpl.class.getName());

	@Autowired
	private UpdateLoanVerificationDAOInt dao;

	

	@Override
	@Transactional
	public long add(UpdateLoanVerificationDTO dto) throws DuplicateRecordException {
		log.info("UpdateLoanVerificationServiceImpl Add method start");
		/*
		 * UpdateLoanVerificationDTO existDTO = dao.findByName(dto.getName()); if (existDTO != null)
		 * throw new DuplicateRecordException("Loan Is is Already Apply");
		 */
		long pk = dao.add(dto);
		log.info("UpdateLoanVerificationServiceImpl Add method end");
		return pk;
	}

	@Override
	@Transactional
	public void delete(UpdateLoanVerificationDTO dto) {
		log.info("UpdateLoanVerificationServiceImpl Delete method start");
		dao.delete(dto);
		log.info("UpdateLoanVerificationServiceImpl Delete method end");

	}

	@Override
	@Transactional
	public UpdateLoanVerificationDTO findBypk(long pk) {
		log.info("UpdateLoanVerificationServiceImpl findBypk method start");
		UpdateLoanVerificationDTO dto = dao.findBypk(pk);
		log.info("UpdateLoanVerificationServiceImpl findBypk method end");
		return dto;
	}

	@Override
	@Transactional
	public UpdateLoanVerificationDTO findByName(String name) {
		log.info("UpdateLoanVerificationServiceImpl findByUpdateLoanVerificationName method start");
		UpdateLoanVerificationDTO dto = dao.findByName(name);
		log.info("UpdateLoanVerificationServiceImpl findByUpdateLoanVerificationName method end");
		return dto;
	}

	@Override
	@Transactional
	public void update(UpdateLoanVerificationDTO dto) throws DuplicateRecordException {
		log.info("UpdateLoanVerificationServiceImpl update method start");
		/*
		 * UpdateLoanVerificationDTO existDTO = dao.findByName(dto.getName()); if (existDTO != null
		 * && dto.getId() != existDTO.getId()) throw new
		 * DuplicateRecordException("Loan is Already Exist");
		 */
		dao.update(dto);
		log.info("UpdateLoanVerificationServiceImpl update method end");
	}

	@Override
	@Transactional
	public List<UpdateLoanVerificationDTO> list() {
		log.info("UpdateLoanVerificationServiceImpl list method start");
		List<UpdateLoanVerificationDTO> list = dao.list();
		log.info("UpdateLoanVerificationServiceImpl list method end");
		return list;
	}

	@Override
	@Transactional
	public List<UpdateLoanVerificationDTO> list(int pageNo, int pageSize) {
		log.info("UpdateLoanVerificationServiceImpl list method start");
		List<UpdateLoanVerificationDTO> list = dao.list(pageNo, pageSize);
		log.info("UpdateLoanVerificationServiceImpl list method end");
		return list;
	}

	@Override
	@Transactional
	public List<UpdateLoanVerificationDTO> search(UpdateLoanVerificationDTO dto) {
		log.info("UpdateLoanVerificationServiceImpl search method start");
		List<UpdateLoanVerificationDTO> list = dao.search(dto);
		log.info("UpdateLoanVerificationServiceImpl search method end");
		return list;
	}

	@Override
	@Transactional
	public List<UpdateLoanVerificationDTO> search(UpdateLoanVerificationDTO dto, int pageNo, int pageSize) {
		log.info("UpdateLoanVerificationServiceImpl search method start");
		List<UpdateLoanVerificationDTO> list = dao.search(dto, pageNo, pageSize);
		log.info("UpdateLoanVerificationServiceImpl search method end");
		return list;
	}
	
	@Override
	@Transactional
	public Blob getFile(long id) throws SerialException, SQLException {
		return dao.getFile(id);
	}



	
}
