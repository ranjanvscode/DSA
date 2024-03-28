package HashMap;
import java.util.LinkedList;

class HashMapImp<K , V>{
    private final static float DEFAULT_LOAD_FACTOR = 0.75f;
    private final static int DEFAULT_CAPACITY = 4;

    private int size=0;

    class Node{
        K key;
        V value;
        Node(K key, V value)
        {
            this.key = key;
            this.value = value;
        }
    }

    LinkedList<Node>[] Bucket;
    private void createBucket(int N)
    {
        Bucket = new LinkedList[N];

        for (int i=0;i<N;i++){
            Bucket[i] = new LinkedList<>();
        }
    }

    public HashMapImp(){
        createBucket(DEFAULT_CAPACITY);
    }

    private int HashFunc(K key)
    {
        int ky=key.hashCode();
        return Math.abs(ky) % Bucket.length;
    }

    private Node searchKey( LinkedList<Node> currentBucket, K key)
    {
        for (Node node : currentBucket) {
            if (node.key == key) return node;
        }
        return null;
    }

    private void rehash(int len){
        LinkedList<Node>[] oldBucket = Bucket;
        createBucket(len);
        size=0;

        for(var node:oldBucket){
            for (var ent:node){
                put(ent.key,ent.value);
            }
        }
    }


    public void put(K key, V value)
    {
        int bi = HashFunc(key);
        LinkedList<Node> currBucket = Bucket[bi];
        Node node = searchKey(currBucket,key);

        if (node!=null) {
            node.value = value;
        }else {
            Node newNode = new Node(key,value);
            currBucket.add(newNode);
            size++;
        }
        if (size>= Bucket.length*DEFAULT_LOAD_FACTOR){
            rehash(Bucket.length*2);
        }
    }

    public V remove(K key){
        int bi = HashFunc(key);
        LinkedList<Node> currBucket = Bucket[bi];
        Node node = searchKey(currBucket,key);

        V val;

        if (node!=null)
            val = node.value;
        else val=null;

        if (node!=null) {
            size--;
            currBucket.remove(node);
        }

        return val;
    }

    public V get(K key)
    {
        int bi = HashFunc(key);
        LinkedList<Node> currBucket = Bucket[bi];
        Node node = searchKey(currBucket,key);

        if (node!=null) return node.value;
        else return null;
    }

    public int getSize()
    {
        return size;
    }
}

public class HashMapImplementation {


    public static void main(String[] args) {

            HashMapImp<String,Integer> HP = new HashMapImp<>();

            HP.put("A",1);
            HP.put("B",2);
            HP.put("C",3);
            HP.put("D",4);
            HP.put("E",5);
            HP.put("F",6);
            HP.put("G",7);
            HP.put("H",8);
            HP.put("I",9);
            HP.put("J",10);
            HP.put("K",11);
            HP.put("L",11);

        System.out.println(HP.remove("E"));
        System.out.println(HP.getSize());
        HP.put("A",23);
        System.out.println(HP.get("A"));
        System.out.println(HP.getSize());
        System.out.println(HP.Bucket.length);
        System.out.println(HP.Bucket.length*0.75);


    }
}
