import java.util.*;

public class MovieRentingSystem {
    // helper class for entries in sets
    private static class Entry {
        int price;
        int shop;
        int movie;
        Entry(int p, int s, int m) {
            price = p;
            shop = s;
            movie = m;
        }
        // equals + hashCode needed for TreeSet removal by object
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Entry)) return false;
            Entry e = (Entry) o;
            return price == e.price && shop == e.shop && movie == e.movie;
        }
        @Override
        public int hashCode() {
            return Objects.hash(price, shop, movie);
        }
    }

    // Comparator for sorting unrented entries by (price, shop)
    private static final Comparator<Entry> cmpUnrented = (a, b) -> {
        if (a.price != b.price)
            return Integer.compare(a.price, b.price);
        return Integer.compare(a.shop, b.shop);
    };

    // Comparator for sorted all rented, ordering (price, shop, movie)
    private static final Comparator<Entry> cmpRented = (a, b) -> {
        if (a.price != b.price)
            return Integer.compare(a.price, b.price);
        if (a.shop != b.shop)
            return Integer.compare(a.shop, b.shop);
        return Integer.compare(a.movie, b.movie);
    };

    // Data structures
    // For each movie, shops with unrented copy, sorted
    private Map<Integer, TreeSet<Entry>> unrentedByMovie;
    // For all rented entries
    private TreeSet<Entry> rentedSet;
    // Price lookup
    private Map<Long, Integer> priceMap;  
    // We'll encode (shop, movie) pair into Long key for priceMap

    public MovieRentingSystem(int n, int[][] entries) {
        unrentedByMovie = new HashMap<>();
        rentedSet = new TreeSet<>(cmpRented);
        priceMap = new HashMap<>();

        for (int[] e : entries) {
            int shop = e[0];
            int movie = e[1];
            int price = e[2];
            long key = makeKey(shop, movie);
            priceMap.put(key, price);

            // add to unrented
            unrentedByMovie
                .computeIfAbsent(movie, k -> new TreeSet<>(cmpUnrented))
                .add(new Entry(price, shop, movie));
        }
    }

    public List<Integer> search(int movie) {
        List<Integer> result = new ArrayList<>();
        TreeSet<Entry> set = unrentedByMovie.get(movie);
        if (set == null) return result;
        int count = 0;
        for (Entry e : set) {
            result.add(e.shop);
            count++;
            if (count == 5) break;
        }
        return result;
    }

    public void rent(int shop, int movie) {
        long key = makeKey(shop, movie);
        int price = priceMap.get(key);
        Entry entry = new Entry(price, shop, movie);
        // remove from unrented
        TreeSet<Entry> set = unrentedByMovie.get(movie);
        if (set != null) {
            set.remove(entry);
        }
        // add to rented
        rentedSet.add(entry);
    }

    public void drop(int shop, int movie) {
        long key = makeKey(shop, movie);
        int price = priceMap.get(key);
        Entry entry = new Entry(price, shop, movie);
        // remove from rented
        rentedSet.remove(entry);
        // add back to unrented
        unrentedByMovie
            .computeIfAbsent(movie, k -> new TreeSet<>(cmpUnrented))
            .add(entry);
    }

    public List<List<Integer>> report() {
        List<List<Integer>> result = new ArrayList<>();
        int count = 0;
        for (Entry e : rentedSet) {
            result.add(Arrays.asList(e.shop, e.movie));
            count++;
            if (count == 5) break;
        }
        return result;
    }

    // Helper to make a unique key for (shop, movie)
    private long makeKey(int shop, int movie) {
        return ((long)shop << 32) ^ movie;
    }
}
