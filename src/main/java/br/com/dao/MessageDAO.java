package br.com.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.entidades.Message;

public class MessageDAO {
	
	private static List<Message> messagesList = new ArrayList<Message>();
	
	public String adcionar(Message message) {
	for (Message messages : messagesList) {
		if(messages.getConversationId() == message.getConversationId()){
			return "mensagem ja cadastrada";
		}
	}
	message.setTimestamp(new Date());
	messagesList.add(message);
	return "OK";
	}
	public List<Message> listarMenssagens(){
		return messagesList;
	}
	public List<Message> listarPorConversationId(String conversationId) {
		List<Message> messages = new ArrayList<Message>();
		for (Message message : messagesList) {
			if(message.getConversationId().equals(conversationId) || message.getConversationId().isEmpty()){
				messages.add(message);
			}
		
		}
		return messages;
	}
	public List<Message> listarPorId(Long id) {
		List<Message> messages = new ArrayList<Message>();
		for (Message message : messagesList) {
			if(message.getId().equals(id)){
				messages.add(message);
			}
		}
		return messages;
	}
	public String adcionarPorConversationId(Message message) {
		// TODO Auto-generated method stub
		return null;
	}
	}
	

