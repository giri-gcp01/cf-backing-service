package tech.gcplearnng.cf.resource;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class WeatherResource {
	
	@GetMapping("/weather/{location}")
	public String getWeather(@PathVariable String location) {
		
		RestTemplate restTemplate = new RestTemplate();
		
		System.out.println("VCAP_SERVICES:"+System.getenv("VCAP_SERVICES"));
		JSONObject vcapServices = new JSONObject(System.getenv("VCAP_SERVICES"));		
		String url="";
		String api="";
		String key="";
		JSONArray services = (JSONArray) vcapServices.get("user-provided");
		for (Object service: services) {
			JSONObject obj = (JSONObject)service;
			String name = (String)obj.get("name");
			if (name!= null && name.equals("weather-service")) {
				JSONObject credentials = (JSONObject)obj.get("credentials");
				url = (String)credentials.get("url");
				api = (String)credentials.get("api");
				key = (String)credentials.get("key");
			}

		}
		
		String resourceUrl = url + "?key=" + key+"&api="+api+"&q="+location;
		ResponseEntity<String> response = restTemplate.getForEntity(resourceUrl, String.class);
		return response.getBody();
	}

}
