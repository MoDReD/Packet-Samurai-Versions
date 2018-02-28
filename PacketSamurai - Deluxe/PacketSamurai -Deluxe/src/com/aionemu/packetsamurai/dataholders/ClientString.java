package com.aionemu.packetsamurai.dataholders;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "string", propOrder = {"id", "name", "body", "display_type", "message_type", "ment" })
public class ClientString 
{
	private int id;
	String name;
	String body;
	
	int display_type;
	String message_type;
	String ment;
	
	public int getId()
	{
		return id;
	}
	
	public String getName()
	{
		return name;
	}	
	
	@XmlTransient
	int _realMessageType = (int)-1;
	
	public int getMessageType()
	{
		if (_realMessageType != -1)
			return _realMessageType;
		
		try
		{
			_realMessageType = Byte.parseByte(message_type);
		}
		catch (NumberFormatException e)
		{
			_realMessageType = 0;
		}
		return _realMessageType;
	}
	
	public int getDisplayType()
	{
		return display_type;
	}
	
	public String getText()
	{
		if (body == null)
			return "";
		
		return body;
	}
	
	public String getMentality()
	{
		if (ment == null)
			return "";
		
		return ment;
	}
}
