package devApp.entity.user.dao;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import devApp.data.GenericSimpleAbstractDao;
import devApp.entity.user.model.WebUser;

@Repository
public class WebUserDaoImpl extends GenericSimpleAbstractDao<WebUser> implements WebUserDao {

    private static final Log LOG = LogFactory.getLog(WebUserDaoImpl.class);

    @Override
    public Class<WebUser> getEntityClass() {
        return WebUser.class;
    }

    /*
    public WebUserDaoImpl(SessionFactory sessionFactory) {
        this.setSessionFactory(sessionFactory);
    }
    */

    @Override
    public WebUser load(Long key) {
    	System.out.println("Dao imp: load(long key)");
    	try {
            return this.get(key);
        } catch (Exception e) {
            if (LOG.isErrorEnabled()) {
                LOG.error(e.getMessage(), e);
            }
            return null;
        }
    }

    @Override
    public WebUser saveOrUpdate(WebUser user) {
        try {
            return this.save(user);
        } catch (Exception e) {
            if (LOG.isErrorEnabled()) {
                LOG.error(e.getMessage(), e);
            }
            return null;
        }
    }

	@Override
	public WebUser loadByUsername(String username) {
		final Session session = this.getSessionFactory().getCurrentSession();
        final Criteria criteria = session.createCriteria(WebUser.class);
        criteria.add(Restrictions.eq("username", username));
        // USER_NAME is unique, so only 1 should return
        return (WebUser) criteria.uniqueResult();
	}

}
