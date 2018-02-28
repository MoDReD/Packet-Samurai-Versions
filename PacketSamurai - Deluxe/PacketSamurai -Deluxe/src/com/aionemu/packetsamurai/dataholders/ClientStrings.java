package com.aionemu.packetsamurai.dataholders;

import java.util.List;

import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.*;

import javolution.util.FastMap;

@XmlRootElement(name = "strings")
@XmlType(name = "ClientStrings")
@XmlAccessorType(XmlAccessType.FIELD)
public class ClientStrings 
{
	@XmlElement(name = "string")
	List<ClientString> stringList;
	
	FastMap<Integer, ClientString> stringIndex;
	
	protected void afterUnmarshal(Unmarshaller u, Object parent)
	{
		stringIndex = new FastMap<Integer, ClientString>();
		for (ClientString s : stringList)
		{
			if (stringIndex.containsKey(s.getId()))
				continue;
			stringIndex.put(s.getId(), s);
		}
	}
	
	public String getStringById(int id)
	{
		if (stringIndex.containsKey(id))
			return stringIndex.get(id).body;
		
		return Integer.toString(id);
	}
}
