package LinkedList;

public class GenericList {

    static class Node<T>
    {
        T data;
        Node<T> next;

        Node(T data){
            this.data = data;
        }
    }

    static class ListMethod<T>{
        private Node<T> head=null;
        private Node<T> tail=null;

        void insertEnd(T data){

            Node<T> temp = new Node<>(data);

            if (head==null){
                head = temp;
            } else {
                tail.next = temp;
            }
            tail = temp;
        }

        void display(Node<T> head)
        {
            Node<T> tempHead = head;
            while(tempHead!=null)
            {
                System.out.println(tempHead.data.toString()+" ");
                tempHead = tempHead.next;
            }
        }
    }

    public static void main(String[] args) {

        ListMethod<Student> list = new ListMethod<>();

        list.insertEnd(new Student(1,"Ranjan Kumar"));
        list.insertEnd(new Student(2,"Manoj Kumar"));
        list.insertEnd(new Student(3,"Rahul Kumar"));
        list.insertEnd(new Student(4,"Mannu Kumar"));
        list.insertEnd(new Student(5,"Saket Kumar"));
        list.insertEnd(new Student(6,"Suri Kumar"));
        list.insertEnd(new Student(7,"Lalan Kumar"));

        list.display(list.head);


    }
}

class Student{
    String name;
    int id;

    Student(int id, String name){
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "ID No. - "+id+" : Name - "+name;
    }
}

