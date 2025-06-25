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

import in.co.loan.granting.system.dto.FeedBackDTO;



@Repository
public class FeedBackDAOImpl implements FeedBackDAOInt {

	private static Logger log = Logger.getLogger(FeedBackDAOImpl.class.getName());

	@Autowired
	private EntityManager entityManager;

	@Override
	public long add(FeedBackDTO dto) {
		log.info("FeedBackDAOImpl Add method Start");
		Session session = entityManager.unwrap(Session.class);
		long pk = (long) session.save(dto);
		log.info("FeedBackDAOImpl Add method End");
		return pk;
	}

	@Override
	public void delete(FeedBackDTO dto) {
		log.info("FeedBackDAOImpl Delete method Start");
		entityManager.remove(entityManager.contains(dto) ? dto : entityManager.merge(dto));
		log.info("FeedBackDAOImpl Delete method End");

	}

	@Override
	public FeedBackDTO findBypk(long pk) {
		log.info("FeedBackDAOImpl FindByPk method Start");
		Session session = entityManager.unwrap(Session.class);
		FeedBackDTO dto = (FeedBackDTO) session.get(FeedBackDTO.class, pk);
		log.info("FeedBackDAOImpl FindByPk method End");
		return dto;
	}

	@Override
	public FeedBackDTO findByIssue(String issue) {
		log.info("FeedBackDAOImpl FindByLogin method Start");
		Session session = entityManager.unwrap(Session.class);
		Criteria criteria = session.createCriteria(FeedBackDTO.class);
		criteria.add(Restrictions.eq("issue",issue));
		FeedBackDTO dto = (FeedBackDTO) criteria.uniqueResult();
		log.info("FeedBackDAOImpl FindByLogin method End");
		return dto;
	}

	@Override
	public void update(FeedBackDTO dto) {
		log.info("FeedBackDAOImpl Update method Start");
		Session session = entityManager.unwrap(Session.class);
		session.merge(dto);
		log.info("FeedBackDAOImpl update method End");
	}

	@Override
	public List<FeedBackDTO> list() {
		return list(0, 0);
	}

	@Override
	public List<FeedBackDTO> list(int pageNo, int pageSize) {
		log.info("FeedBackDAOImpl List method Start");
		Session session = entityManager.unwrap(Session.class);
		Query<FeedBackDTO> query = session.createQuery("from FeedBackDTO", FeedBackDTO.class);
		List<FeedBackDTO> list = query.getResultList();
		log.info("FeedBackDAOImpl List method End");
		return list;
	}

	@Override
	public List<FeedBackDTO> search(FeedBackDTO dto) {
		return search(dto, 0, 0);
	}

	@Override
	public List<FeedBackDTO> search(FeedBackDTO dto, int pageNo, int pageSize) {
		log.info("FeedBackDAOImpl Search method Start");
		Session session = entityManager.unwrap(Session.class);
		StringBuffer hql = new StringBuffer("from FeedBackDTO as u where 1=1 ");
		if (dto != null) {
			if (dto.getId() > 0) {
				hql.append("and u.id = " + dto.getId());
			}
			
			if (dto.getQuestion() !=null && dto.getQuestion().length()>0) {
				hql.append("and u.question like '" + dto.getQuestion()+"%'");
			}
			
		}
		Query<FeedBackDTO> query = session.createQuery(hql.toString(), FeedBackDTO.class);
		if (pageNo > 0) {
			pageNo = (pageNo - 1) * pageSize;
			query.setFirstResult(pageNo);
			query.setMaxResults(pageSize);
		}
		List<FeedBackDTO> list = query.getResultList();
		log.info("FeedBackDAOImpl Search method End");
		return list;
	}

	
}
