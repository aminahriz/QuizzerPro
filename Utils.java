/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quizer.pro;

import java.io.*;
import java.util.*;
/**
 *
 * @author timbi
 */
public class Utils {
        public static Questions[] loadQuestions(String fileName, int quizNum){
            //declare a scanner object
            Scanner sc = null;
            //declare a new list that can store each of the student's information
            Questions[] list = new Questions[0];
            //determines the number of students in the registration file and creates a tally
            try {
                int counter = 0;
                sc = new Scanner(new File(fileName+"["+quizNum+"-problems].txt"));
                while(sc.hasNextLine()){
                    sc.nextLine();
                    counter++;
                }
            
                //declares the list with the counter length, so therefore the list will hold number of students in registration
                list = new Questions[counter];
                String[] length = new String[counter];
            
                //read from the specified file name so that it break each field and store the data into a object, therefore saved into array at index [i]
                sc = new Scanner(new File(fileName+"["+quizNum+"-problems].txt"));
                for(int i=0; i<list.length; i++){
                    length[i] = sc.nextLine();
                    String[] fields = length[i].split(",");
                    String type = fields[0];
                    if(type.equals("mc")){
                        String question = fields[1];
                        String mc1 = fields[2];
                        String mc2 = fields[3];
                        String mc3 = fields[4];
                        String mc4 = fields[5];
                        MultipleChoice mc = new MultipleChoice(type, question, mc1, mc2, mc3, mc4);
                        list[i] = mc;
                    }
                    else if(type.equals("t/f")){
                        String question = fields[1];
                        String True = fields[2];
                        String False = fields[3];
                        TrueFalse tf = new TrueFalse(type, question);
                    }
                    else if(type.equals("numeric")){
                        String question = fields[1];
                        Numeric n = new Numeric(type, question);
                        list[i] = n;
                    }
                }
                return list;
                //catches any errors, in this case the fiule not found exceptioon is to be caughnt and said not found!
            }catch(FileNotFoundException e){
                System.out.println("File not found!");
            }
            //return the list of students who have registered in object data type StudentInformationSystem array
            return list;
        }
        
        public static void quizWriteFileQ(String fileName, int quizNum, ArrayList q){
            PrintWriter pw = null;
            try{
                pw = new PrintWriter(new FileWriter(fileName+"["+quizNum+"-problems].txt",true));
                for(int i=0; i<q.size(); i++){
                    pw.println(q.get(i));
                }
                pw.close();
            }catch(FileNotFoundException e){
                System.out.println("File not found!");
            }catch(IOException e){
                System.out.println("File not found!");
            }
        }
        
        public static void quizWriteFileA(String fileName, int quizNum, ArrayList q){
            PrintWriter pw = null;
            try{
                pw = new PrintWriter(new FileWriter(fileName+"["+quizNum+"-solutions].txt",true));
                for(int i=0; i<q.size(); i++){
                    pw.println(q.get(i));
                }
                pw.close();
            }catch(FileNotFoundException e){
                System.out.println("File not found!");
            }catch(IOException e){
                System.out.println("File not found!");
            }
        }
}
