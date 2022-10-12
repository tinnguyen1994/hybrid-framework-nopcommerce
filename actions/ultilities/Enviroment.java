package ultilities;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.Sources;


@Sources({"file:enviromentConfig/dev.properties"})
public interface Enviroment extends Config {
	
	
	@Key("App.Url")
	String appUrl();
	
	@Key("App.User")
	String getAppUser();
	
	@Key("App.Pass")
	String getAppPass();
	
	
	@Key("DB.Host")
	String getDBHost();
	
	@Key("DB.User")
	String getAppDBUser();
	
	@Key("DB.Pass")
	String getAppDBPass();
	

	
}
