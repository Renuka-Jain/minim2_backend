package edu.upc.dsa.services;

import edu.upc.dsa.StatsManagerImpl;
import edu.upc.dsa.StatsManager;
import edu.upc.dsa.models.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Api(value = "/stats", description = "Endpoint to Stats Service")
@Path("/stats")
public class StatServices {

    private StatsManager manager;
    public StatServices() {
        this.manager = StatsManagerImpl.getInstance();
        if (manager.StatsListSize() == 0) {
            this.manager.addStat(new Stats(1, "EstheMC", "11-11-11", 200));
            this.manager.addStat(new Stats(2, "ÓscarPL", "22-22-22", 50));
            this.manager.addStat(new Stats(3, "MarioAH", "33-33-", 100));
        }
    }

    //Get de ranking
    @GET
    @ApiOperation(value = "Get ranking", notes = "none")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Stats.class, responseContainer = "Lista"),
            @ApiResponse(code = 404, message = "Lista no encontrada")
    })
    @Path("/ranking")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getRanking() {
        List<Stats> list = this.manager.getRanking();
        GenericEntity<List<Stats>> entity = new GenericEntity<List<Stats>>(list){};

        if(list.size() > 0){
            return Response.status(201).entity(entity).build();
        }
        return Response.status(404).entity(entity).build();
    }
}

