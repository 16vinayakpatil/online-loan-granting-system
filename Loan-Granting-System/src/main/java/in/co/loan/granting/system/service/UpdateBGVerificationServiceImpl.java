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

import in.co.loan.granting.system.dao.UpdateBGVerificationDAOInt;
import in.co.loan.granting.system.dto.UpdateBGVerificationDTO;
import in.co.loan.granting.system.exception.DuplicateRecordException;
import in.co.loan.granting.system.util.EmailBuilder;



@Service
public class UpdateBGVerificationServiceImpl implements UpdateBGVerificationServiceInt {

	private static Logger log = Logger.getLogger(UpdateBGVerificationServiceImpl.class.getName());

	@Autowired
	private UpdateBGVerificationDAOInt dao;

	

	@Override
	@Transactional
	public long add(UpdateBGVerificationDTO dto) throws DuplicateRecordException {
		log.info("UpdateBGVerificationServiceImpl Add method start");
		/*
		 * UpdateBGVerificationDTO existDTO = dao.findByName(dto.getName()); if (existDTO != null)
		 * throw new DuplicateRecordException("Loan Is is Already Apply");
		 */
		long pk = dao.add(dto);
		log.info("UpdateBGVerificationServiceImpl Add method end");
		return pk;
	}

	@Override
	@Transactional
	public void delete(UpdateBGVerificationDTO dto) {
		log.info("UpdateBGVerificationServiceImpl Delete method start");
		dao.delete(dto);
		log.info("UpdateBGVerificationServiceImpl Delete method end");

	}

	@Override
	@Transactional
	public UpdateBGVerificationDTO findBypk(long pk) {
		log.info("UpdateBGVerificationServiceImpl findBypk method start");
		UpdateBGVerificationDTO dto = dao.findBypk(pk);
		log.info("UpdateBGVerificationServiceImpl findBypk method end");
		return dto;
	}

	@Override
	@Transactional
	public UpdateBGVerificationDTO findByName(String name) {
		log.info("UpdateBGVerificationServiceImpl findByUpdateBGVerificationName method start");
		UpdateBGVerificationDTO dto = dao.findByName(name);
		log.info("UpdateBGVerificationServiceImpl findByUpdateBGVerificationName method end");
		return dto;
	}

	@Override
	@Transactional
	public void update(UpdateBGVerificationDTO dto) throws DuplicateRecordException {
		log.info("UpdateBGVerificationServiceImpl update method start");
		/*
		 * UpdateBGVerificationDTO existDTO = dao.findByName(dto.getName()); if (existDTO != null
		 * && dto.getId() != existDTO.getId()) throw new
		 * DuplicateRecordException("Loan is Already Exist");
		 */
		dao.update(dto);
		log.info("UpdateBGVerificationServiceImpl update method end");
	}

	@Override
	@Transactional
	public List<UpdateBGVerificationDTO> list() {
		log.info("UpdateBGVerificationServiceImpl list method start");
		List<UpdateBGVerificationDTO> list = dao.list();
		log.info("UpdateBGVerificationServiceImpl list method end");
		return list;
	}

	@Override
	@Transactional
	public List<UpdateBGVerificationDTO> list(int pageNo, int pageSize) {
		log.info("UpdateBGVerificationServiceImpl list method start");
		List<UpdateBGVerificationDTO> list = dao.list(pageNo, pageSize);
		log.info("UpdateBGVerificationServiceImpl list method end");
		return list;
	}

	@Override
	@Transactional
	public List<UpdateBGVerificationDTO> search(UpdateBGVerificationDTO dto) {
		log.info("UpdateBGVerificationServiceImpl search method start");
		List<UpdateBGVerificationDTO> list = dao.search(dto);
		log.info("UpdateBGVerificationServiceImpl search method end");
		return list;
	}

	@Override
	@Transactional
	public List<UpdateBGVerificationDTO> search(UpdateBGVerificationDTO dto, int pageNo, int pageSize) {
		log.info("UpdateBGVerificationServiceImpl search method start");
		List<UpdateBGVerificationDTO> list = dao.search(dto, pageNo, pageSize);
		log.info("UpdateBGVerificationServiceImpl search method end");
		return list;
	}
	
	@Override
	@Transactional
	public Blob getFile(long id) throws SerialException, SQLException {
		return dao.getFile(id);
	}



	
}
