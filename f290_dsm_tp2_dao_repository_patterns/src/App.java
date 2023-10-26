import java.sql.Connection;
import java.sql.ResultSet;
import java.util.List;

import dao.factories.ConexaoFactory;
import dao.factories.ContatoMySqlDAO;
import dao.factories.IContatoDAO;
import domain.ContatoVO;
//import repositories.ContatoInMemoryRepository;
import repositories.ContatoMySqlRepository;
import repositories.IContatoRepository;
import services.ContatoService;
import services.IContadoService;

public class App {
    public static void main(String[] args) throws Exception {

        /*
         * Este conjunto de instruções inicializaram as dependencias 
         * para o uso do serviço de contatos utilizando o repositório
         * com o SGBD MySQL.
         */
       Connection conexao = ConexaoFactory.getConexao();
       IContatoDAO dao = new ContatoMySqlDAO(conexao);
        IContatoRepository repository = new ContatoMySqlRepository(dao);
             // TODO: Altere o repositório MySQL pelo repositório em memória

       // IContatoRepository repository2 = new ContatoInMemoryRepository();


        IContadoService service = new ContatoService(repository);

        // Criar objeto ContatoVO e realizar chamada do metodo salvar do service
        ContatoVO c1 = new ContatoVO(
                null,
                "Maria Silva",
                "maria.silva@email.com",
                "1234567890",
                "maria_silva_li");

        // Chamada do metodo de persistencia
        // TODO: Descomente o trecho abaixo para persisitir em baco de dados e consulte o banco de dados
        //service.salvar(c1);

        //TODO: Criar mais 2 contatos.
        ContatoVO c2 = new ContatoVO(
                null,
                "João Pereira",
                "joao.pereira@email.com",
                "9876543210",
                "joao_pereira_li");
                 //service.salvar(c2);

        ContatoVO c3 = new ContatoVO(
                null,
                "Ana Santos",
                "ana.santos@email.com",
                "5555555555",
                "ana_santos_li");

        //TODO: Exibir os contatos cadastrados
        service.buscarTodos();

        // TODO: Remover o primeiro contatto criado.
          service.excluir(13);

        // TODO: Buscar e exibir o segundo contato criado com base no e-mail
        service.buscarPorEmail("thiago@gmail.com");
      


   


    }
}
