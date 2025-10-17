-- Defesa de código --

-> O desafio tem como proposta a utilização do design pattern *Strategy*, juntamente com a proposta em iniciar um RPG.

Como foi utilizado o strategy? -> O padrão strategy é um design pattern que utiliza do conceito em que uma interface implemente um método de comportamento, mas com estratégias distintas entre as classes que a implementem. Neste caso, a nossa interface arma tem como método 'atacar'. O ponto importante para se atentar é que a interface dita o comportamento que deve ter, não a implementação dele de forma direta, ou como ele literalmente acontece. 
As classes EspadaLonga, MachadoGuerra e ArcoElfico são extendidas da nossa interface Arma, ou seja, elas obrigatoriamente devem implementar o método 'atacar', cada uma com a sua implementação e características isoladas. 
EX: o dano do Machado de Guerra será sempre diferente do Arco Elfico. 
Na classe 'Personagem', todos os personagens tem o direito de estar em uma batalha com alguma arma. Então neste ponto utilizamos a *Strategy*. O personagem implementa uma nova classe, no nosso caso é 'EquiparArma', em que este tem como atributos a nossa interface Arma. Ou seja, o personagem obrigatoriamente tem a posse de uma arma, mas não sabe qual é, e nem precisa saber. 
Caso o design pattern não fosse utilizado, não haveria a utilização do SOLID, especificamente do open-closed, que dita que um sistema deve ser aberto para extensões e fechado para modificações. Visto que, sem o strategy, caso adicionassemos mais um tipo de arma, deveriamos mudar toda a estrutura do projeto.
