import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        List<String> righe = Simulazione.loadLines("resources/example.txt");
        HashMap<String, Integer> mappa = Simulazione.processLines(righe);
        Simulazione.writeLines("resources/result.txt", mappa);

    }

}
