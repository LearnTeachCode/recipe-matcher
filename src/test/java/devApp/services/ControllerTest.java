package devApp.services;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import javax.transaction.Transactional;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import devApp.DevAppAbstractTest;
import devApp.entity.recipe.dao.RecipeDao;
import devApp.entity.recipe.model.Recipe;

@Transactional
public class ControllerTest extends DevAppAbstractTest {
	
	@Autowired
	private WebApplicationContext context;

	@Autowired
	private RecipeDao recipeDao;
	
	
	private MockMvc mockMvc;

	
	@Before
    public void setUp() {
    	mockMvc = MockMvcBuilders.webAppContextSetup(context)
				//.apply(springSecurity())
				.build();
	}
	
	
	@Test
	public void loginTest(){
    	try {

    		mockMvc.perform(get("/login"))
    			.andDo(print())
				.andExpect(status().isOk());
				//.andExpect(content().string(org.hamcrest.Matchers.containsString("into your account")));
				//.andExpect(content().string("into your account"));
    		
    		mockMvc.perform(post("/registration")
    				.param("username", "hayk@gmail.com")
    				.param("password", "tulalan8890")
    				.param("confirmPassword", "tulalan8890"))
    			//.andDo(print())
    			.andExpect(status().is(302));
    		
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
	

	@Test
	public void recipeTest(){
		Recipe recipe = new Recipe();
		
		recipe.setName("Fish");
		recipe.setDescription("Soak shiitake mushrooms in 3/4 cup hot water...");
		
		//** save(recipe)
		this.recipeDao.save(recipe);

		try {			
    		mockMvc.perform(get("/recipe/1").contentType(MediaType.APPLICATION_JSON))
    			.andDo(print())
				.andExpect(status().isOk())
				//.andExpect(jsonPath("$[0].name", is("Fish")));
				.andExpect(jsonPath("$.name").value("Fish"));
				//.andExpect(content().string(org.hamcrest.Matchers.containsString("into your account")));
				//.andExpect(content().string("into your account"));
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
	
	
}
