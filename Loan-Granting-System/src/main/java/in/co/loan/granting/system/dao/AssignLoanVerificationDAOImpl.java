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

import in.co.loan.granting.system.dto.AssignLoanVerificationDTO;


@Repository
public class AssignLoanVerificationDAOImpl implements AssignLoanVerificationDAOInt {

	private static Logger log = Logger.getLogger(AssignLoanVerificationDAOImpl.class.getName());

	@Autowired
	private EntityManager entityManager;

	@Override
	public long add(AssignLoanVerificationDTO dto) {
		log.info("AssignLoanVerificationDAOImpl Add method Start");
		Session session = entityManager.unwrap(Session.class);
		long pk = (long) session.save(dto);
		log.info("AssignLoanVerificationDAOImpl Add method End");
		return pk;
	}

	@Override
	public void delete(AssignLoanVerificationDTO dto) {
		log.info("AssignLoanVerificationDAOImpl Delete method Start");
		entityManager.remove(entityManager.contains(dto) ? dto : entityManager.merge(dto));
		log.info("AssignLoanVerificationDAOImpl Delete method End");

	}

	@Override
	public AssignLoanVerificationDTO findBypk(long pk) {
		log.info("AssignLoanVerificationDAOImpl FindByPk method Start");
		Session session = entityManager.unwrap(Session.class);
		AssignLoanVerificationDTO dto = (AssignLoanVerificationDTO) session.get(AssignLoanVerificationDTO.class, pk);
		log.info("AssignLoanVerificationDAOImpl FindByPk method End");
		return dto;
	}

	@Override
	public AssignLoanVerificationDTO findByName(String name) {
		log.info("AssignLoanVerificationDAOImpl FindByLogin method Start");
		Session session = entityManager.unwrap(Session.class);
		Criteria criteria = session.createCriteria(AssignLoanVerificationDTO.class);
		criteria.add(Restrictions.eq("name",name));
		AssignLoanVerificationDTO dto = (AssignLoanVerificationDTO) criteria.uniqueResult();
		log.info("AssignLoanVerificationDAOImpl FindByLogin method End");
		return dto;
	}

	@Override
	public void update(AssignLoanVerificationDTO dto) {
		log.info("AssignLoanVerificationDAOImpl Update method Start");
		Session session = entityManager.unwrap(Session.class);
		session.merge(dto);
		log.info("AssignLoanVerificationDAOImpl update method End");
	}

	@Override
	public List<AssignLoanVerificationDTO> list() {
		return list(0, 0);
	}

	@Override
	public List<AssignLoanVerificationDTO> list(int pageNo, int pageSize) {
		log.info("AssignLoanVerificationDAOImpl List method Start");
		Session session = entityManager.unwrap(Session.class);
		Query<AssignLoanVerificationDTO> query = session.createQuery("from AssignLoanVerificationDTO", AssignLoanVerificationDTO.class);
		List<AssignLoanVerificationDTO> list = query.getResultList();
		log.info("AssignLoanVerificationDAOImpl List method End");
		return list;
	}

	@Override
	public List<AssignLoanVerificationDTO> search(AssignLoanVerificationDTO dto) {
		return search(dto, 0, 0);
	}

	@Override
	public List<AssignLoanVerificationDTO> search(AssignLoanVerificationDTO dto, int pageNo, int pageSize) {
		log.info("AssignLoanVerificationDAOImpl Search method Start");
		Session session = entityManager.unwrap(Session.class);
		StringBuffer hql = new StringBuffer("from AssignLoanVerificationDTO as u where 1=1 ");
		if (dto != null) {
			if (dto.getId() > 0) {
				hql.append("and u.id = " + dto.getId());
			}
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
		Query<AssignLoanVerificationDTO> query = session.createQuery(hql.toString(), AssignLoanVerificationDTO.class);
		if (pageNo > 0) {
			pageNo = (pageNo - 1) * pageSize;
			query.setFirstResult(pageNo);
			query.setMaxResults(pageSize);
		}
		List<AssignLoanVerificationDTO> list = query.getResultList();
		log.info("AssignLoanVerificationDAOImpl Search method End");
		return list;
	}
}
