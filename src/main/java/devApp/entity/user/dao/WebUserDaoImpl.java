package devApp.entity.user.dao;

import devApp.data.GenericSimpleAbstractDao;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import devApp.entity.user.model.WebUser;

public class WebUserDaoImpl extends GenericSimpleAbstractDao<WebUser> implements WebUserDao {

    private static final Log LOG = LogFactory.getLog(WebUserDaoImpl.class);

    @Override
    public Class<WebUser> getEntityClass() {
        return WebUser.class;
    }

    public WebUserDaoImpl(SessionFactory sessionFactory) {
        this.setSessionFactory(sessionFactory);
    }

    @Override
    public WebUser load(Number key) {
        try {
            return this.get(key.longValue());
        } catch (Exception e) {
            if (LOG.isErrorEnabled()) {
                LOG.error(e.getMessage(), e);
            }
            return null;
        }
    }

    @Override
    public WebUser loadByUserName(String userName) {
        final Session session =
                this.getSessionFactory().getCurrentSession();
        final Criteria criteria =
                session.createCriteria(WebUser.class);
        criteria.add(Restrictions.eq("userName", userName));
        // USER_NAME is unique, so only 1 should return
        return (WebUser) criteria.uniqueResult();
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
}
