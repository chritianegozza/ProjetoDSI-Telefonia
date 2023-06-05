# 🚀 Projeto  DSI  Telefonia
**********************************************************************
O sistema deve seguir o diagrama de classes UML mostrado abaixo:
![image](https://github.com/chritianegozza/ProjetoDSI-Telefonia/assets/72118415/d95c9b5e-a297-4282-8d8b-2714aa3fee68)

![image](https://github.com/chritianegozza/ProjetoDSI-Telefonia/assets/72118415/4650238d-28fd-426f-a6c0-5ff7b85ef419)

![image](https://github.com/chritianegozza/ProjetoDSI-Telefonia/assets/72118415/24b708a2-1475-4ddd-a991-37c4116900b7)


![image](https://github.com/chritianegozza/ProjetoDSI-Telefonia/assets/72118415/294578bf-8296-46f0-b355-c7c86abd3997)

![image](https://github.com/chritianegozza/ProjetoDSI-Telefonia/assets/72118415/9287cf6e-c686-4164-80d8-9500965029b3)

![image](https://github.com/chritianegozza/ProjetoDSI-Telefonia/assets/72118415/3c9e45c0-d46a-4bed-ae10-d4696e84e1fc)


**********************************************************************
👩🏻‍💻 Projeto

Esse projeto foi realizado para colocamos em prática todos os conteúdos 
abordados nesse semestre no curso de Sistemas para Internet 4° Semestre
da FATEC Rubens Lara, Este trabalho consiste em implementar um sistema de 
cadastro de assinantes de uma empresa de telefonia celular, explorando os
conceitos de orientação objetos estudados até aqui.

Descrição do Sistema
O sistema deverá ser baseado em um menu com as seguintes opções:

a) Cadastrar assinante: o sistema deverá solicitar o tipo de assinante, pré-pago ou pós-pago.
Depois solicitar os dados do assinante específico;

b) Listar assinantes: o sistema deverá listar os dados de todos os assinantes pré-pagos e pós-
pagos cadastrados;

c) Fazer chamada: o sistema deverá solicitar o tipo de assinante e seu CPF. Depois solicitar os
dados da chamada, data e duração;

d) Fazerrecarga: o sistema deverá solicitar o CPF de um assinante pré-pago. Depois solicitar a
data e o valor da recarga;

e) Imprimirfaturas: o sistema deverá solicitar o mês e imprimirtodas as faturas dos assinantes
pré-pagos e pós-pagos;

f) Sair do programa: encerra a execução do programa.

3. Descrição das Classes

A seguir serão descritas as classes do sistema.

a.1 Assinante

A classe Assinantepossui 5 atributos:

a) cpf: CPF doassinante;

b) nome: nome completo do assinante;

c) numero: número do telefone celular do assinante.

d) chamadas: vetor de referências a objetos daclasseChamada (vide seção 3.5),representa

as chamadas feitas peloassinante;

e) numChamadas: número de chamadas feitas pelo assinante.

Oconstrutordestaclassedeveinicializaros seus atributoscomosargumentosdoconstrutor

e instanciar o vetor chamadas.

Os métodos da classe Assinantesão descritos a seguir:

a) longgetCpf(): devolve o CPF do assinante;

b) StringtoString():devolveumarepresentaçãotextualdosatributosdeumassinante.

************************************************************************
💡 Linguagem 

✅ JAVA

***************************************************************************
