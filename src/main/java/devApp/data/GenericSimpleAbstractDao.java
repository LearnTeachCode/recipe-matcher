package devApp.data;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
@Transactional
public abstract class GenericSimpleAbstractDao<E> implements GenericSimpleDao<E> {

    @Autowired
    private SessionFactory sessionFactory;

    public GenericSimpleAbstractDao() {
        super();
    }

    /**
     * Concrete class type is required at runtime.
     * @return class type of the entity.
     */
    public abstract Class<E> getEntityClass();

    @Override
    @SuppressWarnings("unchecked")
    public E save(E element) {
        final Session session =
                this.getSessionFactory().getCurrentSession();
        return (E) session.merge(element);
    }

    @Override
    @SuppressWarnings("unchecked")
    public E get(Number key) {
        final Session session =
                this.getSessionFactory().getCurrentSession();
        return (E) session.get(this.getEntityClass(), key);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<E> getAll() {
        final Session session =
                this.getSessionFactory().getCurrentSession();
        final Criteria criteria =
                session.createCriteria(this.getEntityClass());
        return criteria.list();
    }

    @Override
    public void delete(Number key) {
        final Session session =
                this.getSessionFactory().getCurrentSession();
        final E toDelete =
                this.get(key);
        if (toDelete != null) {
            session.delete(toDelete);
        }
    }

    public GenericSimpleAbstractDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
