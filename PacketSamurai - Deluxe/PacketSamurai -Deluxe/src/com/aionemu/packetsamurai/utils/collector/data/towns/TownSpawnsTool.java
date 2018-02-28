package com.aionemu.packetsamurai.utils.collector.data.towns;

import javax.xml.bind.JAXBException;

import com.aionemu.packetsamurai.PacketSamurai;
import com.aionemu.packetsamurai.utils.collector.DataLoader;
import com.aionemu.packetsamurai.utils.collector.JAXBExtractor;

/**
 * 
 * @author ViAl
 *
 */
public class TownSpawnsTool {
	
	public static TownSpawnsData TOWN_SPAWNS_DATA;
	
	public static void load() {
		try {
			DataLoader loader = new DataLoader("./data/town_spawns/town_spawns.xml", new TownSpawnsData());
			TOWN_SPAWNS_DATA = (TownSpawnsData) loader.getData();
			PacketSamurai.getUserInterface().log("Loaded: " + TOWN_SPAWNS_DATA.towns.size()+" towns witn "+TOWN_SPAWNS_DATA.getSpawnsCount()+"spawns");
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}
	
	public static void save() {
		JAXBExtractor extractor = new JAXBExtractor("./data/town_spawns/town_spawns.xml", TOWN_SPAWNS_DATA);
		extractor.extract();
		PacketSamurai.getUserInterface().log("Saved: " + TOWN_SPAWNS_DATA.towns.size()+" towns witn "+TOWN_SPAWNS_DATA.getSpawnsCount()+"spawns");
	}
	
	public static void add(int townId, int worldId, int npcId, float x, float y, float z, int h) {
		Spawn spawn = new Spawn(npcId, x, y, z, h);
		for(TownSpawns town : TOWN_SPAWNS_DATA.towns) {
			if(town.id == townId && town.world_id == worldId) {
				for(Spawn s : town.spawns) {
					if(s.npc_id == npcId)
						return;
				}
				town.spawns.add(spawn);
				return;
			}
		}
		TownSpawns town = new TownSpawns();
		town.id = townId;
		town.world_id = worldId;
		town.spawns.add(spawn);
		TOWN_SPAWNS_DATA.towns.add(town);
		PacketSamurai.getUserInterface().log("New town spawn: town id: " +townId+" , npcId:"+npcId);
	}
}
