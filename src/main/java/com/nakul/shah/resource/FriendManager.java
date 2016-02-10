package com.nakul.shah.resource;

import org.apache.commons.collections4.BidiMap;
import org.apache.commons.collections4.MapIterator;
import org.apache.commons.collections4.bidimap.DualHashBidiMap;
import java.util.concurrent.atomic.AtomicInteger;

public class FriendManager 
{
	private BidiMap<Integer, String> friendList;
	private AtomicInteger atomicInt;
	
	private static FriendManager frndMgr = null;
	
	private FriendManager()
	{
		friendList = new DualHashBidiMap<>();
		atomicInt = new AtomicInteger();
	}
	
	public static FriendManager GetFriendManagerInstance()
	{
		if(null != frndMgr)
			return frndMgr;
		else
		{
			frndMgr = new FriendManager();	
			return frndMgr;
		}
	}
	
	public void AddFriend(String name)
	{
		friendList.put(atomicInt.incrementAndGet(), name);
	}
	
	public Friend GetFriendByName(String name)
	{
		if(friendList.containsValue(name))
			return new Friend(name, friendList.getKey(name));
		
		return null;
	}
	
	public Friend GetFriendById(int id)
	{
		if(friendList.containsKey(id))
			return new Friend(friendList.get(id), id);
		
		return null;
	}
	
	public Friend[] GetAllFriends() 
	{
		Friend[] allFriends = new Friend[friendList.size()];
		
		MapIterator<Integer, String> it = friendList.mapIterator();
		
		int i = 0;
		
		while(it.hasNext())
		{
			allFriends[i] = new Friend(it.getValue(), it.getKey());
			i++;
		}
		
		return allFriends;
	}
	
	public boolean UpdateFriend() throws Exception
	{
		throw new Exception("method not implemented yet");
	}
	
	
}
