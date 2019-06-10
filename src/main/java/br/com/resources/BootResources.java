package br.com.resources;


import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import br.com.dao.BootDAO;
import br.com.entidades.Boot;

import com.google.gson.Gson;


@Path("boot")
@Controller
public class BootResources {

	private static final Logger log = Logger.getLogger(BootResources.class);
	
	

	List<Boot> boots = new ArrayList<Boot>();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String listarBoots() {
		boots = (List<Boot>) new BootDAO().listarTodos();
		return new Gson().toJson(boots);
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response adcionarBoot(String conteudo) {
		try {
			Gson gson = new Gson();
			Boot boot = (Boot) gson.fromJson(conteudo, Boot.class);
			String resul = new BootDAO().adcionar(boot);
			URI uri = URI.create("/boot/" + boot.getId());
			if (!resul.equals("OK")) {
				return Response.serverError().build();
			}
			return Response.created(uri).build();

		} catch (Exception e) {
			log.error("Erro ao adicionar novo registro :" + e.getMessage());
			return Response.serverError().build();
		}

	}

	@Path("{id}")
	@PUT
	public Response alterarBoot(String conteudo, @PathParam("id") Long id) {
		try {
			Gson gson = new Gson();
			Boot boot = (Boot) gson.fromJson(conteudo, Boot.class);
			new BootDAO().alterar(boot);
			URI uri = URI.create("/boot/" + boot.getId());
			return Response.created(uri).build();
		} catch (Exception e) {
			log.error("Erro ao alterar boot" + e);
			return Response.serverError().build();
		}
	}

	@Path("{id}")
	@DELETE
	public Response removerBoot(@PathParam("id") Long id) {
		try {
			new BootDAO().excluir(id);
			return Response.ok().build();
		} catch (Exception e) {
			log.error("Erro ao excluir registro: " + e);
			return Response.serverError().build();
		}

	}
	@Path("{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String listarPorId(@PathParam("id") Long id){
	List<Boot> boot = new ArrayList<Boot>();
	boot = new BootDAO().listarPorId(id);
	return new Gson().toJson(boot);
	}


}
