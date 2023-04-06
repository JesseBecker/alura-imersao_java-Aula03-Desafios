//Desafio_4 Aula_3
public enum API {
    
    IMDB_TOP_MOVIES("https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json", new ExtratorDeConteudoDoIMDB()),
    //String imdbKey = System.getenv("IMDB_API_KEY"), 
    IMDB_TOP_SERIES("https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopTVs.json", new ExtratorDeConteudoDoIMDB()),
    NASA("https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY&start_date=2022-06-10&end_date=2022-06-14", new ExtratorDeConteudoDaNasa());
    //NASA("https://api.nasa.gov/planetary/apod?api_key=" + nasaKey + "&start_date=2022-06-10&end_date=2022-06-14";);
    //String nasaKey = System.getenv("NASA_API_KEY");

    private String url;
    private ExtratorDeConteudo extrator;

    API(String url, ExtratorDeConteudo extrator) {
        this.url = url;
        this.extrator = extrator;
    }

    public String getUrl() {
        return url;
    }

    public ExtratorDeConteudo getExtrator() {
        return extrator;
    }

}
