package tema.frr.chicken.context;

import java.util.Map;

public interface ApplicationContextListener {

  public void contextInitialized(Map<String, Object> context);

  public void contextDestroyed(Map<String, Object> context);

}
