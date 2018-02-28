package com.aionemu.packetsamurai.utils.collector.data.towns;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 * @author ViAl
 *
 */
@XmlRootElement(name = "town_spawns_data")
public class TownSpawnsData {

	@XmlElement(name = "town")
	public List<TownSpawns> towns;
	
	public TownSpawnsData() {
		this.towns = new ArrayList<TownSpawns>();
	}
	
	public int getSpawnsCount() {
		int i = 0;
		for(TownSpawns town : towns)
			i+=town.spawns.size();
		return i;
	}
}
