package CS113.Interfaces;

import CS113.ArrayListKB;

import java.util.ArrayList;

public interface MapInterface<K, V> {

    // Returns the number of key-value mappings in this map
    int size();

    // Returns true if this map contains no key-value mappings
    boolean isEmpty();

    // Returns true if this map contains a mapping for the specified key
    boolean containsKey(K key);

    // Returns true if this map maps one or more keys to the specified value
    boolean containsValue(V value);

    // Returns the value to which the key is mapped, or null if not found
    V get(K key);

    // Associates the specified value with the specified key in this map
    V put(K key, V value);

    // Removes the mapping for a key from this map if it is present
    V remove(K key);

    // Removes all of the mappings from this map
    void clear();

    // Returns an ArrayList of the keys contained in this map
    ArrayListKB<K> keySet();

    // Returns an ArrayList of the values contained in this map
    ArrayListKB<V> values();

    // Interface for a single key-value pair (used in entrySet)
    interface Entry<K, V> {
        K getKey();
        V getValue();
        V setValue(V value);
    }
}