public class MyLinkedList<K, V> {
    MyLinkedList<K, V> next;
    MyLinkedList<K, V> prev;
    K key;
    V value;

    public MyLinkedList(K k, V v) {
        key = k;
        value = v;
    }

    public Object put(K k, V v, MyLinkedList[] list) {
        MyLinkedList<K, V> node = new MyLinkedList<>(k, v);
        node.key = k;
        node.value = v;
        int index = k.hashCode() % 16;
        if (list[index] != null) {
            MyLinkedList nodeOfList = list[index];
            while (nodeOfList != null) {
                if (nodeOfList.key == k) {
                    return nodeOfList.value;
                }
            }
            node.next = list[index];
        }
        list[index] = node;
        return null;
    }
}
