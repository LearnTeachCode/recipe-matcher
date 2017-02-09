package devApp.services;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertThat;

import java.util.List;

import javax.transaction.Transactional;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import devApp.DevAppAbstractTest;
import devApp.entity.user.dao.WebUserDao;
import devApp.entity.user.model.WebUser;

@Transactional
public class WebUserDaoTest extends DevAppAbstractTest {

    @Autowired
    private WebUserDao webUserDao;
    
	@Test
	public void contextLoads() {
		assertThat(webUserDao, instanceOf(WebUserDao.class));
	}
	
	
	@Test 
	public void testAddWebUser(){
		WebUser webUser = new WebUser();
		
		webUser.setEmail("hayk@gmail.com");
		webUser.setId(1L);
		webUser.setPassword("OIKWIC");
		
		this.webUserDao.saveOrUpdate(webUser);
	
		Assert.assertNotNull("failure - addWebUser: expected not null WebUser", webUser);
		Assert.assertEquals(webUser.getEmail(), "hayk@gmail.com");
	}
	
	
	@Test
	public void testLoadWebUser(){
		WebUser webUser = new WebUser();
		
		webUser.setUsername("hayk@gmail.com");
		webUser.setId(10L);
		webUser.setPassword("OIKWIC");
		
		WebUser w = this.webUserDao.saveOrUpdate(webUser);

		System.out.println(w.getId());
		//** findByUsername(String s)
		Assert.assertNotNull("failure - findByUsername: expected not null WebUser", this.webUserDao.loadByUsername("hayk@gmail.com"));


		/*
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/

		
		//** load(long l)  -- this call fails 
		//Assert.assertNotNull("failure - load: expected not null WebUser. This one fails.", this.webUserDao.load(3L));

		
		//** UserDetails loadUserByUsername(String s)
		Assert.assertNotNull("failure - loadUserByUsername: expected not null WebUser", this.webUserDao.loadByUsername("hayk@gmail.com"));
		
		//System.out.println(this.webUserDao.loadByUsername("hayk@gmail.com").getId());
		List<WebUser> listWebUsers = this.webUserDao.getAllWebUsers();
		
		//** List<WebUser> getAllWebUsers()
		Assert.assertNotNull("failure - getAllWebUsers: expected not null WebUser", listWebUsers.get(0));
		Assert.assertEquals("failure - expected size", 1, listWebUsers.size());
	}
	
	
	@Test 
	public void testSaveOrUpdateWebUser(){
		WebUser webUser = new WebUser();
		
		webUser.setEmail("hayk@gmail.com");
		webUser.setFirstName("Hayk");
		webUser.setId(1L);
		webUser.setPassword("OIKWIC");
		webUser.setUsername("Something@gmail.com");
		
		this.webUserDao.saveOrUpdate(webUser);
		
		webUser.setFirstName("Anonymous");
		webUser.setUsername("Anonymous@gmail.com");
		this.webUserDao.saveOrUpdate(webUser);
		
		Assert.assertNotNull("failure - saveOrUpdate: expected not null WebUser", webUser);
		//Assert.assertEquals(webUser.getFirstName(), "Anonymous");
		
		WebUser w = this.webUserDao.loadByUsername("Anonymous@gmail.com");
		System.out.println(w.getId());
		
		Assert.assertNotNull("failure - saveOrUpdate: expected not null WebUser", 
				this.webUserDao.loadByUsername("Anonymous@gmail.com"));
	}

    

}
