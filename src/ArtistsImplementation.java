import java.util.ArrayList;
import java.util.List;

public class ArtistsImplementation implements Searchable {

    // private List<Artist> artists = new ArrayList<>();

    // private OwnList artists = new OwnList();

    // private Artist artist = new Artist();
    private Artist[] artists = new ArtistImplementation[4]; // remember the references

    private int count;

    public void add(ArtistImplementation artist) {
        artists[count++] = artist;
    }

    public Artist get(int index) {
        return artists[index];
    }

    @Override
    public List<Artist> search(String search) {
        List<Artist> searchResult = new ArrayList<>();
            for (Artist artist: artists) {
                boolean isMatched = artist.getName().toLowerCase().contains(search.toLowerCase());

                if (isMatched) {
                    searchResult.add(artist);
                }
            }
        if (searchResult.size() > 0) {
            System.out.println("Artist list is empty");
        }
        return searchResult;
    }
}
