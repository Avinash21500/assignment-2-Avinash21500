/*
 *  Created by IntelliJ IDEA.
 *  User: Vaibhav
 *  Date: 23-Mar-20
 *  Time: 7:15 PM
 */
package problem3.myqueue;

import problem3.node.Node;

public class MyPriorityQueue {
    private Node front;
    private Node rear;
    private int size;

    //Constructor
    MyPriorityQueue(){
        front=null;
        rear=null;
        size=0;
    }


    public boolean isEmpty(){
        boolean response=false;
        if(front!=null || size!=0){
            response=true;
        }
        return response;
    }
    //removing single element from starting of queue
    public Node dequeue(){
        Node response=null;
        if(isEmpty()){
            if(front.getNext()!=null){
                response=new Node(front.getData());
                front=front.getNext();
                rear.setNext(front);
                size--;
            }
            else {
                response=new Node(front.getData());
                front=null;
                rear=null;
                size--;
            }
        }
        return response;
    }
    //inserting data
    public void  enqueue(int data){
        Node node=new Node(data);
        if(front==null){
            front=node;
            size++;
            System.out.println("Value Entered successfully!");
        }
        else if(data<=front.getData()){
            node.setNext(front);
            front=node;
            size++;
            System.out.println("Value Entered successfully!");
        }
        else if(data>=rear.getData()){
            node.setNext(front);
            rear.setNext(node);
            rear=node;
            System.out.println("Value Entered successfully!");
        }
        else {
            Node previous=null;
            Node temp = front;
            while(temp.getNext().getNext()!=null){
                previous=temp;
                if(data<=temp.getData()){
                    previous.setNext(node);
                    node.setNext(temp);
                    size++;
                    System.out.println("Value Entered successfully!");
                }
                temp=temp.getNext();
            }
        }
    }

    //traversing
    public void traversing(){
        Node temp=front;
        while(temp.getNext()!=null){
            System.out.print(temp.getData()+" ");
            temp=temp.getNext();
        }
    }
}
