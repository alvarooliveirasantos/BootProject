Foram expostos dois endpoints que s�o eles:

http://localhost:8080/boot
http://localhost:8080/message/

Para listar todos os boots dispon�veis basta realizar uma chamado atrav�s do m�todo GET o mesmo serve para a interface message

Para fazer uma busca por ID especifico basta inserir uma barra e adicionar o numero do ID, utilizando o m�todo GET 

Foi criada a seguinte regra de negocio, para um boot responder uma message � necess�rio inserir na requisi��o POST o numero do conversationid, assim a message sera relacionada a lista de messages correta 

Para um boot enviar uma message para todos os usu�rios basta n�o preencher o campo conversationid, assim todas os usu�rios ir�o recebe-la 


Tecnologias:

O projeto foi criado as seguintes tecnologias:
Maven, Google gson, log4j, javax.ws, jersey-quava, jaxb-impl, grizzly, jaxws

Banco de dados:

Como este e um projeto com fins de teste a base de dados foi alocada em memoria, n�o sendo necess�rio realizar nenhuma configura��o de base para iniciar a aplica��o