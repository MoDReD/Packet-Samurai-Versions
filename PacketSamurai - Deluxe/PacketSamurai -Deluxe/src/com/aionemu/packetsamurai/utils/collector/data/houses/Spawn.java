package com.aionemu.packetsamurai.utils.collector.data.houses;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "spawn")
public class Spawn {

	@XmlAttribute(required = true)
	protected float x;

	@XmlAttribute(required = true)
	protected float y;

	@XmlAttribute(required = true)
	protected float z;

	@XmlAttribute
	protected Integer h;

	@XmlAttribute(required = true)
	protected SpawnType type;

	public float getX() {
		return x;
	}

	public void setX(float value) {
		this.x = value;
	}

	public float getY() {
		return y;
	}

	public void setY(float value) {
		this.y = value;
	}

	public float getZ() {
		return z;
	}

	public void setZ(float value) {
		this.z = value;
	}

	public Integer getH() {
		if (h == 0)
			return null;
		return h;
	}

	public void setH(Integer value) {
		this.h = value;
	}

	public SpawnType getType() {
		return type;
	}

	public void setType(SpawnType value) {
		this.type = value;
	}

}
