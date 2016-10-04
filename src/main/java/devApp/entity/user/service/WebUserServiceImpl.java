package devApp.entity.user.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import devApp.entity.user.dao.WebUserDao;
import devApp.entity.user.dao.WebUserDaoImpl;
import devApp.entity.user.model.WebUser;
import org.springframework.util.StringUtils;


@Service
public class WebUserServiceImpl implements WebUserService  {

    private static final Log LOG = LogFactory.getLog(WebUserServiceImpl.class);

    @Autowired
    private WebUserDao webUserDao;
    
    public WebUserServiceImpl() {
        super();
    }
    
    public WebUserServiceImpl(WebUserDaoImpl webUserDao) {
        this.webUserDao = webUserDao;
    }
    
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

        final WebUser webUser =
                this.getWebUserDao().loadByUserName(userName);

        if (webUser == null) {
            throw new UsernameNotFoundException("Invalid username/password");
        }

        return webUser;
    }

    @Override
    public WebUser saveOrUpdate(WebUser user) {

        if (user != null) {
            return this.getWebUserDao().saveOrUpdate(user);
        }

        return null;
    }

    @Override
    public WebUser load(Number key) {

        if (key != null) {

            final WebUser webUser =
                    this.getWebUserDao().load(key);

            if (webUser != null) {

                this.logUserFound(key, webUser.getUsername());

                return webUser;
            }
        }

        // at this user was not found or unable to load
        if (LOG.isInfoEnabled()) {
            LOG.info("User null loaded for key =" + key);
        }

        return null;
    }

    @Override
    public WebUser findByUserName(String userName) {

        if (StringUtils.hasText(userName)) {

            final WebUser webUser =
                    this.getWebUserDao().loadByUserName(userName);

            if (webUser != null) {

                this.logUserFound(userName, webUser.getUsername());

                return webUser;
            }
        }

        // at this user was not found or unable to load
        if (LOG.isInfoEnabled()) {
            LOG.info("User null loaded for userName =" + userName);
        }

        return null;
    }

    /**
     * Helper method to log user after load attempt.
     * @param userKey key used to identify the user.
     * @param userValue the value that was found for the key.
     */
    private void logUserFound(Object userKey, Object userValue) {

        if (LOG.isInfoEnabled()) {

            final String userKeyStr =
                    (userKey != null) ? userKey.toString() : "null";

            final String userValueStr =
                    (userValue != null) ? userValue.toString() : "null";

            LOG.info("User " + userValueStr + " loaded for id = " + userKeyStr);
        }
    }

    public WebUserDao getWebUserDao() {
        return webUserDao;
    }

    public void setWebUserDao(WebUserDao webUserDao) {
        this.webUserDao = webUserDao;
    }
}
