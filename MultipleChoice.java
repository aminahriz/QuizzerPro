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
public class MultipleChoice extends Questions {
    String mc1, mc2, mc3, mc4;
    String toCSV = "";
    String delim = ",";
    ArrayList<String> mc = new ArrayList();
    
    public String toString(){
        return toCSV;
    }
    
    public MultipleChoice(String type, String question, String answer, String mc1, String mc2, String mc3, String mc4) {
        super(question, answer, type);
        mc.add(mc1);
        mc.add(mc2);
        mc.add(mc3);
        mc.add(mc4);
        type = MC;
        toCSV = type + delim + question + delim + mc.get(0) + delim + mc.get(1) + delim + mc.get(2) + delim + mc.get(3) + delim + answer;
        answers.add(toCSV);
    }
    
    public MultipleChoice(String type, String question, String mc1, String mc2, String mc3, String mc4){
        super(question, type);
        mc.add(mc1);
        mc.add(mc2);
        mc.add(mc3);
        mc.add(mc4);
        type = MC;
        toCSV = type + delim + question + delim + mc.get(0) + delim + mc.get(1) + delim + mc.get(2) + delim + mc.get(3);
        questions.add(toCSV);
    }
    
    public void addMC(String newMC){
        mc.add(newMC);
        toCSV = type + delim + question + delim + mc.get(0) + delim + mc.get(1) + delim + mc.get(2) + delim + mc.get(3) + delim + newMC + delim + answer;
    }
    
    public void removeMC(String MC){
        mc.remove(MC);
        int size = mc.size();
        toCSV = type + delim + question + delim + mc.get(0) + delim + mc.get(1) + delim + mc.get(2) + delim + mc.get(3) + delim + answer;
    }
    
}
