import java.util.List;

// Represents a single Anime with its details
public class Anime {
    private String title;        // Title of the anime
    private String genre;        // Genre
    private String creator;      // Creator of the anime
    private int release_year;    // Year of release
    private String description;  // Short description of the anime

    // Getters for each field (used by ObjectMapper and XmlMapper)
    public String getTitle() {
        return title;
    }
    public String getGenre() {
        return genre;
    }
    public String getCreator() {
        return creator;
    }
    public int getRelease_year() {
        return release_year;
    }
    public String getDescription() {
        return description;
    }

}

// Represents a collection of Anime objects
class Animes {
    private List<Anime> animes; // List that holds multiple Anime objects

    // Getter and setter for the list
    public List<Anime> getAnimes() {
        return animes;
    }
    public void setAnimes(List<Anime> animes) {
        this.animes = animes;
    }
}

