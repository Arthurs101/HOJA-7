/*
Clase referente a una clase Association<K,V>
*/
public class Association<K,V> {
    private K key;
    private V value;
    public Association(K KEY, V VALUE) {
        key = KEY;
        value = VALUE;
    }
    public K getKey() {
        return key;
    }
    public V getValue() {
        return value;
    }
    public void setKey(K key) {
        this.key = key; 
    }
    public void setValue(V value) {
        this.value = value;
    }


}