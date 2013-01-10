package plugins.util;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;



public class FSMap extends HashMap<String,Pair>{

	private static final long serialVersionUID = 7027451390033737812L;
	
	private Map<String,String> fsmap;
	
	public FSMap(Map<String,String> m,boolean b) {
		super();
		fsmap = m;		
		for(Entry<String, String> e : m.entrySet()){
			super.put(e.getKey(), new Pair(e.getValue()));
		}
	}
	
	public FSMap(Map<String,Pair> m) {
		super(m);
		fsmap = new HashMap<String, String>();		
		for(Entry<String, Pair> e : m.entrySet()){
			fsmap.put(e.getKey(),e.getValue().toString());
		}
	}
	

	public void clear() {
		super.clear();
		fsmap.clear();
	}

	public Pair put(String key, Pair value) {
		fsmap.put(key, value.toString());
		return super.put(key,value);
	}

	public void putAll(Map<? extends String, ? extends Pair> m) {
		for(Entry<? extends String, ? extends Pair> e : m.entrySet()){
			fsmap.put(e.getKey(), e.getValue().toString());
		}
		super.putAll(m);
	}

	public Pair remove(Object key) {
		fsmap.remove(key);
		return super.remove(key);
	}
	
	public Map<String,String> getMap(){
		return fsmap;
	}
	
	
	
	
}
