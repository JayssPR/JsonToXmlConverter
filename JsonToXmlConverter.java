import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class JsonToXmlConverter {
    public static void main(String[] args) {
        // URL of the JSON file hosted online
        String fileUrl = "https://drive.google.com/uc?export=download&id=1mJO0ugJWvtbWZhv8qGmVide3KwQ9GsqR";

        try {
            // Create a URL object from the specified string
            URL url = new URL(fileUrl);

            // Open a BufferedReader to read from the URL
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()))) {
                System.out.println("Reading JSON data from: " + fileUrl);

                // Jackson ObjectMapper to parse JSON
                ObjectMapper objectMapper = new ObjectMapper();

                // Read JSON directly as a List
                List<Anime> list = objectMapper.readValue(reader, List.class);

                // Wrap the list of animes into an Animes object
                Animes animes = new Animes();
                animes.setAnimes(list);

                // Create an XmlMapper to convert Java objects to XML
                XmlMapper xmlMapper = new XmlMapper();

                // Define the output XML file
                String xmlFile = "animes.xml";

                // Write the XML content into the file
                try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(xmlFile))) {
                    xmlMapper.writeValue(writer, animes);
                }
                System.out.println("Data saved in " + xmlFile);

                // Show the contents of the saved XML file using BufferedReader
                System.out.println("===== Content of " + xmlFile + " =====");
                try (BufferedReader Reader = Files.newBufferedReader(Paths.get(xmlFile))) {
                    String line;
                    while ((line = Reader.readLine()) != null) {
                        System.out.println(line);
                    }
                }

            }

        } catch (IOException e) {
            System.err.println("Error opening the URL: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("General error: " + e.getMessage());
        }
    }
}
