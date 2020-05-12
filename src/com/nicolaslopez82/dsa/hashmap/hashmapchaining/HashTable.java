package com.nicolaslopez82.dsa.hashmap.hashmapchaining;

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
 */

public class HashTable {

	private HashItem[] hashTable;
	
	public HashTable() {
		hashTable = new HashItem[Constants.TABLE_SIZE];
	}
	
	public int get(int key) {
		
		int generatedArrayIndex = hash(key);
		
		if( hashTable[generatedArrayIndex] == null ) {
			return -1;
		} else  {
			
			HashItem hashItem = hashTable[generatedArrayIndex];
			
			while( hashItem != null && hashItem.getKey() != key ) {
				hashItem= hashItem.getNextHashItem();
			}
			
			if( hashItem == null ) {
				return -1;
			} else {
				return hashItem.getValue();
			}
		}
	}
	
	public void put(int key, int value) {
		
		int hashArrayIndex = hash(key);
		
		if( hashTable[hashArrayIndex] == null ) {
			System.out.println("No collision simple insertion...");
			hashTable[hashArrayIndex] = new HashItem(key, value);
		} else {
			
			System.out.println("Collision when inserting with key "+key);
			HashItem hashItem = hashTable[hashArrayIndex];
			
			while( hashItem.getNextHashItem() != null )  {
				hashItem = hashItem.getNextHashItem();
				System.out.println("Considering the next item in linked list "+hashItem.getValue());
			}
			
			System.out.println("Finally we have found the place to insert...");
			hashItem.setNextHashItem(new HashItem(key, value));
		}
	}
	
	private int hash(int key) {
		return key % Constants.TABLE_SIZE;
	}
}
