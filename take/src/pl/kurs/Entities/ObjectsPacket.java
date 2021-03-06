package pl.kurs.Entities;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlSeeAlso({Package.class,Sender.class,Recipient.class,Route.class,Address.class,Courier.class})
public class ObjectsPacket {

	@XmlAnyElement(lax = true)
	List <Object> objectsPacket = new ArrayList<Object>();

	
	public List<Object> getObjectsPacket() {
		return objectsPacket;
	}

	public void setObjectsPacket(List<Object> objectsPacket) {
		this.objectsPacket = objectsPacket;
	}

	@Override
	public String toString() {
		return "ObjectsPacket [objectsPacket=" + objectsPacket + "]";
	}
	
	
	
}
