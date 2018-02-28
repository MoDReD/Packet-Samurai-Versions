package com.aionemu.packetsamurai.utils.collector;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

/**
 * 
 * @author ViAl
 *
 */
public class JAXBExtractor {

	private Object object;
	private String fileName;
	
	public JAXBExtractor(String fileName, Object object) {
		this.fileName = fileName;
		this.object = object;
	}
	
	public void extract() {
		File file = new File(fileName);
        JAXBContext jaxbContext;
		try {
			jaxbContext = JAXBContext.newInstance(object.getClass());
	        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
	        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
	        jaxbMarshaller.marshal(object, file);
		}
        catch (JAXBException e) {
			e.printStackTrace();
		}
	}
}
