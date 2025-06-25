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


@Repository
public class ApplyLoanDAOImpl implements ApplyLoanDAOInt {

	private static Logger log = Logger.getLogger(ApplyLoanDAOImpl.class.getName());

	@Autowired
	private EntityManager entityManager;

	@Override
	public long add(ApplyLoanDTO dto) {
		log.info("ApplyLoanDAOImpl Add method Start");
		Session session = entityManager.unwrap(Session.class);
		long pk = (long) session.save(dto);
		log.info("ApplyLoanDAOImpl Add method End");
		return pk;
	}

	@Override
	public void delete(ApplyLoanDTO dto) {
		log.info("ApplyLoanDAOImpl Delete method Start");
		entityManager.remove(entityManager.contains(dto) ? dto : entityManager.merge(dto));
		log.info("ApplyLoanDAOImpl Delete method End");

	}

	@Override
	public ApplyLoanDTO findBypk(long pk) {
		log.info("ApplyLoanDAOImpl FindByPk method Start");
		Session session = entityManager.unwrap(Session.class);
		ApplyLoanDTO dto = (ApplyLoanDTO) session.get(ApplyLoanDTO.class, pk);
		log.info("ApplyLoanDAOImpl FindByPk method End");
		return dto;
	}

	@Override
	public ApplyLoanDTO findByName(String name) {
		log.info("ApplyLoanDAOImpl FindByLogin method Start");
		Session session = entityManager.unwrap(Session.class);
		Criteria criteria = session.createCriteria(ApplyLoanDTO.class);
		criteria.add(Restrictions.eq("name",name));
		ApplyLoanDTO dto = (ApplyLoanDTO) criteria.uniqueResult();
		log.info("ApplyLoanDAOImpl FindByLogin method End");
		return dto;
	}

	@Override
	public void update(ApplyLoanDTO dto) {
		log.info("ApplyLoanDAOImpl Update method Start");
		Session session = entityManager.unwrap(Session.class);
		session.merge(dto);
		log.info("ApplyLoanDAOImpl update method End");
	}

	@Override
	public List<ApplyLoanDTO> list() {
		return list(0, 0);
	}

	@Override
	public List<ApplyLoanDTO> list(int pageNo, int pageSize) {
		log.info("ApplyLoanDAOImpl List method Start");
		Session session = entityManager.unwrap(Session.class);
		Query<ApplyLoanDTO> query = session.createQuery("from ApplyLoanDTO", ApplyLoanDTO.class);
		List<ApplyLoanDTO> list = query.getResultList();
		log.info("ApplyLoanDAOImpl List method End");
		return list;
	}

	@Override
	public List<ApplyLoanDTO> search(ApplyLoanDTO dto) {
		return search(dto, 0, 0);
	}

	@Override
	public List<ApplyLoanDTO> search(ApplyLoanDTO dto, int pageNo, int pageSize) {
		log.info("ApplyLoanDAOImpl Search method Start");
		Session session = entityManager.unwrap(Session.class);
		StringBuffer hql = new StringBuffer("from ApplyLoanDTO as u where 1=1 ");
		if (dto != null) {
			if (dto.getId() > 0) {
				hql.append("and u.id = " + dto.getId());
			}
			if (dto.getUserId() > 0) {
				hql.append("and u.userId = " + dto.getUserId());
			}
			
			if (dto.getRequestLoanId() > 0) {
				hql.append("and u.requestLoanId = " + dto.getRequestLoanId());
			}
			
			if (dto.getName() != null && dto.getName().length() >0) {
				hql.append("and u.name like '" + dto.getName()+"%'");
			}
			
			if (dto.getEmailId() != null && dto.getEmailId().length() >0) {
				hql.append("and u.emailId like '" + dto.getEmailId()+"%'");
			}
			
			if (dto.getStatus() != null && dto.getStatus().length() >0) {
				hql.append("and u.status like '" + dto.getStatus()+"%'");
			}
		
			
		
		}
		Query<ApplyLoanDTO> query = session.createQuery(hql.toString(), ApplyLoanDTO.class);
		if (pageNo > 0) {
			pageNo = (pageNo - 1) * pageSize;
			query.setFirstResult(pageNo);
			query.setMaxResults(pageSize);
		}
		List<ApplyLoanDTO> list = query.getResultList();
		log.info("ApplyLoanDAOImpl Search method End");
		return list;
	}

	@Override
	public Blob getFile(long id,String filedName) throws SerialException, SQLException {
		Session session = entityManager.unwrap(Session.class);
		ApplyLoanDTO person = (ApplyLoanDTO) session.get(ApplyLoanDTO.class, id);
		byte[] blob=null;
		if(filedName.equalsIgnoreCase("resume")) {
			blob = person.getResume();
		}else if(filedName.equalsIgnoreCase("projectPlan")) {
			blob = person.getProjectPlan();
		}else if(filedName.equalsIgnoreCase("personalCreditReport")) {
			blob = person.getPersonalCreditReport();
		}else if(filedName.equalsIgnoreCase("businessCreditReport")) {
			blob = person.getBusinessCreditReport();
		}else if(filedName.equalsIgnoreCase("financialStatement")) {
			blob = person.getFinancialStatement();
		}else if(filedName.equalsIgnoreCase("bankStatement")) {
			blob = person.getBankStatement();
		}
		Blob bBlob = new SerialBlob(blob);
		return bBlob;
	}
}
