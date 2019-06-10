# BootProject
Foram expostos dois endpoints que são eles:

http://localhost:8080/boot
http://localhost:8080/message/

Para listar todos os boots disponíveis basta realizar uma chamado através do método GET o mesmo serve para a interface message

Para fazer uma busca por ID especifico basta inserir uma barra e adicionar o numero do ID, utilizando o método GET 

Foi criada a seguinte regra de negocio, para um boot responder uma message é necessário inserir na requisição POST o numero do conversationid, assim a message sera relacionada a lista de messages correta 

Para um boot enviar uma message para todos os usuários basta não preencher o campo conversationid, assim todas os usuários irão recebe-la 


Tecnologias:

O projeto foi criado as seguintes tecnologias:
Maven, Google gson, log4j, javax.ws, jersey-quava, jaxb-impl, grizzly, jaxws

Banco de dados:

Como este e um projeto com fins de teste a base de dados foi alocada em memoria, não sendo necessário realizar nenhuma configuração de base para iniciar a aplicação
