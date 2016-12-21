package poc.server.rest;

import poc.shared.model.InputObj;
import poc.shared.model.OutputObj;

import javax.ws.rs.core.Response;

/**
 * Created by icttb0 on 18/12/2016.
 */
public interface PocService {
    public String sayPlainTextHello();
    public Response getOutputObj();
    public Response getOutputObj(InputObj inputObj);
}
