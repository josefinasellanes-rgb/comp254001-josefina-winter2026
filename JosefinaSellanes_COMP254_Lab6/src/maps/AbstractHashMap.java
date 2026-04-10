package maps;

import java.util.ArrayList;
import java.util.Random;

public abstract class AbstractHashMap<K, V> extends AbstractMap<K, V> {
  protected int n = 0;
  protected int capacity;
  private int prime;
  private long scale, shift;

  private double maxLoadFactor;

  public AbstractHashMap(int cap, int p, double loadFactor) {
    prime = p;
    capacity = cap;
    maxLoadFactor = loadFactor;

    Random rand = new Random();
    scale = rand.nextInt(prime - 1) + 1;
    shift = rand.nextInt(prime);

    createTable();
  }

  public AbstractHashMap(int cap) {
    this(cap, 109345121, 0.5);
  }

  public AbstractHashMap() {
    this(17, 109345121, 0.5);
  }

  public void setMaxLoadFactor(double lf) {
    this.maxLoadFactor = lf;
  }

  @Override
  public int size() {
    return n;
  }

  @Override
  public V get(K key) {
    return bucketGet(hashValue(key), key);
  }

  @Override
  public V remove(K key) {
    return bucketRemove(hashValue(key), key);
  }

  @Override
  public V put(K key, V value) {
    V answer = bucketPut(hashValue(key), key, value);

    if ((double) n / capacity > maxLoadFactor)
      resize(2 * capacity - 1);

    return answer;
  }

  private int hashValue(K key) {
    return (int) ((Math.abs(key.hashCode() * scale + shift) % prime) % capacity);
  }

  private void resize(int newCap) {
    ArrayList<Entry<K, V>> buffer = new ArrayList<>(n);

    for (Entry<K, V> e : entrySet())
      buffer.add(e);

    capacity = newCap;
    createTable();
    n = 0;

    for (Entry<K, V> e : buffer)
      put(e.getKey(), e.getValue());
  }

  protected abstract void createTable();

  protected abstract V bucketGet(int h, K k);

  protected abstract V bucketPut(int h, K k, V v);

  protected abstract V bucketRemove(int h, K k);
}