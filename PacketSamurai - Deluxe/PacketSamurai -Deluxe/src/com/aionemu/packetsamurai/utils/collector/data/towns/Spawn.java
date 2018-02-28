package com.aionemu.packetsamurai.utils.collector.data.towns;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

/**
 * 
 * @author ViAl
 *
 */
@XmlType(name = "spawn")
public class Spawn {
	
	@XmlAttribute(name = "npc_id")
	public int npc_id;
	
	@XmlAttribute(name = "x")
	public float x;
	
	@XmlAttribute(name = "y")
	public float y;
	
	@XmlAttribute(name = "z")
	public float z;
	
	@XmlAttribute(name = "h")
	public int h;

	public Spawn() {
		super();
	}
	
	/**
	 * @param npc_id
	 * @param x
	 * @param y
	 * @param z
	 * @param h
	 */
	public Spawn(int npc_id, float x, float y, float z, int h) {
		super();
		this.npc_id = npc_id;
		this.x = x;
		this.y = y;
		this.z = z;
		this.h = h;
	}
}
