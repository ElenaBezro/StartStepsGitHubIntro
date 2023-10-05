import java.util.List; // LinkedList, ArrayList

public interface Searchable {

    /**
     *
     * @param name a name or part of a name to look up
     *                 "A"
     *                 "a"
     *
     * @return a result list
     *
     * 0 results: an empty list
     *
     * 1 result:  a list with one entry
     *
     * n results (where n > 1): a list with n entries
     */

    List<Artist> search(String name);

}