package com.aionemu.packetsamurai.utils.collector;

import com.aionemu.packetsamurai.utils.collector.data.houses.CollectedHouseDataLoader;
import com.aionemu.packetsamurai.utils.collector.data.npcData.CollectedNpcDataLoader;
import com.aionemu.packetsamurai.utils.collector.data.npcMoves.NpcMoveDataSaver;
import com.aionemu.packetsamurai.utils.collector.data.npcskills.NpcSkillsTool;
import com.aionemu.packetsamurai.utils.collector.data.towns.TownSpawnsTool;

public class DataManager {

	public static void load() {
		NpcSkillsTool.load();
		CollectedNpcDataLoader.load();
		CollectedHouseDataLoader.load();
		TownSpawnsTool.load();
	}

	public static void save() {
		NpcSkillsTool.save();
		CollectedNpcDataLoader.save();
		NpcMoveDataSaver.save();
		CollectedHouseDataLoader.save();
		TownSpawnsTool.save();
	}

}
