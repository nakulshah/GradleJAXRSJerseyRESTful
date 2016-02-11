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
	
	public int AddFriend(String name)
	{
		int id = atomicInt.incrementAndGet();
		friendList.put(id, name);
		return id;
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
			int k = it.next();
			allFriends[i] = new Friend(friendList.get(k), k);
			i++;
		}
		
		return allFriends;
	}
	
	public boolean UpdateFriend(int id, String name) 
	{
		boolean toReturn = false;
		
		if(friendList.containsKey(id))
		{
			friendList.remove(id);
			friendList.put(id, name);
			toReturn = true;
		}
		
		return toReturn;
	}
	
	
}
