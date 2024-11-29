# Bem-vindo ao Back-End do VAGAS!

Desenvolvi este projeto com muito cuidado e dedicação, buscando criar uma interface o mais intuitiva possível. Ele é um reflexo do meu estilo de programação e, embora haja sempre espaço para melhorias, estou evoluindo a cada dia. Concluir um software com back-end e front-end em apenas 7 dias foi um grande desafio.

Aprendi muito durante esses 7 dias. O projeto ainda não está 100% finalizado, e peço desculpas por isso, pois 7 dias é realmente um prazo apertado.

Confesso que estou ansioso para saber o resultado. Independentemente do que acontecer, agradeço por esta oportunidade e espero que o sistema Pacto prospere, com ou sem a minha participação!

# Requisitos

## Instalação
Certifique-se de que o **Docker Desktop** está instalado em sua máquina.

## Configuração
Para configurar e iniciar os serviços necessários, execute os seguintes comandos no terminal:

```bash
docker-compose down
docker-compose up -d
docker-compose up --build
```

## Banco de Dados
O banco de dados está configurado para operar na porta **5433**. Se houver algum serviço já utilizando esta porta, altere a configuração no arquivo `docker-compose.yml`.

### Criação do Banco de Dados
Se ocorrer algum erro com a criação automática do banco de dados, você deverá criá-lo manualmente. Isso pode ser feito acessando o **pgAdmin** ou outro administrador de banco de dados de sua escolha.

## Compilação do Projeto
Após garantir que o banco de dados esteja corretamente configurado e criado, compile o projeto com o seguinte comando:

```bash
./gradlew build
```

## Execução
Execute o projeto através do **IntelliJ IDEA** ou sua IDE preferida.


O Frot-end tem que estar em execução, você pode acessar pelo github ou pelo arquivo anexo no email.
[Visite o GitHub!](https://github.com/viMoraes10/vagasFront/tree/master)

 