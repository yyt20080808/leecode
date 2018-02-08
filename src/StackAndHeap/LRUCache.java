package StackAndHeap;

import java.util.HashMap;

/**
 * Created by yyt on 2018/2/3.
 */
//Design and implement a data structure for Least Recently Used (LRU) cache.
// It should support the following operations: get and put.
//
//        get(key) - Get the value (will always be positive) of the key
// if the key exists in the cache, otherwise return -1.
//        put(key, value) - Set or insert the value if the key is not
// already present. When the cache reached its capacity,
// it should invalidate the least recently used item before inserting
// a new item.
//
//        Follow up:
//        Could you do both operations in O(1) time complexity?
//
//        Example:
//
//        LRUCache cache = new LRUCache( 2 /* capacity */ );
//
//        cache.put(1, 1);
//        cache.put(2, 2);
//        cache.get(1);       // returns 1
//        cache.put(3, 3);    // evicts key 2
//        cache.get(2);       // returns -1 (not found)
//        cache.put(4, 4);    // evicts key 1
//        cache.get(1);       // returns -1 (not found)
//        cache.get(3);       // returns 3
//        cache.get(4);       // returns 4
class LRUCache {
    private class Node {
        private int key;
        private int value;
        private Node last;
        private Node next;

        private Node() {
            last = null;
            next = null;
        }

        private Node(int key, int value) {
            last = null;
            next = null;
            this.key = key;
            this.value = value;
        }

    }

    private Node root;
    private Node tail;
    private int capacity;
    private HashMap<Integer, Node> map;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        root = new Node();
        tail = new Node();
        root.next = tail;
        tail.last = root;
        map = new HashMap<Integer, Node>();
    }

    /**
     * Always add the new node right after head;
     */
    private void addNode(Node node) {
        node.last = root;
        node.next = root.next;


        if (root.next != null) {
            root.next.last = node;
            root.next = node;
        }

    }

    public int get(int key) {
        if (map.containsKey( key )) {
            Node node = map.get( key );
            moveToHead( node );
            return node.value;
        } else
            return -1;

    }

    private void moveToHead(Node node) {
        this.removeNode( node );
        this.addNode( node );

    }

    public void put(int key, int value) {

        if (map.containsKey( key )) {
            Node node = map.get( key );
            node.value = value;
            moveToHead( node );

        } else {
            Node node = new Node( key, value );
            addNode( node );
            map.put( key, node );
            if (capacity-- <= 0) {
                Node res = popTail();
                map.remove( res.key );
                removeNode( res );
                capacity++;
            }
        }

    }

    // pop the current tail.
    private Node popTail() {
        Node res = tail.last;
        this.removeNode( res );
        return res;
    }

    /**
     * Remove an existing node from the linked list.
     */
    private void removeNode(Node node) {
        Node pre = node.last;
        Node post = node.next;

        pre.next = post;
        post.last = pre;
    }
}
/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */