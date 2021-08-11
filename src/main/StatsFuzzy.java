package main;

import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.plot.JFuzzyChart;
import net.sourceforge.jFuzzyLogic.rule.Variable;
import net.sourceforge.jFuzzyLogic.rule.Rule;


public class StatsFuzzy {

    public static void main(String[] args){
        FIS fis = FIS.load("src/resource/stats.fcl", true);

        //SHOW VARIABLE
        JFuzzyChart.get().chart(fis.getFunctionBlock("stats"));

        //SET ENTRY
        fis.setVariable("kill",  45);
        fis.setVariable("assist",5);
        fis.setVariable("death", 14);
        fis.setVariable("kast",  92);

        fis.evaluate();

        //SHOWS GRAPHIC
        Variable performance = fis.getFunctionBlock("stats").getVariable("performance");
        JFuzzyChart.get().chart(performance, performance.getDefuzzifier(), true);

        //VARIABLE OUTPUT
        System.out.println(performance.getValue());



        //SHOW RULES WITH ACTIVATION VALUE
        for( Rule r: fis.getFunctionBlock("stats").getFuzzyRuleBlock("No1").getRules())
            System.out.println(r);

    }
}