package com.aionemu.packetsamurai.utils.collector.objects;

public class VisibleObject {
	protected int objectId;
	protected int templateId;
	protected int staticId;

	/**
	 * @param objectId
	 * @param templateId
	 * @param staticId
	 */
	public VisibleObject(int objectId, int templateId, int staticId) {
		this.objectId = objectId;
		this.templateId = templateId;
		this.staticId = staticId;
	}

	/**
	 * @return the objectId
	 */
	public int getObjectId() {
		return objectId;
	}
	/**
	 * @return the templateId
	 */
	public int getTemplateId() {
		return templateId;
	}

	/**
	 * @return the staticId
	 */
	public int getStaticId() {
		return staticId;
	}
	
}
