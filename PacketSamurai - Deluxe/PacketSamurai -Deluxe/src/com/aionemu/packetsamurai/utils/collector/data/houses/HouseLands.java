package com.aionemu.packetsamurai.utils.collector.data.houses;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "land" })
@XmlRootElement(name = "house_lands")
public class HouseLands {

	protected List<Land> land;

	public List<Land> getLand() {
		if (land == null) {
			land = new ArrayList<Land>();
		}
		return this.land;
	}

}
