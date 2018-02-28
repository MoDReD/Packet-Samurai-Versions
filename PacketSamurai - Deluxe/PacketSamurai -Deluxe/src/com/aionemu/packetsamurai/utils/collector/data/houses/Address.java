package com.aionemu.packetsamurai.utils.collector.data.houses;

import java.util.List;
import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "spawn" })
@XmlRootElement(name = "address")
public class Address {

	@XmlElement(required = false)
	protected List<Spawn> spawn;

	@XmlAttribute(required = true)
	protected int id;

	public List<Spawn> getSpawn() {
		return this.spawn;
	}
	
	public void setSpawn(List<Spawn> spawns) {
		this.spawn = spawns;
	}

	public int getId() {
		return id;
	}

	public void setId(int value) {
		this.id = value;
	}

}
