package com.nicolaslopez82.dsa.ternarysearchtree;

/**
 *
 * TST:
 *
 * - With the help of tries we can search and sort strings very very efficiently.
 * - The problem is that tries consume a lot of memory, so we should use ternary search trees instead which stores less references and null objects.
 * - TST stores characters or strings in nodes.
 * - Each node has 3 children: less (lower child), equal (middle child) or greater (higher child).
 * - Can we balance TST-s with rotations? Yes, but it does not worth the trouble.
 * - It can be used instead of hashmap: it is as efficient as hashing.
 * - Hashing need to examine the entire string key ... TST does not.
 *
 * - TST support sorting operation !!!
 * - So: TST is better than hashing  especially for search misses + flexible than BST ( usually there is no perfect hash function )
 * - Conclusion: TST is faster than hashmap and more flexible than binary search trees
 * 
 * ===============================================================================================================
 *
 *  Motivation:
 *
 *  - Hashmaps are very efficient so far: we can achieve O(1)
 *    running time for the most important operations.
 *
 *  - Does not support sorting + hashfunction is usually not perfect: we would
 *    like to construct a data structure where search and insert operations have
 *  	 running time proportional to the length of the key !!!
 *  		~ hashmap worst case search: O(N)
 *
 *  - We would like to get rid of collisions: this can be solved with tries
 *  + add another feature: sorting!!!
 *
 *  ===============================================================================================================
 *
 *  TRIES:
 *  - Trie / radix tree / prefix tree.
 *  - It is a data structure to implement associative arrays.
 *  - The keys are usually strings.
 *  - Unlike BST no node in the tree stores the key associated with that given node  its position in the
 *    tree defines the key with which it is associated.
 *  - All the descendants of a node have a common prefix of the string associated with that node, and the root
 *    is associated with the empty string
 *  - Values are not necessarily associated with every node // usually leaf nodes only.
 *
 *  - With the help of tries we can search and sort strings very very efficiently.
 *  - The problem is that tries consume a lot of memory, so we should use ternary search trees instead which
 *    stores less references and null objects.
 *
 * ===============================================================================================================
 *
 * - put: with this operation we would like to insert a new element into the
 * 	ternary search tree with a given key:
 *      - if the character is smaller alphabetically: we go to the left.
 *      - if the character is equal: we go to the middle.
 *      - if the character is greater alphabetically: go right.
 *
 * ===============================================================================================================
 *
 * TST vs Hashing:
 *
 * Hashing
 * - Need to examine the entire key ( because that is the way the hash function works ).
 * - Search hits and misses cost the same.
 * - The running time and performance relies heavily on the hashfunction.
 * - Does not support as much operations than TST ( sorting ).
 *
 * TST
 * - Works only for strings.
 * - Only examines just enough key characters.
 * - Search miss may only involve a few characters.
 * - Support more operations ( sorting ).
 * - Faster than hashing ( for misses especially ) and more flexible than BST.
 *
 * ===============================================================================================================
 *
 * Applications:
 *
 * - It can be used to implement the auto-complete feature very very efficiently.
 * - Can be used for spell-checkers.
 * - Near-neighbor searching (of which a spell-check is a special case).
 * - For databases especially when indexing by several non-key fields is desirable.
 * - Very important in package routing on WWW  the router direct the packages in the direction of the longest prefix.
 *   It can be found very quickly with the help of TST-s.
 * - Prefix matching  ~ google search.
 * - We can use DFS instead usually.
 *
 * ===============================================================================================================
 *
 * Important notes: 
 * - We should combine tries with TST.
 * - At the root: it is a trie with many many children.
 * - At lower levels it becomes a TST with 3 children only.
 * - This combination is quite efficient!!!
 *
 * ===============================================================================================================
 *
 * 
 *
 */

public class TST {

	private Node rootNode;
	
	public void put(String key, int value){
		rootNode = put(rootNode,key,value,0);
	}

	private Node put(Node node, String key, int value, int index) {
		
		char c = key.charAt(index);
		
		if( node == null ){
			node = new Node(c);
		}
		
		if( c < node.getCharacter() ){
			node.setLeftNode(put(node.getLeftNode(),key,value,index));
		}else if( c > node.getCharacter() ){
			node.setRightNode(put(node.getRightNode(),key,value,index));
		}else if( index < key.length()-1 ){
			node.setMiddleNode(put(node.getMiddleNode(),key,value,index+1));
		}else{
			node.setValue(value);
		}
		
		return node;
	}
	
	public Integer get(String key){
		
		Node node = get(rootNode,key,0);
		
		if( node == null ){
			return null;
		}
		
		return node.getValue();
	}

	private Node get(Node node, String key, int index) {
		
		if( node == null ) return null;
		
		char c = key.charAt(index);
		
		if( c < node.getCharacter() ){
			return get(node.getLeftNode(),key,index);
		}else if( c > node.getCharacter() ){
			return get(node.getRightNode(), key, index);
		}else if( index < key.length()-1){
			return get(node.getMiddleNode(),key,index+1);
		}else{
			return node;
		}
		
	}

}
