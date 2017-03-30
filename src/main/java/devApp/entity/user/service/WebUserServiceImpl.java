package devApp.entity.user.service;

import java.util.List;

import javax.transaction.Transactional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import devApp.entity.user.dao.WebUserDao;
import devApp.entity.user.dao.WebUserDaoImpl;
import devApp.entity.user.model.User;
import devApp.entity.user.model.WebUser;
import devApp.security.util.SecurityRoleType;


@Service
public class WebUserServiceImpl implements WebUserService  {

    private static final Log LOG = LogFactory.getLog(WebUserServiceImpl.class);

    @Autowired
    private WebUserDao webUserDao;
    
	@Autowired
	private BCryptPasswordEncoder bPasswordCryptEncoder;
    
    public WebUserServiceImpl() {
        super();
    }
    
    public WebUserServiceImpl(WebUserDaoImpl webUserDao) {
        this.webUserDao = webUserDao;
    }
    
    @Override
    @Transactional
    public User loadUserByUsername(String username) throws UsernameNotFoundException {    	
    	final WebUser webUser = this.webUserDao.loadByUsername(username);
  
        if (webUser == null) {
            throw new UsernameNotFoundException("Invalid username/password");
        } 

        return webUser;
    }

    @Override
    @Transactional
    public WebUser saveOrUpdate(WebUser user) {

        if (user != null) {
            return this.getWebUserDao().saveOrUpdate(user);
        }

        return null;
    }

    @Override
    @Transactional
    public WebUser load(Long key) {
    	System.out.println("User Service imp: load(long)");
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
    @Transactional
    public WebUser findByUsername(String username) {
       if (StringUtils.hasText(username)) {
    	   WebUser webUser = this.getWebUserDao().loadByUsername(username); 
       
            if (webUser != null) {
                this.logUserFound(username, webUser.getUsername());

                return webUser;
            }
       }

        // at this user was not found or unable to load
        if (LOG.isInfoEnabled()) {
            LOG.info("User null loaded for username =" + username);
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


	@Override
	@Transactional
	public void addWebUser(WebUser webUser) {
		webUser.setPassword(bPasswordCryptEncoder.encode(webUser.getPassword()));
		webUser.setSecurityRoleType(SecurityRoleType.USER);
		
		this.webUserDao.saveOrUpdate(webUser);
	}

	@Override
	@Transactional
	public List<WebUser> getAllWebUsers() {
		return this.webUserDao.getAllWebUsers();
	}


}
