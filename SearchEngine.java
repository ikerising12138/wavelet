import java.util.ArrayList;
import java.io.IOException;
import java.net.URI;

public class SearchEngine {
    ArrayList<String> lst = new ArrayList<>();

    public String handleRequest(URI url) {


        System.out.println(url.getQuery());
        int num = 0;
        if (url.getPath().equals("/")) {
            return String.format("Kay's Number: %d", num);
        } else if (url.getPath().equals("/increment")) {
            num += 1;
            return String.format("Number incremented!");
        } else {
            System.out.println("Path: " + url.getPath());
            if (url.getPath().contains("/add")) {
                String[] parameters = url.getQuery().split("=");
                if (parameters[0].equals("count")) {
                    num += Integer.parseInt(parameters[1]);
                    return String.format("Number increased by %s! It's now %d", parameters[1], num);
                }
            }
            return "404 Not Found!";
        }
    }
}
