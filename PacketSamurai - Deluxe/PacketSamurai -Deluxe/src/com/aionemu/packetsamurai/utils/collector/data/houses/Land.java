package com.aionemu.packetsamurai.utils.collector.data.houses;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Land", propOrder = { "addresses" })
public class Land {

	@XmlElement(required = true)
	protected Addresses addresses;

	public Addresses getAddresses() {
		return addresses;
	}

	public void setAddresses(Addresses value) {
		this.addresses = value;
	}

}
