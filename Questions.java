/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quizer.pro;

import java.util.ArrayList;

/**
 *
 * @author timbi
 */
public class Questions {
    
    public static ArrayList questions = new ArrayList();
    public static ArrayList answers = new ArrayList();
    String question, answer;
    public final static String MC = "mc";
    public final static String TF = "t/f";
    public final static String NUMERIC = "numeric";
    String type = MC;
    
    public Questions(){
        
    }
    
    public Questions(String question, String answer, String type){
        this.question = question;
        this.answer = answer;
        this.type = type;
    }
    
    public Questions(String type, String question){
        this.question = question;
        this.type = type;
    }
    
    public static void writeToFileQQ(String fileName, int quizNum){
        Utils.quizWriteFileQ(fileName, quizNum, questions);
    }
    
    public static void writeToFileAA(String fileName, int quizNum){
        Utils.quizWriteFileA(fileName, quizNum, answers);
    }
    
    public void emptyList(){
        if(questions.isEmpty()){
            System.out.println("Already empty.");
            return;
        }
        else if(!questions.isEmpty()){
            questions.clear();
            System.out.println("Cleared.");
        }
    }
}
