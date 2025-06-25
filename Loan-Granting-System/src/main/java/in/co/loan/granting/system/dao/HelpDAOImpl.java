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

import in.co.loan.granting.system.dto.HelpDTO;


@Repository
public class HelpDAOImpl implements HelpDAOInt {

	private static Logger log = Logger.getLogger(HelpDAOImpl.class.getName());

	@Autowired
	private EntityManager entityManager;

	@Override
	public long add(HelpDTO dto) {
		log.info("HelpDAOImpl Add method Start");
		Session session = entityManager.unwrap(Session.class);
		long pk = (long) session.save(dto);
		log.info("HelpDAOImpl Add method End");
		return pk;
	}

	@Override
	public void delete(HelpDTO dto) {
		log.info("HelpDAOImpl Delete method Start");
		entityManager.remove(entityManager.contains(dto) ? dto : entityManager.merge(dto));
		log.info("HelpDAOImpl Delete method End");

	}

	@Override
	public HelpDTO findBypk(long pk) {
		log.info("HelpDAOImpl FindByPk method Start");
		Session session = entityManager.unwrap(Session.class);
		HelpDTO dto = (HelpDTO) session.get(HelpDTO.class, pk);
		log.info("HelpDAOImpl FindByPk method End");
		return dto;
	}

	@Override
	public HelpDTO findByIssue(String issue) {
		log.info("HelpDAOImpl FindByLogin method Start");
		Session session = entityManager.unwrap(Session.class);
		Criteria criteria = session.createCriteria(HelpDTO.class);
		criteria.add(Restrictions.eq("issue",issue));
		HelpDTO dto = (HelpDTO) criteria.uniqueResult();
		log.info("HelpDAOImpl FindByLogin method End");
		return dto;
	}

	@Override
	public void update(HelpDTO dto) {
		log.info("HelpDAOImpl Update method Start");
		Session session = entityManager.unwrap(Session.class);
		session.merge(dto);
		log.info("HelpDAOImpl update method End");
	}

	@Override
	public List<HelpDTO> list() {
		return list(0, 0);
	}

	@Override
	public List<HelpDTO> list(int pageNo, int pageSize) {
		log.info("HelpDAOImpl List method Start");
		Session session = entityManager.unwrap(Session.class);
		Query<HelpDTO> query = session.createQuery("from HelpDTO", HelpDTO.class);
		List<HelpDTO> list = query.getResultList();
		log.info("HelpDAOImpl List method End");
		return list;
	}

	@Override
	public List<HelpDTO> search(HelpDTO dto) {
		return search(dto, 0, 0);
	}

	@Override
	public List<HelpDTO> search(HelpDTO dto, int pageNo, int pageSize) {
		log.info("HelpDAOImpl Search method Start");
		Session session = entityManager.unwrap(Session.class);
		StringBuffer hql = new StringBuffer("from HelpDTO as u where 1=1 ");
		if (dto != null) {
			if (dto.getId() > 0) {
				hql.append("and u.id = " + dto.getId());
			}
			
			if (dto.getRequestId() > 0) {
				hql.append("and u.requestId = " + dto.getRequestId());
			}
			
			if (dto.getIssue() !=null && dto.getIssue().length()>0) {
				hql.append("and u.issue like '" + dto.getIssue()+"%'");
			}
			
			
			
		}
		Query<HelpDTO> query = session.createQuery(hql.toString(), HelpDTO.class);
		if (pageNo > 0) {
			pageNo = (pageNo - 1) * pageSize;
			query.setFirstResult(pageNo);
			query.setMaxResults(pageSize);
		}
		List<HelpDTO> list = query.getResultList();
		log.info("HelpDAOImpl Search method End");
		return list;
	}

	
}
