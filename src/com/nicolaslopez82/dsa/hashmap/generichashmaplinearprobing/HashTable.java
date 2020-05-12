package com.nicolaslopez82.dsa.hashmap.generichashmaplinearprobing;

/**
 *
 * Hashtables.
 *
 * Distribute the keys uniformly into buckets.
 *
 * n: number of keys.
 * m: number of buckets // size of array.
 * h(x) = n % m   ( modulo operator ).
 *
 * We should use prime numbers both for the size of the array and in our hash function to make sure the distribution
 * of the generated indexes  will be uniform !!!
 *
 * String keys: we could calculate the ASCII value for each character, add them up -> make % modulo.
 *
 * =================================================================================================================
 *
 * Hashtables doesn't support sorting operations.
 * Lookup of value associated with a given key
 * For most of the operations -> O(1) Constant time complexity.
 *
 * Hashing -> map a certain key of any type to a random array index.
 *
 * n: number of keys
 *
 * m: number of buckets // size of the array.
 *
 * h(x) = n%m (modulo operator) // Uses prime numbers both for the size of the array in our hash function.
 *
 * Key Integer -> Modulo operator to transform the # into the range [0,m-1].
 * Key String -> calculate the  ASCII values for each character and add them -> make % modulo in order to end up with an index to the array.
 *
 * Balanced BST -> O(logN) for search.
 *
 * HashTables -> O(1) for search if we know the index (key).
 * Key -> slot in a set of buckets.
 *
 * index = h(key) where h() is the hash function, it maps the key to indexes in the array.
 *
 * =================================================================================================================
 *
 * Distribute the keys uniformly into buckets
 * n: number of keys
 * m: number of buckets // size of array
 * h(x) = n % m   ( modulo operator )
 * We should use prime numbers both for the size of the array and in our hash function to make sure the distribution of the generated indexes  will be uniform !!!
 * String keys: we could calculate the ASCII value for each character, add them up -> make % modulo
 *
 * =================================================================================================================
 *
 * Load factor: number of entries divided by the number of slots / buckets
 *
 * n/m
 *
 * This is the load factor. It is 0 if the hashtable is empty, it is
 * 1 if the hashtable is full !!!
 *
 * Load Factor n/m: Number of entries divided by the number of slots / buckets.
 *
 * n/m = 0 -> hastable empty.
 *
 * n/m = 1-> hashtable full.
 *
 * =================================================================================================================
 *
 * Collision resolution with Chaining -> we put multiple entries into the same slot with the help of a linked list.
 *
 * Collision resolution with Open Addressing: Continuous looking for an empty slot. It has different algorithmics for that:
 * Linear probing -> find the next slot empty.
 * Quadratic probing -> try units far away.
 * Rehashing -> we has the result again in order to find an empty slot.
 *
 * =================================================================================================================
 *
 * Java: when the load factor is greater than 0.75, the hashmap will be
 * 	resized automatically
 *
 *
 *
 * @param <Key>
 * @param <Value>
 */

@SuppressWarnings("unchecked")
public class HashTable<Key, Value> {

	private Key[] keys;
	private Value[] values;
	private int numOfItems;
	private int capacity;
	
	public HashTable() {
		this.keys = (Key[] ) new Object[Constants.TABLE_SIZE];
		this.values = (Value[] ) new Object[Constants.TABLE_SIZE];
		this.capacity = Constants.TABLE_SIZE;
		this.numOfItems = 0;
	}
	
	// have to define a different constructor because when we resize the table we use it !!!
	public HashTable(int capacity) {
		this.keys = (Key[] ) new Object[capacity];
		this.values = (Value[] ) new Object[capacity];
		this.capacity = capacity;
		this.numOfItems = 0;
	}
	
	public int size()  {
		return this.numOfItems;
	}
	
	public boolean isEmpty() {
		return this.numOfItems == 0;
	}

	public Value get(Key key) {
		
		if( key == null ) return null;
		
		// we have to calculate an array index from the key !!!
		int index = hash(key);
		
		// we have to consider the items right after each other because the item could have been shifted down
		// because of the linear probing
		while( keys[index] != null ) {
			if( keys[index].equals(key))
				return values[index];
			
			// have to check the next slot / array bucket
			index = (index+1) % capacity;
		}
			
		// search miss: no value with the given key
		return null;
	}
	
	public int hash(Key key) {
		return key.hashCode() % this.capacity;
	}
	
	public void put(Key key, Value value){
		
		if( key == null || value == null ) return;
		
		// load balance is 0.75: so when the table is 75% full we resize it --> double its size
		// why? when it is nearly empty --> we waste a lot of memory for no reason
		// when it is nearly full --> there will be lots of collisions --> O(1) will reduce to O(N) or something like that
		if( numOfItems >= capacity * 0.75  ) 
			resize(2*capacity);
		
		int index = hash(key);
		
		// maybe there is a collision and there is already an item inserted to that given index, so we have to
		// find an empty slot --> hence the condition != null
		while( keys[index] != null ) {
			
			// update section: we update the value when the keys are equal
			if( keys[index].equals(key) ) {
				values[index] = value;
				return;
			}
			
			index = (index+1) % capacity;
		}
		
		// we have managed to found the array index where we can insert the value --> so update accordingly !!!
		keys[index] = key;
		values[index] = value;
		numOfItems++;
	}
	
	public void remove(Key key) {
		
		if( key == null ) return;
		
		int index = hash(key);
		
		// first we have to find the item we want to get rid of
		while( !keys[index].equals(key) ) {
			index = (index+1) % capacity;
		}
		
		// we delete the item: the key + the value
		keys[index] = null;
		values[index] = null;
		
		// we have to reconstruct the table starting from the item deleted: there is a "hole" in the table,
		// the get() method will not work properly otherwise
		index = (index+1) % capacity;
		
		while( keys[index] != null ) {
			
			Key tempKey = keys[index];
			Value tempValue = values[index];
			
			keys[index] = null;
			values[index] = null;

			// we have to decrement the size, because with the put() method it will be increased again
			// so it will be fine !!!
			numOfItems--;
			put(tempKey, tempValue);
			
			index = (index+1) % capacity;
		}
		
		numOfItems--;
		
		if( numOfItems <= capacity/3 )
			resize(capacity/2);
	}
	
	private void resize(int newCapacity) {
		
		System.out.println("Resize table with new capacity: " + newCapacity);
		
		HashTable<Key, Value> newTable = new HashTable<>(newCapacity);
		
		// have to rehash the table entries because the hashfunction relies heavily on the 
		// size:    ~ key.hashCode() % sizeOfTable !!!
		// So it is a O(N) operation --> we should make as few resize operation as possible !!!
		for(int i=0;i<capacity;++i) {
			if( keys[i] != null ) {
				newTable.put(keys[i], values[i]);
			}
		}
		
		keys = newTable.getKeys();
		values = newTable.getValues();
		capacity = newTable.getCapacity();
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public Key[] getKeys() {
		return keys;
	}

	public void setKeys(Key[] keys) {
		this.keys = keys;
	}

	public Value[] getValues() {
		return values;
	}

	public void setValues(Value[] values) {
		this.values = values;
	}
}
