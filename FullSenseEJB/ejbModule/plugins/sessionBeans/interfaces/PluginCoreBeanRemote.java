package plugins.sessionBeans.interfaces;
import java.util.Map;

import javax.ejb.Remote;

@Remote
public interface PluginCoreBeanRemote {
	
	public void signalSensor(String type, Map<String,String> arguments) throws Exception;

	public void startServices() throws Exception;
}
