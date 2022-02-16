package by.arabienko.controller.DELETE;

import by.arabienko.bean.ComponentLeaf;
import by.arabienko.bean.CompositeParts;
import by.arabienko.bean.ExceptionBean;
import by.arabienko.bean.TypeRegex;


public class Test {
    public static void main(String[] args) throws ExceptionBean {
        CompositeParts paragraphThree = new CompositeParts(TypeRegex.DELIM_SENTENCE.getRegexForSplit());
        //Three cats. Red - green. By.
        CompositeParts parThreeSentOne = new CompositeParts(TypeRegex.DELIM_LEXEME.getRegexForSplit());

        CompositeParts parThreeSentOneLexOne = new CompositeParts(TypeRegex.DELIM_LEXEME.getRegexForSplit());
        CompositeParts parThreeSentOneWordOne = new CompositeParts(TypeRegex.DELIM_LEXEME.getRegexForSplit());
        ComponentLeaf parThreeSentOneWordOne1 = new ComponentLeaf('T');
        ComponentLeaf parThreeSentOneWordOne2 = new ComponentLeaf('h');
        ComponentLeaf parThreeSentOneWordOne3 = new ComponentLeaf('r');
        ComponentLeaf parThreeSentOneWordOne4 = new ComponentLeaf('e');
        ComponentLeaf parThreeSentOneWordOne5 = new ComponentLeaf('e');
        parThreeSentOneWordOne.addElement(parThreeSentOneWordOne1);
        parThreeSentOneWordOne.addElement(parThreeSentOneWordOne2);
        parThreeSentOneWordOne.addElement(parThreeSentOneWordOne3);
        parThreeSentOneWordOne.addElement(parThreeSentOneWordOne4);
        parThreeSentOneWordOne.addElement(parThreeSentOneWordOne5);
        parThreeSentOneLexOne.addElement(parThreeSentOneWordOne);

        CompositeParts parThreeSentOneLexTwo = new CompositeParts(TypeRegex.DELIM_LEXEME.getRegexForSplit());
        CompositeParts parThreeSentOneWord1Two = new CompositeParts(TypeRegex.DELIM_LEXEME.getRegexForSplit());
        parThreeSentOneLexTwo.addElement(parThreeSentOneWord1Two);
        ComponentLeaf parThreeSentOneWordTwo1 = new ComponentLeaf('c');
        ComponentLeaf parThreeSentOneWordTwo2 = new ComponentLeaf('a');
        ComponentLeaf parThreeSentOneWordTwo3 = new ComponentLeaf('t');
        ComponentLeaf parThreeSentOneWordTwo4 = new ComponentLeaf('s');
        parThreeSentOneWord1Two.addElement(parThreeSentOneWordTwo1);
        parThreeSentOneWord1Two.addElement(parThreeSentOneWordTwo2);
        parThreeSentOneWord1Two.addElement(parThreeSentOneWordTwo3);
        parThreeSentOneWord1Two.addElement(parThreeSentOneWordTwo4);
        CompositeParts parThreeSentOneWord2Two = new CompositeParts(TypeRegex.DELIM_LEXEME.getRegexForSplit());
        parThreeSentOneLexTwo.addElement(parThreeSentOneWord2Two);
        ComponentLeaf parThreeSentOneWord2Two1 = new ComponentLeaf('.');
        parThreeSentOneWord2Two.addElement(parThreeSentOneWord2Two1);
        parThreeSentOne.addElement(parThreeSentOneLexOne);
        parThreeSentOne.addElement(parThreeSentOneLexTwo);
        //Red - green.
        CompositeParts parThreeSentTwo = new CompositeParts(TypeRegex.DELIM_LEXEME.getRegexForSplit());
        CompositeParts parThreeSentTwoLexOne = new CompositeParts(TypeRegex.DELIM_LEXEME.getRegexForSplit());
        CompositeParts parThreeSentTwoWordOne = new CompositeParts(TypeRegex.DELIM_LEXEME.getRegexForSplit());
        ComponentLeaf parThreeSentTwoWordOne1 = new ComponentLeaf('R');
        ComponentLeaf parThreeSentTwoWordOne2 = new ComponentLeaf('e');
        ComponentLeaf parThreeSentTwoWordOne3 = new ComponentLeaf('d');
        parThreeSentTwoWordOne.addElement(parThreeSentTwoWordOne1);
        parThreeSentTwoWordOne.addElement(parThreeSentTwoWordOne2);
        parThreeSentTwoWordOne.addElement(parThreeSentTwoWordOne3);
        parThreeSentTwoLexOne.addElement(parThreeSentTwoWordOne);

        CompositeParts parThreeSentTwoLexOne1 = new CompositeParts(TypeRegex.DELIM_LEXEME.getRegexForSplit());
        CompositeParts parThreeSentTwoWordOne11 = new CompositeParts(TypeRegex.DELIM_LEXEME.getRegexForSplit());
        ComponentLeaf parThreeSentTwoWordOne111 = new ComponentLeaf('-');
        parThreeSentTwoWordOne11.addElement(parThreeSentTwoWordOne111);
        parThreeSentTwoLexOne1.addElement(parThreeSentTwoWordOne11);

        CompositeParts parThreeSentTwoLexTwo = new CompositeParts(TypeRegex.DELIM_LEXEME.getRegexForSplit());
        CompositeParts parThreeSentTwoWordOneL2 = new CompositeParts(TypeRegex.DELIM_LEXEME.getRegexForSplit());
        ComponentLeaf parThreeSentTwoWordOneL21 = new ComponentLeaf('g');
        ComponentLeaf parThreeSentTwoWordOneL22 = new ComponentLeaf('r');
        ComponentLeaf parThreeSentTwoWordOneL23 = new ComponentLeaf('e');
        ComponentLeaf parThreeSentTwoWordOneL24 = new ComponentLeaf('e');
        ComponentLeaf parThreeSentTwoWordOneL25 = new ComponentLeaf('n');
        parThreeSentTwoWordOneL2.addElement(parThreeSentTwoWordOneL21);
        parThreeSentTwoWordOneL2.addElement(parThreeSentTwoWordOneL22);
        parThreeSentTwoWordOneL2.addElement(parThreeSentTwoWordOneL23);
        parThreeSentTwoWordOneL2.addElement(parThreeSentTwoWordOneL24);
        parThreeSentTwoWordOneL2.addElement(parThreeSentTwoWordOneL25);
        CompositeParts parThreeSentTwoWordTwoL2 = new CompositeParts(TypeRegex.DELIM_LEXEME.getRegexForSplit());
        ComponentLeaf parThreeSentTwoWordTwoL21 = new ComponentLeaf('.');
        parThreeSentTwoWordTwoL2.addElement(parThreeSentTwoWordTwoL21);

        parThreeSentTwoLexTwo.addElement(parThreeSentTwoWordOneL2);
        parThreeSentTwoLexTwo.addElement(parThreeSentTwoWordTwoL2);


        parThreeSentTwo.addElement(parThreeSentTwoLexOne);
        parThreeSentTwo.addElement(parThreeSentTwoLexOne1);
        parThreeSentTwo.addElement(parThreeSentTwoLexTwo);

        CompositeParts parThreeSentThree = new CompositeParts(TypeRegex.DELIM_LEXEME.getRegexForSplit());
        CompositeParts parThreeSentThreeLexTwo = new CompositeParts(TypeRegex.DELIM_LEXEME.getRegexForSplit());
        CompositeParts parThreeSentThreeWord1Two = new CompositeParts(TypeRegex.DELIM_LEXEME.getRegexForSplit());

        ComponentLeaf parThreeSentThreeWordTwo1 = new ComponentLeaf('B');
        ComponentLeaf parThreeSentThreeWordTwo2 = new ComponentLeaf('y');
        parThreeSentThreeWord1Two.addElement(parThreeSentThreeWordTwo1);
        parThreeSentThreeWord1Two.addElement(parThreeSentThreeWordTwo2);
        CompositeParts parThreeSentThreeWord2Two = new CompositeParts(TypeRegex.DELIM_LEXEME.getRegexForSplit());
        ComponentLeaf parThreeSentThreeWord2Two1 = new ComponentLeaf('.');
        parThreeSentThreeWord2Two.addElement(parThreeSentThreeWord2Two1);
        parThreeSentThreeLexTwo.addElement(parThreeSentThreeWord1Two);
        parThreeSentThreeLexTwo.addElement(parThreeSentThreeWord2Two);
        parThreeSentThree.addElement(parThreeSentThreeLexTwo);

        paragraphThree.addElement(parThreeSentOne);
        paragraphThree.addElement(parThreeSentTwo);
        paragraphThree.addElement(parThreeSentThree);

        System.out.println(paragraphThree);
    }
}
