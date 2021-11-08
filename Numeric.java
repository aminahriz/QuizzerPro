/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quizer.pro;

/**
 *
 * @author timbi
 */
public class Numeric extends Questions {
    
    int answer;
    String toCSV;
    String delim = ",";
    
    public String toString(){
        return toCSV;
    }

    public Numeric(String type, String question, String answer) {
        super(question, answer, type);
        type = NUMERIC;
        toCSV = type + delim + question + delim + answer;
        answers.add(toCSV);
    }
    
    public Numeric(String type, String question){
        super(type, question);
        toCSV = type + delim + question;
        questions.add(toCSV);
    }
    
    
}
