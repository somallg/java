package java.chapter05.item27;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by somallg on 8/23/14.
 */
public class Favorites {

    private Map<Class<?>, Object> favorites = new HashMap<Class<?>, Object>();


    public <T> void putFavorite(Class<T> type, T instance) {
        if (type == null) {
            throw new NullPointerException("Type is null");
        }
        favorites.put(type, type.cast(instance));
    }

    public <T> T getFavorite(Class<T> type) throws IllegalAccessException, InstantiationException {
        return type.cast(favorites.get(type));
    }

    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        Favorites f = new Favorites();
        f.putFavorite(String.class, "Java");
        f.putFavorite(Integer.class, 0xcafebabe);
        f.putFavorite(Class.class, Favorites.class);

        String favoriteString = f.getFavorite(String.class);
        int favoriteInt = f.getFavorite(Integer.class);
        Class<?> favoriteClass = f.getFavorite(Class.class);

        System.out.printf("%s %x %s %n", favoriteString, favoriteInt, favoriteClass.getName());

    }


}
