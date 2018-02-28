package com.aionemu.packetsamurai.utils.collector.data.towns;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * 
 * @author ViAl
 *
 */
@XmlType(name = "town")
public class TownSpawns {

	@XmlAttribute(name = "town_id")
	public int id;
	
	@XmlAttribute(name = "world_id")
	public int world_id;
	
	@XmlElement(name="spawn")
	List<Spawn> spawns;
	
	public TownSpawns() {
		this.spawns = new ArrayList<Spawn>();
	}
}
