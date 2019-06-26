package com.RestAPI.MiniOfficeResource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.RestAPI.MiniOffice.Profile;
import com.RestAPI.database.DatabaseService;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("/profile")
public class ProfileResource {

	DatabaseService databaseService = new DatabaseService();

   
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Profile> getIt() {
    	//ProfileService profileService = new ProfileService();
        return databaseService.getDatabase();

    }
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Profile postIt(Profile profile){
    	return databaseService.postDatabase(profile);
    }
    
    @DELETE
    @Path("/{profileName}")
    @Produces(MediaType.APPLICATION_JSON)
    public void deleteIt(@PathParam ("profileName") String profileName){
    	
    	databaseService.deleteProfile(profileName);
    	
    }
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Profile updateIt(Profile profile){
		return databaseService.updateDatabase(profile);
    	
    }
    
}
