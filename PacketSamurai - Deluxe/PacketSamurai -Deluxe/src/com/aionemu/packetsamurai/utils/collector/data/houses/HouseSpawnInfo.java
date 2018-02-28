package com.aionemu.packetsamurai.utils.collector.data.houses;

import com.aionemu.packetsamurai.parser.valuereader.ClientStringReader;

public class HouseSpawnInfo {

	public HouseSpawnInfo(int creatorId, int nameId) {
		this.creatorId = creatorId;
		this.nameId = nameId;
	}

	public int nameId;
	public int creatorId;
	public float X;
	public float Y;
	public float Z;
	private int h;

	public SpawnType getSpawnType() {
		String npcName = ClientStringReader.getData().getStringById(nameId).toLowerCase();
		if (npcName.indexOf("butler") != -1)
			return SpawnType.MANAGER;
		else if (npcName.indexOf("crystal") != -1)
			return SpawnType.TELEPORT;
		return SpawnType.SIGN;
	}

	public void setCoords(float x, float y, float z, int h) {
		this.X = x;
		this.Y = y;
		this.Z = z;
		this.h = h & 0xFF;
		if (h > 120)
			this.h -= 120;
	}

	public int getH() {
		return h;
	}
}
