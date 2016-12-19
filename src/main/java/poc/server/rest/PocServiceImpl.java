package poc.server.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import poc.server.dao.PocDao;
import poc.shared.InputObj;
import poc.shared.InputObjElem;
import poc.shared.OutputObj;
import poc.shared.OutputObjElem;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by icttb0 on 16/12/2016.
 */
@Path("/srv")
@Component
@Transactional
public class PocServiceImpl implements PocService {

    private PocDao pocDao;

    public PocServiceImpl() {
    }

    @Autowired
    public void setPocDao(PocDao pocDao) {
        this.pocDao = pocDao;
    }

    @Path("/prova")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String sayPlainTextHello() {
        return "Hello Jersey";
    }

    @Path("/obj")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public OutputObj getOutputObj(){
        OutputObj outputObj = pocDao.getOutputObj(1);
        List<OutputObjElem> outputObjElems = new ArrayList<OutputObjElem>();
        outputObjElems.add(new OutputObjElem(1,"POC-1"));
        outputObjElems.add(new OutputObjElem(2,"POC-2"));
        outputObj.setOutputObjElems(outputObjElems);
        return outputObj;
    }

    @Path("/obj")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public OutputObj getOutputObj(InputObj inputObj){
        OutputObj outputObj = pocDao.getOutputObj(inputObj.getId());
        if (inputObj.getInputObjElems()!=null && inputObj.getInputObjElems().size()>0){
            List<OutputObjElem> outputObjElems = new ArrayList<OutputObjElem>();
            for(InputObjElem inputObjElem : inputObj.getInputObjElems()){
                outputObjElems.add(new OutputObjElem(inputObjElem.getId(),inputObjElem.getContent()));
            }
            outputObj.setOutputObjElems(outputObjElems);
        }
        return outputObj;
    }
}
