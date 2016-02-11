package com.nakul.shah;

import java.net.URI;
import java.net.URISyntaxException;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.nakul.shah.resource.Friend;
import com.nakul.shah.resource.FriendManager;

@Path("friend")
public class FriendREST 
{
	FriendManager frndMgr = FriendManager.GetFriendManagerInstance();
	
	@GET
    @Produces(MediaType.APPLICATION_JSON)
    public Friend[] getAllFriends() 
	{
        return frndMgr.GetAllFriends();
    }
	
	/**/
	@GET
    @Produces(MediaType.APPLICATION_JSON)
	@Path("/name/{name}")
    public Friend getFriendByName(@PathParam("name") String name) 
	{
        return frndMgr.GetFriendByName(name);
    }
    /**/
	
	@GET
    @Produces(MediaType.APPLICATION_JSON)
	@Path("/id/{id}")
    public Friend getFriendByID(@PathParam("id") int id) 
	{
        return frndMgr.GetFriendById(id);
    }
	
	@POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response addFriend(@QueryParam("name") String name) 
	{
		int id = frndMgr.AddFriend(name);
		URI location = null;
		try 
		{
			location = new URI(String.valueOf(id));
		} 
		catch (URISyntaxException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Response.created(location).build();
    }
	
	@PUT
    @Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}")
    public Response updateFriend(@PathParam("id") int id, @QueryParam("name") String name) 
	{
		if(frndMgr.UpdateFriend(id, name))
			return Response.ok().build();
		else
			return Response.notModified().build();
    }
}
