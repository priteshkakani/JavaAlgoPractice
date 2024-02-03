package practice;

import java.util.*;
import java.util.concurrent.LinkedBlockingDeque;

public class problem5 {
    public int balancedStringSplit(String s) {
        return 1;
    }

    int columnWithMaxZeros(int arr[][], int N)
    {
        return 0;
    }
    static class Person{
        String name;
        int age;
        public Person(String name,int age){
            this.name = name;
            this.age = age;
        }
    }

    static class Node{
        int key;
        Node left;
        Node right;
        public Node(int item){
            key = item;
            left = right = null;
        }
    }

    public static class BinarySearchTree{
        Node root;
        BinarySearchTree(){
            root = null;
        }
        // insert key into BST
        void insert(int key){
            root = insertRec(root, key);
        }

        Node insertRec(Node root, int key){
            if(root == null){
                root = new Node(key);
                return root;
            }
            if( key < root.key){
                root.left = insertRec(root.left,key);
            } else if ( key > root.key) {
                root.right = insertRec(root.right,key);
            }

            return root;
        }
        boolean search(int key){
            return searchRec(root,key);
        }
        boolean searchRec(Node root, int key){
            // Base cases : root is null or key is present at root
            if(root == null || root.key == key){
                return root != null;
            }
            if(key > root.key){
                return searchRec(root.right,key);
            }
            return searchRec(root.left, key);
        }
        // Inorder traversal of BST
        void inorder(){
            inorderRec(root);
        }
        void inorderRec(Node root){
            if(root != null){
                inorderRec(root.left);
                System.out.println(root.key + " ");
                inorderRec(root.right);
            }
        }

        void delete(int key){
            root = deleteRec(root, key);
        }

        Node deleteRec(Node root, int key) {
            // Base case: If tree is empty
            if (root == null) {
                return root;
            }
            // Recur down the tree
            if (key < root.key) {
                root.left = deleteRec(root.left, key);
            } else if (key > root.key) {
                root.right = deleteRec(root.right, key);
            } else {
                if (root.left == null) {
                    return root.right;
                } else if (root.right == null) {
                    return root.left;
                }
                // Node with 2 children : Get inorder successor (smallest in right subtree)
                root.key = minValue(root.right);
                root.right = deleteRec(root.right, root.key);
            }
            return root;
        }


        int minValue(Node root){
            int minValue = root.key;
            while(root.left != null){
                minValue = root.left.key;
                root = root.left;
            }
            return minValue;
        }
    }

    public static class Graph{
        private int vertices;
        private int[][] adjacencyMatrix;

        public Graph(int vertices){
            this.vertices = vertices;
            this.adjacencyMatrix = new int[vertices][vertices];
        }

        public void addEdge(int source, int destination){
            adjacencyMatrix[source][destination] = 1;
            adjacencyMatrix[destination][source] = 1; // uncomment if graph is undirected.
        }

        public void printGraph(){
            System.out.println("Adjacency Matrix : ");
            for (int[] row : adjacencyMatrix){
                System.out.println(Arrays.toString(row));
            }
        }
    }

    public static class Graph1{
        private int vertices;
        private LinkedList<Integer>[] adjacencyList;

        public Graph1(int vertices){
            this.vertices = vertices;
            this.adjacencyList = new LinkedList[vertices];
            for(int i =0;i<vertices;i++){
                adjacencyList[i] = new LinkedList<>();
            }
        }
        public void addEdge(int source, int destination){
            adjacencyList[source].add(destination);
            // Uncomment below line if graph is undirected.
            //adjacencyList[destination].add(source);
        }
        public void printGraph(){
            System.out.println("Adjacency List:");
            for(int i = 0;i<vertices;i++){
                System.out.println(i+" -> ");
                for(Integer neighbor :adjacencyList[i] ){
                    System.out.print(neighbor+ " ");
                }
                System.out.println();
            }
        }
    }

