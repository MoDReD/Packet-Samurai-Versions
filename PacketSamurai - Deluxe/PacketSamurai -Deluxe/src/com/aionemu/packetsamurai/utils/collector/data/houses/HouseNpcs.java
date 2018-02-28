package com.aionemu.packetsamurai.utils.collector.data.houses;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "address" })
@XmlRootElement(name = "house_npcs")
public class HouseNpcs {

	protected List<Address> address;

	public List<Address> getAddress() {
		if (address == null) {
			address = new ArrayList<Address>();
		}
		return this.address;
	}

}
