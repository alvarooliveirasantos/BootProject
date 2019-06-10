package br.com.resources;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;

import br.com.dao.MessageDAO;
import br.com.entidades.Message;

import com.google.gson.Gson;


@Path("message")
public class MessageResources {
	
	private static final Logger log = Logger.getLogger(MessageResources.class);
	
	List<Message> messages = new ArrayList<Message>();
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response adcionarMessage(String conteudo){
		try{
		Gson gson = new Gson();
		Message message = gson.fromJson(conteudo,Message.class);
		String resul = new MessageDAO().adcionar(message);
		URI uri = URI.create("/message/" + message.getConversationId());
		return Response.created(uri).build();
		}
		catch(Exception e){
			log.error("Erro ao adcionar nova mensagem");
			return Response.serverError().build();
		}
	}
	/*@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response adcionarMessagePorConversationId(@PathParam("conversationId") String conversationId, String conteudo){
	try{
	Gson gson = new Gson();
	Message message = gson.fromJson(conteudo, Message.class);
	String resul = new MessageDAO().adcionarPorConversationId(message);
	URI uri = URI.create("/message/" + message.getConversationId());
	return Response.created(uri).build();
	}
	catch(Exception e){
		log.error("Erro ao adcionar nova mensagem");
		return Response.serverError().build();
	}
	}*/
		
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String listarMensagens(){
	messages = new MessageDAO().listarMenssagens();	
	return new Gson().toJson(messages);
	}

	@Path("/conversationId/{conversationId}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String listarPorconversationId(@PathParam("conversationId") String conversationId){
	List<Message> messages = new ArrayList<Message>();
	messages = new MessageDAO().listarPorConversationId(conversationId);
	return new Gson().toJson(messages);
	}
	
	@Path("{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String listarPorId(@PathParam("id") Long id){
	List<Message> messages = new ArrayList<Message>();
	messages = new MessageDAO().listarPorId(id);
	return new Gson().toJson(messages);
	}

}
