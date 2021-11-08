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
public class TrueFalse extends Questions {
    
    String toCSV;
    String delim = ",";
    String[] tf = new String[2];

    public String toString(){
        return toCSV;
    }
    
    public TrueFalse(String type, String question, String answer) {
        super(question, answer, type);
        type = TF;
        tf[0] = "True";
        tf[1] = "False";
        toCSV = type + delim + question + delim + tf[0] + delim + tf[1] + delim + answer;
        answers.add(toCSV);
    }
    
    public TrueFalse(String type, String question){
        super(type, question);
        type = TF;
        tf[0] = "True";
        tf[1] = "False";
        toCSV = type + delim + question + delim + tf[0] + delim + tf[1];
        questions.add(toCSV);
    }
}
