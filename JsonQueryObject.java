import java.util.HashMap;

import com.google.gson.Gson;



public class JsonQueryObject extends HashMap<String,JsonQuery>{

	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	
	public void jset(String key, String value, Gson gson){
	    if(value=="")value="\"\"";
		String json = "{\"obj\":"+value+"}";
		JsonQuery node = gson.fromJson(json,JsonQuery.class);
		this.put(key,(JsonQuery)node._("obj"));
	}
	
	public void set(String key, Object value){
		if(value instanceof JsonQuery){
			this.put(key,(JsonQuery) value);
		}else{
			this.put(key,new JsonQuery(value));
		}
	}
}
