package ru.academits.java.JaroslavZuban.list;

public class SinglyLinkedList<T> {
    private ListItem<T> head;
    private int length;

    public SinglyLinkedList() {
    }

    public int lengthList() {
        return length;
    }//длинна списка

    public T getFirstElementList() {
        return head.getData();
    }//получения первого элемента списка

    public T getElementIndex(int index) {//получения элемента по индексу
        if (index >= length) {
            throw new ArrayIndexOutOfBoundsException("Нет такого индекса в списке ");
        }

        int i = 0;

        for (ListItem<T> p = head; p != null; p = p.getNext(), i++) {
            if (i == index) {
                return p.getData();
            }
        }

        return null;
    }

    public T setElementIndex(int index, T element) {//установить элемент по индексу
        if (index >= length) {
            throw new ArrayIndexOutOfBoundsException("Нет такого индекса в списке ");
        }

        int i = 0;
        T oldElement = null;

        for (ListItem<T> p = head; p != null; p = p.getNext(), i++) {
            if (i == index) {
                oldElement = p.getData();
                p.setData(element);
            }
        }

        return oldElement;
    }

    public T deleteElementIndex(int index) {//удаления элемента по инддексу
        if (index >= length) {
            throw new ArrayIndexOutOfBoundsException("Нет такого индекса в списке ");
        }

        int i = 0;
        T oldElement = null;

        if (index == 0) {
            oldElement = head.getData();
            this.head = head.getNext();
        } else {
            for (ListItem<T> p = head; p != null; p = p.getNext(), i++) {
                oldElement = p.getNext().getData();

                if (index - 1 == length && index - 1 == i) {
                    p.setNext(null);
                } else if (i == index - 1) {
                    p.setNext(p.getNext().getNext());
                }
            }

        }

        this.length--;
        return oldElement;
    }

    public void insertElementBeginning(ListItem<T> element) {//вставить в начало элемент
        if (head==null) {
            this.head = new ListItem<>(element.getData());
        } else {
            element.setNext(head);
            this.head = element;
        }

        this.length++;
    }

    public void insertElementIndex(ListItem<T> element, int index) {//вставить элемент по идексу
        if (index >= length) {
            throw new ArrayIndexOutOfBoundsException("Нет такого индекса в списке ");
        }

        if (index == 0) {
            this.head = new ListItem<>(element.getData());
        } else {
            int i = 0;

            for (ListItem<T> p = head; p != null; p = p.getNext(), i++) {
                if (index - 1 == i) {
                    ListItem<T> list = p.getNext();
                    p.setNext(element);
                    p.getNext().setNext(list);
                }

            }
        }

        this.length++;
    }

    public boolean deleteElementMeaning(T data) {//удаления элемента по значению
        if(head==null){
            throw new NullPointerException("Список пуст");
        }

        int i = 0;
        ListItem<T> list;

        if (data == head.getData()) {
            if (length == 1) {
                this.head = null;
            } else {
                list = new ListItem<>(head.getNext().getData(), head.getNext().getNext());
                this.head = list;
            }

            this.length--;
            return true;
        } else {
            for (ListItem<T> p = head; p != null; p = p.getNext(), i++) {
                if (p.getNext().getNext() == null && data == p.getNext().getData()) {
                    p.setNext(null);
                    this.length--;
                    return true;
                } else if (p.getNext().getData() == data && p.getNext().getNext() != null) {
                    list = new ListItem<>(p.getData(), p.getNext().getNext());
                    this.head = list;
                    this.length--;
                    return true;
                }
            }
        }

        return false;
    }

    public T deleteFirstElement() {//удаления первого элемента
        T oldElement = head.getData();
        this.head = new ListItem<>(head.getNext().getData(), head.getNext().getNext());
        this.length--;

        return oldElement;
    }

    public void reverseList() {//разворот списка
        ListItem<T> listItem = null;
        ListItem<T> temp = head;

        while (temp != null) {
            ListItem<T> next = temp.getNext();
            temp.setNext(listItem);
            listItem = temp;
            temp = next;
        }

        this.head = listItem;
    }

    public void print() {//вывод списка на экран
        System.out.print("Список заполнен: ");

        for (ListItem<T> p = head; p != null; p = p.getNext()) {
            System.out.print(p.getData() + " ");
        }

        System.out.println();
    }

    public void copy(SinglyLinkedList<T> copyList){
        this.head=new ListItem<>();
        int i=0;

        for(ListItem<T> p = head;i<copyList.lengthList() && copyList.getElementIndex(i)!=null;p=p.getNext(),i++){
            if(i==copyList.lengthList()-1){
                p.setNext(null);
            }else{
                p.setNext(new ListItem<>());
            }

            p.setData(copyList.getElementIndex(i));
        }
    }
}
