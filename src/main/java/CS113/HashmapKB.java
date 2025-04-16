package CS113;

import CS113.Interfaces.IteratorInterface;
import CS113.Interfaces.MapInterface;


public class HashmapKB<K,V> implements MapInterface<K,V> {

    class Entry<K,V> implements MapInterface.Entry<K,V> {
        K key;
        V value;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public K getKey() {
            return this.key;
        }

        @Override
        public V getValue() {
            return this.value;
        }

        @Override
        public V setValue(V value) {
            return this.value = value;
        }

    }
    final int BUCKET_COUNT = 9;
    LinkedListKB<Entry<K,V>>[] buckets = new LinkedListKB[BUCKET_COUNT];
    int count = 0;
    int capacityFactor = 0;

    public HashmapKB() {
        for(int i = 0; i < buckets.length; i++) {
            buckets[i] = new LinkedListKB<>();
        }
        capacityFactor = (int)((double)buckets.length *.75);
    }

    public int getHash(K key){
        return Math.abs(key.hashCode()) % buckets.length;
    }

    @Override
    public int size() {

        return this.count;
    }

    @Override
    public boolean isEmpty() {
        return this.count == 0;
    }

    @Override
    public boolean containsKey(K key) {
        return false;
    }


    void rehash(){
        LinkedListKB<Entry<K,V>>[] oldBuckets = buckets;
        buckets = new LinkedListKB[buckets.length * 2];

        for(int i = 0; i < buckets.length; i++) {
            buckets[i] = new LinkedListKB<>();
        }
        capacityFactor = (int)((double)buckets.length *.75);

        for(LinkedListKB<Entry<K,V>> bucket : buckets) {
            IteratorInterface<Entry<K,V>> iterator = bucket.iterator();
            while(iterator.hasNext()){
                Entry<K,V> temp = iterator.next();
                int index = getHash(temp.getKey());
                LinkedListKB<Entry<K,V>> newBucket = buckets[index];
                newBucket.addLast(temp);
            }
        }
    }


    @Override
    public boolean containsValue(V value) {

        for(LinkedListKB<Entry<K,V>> bucket : buckets) {
            IteratorInterface<Entry<K,V>> iterator = bucket.iterator();
            while(iterator.hasNext()) {
                if(iterator.next().getValue().equals(value)) {
                    return true;
                }
            }
        }

        return false;  // O(n) worst case
    }

    @Override
    public V get(K key) {
        int index = getHash(key);
        LinkedListKB<Entry<K,V>> bucket = buckets[index];
        IteratorInterface<Entry<K,V>> iterator = bucket.iterator();

        while(iterator.hasNext()) {
            Entry<K,V> entry = iterator.next();
            if(entry.key == key){
                 return entry.getValue();
            }
        }
        return null;//best O(1)
                    //typical O(logn)
                    // worst O(n)
    }

    @Override
    public V put(K key, V value) {
        int index = getHash(key);
        LinkedListKB<Entry<K,V>> bucket = buckets[index];
        IteratorInterface<Entry<K,V>> iterator = bucket.iterator();

        while(iterator.hasNext()) {
            Entry<K,V> entry = iterator.next();
            if(entry.key == key){
                entry.setValue(value);
                return value;
            }
        }

        count++;
        bucket.addLast(new Entry<>(key, value));

        if(count > capacityFactor){rehash();}

        return value;
    }

    @Override
    public V remove(K key) {
        int index = getHash(key);
        LinkedListKB<Entry<K,V>> bucket = buckets[index];
        IteratorInterface<Entry<K,V>> iterator = bucket.iterator();

        while(iterator.hasNext()) {
            Entry<K,V> entry = iterator.next();
            if(entry.key == key){
                V temp = entry.getValue();
                iterator.remove();
                count--;
                return temp;
            }
        }
        return null;
    }

    @Override
    public void clear() {

    }

    @Override
    public ArrayListKB<K> keySet() {
        return null;
    }

    @Override
    public ArrayListKB<V> values() {
        ArrayListKB<V> returnValues = new ArrayListKB<>();

        for(LinkedListKB<Entry<K,V>> bucket : buckets) {
            IteratorInterface<Entry<K,V>> iterator = bucket.iterator();
                while(iterator.hasNext()) {
                    returnValues.add(iterator.next().getValue());
            }
        }
        return returnValues;
    }
}
