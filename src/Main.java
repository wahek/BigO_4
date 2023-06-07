public class Main {
    public static void main(String[] args) {
        MyLinkedList[] hashList = new MyLinkedList[16];
        MyLinkedList linkedList = new MyLinkedList(null,null);
        for (int i = 0; i < 17; i++) {
            linkedList.put(i+1, i+1, hashList);
            i++;
        }
        System.out.println(hashList);
    }

}
