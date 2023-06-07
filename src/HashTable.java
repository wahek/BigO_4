public class HashTable {
    public static void main(String[] args) {
        Node node = new Node();
        HashTable hashTable = new HashTable();
        for (int i = 0; i < 32; i++) {
            hashTable.put(i + 1, i);
        }
        System.out.println(hashTable.get(30));
        hashTable.replays(30, 2318);

        System.out.println(hashTable.get(30));
        System.out.println("Количетсво элементов: " + hashTable.size());
        hashTable.remove(30);
        System.out.println(hashTable.get(30));
        System.out.println("Количетсво элементов: " + hashTable.size());
        System.out.println(hashTable.containsKey(10));
        System.out.println(hashTable.containsValue(33));
    }

    Node head;
    Node[] list = new Node[16];

    public int size() {
        int count = 0;
        for (int i = 0; i < list.length; i++) {
            if (list[i] != null) {
                count++;
                Node currentNode = list[i];
                while (currentNode.next != null) {
                    currentNode = currentNode.next;
                    count++;
                }
            }
        }
        return count;
    }

    public boolean containsKey(Integer key) {
        for (int i = 0; i < list.length; i++) {
            if (list[i] != null) {
                Node currentNode = list[i];
                while (currentNode != null) {
                    if (key == currentNode.key)
                        return true;
                    currentNode = currentNode.next;
                }
            }
        }
        return false;
    }

    public boolean containsValue(Integer value) {
        for (int i = 0; i < list.length; i++) {
            if (list[i] != null) {
                Node currentNode = list[i];
                while (currentNode != null) {
                    if (value == currentNode.value)
                        return true;
                    currentNode = currentNode.next;
                }
            }
        }
        return false;
    }

    public Object replays(Integer key, Integer v) {
        int index = key.hashCode() % 16;
        if (list[index] != null) {
            Node tempNode = list[index];
            while (tempNode != null) {
                if (tempNode.key == key) {
                    Integer x = tempNode.value;
                    tempNode.value = v;
                    return x;
                }
                tempNode = tempNode.next;
            }
        }
        return null;
    }

    public Object get(Integer key) {
        int index = key.hashCode() % 16;
        if (list[index] != null) {
            Node tempNode = list[index];
            while (tempNode != null) {
                if (tempNode.key == key) {
                    return tempNode.value;
                }
                tempNode = tempNode.next;
            }
        }
        return null;
    }

    public Object remove(Integer key) {
        int index = key.hashCode() % 16;
        if (list[index] != null) {
            Node tempNode = list[index];
            if (tempNode.key == key && tempNode.next == null) {
                list[index] = null;
                return tempNode.value;
            }
            if (tempNode.key == key && tempNode.next != null) {
                list[index] = tempNode.next;
                return tempNode.value;
            }
            while (tempNode.next != null) {
                if (tempNode.next.key == key) {
                    Integer tmp = tempNode.next.value;
                    tempNode.next = tempNode.next.next;
                    return tmp;
                }
                tempNode = tempNode.next;
            }
        }
        return null;
    }

    public Object put(int v, int k) {
        Node temp = new Node();
        temp.value = v;
        temp.key = k;
        temp.hash = temp.key.hashCode() % 16;
        if (list[temp.hash] != null) {
            Node tempNode = list[temp.hash];
            while (tempNode != null) {
                if (tempNode.key == k) {
                    return tempNode.value;
                }
                tempNode = tempNode.next;
            }
            temp.next = list[temp.hash];
        }
        list[temp.hash] = temp;
        return null;
    }
}

class Node {
    Integer value, key;
    int hash;
    Node next;
}