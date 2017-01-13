package devApp.entity.user.dao;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import devApp.entity.user.model.WebUser;

@Repository
@Transactional
public interface WebUserDao {

    /**
     * Load WebUser by its database key.
     * @param key key of the WebUser.
     * @return WebUser of the key, null otherwise.
     */
    WebUser load(Long key);

    /**
     * Load WebUser by its user name.
     * @param userName find this user name.
     * @return WebUser with given user name, null otherwise.
     */
    WebUser loadByUsername(String username);

    /**
     * Merge given WebUser.
     * @param user merge this user.
     * @return merged user.
     */
    WebUser saveOrUpdate(WebUser user);
}
