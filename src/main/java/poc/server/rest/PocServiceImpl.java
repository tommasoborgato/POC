package poc.server.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import poc.server.dao.PocDao;
import poc.shared.model.InputObj;
import poc.shared.model.InputObjElem;
import poc.shared.model.OutputObj;
import poc.shared.model.OutputObjElem;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
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
        return "Hello Resteasy";
    }

    @Path("/obj")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getOutputObj(){
        OutputObj outputObj = pocDao.getOutputObj(1);
        List<OutputObjElem> outputObjElems = new ArrayList<OutputObjElem>();
        outputObjElems.add(new OutputObjElem(1,"POC-1"));
        outputObjElems.add(new OutputObjElem(2,"POC-2"));
        outputObj.setOutputObjElems(outputObjElems);
        return Response.ok(outputObj).header("Access-Control-Allow-Origin", "*").build();
    }

    @Path("/obj")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response getOutputObj(InputObj inputObj){
        OutputObj outputObj = pocDao.getOutputObj(inputObj.getId());
        if (inputObj.getInputObjElems()!=null && inputObj.getInputObjElems().size()>0){
            List<OutputObjElem> outputObjElems = new ArrayList<OutputObjElem>();
            for(InputObjElem inputObjElem : inputObj.getInputObjElems()){
                outputObjElems.add(new OutputObjElem(inputObjElem.getId(),inputObjElem.getContent()));
            }
            outputObj.setOutputObjElems(outputObjElems);
        }
        return Response.ok(outputObj).header("Access-Control-Allow-Origin", "*").build();
    }
}
