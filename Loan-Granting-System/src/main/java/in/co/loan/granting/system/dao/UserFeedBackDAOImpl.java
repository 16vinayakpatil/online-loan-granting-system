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

import in.co.loan.granting.system.dto.UserFeedBackDTO;


@Repository
public class UserFeedBackDAOImpl implements UserFeedBackDAOInt {

	private static Logger log = Logger.getLogger(UserFeedBackDAOImpl.class.getName());

	@Autowired
	private EntityManager entityManager;

	@Override
	public long add(UserFeedBackDTO dto) {
		log.info("UserFeedBackDAOImpl Add method Start");
		Session session = entityManager.unwrap(Session.class);
		long pk = (long) session.save(dto);
		log.info("UserFeedBackDAOImpl Add method End");
		return pk;
	}

	@Override
	public void delete(UserFeedBackDTO dto) {
		log.info("UserFeedBackDAOImpl Delete method Start");
		entityManager.remove(entityManager.contains(dto) ? dto : entityManager.merge(dto));
		log.info("UserFeedBackDAOImpl Delete method End");

	}

	@Override
	public UserFeedBackDTO findBypk(long pk) {
		log.info("UserFeedBackDAOImpl FindByPk method Start");
		Session session = entityManager.unwrap(Session.class);
		UserFeedBackDTO dto = (UserFeedBackDTO) session.get(UserFeedBackDTO.class, pk);
		log.info("UserFeedBackDAOImpl FindByPk method End");
		return dto;
	}

	@Override
	public UserFeedBackDTO findByIssue(String issue) {
		log.info("UserFeedBackDAOImpl FindByLogin method Start");
		Session session = entityManager.unwrap(Session.class);
		Criteria criteria = session.createCriteria(UserFeedBackDTO.class);
		criteria.add(Restrictions.eq("issue",issue));
		UserFeedBackDTO dto = (UserFeedBackDTO) criteria.uniqueResult();
		log.info("UserFeedBackDAOImpl FindByLogin method End");
		return dto;
	}

	@Override
	public void update(UserFeedBackDTO dto) {
		log.info("UserFeedBackDAOImpl Update method Start");
		Session session = entityManager.unwrap(Session.class);
		session.merge(dto);
		log.info("UserFeedBackDAOImpl update method End");
	}

	@Override
	public List<UserFeedBackDTO> list() {
		return list(0, 0);
	}

	@Override
	public List<UserFeedBackDTO> list(int pageNo, int pageSize) {
		log.info("UserFeedBackDAOImpl List method Start");
		Session session = entityManager.unwrap(Session.class);
		Query<UserFeedBackDTO> query = session.createQuery("from UserFeedBackDTO", UserFeedBackDTO.class);
		List<UserFeedBackDTO> list = query.getResultList();
		log.info("UserFeedBackDAOImpl List method End");
		return list;
	}

	@Override
	public List<UserFeedBackDTO> search(UserFeedBackDTO dto) {
		return search(dto, 0, 0);
	}

	@Override
	public List<UserFeedBackDTO> search(UserFeedBackDTO dto, int pageNo, int pageSize) {
		log.info("UserFeedBackDAOImpl Search method Start");
		Session session = entityManager.unwrap(Session.class);
		StringBuffer hql = new StringBuffer("from UserFeedBackDTO as u where 1=1 ");
		if (dto != null) {
			if (dto.getId() > 0) {
				hql.append("and u.id = " + dto.getId());
			}
			
			if (dto.getQuestion() !=null && dto.getQuestion().length()>0) {
				hql.append("and u.question like '" + dto.getQuestion()+"%'");
			}
			
		}
		Query<UserFeedBackDTO> query = session.createQuery(hql.toString(), UserFeedBackDTO.class);
		if (pageNo > 0) {
			pageNo = (pageNo - 1) * pageSize;
			query.setFirstResult(pageNo);
			query.setMaxResults(pageSize);
		}
		List<UserFeedBackDTO> list = query.getResultList();
		log.info("UserFeedBackDAOImpl Search method End");
		return list;
	}

	
}
