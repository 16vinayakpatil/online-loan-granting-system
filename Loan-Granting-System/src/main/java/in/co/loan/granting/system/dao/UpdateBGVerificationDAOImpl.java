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
import in.co.loan.granting.system.dto.UpdateBGVerificationDTO;


@Repository
public class UpdateBGVerificationDAOImpl implements UpdateBGVerificationDAOInt {

	private static Logger log = Logger.getLogger(UpdateBGVerificationDAOImpl.class.getName());

	@Autowired
	private EntityManager entityManager;

	@Override
	public long add(UpdateBGVerificationDTO dto) {
		log.info("UpdateBGVerificationDAOImpl Add method Start");
		Session session = entityManager.unwrap(Session.class);
		long pk = (long) session.save(dto);
		log.info("UpdateBGVerificationDAOImpl Add method End");
		return pk;
	}

	@Override
	public void delete(UpdateBGVerificationDTO dto) {
		log.info("UpdateBGVerificationDAOImpl Delete method Start");
		entityManager.remove(entityManager.contains(dto) ? dto : entityManager.merge(dto));
		log.info("UpdateBGVerificationDAOImpl Delete method End");

	}

	@Override
	public UpdateBGVerificationDTO findBypk(long pk) {
		log.info("UpdateBGVerificationDAOImpl FindByPk method Start");
		Session session = entityManager.unwrap(Session.class);
		UpdateBGVerificationDTO dto = (UpdateBGVerificationDTO) session.get(UpdateBGVerificationDTO.class, pk);
		log.info("UpdateBGVerificationDAOImpl FindByPk method End");
		return dto;
	}

	@Override
	public UpdateBGVerificationDTO findByName(String name) {
		log.info("UpdateBGVerificationDAOImpl FindByLogin method Start");
		Session session = entityManager.unwrap(Session.class);
		Criteria criteria = session.createCriteria(UpdateBGVerificationDTO.class);
		criteria.add(Restrictions.eq("name",name));
		UpdateBGVerificationDTO dto = (UpdateBGVerificationDTO) criteria.uniqueResult();
		log.info("UpdateBGVerificationDAOImpl FindByLogin method End");
		return dto;
	}

	@Override
	public void update(UpdateBGVerificationDTO dto) {
		log.info("UpdateBGVerificationDAOImpl Update method Start");
		Session session = entityManager.unwrap(Session.class);
		session.merge(dto);
		log.info("UpdateBGVerificationDAOImpl update method End");
	}

	@Override
	public List<UpdateBGVerificationDTO> list() {
		return list(0, 0);
	}

	@Override
	public List<UpdateBGVerificationDTO> list(int pageNo, int pageSize) {
		log.info("UpdateBGVerificationDAOImpl List method Start");
		Session session = entityManager.unwrap(Session.class);
		Query<UpdateBGVerificationDTO> query = session.createQuery("from UpdateBGVerificationDTO", UpdateBGVerificationDTO.class);
		List<UpdateBGVerificationDTO> list = query.getResultList();
		log.info("UpdateBGVerificationDAOImpl List method End");
		return list;
	}

	@Override
	public List<UpdateBGVerificationDTO> search(UpdateBGVerificationDTO dto) {
		return search(dto, 0, 0);
	}

	@Override
	public List<UpdateBGVerificationDTO> search(UpdateBGVerificationDTO dto, int pageNo, int pageSize) {
		log.info("UpdateBGVerificationDAOImpl Search method Start");
		Session session = entityManager.unwrap(Session.class);
		StringBuffer hql = new StringBuffer("from UpdateBGVerificationDTO as u where 1=1 ");
		if (dto != null) {
			if (dto.getId() > 0) {
				hql.append("and u.id = " + dto.getId());
			}
			/*
			 * if (dto.getRoleId() > 0) { hql.append("and u.roleId = " + dto.getRoleId()); }
			 */
			
			if (dto.getFieldOfficerId() > 0) {
				hql.append("and u.fieldOfficerId = " + dto.getFieldOfficerId());
			}
			
			if (dto.getLoanRequestId() > 0) {
				hql.append("and u.loanRequestId = " + dto.getLoanRequestId());
			}
			
			if (dto.getFieldOfficerName() != null && dto.getFieldOfficerName().length() >0) {
				hql.append("and u.fieldOfficerName like '" + dto.getFieldOfficerName()+"%'");
			}
		
			
		
		}
		Query<UpdateBGVerificationDTO> query = session.createQuery(hql.toString(), UpdateBGVerificationDTO.class);
		if (pageNo > 0) {
			pageNo = (pageNo - 1) * pageSize;
			query.setFirstResult(pageNo);
			query.setMaxResults(pageSize);
		}
		List<UpdateBGVerificationDTO> list = query.getResultList();
		log.info("UpdateBGVerificationDAOImpl Search method End");
		return list;
	}
	
	@Override
	public Blob getFile(long id) throws SerialException, SQLException {
		Session session = entityManager.unwrap(Session.class);
		UpdateBGVerificationDTO person = (UpdateBGVerificationDTO) session.get(UpdateBGVerificationDTO.class, id);
		byte[] blob=null;
			blob = person.getReport();
		Blob bBlob = new SerialBlob(blob);
		return bBlob;
	}

}
