package poc.server.rest;


import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by icttb0 on 16/12/2016.
 */
public class RestApplication extends Application {

    private Set<Object> singletons = new HashSet<Object>();

    public RestApplication() {
        singletons.add(new PocServiceImpl());
    }

    @Override
    public Set<Class<?>> getClasses()
    {
        HashSet<Class<?>> set = new HashSet<Class<?>>();
        return set;
    }

    @Override
    public Set<Object> getSingletons()
    {
        return singletons;
    }
}
