package leetcode_medium;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.
 * Implement the LRUCache class:
 * LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
 * int get(int key) Return the value of the key if the key exists, otherwise return -1.
 * void put(int key, int value) Update the value of the key if the key exists. Otherwise, add the key-value pair to the cache. If the number of keys exceeds the capacity from this operation, evict the least recently used key.
 * The functions get and put must each run in O(1) average time complexity.
 * <p>
 * Example 1:
 * <p>
 * Input
 * ["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
 * [[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
 * Output
 * [null, null, null, 1, null, -1, null, -1, 3, 4]
 * <p>
 * https://www.youtube.com/watch?v=iEmActx7dYc&ab_channel=KnowledgeCenter
 * https://www.youtube.com/watch?v=xpSfcHDTPZQ&ab_channel=AlgorithmsMadeEasy (Recommended)
 * <p>
 * Time Complexity : O(n)
 * Space Complexity: O(1)
 */
public class LRU_Cache {

    // LinkedHashMap - is maintained the key order. It's a great choice for simple LRU cache implementation.
    // Doubly Linked List + HashMap - If you need a more advanced caching mechanism(e.g., time-based expiration, frequency-based caching).

    Node head = new Node(0, 0), tail = new Node(0, 0);
    Map<Integer, Node> map = new HashMap<>();
    int capacity;

    public LRU_Cache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node data = map.get(key);
            //move data to the top
            //remove the node
            remove(data);
            //insert it
            insert(data);
            return data.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        //if value is already present we move it to top
        if (map.containsKey(key)) {
            remove(map.get(key));
        }
        //if cache is full
        if (capacity == map.size()) {
            remove(tail.prev);
        }
        //tail.prev --> least recently used
        insert(new Node(key, value));
    }

    void remove(Node node) {
        map.remove(node.key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    void insert(Node node) {
        map.put(node.key, node);
        Node headNext = head.next;
        head.next = node;
        node.prev = head;
        headNext.prev = node;
        node.next = headNext;
    }

    class Node {
        Node prev, next;
        int key, value;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }


//    private int _capacity;
//    private LinkedHashMap<Integer, Integer> _map;
//
//    private LRU_Cache(int capacity) {
//        _capacity = capacity;
//        _map = new LinkedHashMap<>();
//    }
//
//    private int get(int key) {
//        if (_map.containsKey(key)) {
//            int val = _map.get(key);
//            _map.remove(key);
//            _map.put(key, val);
//            return key;
//        }
//        return -1;
//    }
//
//    private void put(int key, int value) {
//        if (_map.containsKey(key)) {
//            _map.remove(key);
//            _map.put(key, value);
//        } else if (_map.size() == _capacity) {
//            _map.remove(_map.keySet().iterator().next());
//        }
//        _map.put(key, value);
//    }

}
