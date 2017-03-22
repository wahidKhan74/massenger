package org.wahid.rests.massenger.resource;

import java.util.List;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.wahid.rests.massenger.model.Message;
import org.wahid.rests.massenger.resource.beans.MessageFilterBean;
import org.wahid.rests.massenger.service.MassageService;

@Path("/messages")
public class MassageResources {
	
	MassageService messageService= new MassageService();
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Message> getMassages(@BeanParam MessageFilterBean filter){
		if (filter.getYear() > 0){
			return messageService.getAllMessagesForYear(filter.getYear());
		}
		if(filter.getStart() >= 0 && filter.getSize() >= 0) {
			return messageService.getAllMessagePaginat(filter.getStart(),filter.getSize());
		}
		return messageService.getAllMassage();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Message addMessage(Message message){
		return messageService.addMessage(message);
	}
	
	@PUT
	@Path("{messageId}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Message updateMessage(@PathParam("messageId") long messageId,Message message){
		message.setId(messageId);
		return messageService.updateMessage(message);
		
	}
	@DELETE
	@Path("{messageId}")
	@Produces(MediaType.APPLICATION_JSON)
	public void deleteMessage(@PathParam("messageId") long messageId){
		messageService.removeMessage(messageId);
	}
		
	@GET
	@Path("{messageId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Message getMessage(@PathParam("messageId") long messageId){
		return messageService.getMessage(messageId);
	}
	
	@Path("{messageId}/comments")
	public CommentResource getCommentResource(){
		return new CommentResource();
	}
}
