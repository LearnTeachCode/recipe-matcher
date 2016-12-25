package devApp.helpers;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.springframework.util.CollectionUtils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class AppHelper {
	
	private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
	

	public String getJsonList(List<?> objects, Log LOG, String processType){
		
		if(LOG.isInfoEnabled()){
			LOG.info((CollectionUtils.isEmpty(objects)
					? "[null/empty]" : objects.size())
					+ " " + processType + "loaded");
		}
		
		
		final List<String> jsonList = new ArrayList<>();
		
		for(Object o : objects){
			
			try {
				
				final String processed = OBJECT_MAPPER.writeValueAsString(o);
				jsonList.add(processed);
				
			} catch (JsonProcessingException e) {

				if(LOG.isErrorEnabled()){
					LOG.error(e.getMessage());
				}
				
				e.printStackTrace();
			}		
		}
		
		return jsonList.toString();
	}
	
	
	
	
	public String objectToJSON(Object o, Log LOG, String processType){
		final List<String> jsonList = new ArrayList<>();
		
		try {
			
			final String processed = OBJECT_MAPPER.writeValueAsString(o);
			jsonList.add(processed);
			
		} catch (JsonProcessingException e) {

			if(LOG.isErrorEnabled()){
				LOG.error(e.getMessage());
			}
			
			e.printStackTrace();
		}	
		
		return jsonList.toString();
	}
	
	
	
	
}
