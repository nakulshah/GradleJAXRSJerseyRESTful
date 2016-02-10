package com.nakul.shah;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.nakul.shah.resource.Friend;

@Path("friend")
public class FriendREST 
{
	@GET
    @Produces(MediaType.APPLICATION_JSON)
    public Friend getAllFriends() 
	{
        return new Friend("Jheenu", 3);
    }
}
