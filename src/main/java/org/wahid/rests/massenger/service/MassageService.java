package org.wahid.rests.massenger.service;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import org.wahid.rests.massenger.database.DatabaseClass;
import org.wahid.rests.massenger.model.Message;
public class MassageService {
	
	private Map<Long, Message> messages= DatabaseClass.getMessages();
	public MassageService() {
		messages.put(1l,new Message(1,"Hello World","Wahid"));
		messages.put(2l,new Message(2,"Hello Rest","Wahid"));
		messages.put(3l,new Message(3,"Hello Api","Wahid"));
	}
	public List <Message> getAllMessagesForYear(int year){
		List <Message> messagesforYear = new ArrayList<>();
		Calendar cal = Calendar.getInstance();
		for(Message message:messages.values()){
			cal.setTime(message.getCreated());
			if(cal.get(Calendar.YEAR)==year){
				messagesforYear.add(message);
			}
		}
		return messagesforYear;
	}
	
	public List<Message> getAllMessagePaginat(int start,int size) {
		ArrayList<Message> list = new ArrayList<Message>(messages.values());
		if (start +size >list.size()) return new ArrayList<Message>();
		return list.subList(start, start+size);
	}
	
	public List<Message> getAllMassage(){
		return new ArrayList<Message>( messages.values());
	}
	
	public Message getMessage(long id){
		return messages.get(id);
	}
	public Message addMessage(Message message){
		message.setId(messages.size()+1);
		messages.put(message.getId(),message);
		return message;
	}
	public Message updateMessage(Message message) {
		if (message.getId() <= 0){
			return null;
		}
		messages.put(message.getId(),message);
		return message;
	}
	public Message removeMessage(long id ) {
		return messages.remove(id);
		
	}
}
