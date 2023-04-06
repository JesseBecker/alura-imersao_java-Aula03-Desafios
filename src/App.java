import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.util.List;

public class App {

    public static void main(String[] args) throws Exception {

        API api = API.IMDB_TOP_MOVIES;  //Desafio_4 Aula_3
        //API api = API.IMDB_TOP_SERIES;  //Desafio_4 Aula_3
        //API api = API.NASA;             //Desafio_4 Aula_3

        String url = api.getUrl();
        ExtratorDeConteudo extrator = api.getExtrator();
        
        var http = new ClienteHttp();
        String json = http.buscaDados(url);

        List<Conteudo> conteudos = extrator.extraiConteudos(json);

        var geradora = new GeradoraDeFigurinhas();

        var diretorio = new File("saida/"); 
        diretorio.mkdir();                           
        
        for (int i = 0; i < 3; i++) {

            Conteudo conteudo = conteudos.get(i);
            
            InputStream inputStream = new URL(conteudo.urlImage()).openStream();
            String nomeArquivo = "saida/" + conteudo.titulo().replace(":", " -") + ".png";

            geradora.cria(inputStream, nomeArquivo);

            System.out.println(conteudo.titulo());
            System.out.println();
        }
    }
}
