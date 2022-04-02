
public class Noder<K,V>  {
        Noder<K,V> left, right; 
        Association<K,V> data;
   
        public Noder(String word, String transaltion){ 
            data = new Association(word, transaltion);
            left = right = null; 
        } 
}
