package com.aionemu.packetsamurai.utils.collector;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

/**
 * 
 * @author ViAl
 *
 */
public class DataLoader {

	private Object data;
	
	public DataLoader(String fileName, Object object) throws JAXBException {
		this.data = object;
		File file = new File(fileName);
        JAXBContext jaxbContext = JAXBContext.newInstance(data.getClass());
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        this.data = jaxbUnmarshaller.unmarshal(file);
	}
	
	public Object getData() {
		return this.data;
	}
}
