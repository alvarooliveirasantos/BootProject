package br.com.main;

import java.io.IOException;
import java.net.URI;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;


@SpringBootApplication
@Controller
public class Servidor {
	private static final Logger log = Logger.getLogger(Servidor.class);
	
	public static void main (String[] args) throws IOException{
		BasicConfigurator.configure();
		try{
			HttpServer server = iniciarServidor();
			log.info("Servidor iniciado");
			System.in.read();
			server.stop();
			
		}
	
		catch(IOException e){
			log.error("Problema ao iniciar servidor" + e.getMessage());
		}
	}

	private static HttpServer iniciarServidor() {
		ResourceConfig config = new ResourceConfig().packages("br.com.resources");
		URI uri = URI.create("http://localhost:8080/");
		HttpServer server = GrizzlyHttpServerFactory.createHttpServer(uri,config);
		return server;
	}
	/*@Bean
	public DataSource dataSource(){
	    DriverManagerDataSource dataSource = new DriverManagerDataSource();
	    dataSource.setDriverClassName("com.mysql.jdbc.Driver");
	    dataSource.setUrl("jdbc:mysql://localhost:3306/bootMessage");
	    dataSource.setUsername("root");
	    dataSource.setPassword("357159aA");
	    return dataSource;
	}	*/

}