    public static void main(String[] args){
        String input = "RLRRLLRLRL";
        problem5 p = new problem5();
        p.balancedStringSplit(input);

        // Given a matrix(2D array) M of size N*N consisting of 0s and 1s only.
        // The task is to find the column with maximum number of 0s.
        // If more than one column exists, print the one which comes first.
        // If the maximum number of 0s is 0 then return -1.

        int[] arr;
        arr = new int[5];
        int[] myArray = new int[5];
        int[] myArray1 = {1,4,5};
        int len = myArray1.length;
        for (int i =0;i<myArray1.length;i++)
            System.out.println(myArray[i]);
        for(int my:myArray1)
            System.out.println(my);
        String my = "new";
        len = my.length();
        String my1 = "Hello";
        boolean isEqual = my1.equals(my);
        boolean isEqual1 = my1.equalsIgnoreCase(my);
        String original = "Hello";
        String substring = original.substring(0,5);
        String example = "Java";
        String replaced = example.replace("Java","Python");
        System.out.println("replaced "+replaced);
        int index = example.indexOf("va");
        System.out.println(index);
        String upperCase = example.toUpperCase();
        String formattedString = String.format("The value of pi is %.2f",Math.PI);
        System.out.println(formattedString);
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("Element 1");
        linkedList.add("Element 2");
        linkedList.addFirst("Eicher Motors");
        linkedList.addLast("Tata Motors");
        String firstElement = linkedList.getFirst();
        String lastElement = linkedList.getLast();
        String elementAtIndex = linkedList.get(1);
        linkedList.set(1,"element");
        linkedList.remove();
        int size = linkedList.size();
        boolean contains = linkedList.contains("Element 2");
        String[] array = linkedList.toArray(new String[0]);
        LinkedList<String> newList = new LinkedList<>(Arrays.asList(array));
        Iterator<String> descendingIterator = linkedList.descendingIterator();
        while(descendingIterator.hasNext()){
            System.out.println(descendingIterator.next());
        }
        HashMap<String, Integer> stockPrices = new HashMap<>();
        stockPrices.put("HUL",2450);
        int value = stockPrices.get("HUL");
        System.out.println(value);
        boolean containsKey = stockPrices.containsKey("HUL");
        System.out.println(containsKey);
        boolean containsValue = stockPrices.containsValue(2450);
        System.out.println(containsValue);
        for(String name : stockPrices.keySet()){
            int price = stockPrices.get(name);
            System.out.println("Name : "+name +"Price: "+price);
        }
        stockPrices.remove("HUL");
        stockPrices.put("Nestle",20000);
        int size1 = stockPrices.size();
        stockPrices.clear();
        stockPrices.put("ITC",440);
        stockPrices.put(null,300);
        stockPrices.put("Apl Apollo Tubes",null);

        HashMap<String, Person> personMap = new HashMap<>();
        personMap.put("Ambani",new Person("Mukesh",60));
        personMap.put("Adani", new Person("Gautam", 55));
        Person mukesh = personMap.get("Ambani");
        System.out.println(mukesh.name+" "+mukesh.age);
        for(Map.Entry<String, Integer> entry: stockPrices.entrySet()) {
            System.out.println("Key : " + entry.getKey() + " Value:" + entry.getValue());
        }
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);
        System.out.println("Inorder Traversal: ");
        tree.inorder();
        // Search for a key
        int searchKey = 40;
        System.out.println("Does BST contain "+searchKey+"? "+ tree.search(searchKey) );
        //Delete a key
        int deleteKey = 30;
        tree.delete(deleteKey);
        System.out.println("Inorder traversal after deleting "+deleteKey+ ":");
        tree.inorder();

        Stack<String> stack = new Stack<>();
        stack.push("Eicher Motors");
        stack.push("Tata Motors");
        stack.push("Mahindra & Mahindra");
        String poppedElement = stack.pop();
        System.out.println("Popped Element : "+poppedElement);
        String topElement = stack.peek();
        System.out.println("Top Element : "+topElement);
        boolean isEmpty = stack.isEmpty();
        System.out.println("Is the stack empty : "+isEmpty);
        int position = stack.search("Element 1");
        System.out.println("Position of element 1 : "+position);
        System.out.println("Stack Elements : "+stack);

        Deque<String> stack1 = new LinkedList<>();

        Queue<String> queue = new LinkedList<>();
        queue.add("Eicher Motors");
        queue.add("Tata Motors");
        queue.add("Mahindra & Mahindra");
        // Dequeuing (removing) and retriving the front element
        String frontElement = queue.peek();
        System.out.println("Front element after peek: "+frontElement);
        boolean isEmpty2 = queue.isEmpty();
        System.out.println("Is queue empty : "+isEmpty2);
        int size2 = queue.size();
        System.out.println("Size of Queue : "+size2);
        System.out.println("Queue Elements : "+queue);
        // thread safe implementation
        LinkedBlockingDeque<String> blockingDeque = new LinkedBlockingDeque<>();
        // Enqueuing (adding) elements to blockingQueue
        blockingDeque.add("Element 1 ");
        blockingDeque.add("Element 2 ");
        blockingDeque.add("Element 3 ");
        // Dequequing (removing) and retrieving front element
        String frontElement2 = blockingDeque.poll();
        System.out.println("Front Element : " + frontElement2);

        // creating min heap (PriorityQueue)
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        minHeap.add(10);
        minHeap.add(30);
        minHeap.add(20);
        minHeap.add(5);
        System.out.println("Min heap elements:");
        while (!minHeap.isEmpty()){
            System.out.println(minHeap.poll());
        }

        // Creating max heap(PriorityQueue with Custom comparator)
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        maxHeap.add(10);
        maxHeap.add(30);
        maxHeap.add(20);
        maxHeap.add(5);
        // Removing Elements (Largest element is removed first)
        System.out.println("Max heap elements :");
        while(!maxHeap.isEmpty()){
            System.out.println(maxHeap.poll());
        }

        int numVertices = 5;
        Graph graph = new Graph(numVertices);
        graph.addEdge(0,1);
        graph.addEdge(0,4);
        graph.addEdge(1,2);
        graph.addEdge(1,3);
        graph.addEdge(1,4);
        graph.addEdge(2,3);
        graph.addEdge(3,4);
        graph.printGraph();

        int numVertices1 = 5;
        Graph1 graph1 = new Graph1(numVertices1);
        graph1.addEdge(0,1);
        graph1.addEdge(0,4);
        graph1.addEdge(1,2);
        graph1.addEdge(1,3);
        graph1.addEdge(1,4);
        graph1.addEdge(2,3);
        graph1.addEdge(3,4);
        graph1.printGraph();

    }
}
