# tqi_evolution_fullstack_2022
Desafio TQI

-- Minha resolução do desafio proposto pela seleção

-- O backend foi desenvolvido com springboot(Linguagem Java, como foi requisitado), consiste em uma API que recebe requisições no formato Json. A Api está com acesso de requests permitido para todos os casos, visto que é uma API de testes para uso local. Para facilitar os testes a Api foi desenvolvida com um Banco de Dados em memória(H2 database), é um BD que é iniciado quando a API entra em execução e é totalmente apagado quando a API para de vez(porém o BD não se apaga com reload). A Api consegue fazer todos os registros requisitados.

--O frontend por sua vez foi desenvolvido, como requisitado pelo desafio, em ReactJS, ele tem as funções focadas no cadastro de livros. Ainda precisa de algumas melhorias, mas já apto para teste, visto que já consegue se comunicar sem maiores problemas com a Api. O desenvolvimento do frontend também foi facilitado pelo uso de extensões tal qual o Axis para conectar à API. 

-- O frontend ficou com um tamanho relativamente grande para ser "upado" no GitHUB, sendo assim, criei um zip com o projeto, o link para baixar o frontende é: https://drive.google.com/file/d/1LtszH_fJMd_Az_TIpOx84rQxXy1yzc8G/view?usp=sharing
