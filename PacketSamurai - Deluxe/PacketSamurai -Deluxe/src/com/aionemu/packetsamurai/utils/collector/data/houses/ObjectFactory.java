package com.aionemu.packetsamurai.utils.collector.data.houses;

import javax.xml.bind.annotation.XmlRegistry;

@XmlRegistry
public class ObjectFactory {

	public ObjectFactory() {
	}

	public Address createAddress() {
		return new Address();
	}

	public HouseNpcs createHouseNpcs() {
		return new HouseNpcs();
	}

	public Spawn createSpawn() {
		return new Spawn();
	}

}
