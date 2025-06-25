package in.co.loan.granting.system.dao;

import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.sql.rowset.serial.SerialBlob;
import javax.sql.rowset.serial.SerialException;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import in.co.loan.granting.system.dto.ApplyLoanDTO;
import in.co.loan.granting.system.dto.UpdateLoanVerificationDTO;


@Repository
public class UpdateLoanVerificationDAOImpl implements UpdateLoanVerificationDAOInt {

	private static Logger log = Logger.getLogger(UpdateLoanVerificationDAOImpl.class.getName());

	@Autowired
	private EntityManager entityManager;

	@Override
	public long add(UpdateLoanVerificationDTO dto) {
		log.info("UpdateLoanVerificationDAOImpl Add method Start");
		Session session = entityManager.unwrap(Session.class);
		long pk = (long) session.save(dto);
		log.info("UpdateLoanVerificationDAOImpl Add method End");
		return pk;
	}

	@Override
	public void delete(UpdateLoanVerificationDTO dto) {
		log.info("UpdateLoanVerificationDAOImpl Delete method Start");
		entityManager.remove(entityManager.contains(dto) ? dto : entityManager.merge(dto));
		log.info("UpdateLoanVerificationDAOImpl Delete method End");

	}

	@Override
	public UpdateLoanVerificationDTO findBypk(long pk) {
		log.info("UpdateLoanVerificationDAOImpl FindByPk method Start");
		Session session = entityManager.unwrap(Session.class);
		UpdateLoanVerificationDTO dto = (UpdateLoanVerificationDTO) session.get(UpdateLoanVerificationDTO.class, pk);
		log.info("UpdateLoanVerificationDAOImpl FindByPk method End");
		return dto;
	}

	@Override
	public UpdateLoanVerificationDTO findByName(String name) {
		log.info("UpdateLoanVerificationDAOImpl FindByLogin method Start");
		Session session = entityManager.unwrap(Session.class);
		Criteria criteria = session.createCriteria(UpdateLoanVerificationDTO.class);
		criteria.add(Restrictions.eq("name",name));
		UpdateLoanVerificationDTO dto = (UpdateLoanVerificationDTO) criteria.uniqueResult();
		log.info("UpdateLoanVerificationDAOImpl FindByLogin method End");
		return dto;
	}

	@Override
	public void update(UpdateLoanVerificationDTO dto) {
		log.info("UpdateLoanVerificationDAOImpl Update method Start");
		Session session = entityManager.unwrap(Session.class);
		session.merge(dto);
		log.info("UpdateLoanVerificationDAOImpl update method End");
	}

	@Override
	public List<UpdateLoanVerificationDTO> list() {
		return list(0, 0);
	}

	@Override
	public List<UpdateLoanVerificationDTO> list(int pageNo, int pageSize) {
		log.info("UpdateLoanVerificationDAOImpl List method Start");
		Session session = entityManager.unwrap(Session.class);
		Query<UpdateLoanVerificationDTO> query = session.createQuery("from UpdateLoanVerificationDTO", UpdateLoanVerificationDTO.class);
		List<UpdateLoanVerificationDTO> list = query.getResultList();
		log.info("UpdateLoanVerificationDAOImpl List method End");
		return list;
	}

	@Override
	public List<UpdateLoanVerificationDTO> search(UpdateLoanVerificationDTO dto) {
		return search(dto, 0, 0);
	}

	@Override
	public List<UpdateLoanVerificationDTO> search(UpdateLoanVerificationDTO dto, int pageNo, int pageSize) {
		log.info("UpdateLoanVerificationDAOImpl Search method Start");
		Session session = entityManager.unwrap(Session.class);
		StringBuffer hql = new StringBuffer("from UpdateLoanVerificationDTO as u where 1=1 ");
		if (dto != null) {
			if (dto.getId() > 0) {
				hql.append("and u.id = " + dto.getId());
			}
			/*
			 * if (dto.getRoleId() > 0) { hql.append("and u.roleId = " + dto.getRoleId()); }
			 */
			
			if (dto.getLoanOfficerId() > 0) {
				hql.append("and u.loanOfficerId = " + dto.getLoanOfficerId());
			}
			
			if (dto.getLoanRequestId() > 0) {
				hql.append("and u.loanRequestId = " + dto.getLoanRequestId());
			}
			
			if (dto.getLoanOfficerName() != null && dto.getLoanOfficerName().length() >0) {
				hql.append("and u.loanOfficerName like '" + dto.getLoanOfficerName()+"%'");
			}
		
			
		
		}
		Query<UpdateLoanVerificationDTO> query = session.createQuery(hql.toString(), UpdateLoanVerificationDTO.class);
		if (pageNo > 0) {
			pageNo = (pageNo - 1) * pageSize;
			query.setFirstResult(pageNo);
			query.setMaxResults(pageSize);
		}
		List<UpdateLoanVerificationDTO> list = query.getResultList();
		log.info("UpdateLoanVerificationDAOImpl Search method End");
		return list;
	}
	
	@Override
	public Blob getFile(long id) throws SerialException, SQLException {
		Session session = entityManager.unwrap(Session.class);
		UpdateLoanVerificationDTO person = (UpdateLoanVerificationDTO) session.get(UpdateLoanVerificationDTO.class, id);
		byte[] blob=null;
			blob = person.getReport();
		Blob bBlob = new SerialBlob(blob);
		return bBlob;
	}

}
