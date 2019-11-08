import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Scanner;
import java.awt.Desktop;
import java.net.URI;

public class Main {
    public static void main(String[] args) throws URISyntaxException, IOException {
        System.out.println("!stop");
        System.out.println("If you want to stop the loop.");

        while (true) {
            Scanner reader = new Scanner(System.in);
            System.out.print("Give me a keyword: ");
            String keyword = reader.nextLine();
            System.out.println("");

            keyword = keyword.replace(" ","%20");

            if (keyword.equalsIgnoreCase("!stop")) {
                break;
            }

            System.out.println("You can choose between a lot of search engines.");
            System.out.println("Google, Bing, DuckDuckGo, Gibiru, Search Encrypt, Swisscows");
            System.out.print("Which search engine do you want to use? ");
            String engine = reader.nextLine();
            System.out.println("");

            engine = engine.replaceAll(" ", "");

            if (engine.equalsIgnoreCase("!stop")) {
                break;
            }

            char timesEngineChar = ',';
            int times = 0;

            for (int i = 0; i < engine.length(); i++) {
                if (engine.charAt(i) == timesEngineChar) {
                    times++;
                }
            }
            times++;

            if (times >= 1){
                String[] engines = engine.split(",");
                String engine1 = engines[0];
                searchWithEngine(engine1, keyword);
                if (times >= 2) {
                    String engine2 = engines[1];
                    searchWithEngine(engine2, keyword);
                    if (times >= 3) {
                        String engine3 = engines[2];
                        searchWithEngine(engine3, keyword);
                        if (times >= 4) {
                            String engine4 = engines[3];
                            searchWithEngine(engine4, keyword);
                            if (times >=  5) {
                                String engine5 = engines[4];
                                searchWithEngine(engine5, keyword);
                                if (times >= 6) {
                                    String engine6 = engines[5];
                                    searchWithEngine(engine6, keyword);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private static void searchWithEngine(String engine, String keyword) throws URISyntaxException, IOException {
        String baseUrl = null;

        switch(engine.toLowerCase()){
            case "google" : baseUrl = "http://google.com/search?q=";
                break;
            case "bing" : baseUrl = "https://www.bing.com/search?q=";
                break;
            case "duckduckgo" : baseUrl = "http://duckduckgo.com/?q=";
                break;
            case "gibiru" : baseUrl = "http://gibiru.com/results.html?q=";
                break;
            case "searchencrypt" : baseUrl = "http://www.searchencrypt.com/search?eq=";
                break;
            case "swisscows" : baseUrl = "http://www.swisscows.com/web?query=";
                break;
            case "ecosia" : baseUrl = "http://www.ecosia.org/search?q=";
                break;
            default:
            System.err.println("Engine is not supported: " + engine);
                break;
        }
        if (baseUrl != null) {
            String url = baseUrl + keyword;
            System.out.println("Searching: " + url);
            Desktop.getDesktop().browse(new URI(url));
        }
    }
}


