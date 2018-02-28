package com.aionemu.packetsamurai.utils.collector.data.houses;

public class HouseDecorData {

	private static String NULL = "NULL";
	
	public int address;
	public int building;
	
	public int roof;
	public int outwall;
	public int frame;
	public int door;
	public int garden;
	public int fence;
	public int inwall;
	public int infloor;
	public int addon;
	
	public int getUniqueId() {
		return address << 16 | building;
	}
	
	private String formatInt(int value) {
		if (value == 0)
			return NULL;
		return Integer.toString(value);
	}
	
	public String getRoofSql() {
		return formatInt(roof);
	}
	
	public String getOutwallSql() {
		return formatInt(outwall);
	}
	
	public String getFrameSql() {
		return formatInt(frame);
	}
	
	public String getDoorSql() {
		return formatInt(door);
	}
	
	public String getGardenSql() {
		return formatInt(garden);
	}
	
	public String getFenceSql() {
		return formatInt(fence);
	}
	
	public String getInwallSql() {
		return formatInt(inwall);
	}
	
	public String getInfloorSql() {
		return formatInt(infloor);
	}
	
	public String getAddonSql() {
		return formatInt(addon);
	}
}
