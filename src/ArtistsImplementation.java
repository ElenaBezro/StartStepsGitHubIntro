public class ArtistsImplementation {

    // private List<Artist> artists = new ArrayList<>();

    // private OwnList artists = new OwnList();

    // private Artist artist = new Artist();
    private Artist[] artists = new Artist[4]; // remember the references

    private int count;

    public void add(Artist artist) {
        artists[count++] = artist;
    }

    public Artist get(int index) {
        return artists[index];
    }

    // search
}
