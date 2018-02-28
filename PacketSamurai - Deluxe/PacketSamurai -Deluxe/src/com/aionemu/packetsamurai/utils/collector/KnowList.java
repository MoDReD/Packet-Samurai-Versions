package com.aionemu.packetsamurai.utils.collector;

import java.util.Map;

import com.aionemu.packetsamurai.utils.collector.objects.VisibleObject;

import javolution.util.FastMap;

public class KnowList {
	private Map<Integer, VisibleObject> objects = new FastMap<Integer, VisibleObject>();
	
	public void add (VisibleObject object){
		objects.put(object.getObjectId(), object);
	}
	
	public void remove(int objectId){
		objects.remove(objectId);
	}
	
	public VisibleObject get(int objectId){
		return objects.get(objectId);
	}
}
