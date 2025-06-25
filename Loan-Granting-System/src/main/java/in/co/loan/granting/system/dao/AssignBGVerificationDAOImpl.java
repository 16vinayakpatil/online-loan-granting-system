package in.co.loan.granting.system.dao;

import java.util.List;
import java.util.logging.Logger;

import javax.persistence.EntityManager;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import in.co.loan.granting.system.dto.AssignBGVerificationDTO;


@Repository
public class AssignBGVerificationDAOImpl implements AssignBGVerificationDAOInt {

	private static Logger log = Logger.getLogger(AssignBGVerificationDAOImpl.class.getName());

	@Autowired
	private EntityManager entityManager;

	@Override
	public long add(AssignBGVerificationDTO dto) {
		log.info("AssignBGVerificationDAOImpl Add method Start");
		Session session = entityManager.unwrap(Session.class);
		long pk = (long) session.save(dto);
		log.info("AssignBGVerificationDAOImpl Add method End");
		return pk;
	}

	@Override
	public void delete(AssignBGVerificationDTO dto) {
		log.info("AssignBGVerificationDAOImpl Delete method Start");
		entityManager.remove(entityManager.contains(dto) ? dto : entityManager.merge(dto));
		log.info("AssignBGVerificationDAOImpl Delete method End");

	}

	@Override
	public AssignBGVerificationDTO findBypk(long pk) {
		log.info("AssignBGVerificationDAOImpl FindByPk method Start");
		Session session = entityManager.unwrap(Session.class);
		AssignBGVerificationDTO dto = (AssignBGVerificationDTO) session.get(AssignBGVerificationDTO.class, pk);
		log.info("AssignBGVerificationDAOImpl FindByPk method End");
		return dto;
	}

	@Override
	public AssignBGVerificationDTO findByName(String name) {
		log.info("AssignBGVerificationDAOImpl FindByLogin method Start");
		Session session = entityManager.unwrap(Session.class);
		Criteria criteria = session.createCriteria(AssignBGVerificationDTO.class);
		criteria.add(Restrictions.eq("name",name));
		AssignBGVerificationDTO dto = (AssignBGVerificationDTO) criteria.uniqueResult();
		log.info("AssignBGVerificationDAOImpl FindByLogin method End");
		return dto;
	}

	@Override
	public void update(AssignBGVerificationDTO dto) {
		log.info("AssignBGVerificationDAOImpl Update method Start");
		Session session = entityManager.unwrap(Session.class);
		session.merge(dto);
		log.info("AssignBGVerificationDAOImpl update method End");
	}

	@Override
	public List<AssignBGVerificationDTO> list() {
		return list(0, 0);
	}

	@Override
	public List<AssignBGVerificationDTO> list(int pageNo, int pageSize) {
		log.info("AssignBGVerificationDAOImpl List method Start");
		Session session = entityManager.unwrap(Session.class);
		Query<AssignBGVerificationDTO> query = session.createQuery("from AssignBGVerificationDTO", AssignBGVerificationDTO.class);
		List<AssignBGVerificationDTO> list = query.getResultList();
		log.info("AssignBGVerificationDAOImpl List method End");
		return list;
	}

	@Override
	public List<AssignBGVerificationDTO> search(AssignBGVerificationDTO dto) {
		return search(dto, 0, 0);
	}

	@Override
	public List<AssignBGVerificationDTO> search(AssignBGVerificationDTO dto, int pageNo, int pageSize) {
		log.info("AssignBGVerificationDAOImpl Search method Start");
		Session session = entityManager.unwrap(Session.class);
		StringBuffer hql = new StringBuffer("from AssignBGVerificationDTO as u where 1=1 ");
		if (dto != null) {
			if (dto.getId() > 0) {
				hql.append("and u.id = " + dto.getId());
			}
			
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
		Query<AssignBGVerificationDTO> query = session.createQuery(hql.toString(), AssignBGVerificationDTO.class);
		if (pageNo > 0) {
			pageNo = (pageNo - 1) * pageSize;
			query.setFirstResult(pageNo);
			query.setMaxResults(pageSize);
		}
		List<AssignBGVerificationDTO> list = query.getResultList();
		log.info("AssignBGVerificationDAOImpl Search method End");
		return list;
	}
}
