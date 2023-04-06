import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;

public class Simulazione {

    public static List<String> loadLines(String filepath) throws IOException {
        /* 1) FileReader fileReader = new FileReader(filepath);
        BufferedReader br = new BufferedReader(fileReader);
        List<String> righe = new ArrayList<>();
        while (br.ready()) {
            righe.add(br.readLine());
        }
        br.close();
        return righe; */
        // 2) return Files.readAllLines(Path.of(filepath));
        // 3)
        return Files.lines(Path.of(filepath)).toList();
    }

    public static HashMap<String, Integer> processLines(List<String> lines) {
        HashMap<String, Integer> mappa = new HashMap<>();
        for (String riga : lines) {
            if (riga.length() == 0) continue;
            if (riga.indexOf("$") == -1) {
                System.out.println("il carattere $ non è presente");
            }
            else {
                String[] rigaSplit = riga.split("\\$");
                String chiave = rigaSplit[0].strip();
                int valore = rigaSplit[1].strip().split(" ").length;
                mappa.put(chiave, valore);
            }
        }
        return mappa;
    }

    public static void writeLines(String filepath, HashMap<String, Integer> map) throws IOException {
        FileWriter fileWriter = new FileWriter(filepath);
        BufferedWriter bw = new BufferedWriter(fileWriter);
        for (String key : map.keySet()) {
            String line = key.toUpperCase() + " - " + map.get(key) + "\n";
            bw.write(line);
        }
        bw.close();
    }

}
