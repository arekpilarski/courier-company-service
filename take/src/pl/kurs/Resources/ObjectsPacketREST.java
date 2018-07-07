package pl.kurs.Resources;

import java.io.IOException;
import java.io.StringReader;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import pl.kurs.Entities.Package;
import pl.kurs.Entities.Recipient;
import pl.kurs.Entities.Sender;
import pl.kurs.Entities.Address;
import pl.kurs.Entities.ObjectsPacket;
import pl.kurs.Services.CommonEJB;

@Path("/test/processObjects")
public class ObjectsPacketREST {

	
	@EJB
	CommonEJB bean;
	
	@POST
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_XML)
	public String processObjects(ObjectsPacket objectsPacket ) {
		
		//Get all request objects from XML
		Package newPackage = (Package) objectsPacket.getObjectsPacket().get(0);
		Sender newSender = (Sender) objectsPacket.getObjectsPacket().get(1);
		Address newSenderAddress = (Address) objectsPacket.getObjectsPacket().get(2);
		Recipient newRecipient = (Recipient) objectsPacket.getObjectsPacket().get(3);
		Address newRecipientAddress = (Address) objectsPacket.getObjectsPacket().get(4);
		
		//Create new instances in database
		newPackage = bean.createPackage(newPackage);
		newSender = bean.createSender(newSender);
		newSenderAddress = bean.createAddress(newSenderAddress);
		newRecipient = bean.createRecipient(newRecipient);
		newRecipientAddress = bean.createAddress(newRecipientAddress);
		
		//Make proper links between new data.
		
		bean.addSenderToAddress(newSender.getID(), newSenderAddress.getID());
		bean.addRecipientToAddress(newRecipient.getID(), newRecipientAddress.getID());
		bean.addSenderToPackage(newSender.getID(), newPackage.getPackageId());
		bean.addRecipientToPackage(newRecipient.getID(), newPackage.getPackageId());
		
		return "Successfully added!";
	}

}
