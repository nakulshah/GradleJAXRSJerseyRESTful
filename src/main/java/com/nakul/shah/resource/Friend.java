package com.nakul.shah.resource;

import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlAccessType;

/**
 * REF: http://docs.oracle.com/javaee/6/tutorial/doc/gkknj.html#gmfnu
 */

@XmlRootElement(name="product")
@XmlAccessorType(XmlAccessType.FIELD)
public class Friend 
{
	@XmlElement(required=true)
	private String name;
	@XmlElement(required=true)
	private int id;
	
	public Friend(String name, int id) 
	{
		this.setName(name);
		this.setId(id);
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

}
