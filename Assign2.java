//Assign2.java
/**
@author Hridika Banik <a 
href="mailto:hridika.banik@ucalgary.ca">firstname.lastname@ucalgary.ca</a>
@version 1.3
@since 1.0
*/
import java.io.*;
import java.util.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class Assign2{
    private String inputFile = "";    // Input file name
    private String outputFile = "";   // Output file name

    private String[] ListofWord;       // Word list to initially put file into
    private LinkedList[] linkedListArray;     // Array to store all linked lists
    private long startTime;
    public static void main(String[] args){
        new Assign2(args);
    }
    public void startOfProgram(){
        startTime = System.nanoTime();
    }
    public void endOfProgram(){
        System.out.println(System.nanoTime() - startTime);
    }
    public Assign2(String[] args) {
        startOfProgram();

        // Error-Checking of Arguments
        if(args.length < 2){
            throw new IllegalArgumentException("Wrong number of input arguments: too few arguments");
        } else if(args.length > 2){
            throw new IllegalArgumentException("Wrong number of input arguments: too many arguments");
        }

        inputFile = args[0] + ".txt";
        outputFile = args[1];

        if (inputFile.length() == 0) {
            System.out.println("File is empty.Input File name again.");
            System.exit(0);
        } 
        else if (inputFile.length() != 0) {
            System.out.println("File is not empty.");
            return;} 
        readFile();
        

       

        //printFile();

        endOfProgram();
    }
    /*The code of Filereader is sourced from the link below:

     
    */
    private void readFile() {
        // list that holds strings of a file
        List<String> listOfStrings = new ArrayList<String>();
        BufferedReader bf;
        // load data from file
        //https://www.sitepoint.com/community/t/getting-try-catch-for-filenotfoundexception/2202
        try {
            bf = new BufferedReader(new FileReader(inputFile));
        } 
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("File does not exist.");
        }
            
        try {
            bf = new BufferedReader(new FileReader(inputFile));
            // read entire line as string
            String line = bf.readLine();

            // checking for end of file
            while (line != null) {
                listOfStrings.add(line);
                line = bf.readLine();
            }
        } catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException("There has been an error in reading the file." );
        }

        // closing bufferreader object
        try {
            bf.close();
        }
        catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("There has been an error in closing the file" );
        }
        // storing the data in arraylist to array
        ListofWord = listOfStrings.toArray(new String[0]);
        int line = 1;
        for (String str : ListofWord) {
            System.out.println(str + "is in Line" + String.valueOf(line));
            line++;
        }
        }
        public class LinkedList {
            
            public Node head;
            public LinkedList(){
                this.head = null;
            }
        
            public LinkedList(Node newNode){
                this.head = newNode;
            }
            public void add(String data){
                Node temp = new Node(data, head);
                head = temp;
            }
        
            public void insertAfter(String data, Node prev){
                Node temp = new Node(data, prev.next);
                prev.next = temp;
            }
        
        }
        
        public class Node {
            
            public String data;
            public Node next;
            public Node( String data, Node next){
                this.data = data;
                this.next = next;
            }
        
        }}
        
             
       
        
        



