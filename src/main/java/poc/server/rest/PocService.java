package poc.server.rest;

import poc.shared.InputObj;
import poc.shared.OutputObj;

/**
 * Created by icttb0 on 18/12/2016.
 */
public interface PocService {
    public String sayPlainTextHello();
    public OutputObj getOutputObj();
    public OutputObj getOutputObj(InputObj inputObj);
}
