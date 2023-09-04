package org.example;

public class Map<K, V> {
    private Node<K, V> head;
    private Node<K, V> tail;
    private int size;

    public Map() {
        head = new Node<>(null, null); // Cabeça vazia
        tail = new Node<>(null, null); // Cauda vazia
        head.next = tail;
        tail.prev = head;
        size = 0;
    }

    public void put(K key, V value) {
        // Verifica se a chave já existe no mapa
        Node<K, V> node = getNode(key);
        if (node != null) {
            // Atualiza o valor se a chave já existir
            node.value = value;
        } else {
            // Cria um novo nó para o par chave-valor
            Node<K, V> newNode = new Node<>(key, value);

            // Insere o novo nó no final da lista
            newNode.next = tail;
            newNode.prev = tail.prev;
            tail.prev.next = newNode;
            tail.prev = newNode;
        }
        size++;
    }

    public V get(K key) {
        Node<K, V> node = getNode(key);
        return (node != null) ? node.value : null;
    }

    public void remove(K key) {
        Node<K, V> node = getNode(key);
        if (node != null) {
            // Remove o nó da lista
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
        size--;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        boolean result = size == 0 ? true : false;
        return result;
    }

    private Node<K, V> getNode(K key) {
        Node<K, V> current = head.next;
        while (current != tail) {
            if (current.key != null && current.key.equals(key)) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    public static void main(String[] args) {

        Map newMap = new Map();

        newMap.put("one", 1);
        System.out.println(newMap.get("one"));
        System.out.println(newMap.size());
        System.out.println(newMap.isEmpty());
        newMap.remove("one");
        System.out.println(newMap.size());
        System.out.println(newMap.isEmpty());
    }
}
