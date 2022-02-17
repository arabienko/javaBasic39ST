package by.arabienko.service.impl.parse;

import by.arabienko.bean.ComponentLeaf;
import by.arabienko.bean.CompositeParts;
import by.arabienko.bean.TypeRegex;
import by.arabienko.service.ExceptionService;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.concurrent.ExecutorService;

import static org.testng.Assert.*;

public class ParseTextToParagraphTest {
    ParseTextToParagraph parseTextToParagraph;
    CompositeParts text = new CompositeParts(TypeRegex.DELIM_PARAGRAPH.getRegexForSplit());
    CompositeParts text2 = new CompositeParts(TypeRegex.DELIM_PARAGRAPH.getRegexForSplit());

    public ParseTextToParagraphTest() {
        this.parseTextToParagraph = new ParseTextToParagraph();
        //CompositeParts text_test = new CompositeParts(TypeRegex.DELIM_PARAGRAPH.getRegexForSplit());
        CompositeParts paragraphOne = new CompositeParts(TypeRegex.DELIM_SENTENCE.getRegexForSplit());
        CompositeParts paragraphTwo = new CompositeParts(TypeRegex.DELIM_SENTENCE.getRegexForSplit());
        CompositeParts paragraphThree = new CompositeParts(TypeRegex.DELIM_SENTENCE.getRegexForSplit());
        text.addElement(paragraphOne);
        text.addElement(paragraphTwo);
        text.addElement(paragraphThree);

        CompositeParts parOneSentOne = new CompositeParts(TypeRegex.DELIM_SENTENCE.getRegexForSplit());
        //paragraphOne.addElement(parOneSentOne);

        CompositeParts parOneSentOneLexOne = new CompositeParts(TypeRegex.DELIM_LEXEME.getRegexForSplit());
        CompositeParts parOneSentOneWordOne = new CompositeParts(TypeRegex.DELIM_SYMBOL.getRegexForSplit());
        parOneSentOneLexOne.addElement(parOneSentOneWordOne);
        ComponentLeaf parOneSentOneWordOne1 = new ComponentLeaf('O');
        ComponentLeaf parOneSentOneWordOne2 = new ComponentLeaf('n');
        ComponentLeaf parOneSentOneWordOne3 = new ComponentLeaf('e');
        parOneSentOneWordOne.addElement(parOneSentOneWordOne1);
        parOneSentOneWordOne.addElement(parOneSentOneWordOne2);
        parOneSentOneWordOne.addElement(parOneSentOneWordOne3);

        CompositeParts parOneSentOneLexTwo = new CompositeParts(TypeRegex.DELIM_LEXEME.getRegexForSplit());
        CompositeParts parOneSentOneWordTwo = new CompositeParts(TypeRegex.DELIM_SYMBOL.getRegexForSplit());
        parOneSentOneLexTwo.addElement(parOneSentOneWordTwo);
        ComponentLeaf parOneSentOneWordTwo1 = new ComponentLeaf('t');
        ComponentLeaf parOneSentOneWordTwo2 = new ComponentLeaf('w');
        ComponentLeaf parOneSentOneWordTwo3 = new ComponentLeaf('o');
        parOneSentOneWordTwo.addElement(parOneSentOneWordTwo1);
        parOneSentOneWordTwo.addElement(parOneSentOneWordTwo2);
        parOneSentOneWordTwo.addElement(parOneSentOneWordTwo3);

        CompositeParts parOneSentOneLexThree = new CompositeParts(TypeRegex.DELIM_LEXEME.getRegexForSplit());
        CompositeParts parOneSentOneWordThree = new CompositeParts(TypeRegex.DELIM_SYMBOL.getRegexForSplit());
        parOneSentOneLexThree.addElement(parOneSentOneWordThree);
        ComponentLeaf parOneSentOneWordThree1 = new ComponentLeaf('t');
        ComponentLeaf parOneSentOneWordThree2 = new ComponentLeaf('h');
        ComponentLeaf parOneSentOneWordThree3 = new ComponentLeaf('r');
        ComponentLeaf parOneSentOneWordThree4 = new ComponentLeaf('e');
        ComponentLeaf parOneSentOneWordThree5 = new ComponentLeaf('e');
        parOneSentOneWordThree.addElement(parOneSentOneWordThree1);
        parOneSentOneWordThree.addElement(parOneSentOneWordThree2);
        parOneSentOneWordThree.addElement(parOneSentOneWordThree3);
        parOneSentOneWordThree.addElement(parOneSentOneWordThree4);
        parOneSentOneWordThree.addElement(parOneSentOneWordThree5);

        CompositeParts parOneSentOneLexFour = new CompositeParts(TypeRegex.DELIM_LEXEME.getRegexForSplit());
        CompositeParts parOneSentOneWord1Four = new CompositeParts(TypeRegex.DELIM_SYMBOL.getRegexForSplit());
        CompositeParts parOneSentOneWord2Four = new CompositeParts(TypeRegex.DELIM_SYMBOL.getRegexForSplit());
        parOneSentOneLexFour.addElement(parOneSentOneWord1Four);
        ComponentLeaf parOneSentOneWord1Four1 = new ComponentLeaf('f');
        ComponentLeaf parOneSentOneWord1Four2 = new ComponentLeaf('o');
        ComponentLeaf parOneSentOneWord1Four3 = new ComponentLeaf('u');
        ComponentLeaf parOneSentOneWord1Four4 = new ComponentLeaf('r');
        parOneSentOneWord1Four.addElement(parOneSentOneWord1Four1);
        parOneSentOneWord1Four.addElement(parOneSentOneWord1Four2);
        parOneSentOneWord1Four.addElement(parOneSentOneWord1Four3);
        parOneSentOneWord1Four.addElement(parOneSentOneWord1Four4);
        parOneSentOneLexFour.addElement(parOneSentOneWord2Four);
        ComponentLeaf parOneSentOneWord2Four1 = new ComponentLeaf('.');
        parOneSentOneWord2Four.addElement(parOneSentOneWord2Four1);

        parOneSentOne.addElement(parOneSentOneLexOne);
        parOneSentOne.addElement(parOneSentOneLexTwo);
        parOneSentOne.addElement(parOneSentOneLexThree);
        parOneSentOne.addElement(parOneSentOneLexFour);

        paragraphOne.addElement(parOneSentOne);

        CompositeParts parOneSentTwo = new CompositeParts(TypeRegex.DELIM_SENTENCE.getRegexForSplit());
        paragraphOne.addElement(parOneSentTwo);

        CompositeParts parOneSentTwoLexOne = new CompositeParts(TypeRegex.DELIM_LEXEME.getRegexForSplit());
        CompositeParts parOneSentTwoWordOne = new CompositeParts(TypeRegex.DELIM_SYMBOL.getRegexForSplit());
        ComponentLeaf parOneSentTwoWordOne1 = new ComponentLeaf('R');
        ComponentLeaf parOneSentTwoWordOne2 = new ComponentLeaf('e');
        ComponentLeaf parOneSentTwoWordOne3 = new ComponentLeaf('d');
        parOneSentTwoWordOne.addElement(parOneSentTwoWordOne1);
        parOneSentTwoWordOne.addElement(parOneSentTwoWordOne2);
        parOneSentTwoWordOne.addElement(parOneSentTwoWordOne3);
        CompositeParts parOneSentTwoWordTwo = new CompositeParts(TypeRegex.DELIM_SYMBOL.getRegexForSplit());
        ComponentLeaf parOneSentTwoWordTwo1 = new ComponentLeaf(',');
        parOneSentTwoWordTwo.addElement(parOneSentTwoWordTwo1);
        parOneSentTwoLexOne.addElement(parOneSentTwoWordOne);
        parOneSentTwoLexOne.addElement(parOneSentTwoWordTwo);

        CompositeParts parOneSentTwoLexTwo = new CompositeParts(TypeRegex.DELIM_LEXEME.getRegexForSplit());
        CompositeParts parOneSentTwoWordOneL2 = new CompositeParts(TypeRegex.DELIM_SYMBOL.getRegexForSplit());
        ComponentLeaf parOneSentTwoWordOneL21 = new ComponentLeaf('g');
        ComponentLeaf parOneSentTwoWordOneL22 = new ComponentLeaf('r');
        ComponentLeaf parOneSentTwoWordOneL23 = new ComponentLeaf('e');
        ComponentLeaf parOneSentTwoWordOneL24 = new ComponentLeaf('e');
        ComponentLeaf parOneSentTwoWordOneL25 = new ComponentLeaf('n');
        parOneSentTwoWordOneL2.addElement(parOneSentTwoWordOneL21);
        parOneSentTwoWordOneL2.addElement(parOneSentTwoWordOneL22);
        parOneSentTwoWordOneL2.addElement(parOneSentTwoWordOneL23);
        parOneSentTwoWordOneL2.addElement(parOneSentTwoWordOneL24);
        parOneSentTwoWordOneL2.addElement(parOneSentTwoWordOneL25);
        CompositeParts parOneSentTwoWordTwoL2 = new CompositeParts(TypeRegex.DELIM_SYMBOL.getRegexForSplit());
        ComponentLeaf parOneSentTwoWordTwoL21 = new ComponentLeaf(',');
        parOneSentTwoWordTwoL2.addElement(parOneSentTwoWordTwoL21);

        CompositeParts parOneSentTwoLexThree = new CompositeParts(TypeRegex.DELIM_LEXEME.getRegexForSplit());
        CompositeParts parOneSentTwoWordOneL3 = new CompositeParts(TypeRegex.DELIM_SYMBOL.getRegexForSplit());
        ComponentLeaf parOneSentTwoWordOneL31 = new ComponentLeaf('b');
        ComponentLeaf parOneSentTwoWordOneL32 = new ComponentLeaf('l');
        ComponentLeaf parOneSentTwoWordOneL33 = new ComponentLeaf('a');
        ComponentLeaf parOneSentTwoWordOneL34 = new ComponentLeaf('c');
        ComponentLeaf parOneSentTwoWordOneL35 = new ComponentLeaf('k');
        parOneSentTwoWordOneL3.addElement(parOneSentTwoWordOneL31);
        parOneSentTwoWordOneL3.addElement(parOneSentTwoWordOneL32);
        parOneSentTwoWordOneL3.addElement(parOneSentTwoWordOneL33);
        parOneSentTwoWordOneL3.addElement(parOneSentTwoWordOneL34);
        parOneSentTwoWordOneL3.addElement(parOneSentTwoWordOneL35);
        CompositeParts parOneSentTwoWordTwoL3 = new CompositeParts(TypeRegex.DELIM_SYMBOL.getRegexForSplit());
        ComponentLeaf parOneSentTwoWordTwoL31 = new ComponentLeaf('.');
        parOneSentTwoWordTwoL3.addElement(parOneSentTwoWordTwoL31);

        parOneSentTwoLexTwo.addElement(parOneSentTwoWordOneL2);
        parOneSentTwoLexTwo.addElement(parOneSentTwoWordTwoL2);

        parOneSentTwoLexThree.addElement(parOneSentTwoWordOneL3);
        parOneSentTwoLexThree.addElement(parOneSentTwoWordTwoL3);

        parOneSentTwo.addElement(parOneSentTwoLexOne);
        parOneSentTwo.addElement(parOneSentTwoLexTwo);
        parOneSentTwo.addElement(parOneSentTwoLexThree);

        CompositeParts parTwoSentOne = new CompositeParts(TypeRegex.DELIM_SENTENCE.getRegexForSplit());
        paragraphTwo.addElement(parTwoSentOne);


        CompositeParts parTwoSentOneLexOne = new CompositeParts(TypeRegex.DELIM_LEXEME.getRegexForSplit());
        CompositeParts parTwoSentOneWordOne = new CompositeParts(TypeRegex.DELIM_SYMBOL.getRegexForSplit());
        parTwoSentOneLexOne.addElement(parTwoSentOneWordOne);
        ComponentLeaf parTwoSentOneWordOne1 = new ComponentLeaf('O');
        ComponentLeaf parTwoSentOneWordOne2 = new ComponentLeaf('n');
        ComponentLeaf parTwoSentOneWordOne3 = new ComponentLeaf('e');
        parTwoSentOneWordOne.addElement(parTwoSentOneWordOne1);
        parTwoSentOneWordOne.addElement(parTwoSentOneWordOne2);
        parTwoSentOneWordOne.addElement(parTwoSentOneWordOne3);

        CompositeParts parTwoSentOneLexTwo = new CompositeParts(TypeRegex.DELIM_LEXEME.getRegexForSplit());
        CompositeParts parTwoSentOneWordTwo = new CompositeParts(TypeRegex.DELIM_SYMBOL.getRegexForSplit());
        parTwoSentOneLexTwo.addElement(parTwoSentOneWordTwo);
        ComponentLeaf parTwoSentOneWordTwo1 = new ComponentLeaf('t');
        ComponentLeaf parTwoSentOneWordTwo2 = new ComponentLeaf('w');
        ComponentLeaf parTwoSentOneWordTwo3 = new ComponentLeaf('o');
        parTwoSentOneWordTwo.addElement(parTwoSentOneWordTwo1);
        parTwoSentOneWordTwo.addElement(parTwoSentOneWordTwo2);
        parTwoSentOneWordTwo.addElement(parTwoSentOneWordTwo3);

        CompositeParts parTwoSentOneLexThree = new CompositeParts(TypeRegex.DELIM_LEXEME.getRegexForSplit());
        CompositeParts parTwoSentOneWordThree = new CompositeParts(TypeRegex.DELIM_SYMBOL.getRegexForSplit());
        parTwoSentOneLexThree.addElement(parTwoSentOneWordThree);
        ComponentLeaf parTwoSentOneWordThree1 = new ComponentLeaf('t');
        ComponentLeaf parTwoSentOneWordThree2 = new ComponentLeaf('h');
        ComponentLeaf parTwoSentOneWordThree3 = new ComponentLeaf('r');
        ComponentLeaf parTwoSentOneWordThree4 = new ComponentLeaf('e');
        ComponentLeaf parTwoSentOneWordThree5 = new ComponentLeaf('e');
        parTwoSentOneWordThree.addElement(parTwoSentOneWordThree1);
        parTwoSentOneWordThree.addElement(parTwoSentOneWordThree2);
        parTwoSentOneWordThree.addElement(parTwoSentOneWordThree3);
        parTwoSentOneWordThree.addElement(parTwoSentOneWordThree4);
        parTwoSentOneWordThree.addElement(parTwoSentOneWordThree5);

        CompositeParts parTwoSentOneLexFour = new CompositeParts(TypeRegex.DELIM_LEXEME.getRegexForSplit());
        CompositeParts parTwoSentOneWord1Four = new CompositeParts(TypeRegex.DELIM_SYMBOL.getRegexForSplit());
        parTwoSentOneLexFour.addElement(parTwoSentOneWord1Four);
        ComponentLeaf parTwoSentOneWord1Four1 = new ComponentLeaf('f');
        ComponentLeaf parTwoSentOneWord1Four2 = new ComponentLeaf('o');
        ComponentLeaf parTwoSentOneWord1Four3 = new ComponentLeaf('u');
        ComponentLeaf parTwoSentOneWord1Four4 = new ComponentLeaf('r');
        parTwoSentOneWord1Four.addElement(parTwoSentOneWord1Four1);
        parTwoSentOneWord1Four.addElement(parTwoSentOneWord1Four2);
        parTwoSentOneWord1Four.addElement(parTwoSentOneWord1Four3);
        parTwoSentOneWord1Four.addElement(parTwoSentOneWord1Four4);

        CompositeParts parTwoSentOneLexL5 = new CompositeParts(TypeRegex.DELIM_LEXEME.getRegexForSplit());
        CompositeParts parTwoSentOneWord1L5 = new CompositeParts(TypeRegex.DELIM_SYMBOL.getRegexForSplit());
        CompositeParts parTwoSentOneWord2L5 = new CompositeParts(TypeRegex.DELIM_SYMBOL.getRegexForSplit());
        parTwoSentOneLexL5.addElement(parTwoSentOneWord1L5);
        ComponentLeaf parTwoSentOneWord1L51 = new ComponentLeaf('f');
        ComponentLeaf parTwoSentOneWord1L52 = new ComponentLeaf('i');
        ComponentLeaf parTwoSentOneWord1L53 = new ComponentLeaf('v');
        ComponentLeaf parTwoSentOneWord1L54 = new ComponentLeaf('e');
        parTwoSentOneWord1L5.addElement(parTwoSentOneWord1L51);
        parTwoSentOneWord1L5.addElement(parTwoSentOneWord1L52);
        parTwoSentOneWord1L5.addElement(parTwoSentOneWord1L53);
        parTwoSentOneWord1L5.addElement(parTwoSentOneWord1L54);

        parTwoSentOneLexL5.addElement(parTwoSentOneWord2L5);
        ComponentLeaf parTwoSentOneWord2L51 = new ComponentLeaf('.');
        parTwoSentOneWord2L5.addElement(parTwoSentOneWord2L51);

        parTwoSentOne.addElement(parTwoSentOneLexOne);
        parTwoSentOne.addElement(parTwoSentOneLexTwo);
        parTwoSentOne.addElement(parTwoSentOneLexThree);
        parTwoSentOne.addElement(parTwoSentOneLexFour);
        parTwoSentOne.addElement(parTwoSentOneLexL5);

        CompositeParts parTwoSentTwo = new CompositeParts(TypeRegex.DELIM_SENTENCE.getRegexForSplit());
        paragraphTwo.addElement(parTwoSentTwo);

        CompositeParts parTwoSentTwoLexOne = new CompositeParts(TypeRegex.DELIM_LEXEME.getRegexForSplit());
        CompositeParts parTwoSentTwoWordOne = new CompositeParts(TypeRegex.DELIM_SYMBOL.getRegexForSplit());
        ComponentLeaf parTwoSentTwoWordOne1 = new ComponentLeaf('R');
        ComponentLeaf parTwoSentTwoWordOne2 = new ComponentLeaf('e');
        ComponentLeaf parTwoSentTwoWordOne3 = new ComponentLeaf('d');
        parTwoSentTwoWordOne.addElement(parTwoSentTwoWordOne1);
        parTwoSentTwoWordOne.addElement(parTwoSentTwoWordOne2);
        parTwoSentTwoWordOne.addElement(parTwoSentTwoWordOne3);
        CompositeParts parTwoSentTwoWordTwo = new CompositeParts(TypeRegex.DELIM_SYMBOL.getRegexForSplit());
        ComponentLeaf parTwoSentTwoWordTwo1 = new ComponentLeaf(',');
        parTwoSentTwoWordTwo.addElement(parTwoSentTwoWordTwo1);
        parTwoSentTwoLexOne.addElement(parTwoSentTwoWordOne);
        parTwoSentTwoLexOne.addElement(parTwoSentTwoWordTwo);

        CompositeParts parTwoSentTwoLexTwo = new CompositeParts(TypeRegex.DELIM_LEXEME.getRegexForSplit());
        CompositeParts parTwoSentTwoWordOneL2 = new CompositeParts(TypeRegex.DELIM_SYMBOL.getRegexForSplit());
        ComponentLeaf parTwoSentTwoWordOneL21 = new ComponentLeaf('g');
        ComponentLeaf parTwoSentTwoWordOneL22 = new ComponentLeaf('r');
        ComponentLeaf parTwoSentTwoWordOneL23 = new ComponentLeaf('e');
        ComponentLeaf parTwoSentTwoWordOneL24 = new ComponentLeaf('e');
        ComponentLeaf parTwoSentTwoWordOneL25 = new ComponentLeaf('n');
        parTwoSentTwoWordOneL2.addElement(parTwoSentTwoWordOneL21);
        parTwoSentTwoWordOneL2.addElement(parTwoSentTwoWordOneL22);
        parTwoSentTwoWordOneL2.addElement(parTwoSentTwoWordOneL23);
        parTwoSentTwoWordOneL2.addElement(parTwoSentTwoWordOneL24);
        parTwoSentTwoWordOneL2.addElement(parTwoSentTwoWordOneL25);
        CompositeParts parTwoSentTwoWordTwoL2 = new CompositeParts(TypeRegex.DELIM_SYMBOL.getRegexForSplit());
        ComponentLeaf parTwoSentTwoWordTwoL21 = new ComponentLeaf(',');
        parTwoSentTwoWordTwoL2.addElement(parTwoSentTwoWordTwoL21);

        CompositeParts parTwoSentTwoLexThree = new CompositeParts(TypeRegex.DELIM_LEXEME.getRegexForSplit());
        CompositeParts parTwoSentTwoWordOneL3 = new CompositeParts(TypeRegex.DELIM_SYMBOL.getRegexForSplit());
        ComponentLeaf parTwoSentTwoWordOneL31 = new ComponentLeaf('b');
        ComponentLeaf parTwoSentTwoWordOneL32 = new ComponentLeaf('l');
        ComponentLeaf parTwoSentTwoWordOneL33 = new ComponentLeaf('a');
        ComponentLeaf parTwoSentTwoWordOneL34 = new ComponentLeaf('c');
        ComponentLeaf parTwoSentTwoWordOneL35 = new ComponentLeaf('k');
        parTwoSentTwoWordOneL3.addElement(parTwoSentTwoWordOneL31);
        parTwoSentTwoWordOneL3.addElement(parTwoSentTwoWordOneL32);
        parTwoSentTwoWordOneL3.addElement(parTwoSentTwoWordOneL33);
        parTwoSentTwoWordOneL3.addElement(parTwoSentTwoWordOneL34);
        parTwoSentTwoWordOneL3.addElement(parTwoSentTwoWordOneL35);

        CompositeParts parTwoSentTwoLex4 = new CompositeParts(TypeRegex.DELIM_LEXEME.getRegexForSplit());
        CompositeParts parTwoSentTwoWordOneL4 = new CompositeParts(TypeRegex.DELIM_SYMBOL.getRegexForSplit());
        ComponentLeaf parTwoSentTwoWordOneL41 = new ComponentLeaf('(');
        ComponentLeaf parTwoSentTwoWordOneL42 = new ComponentLeaf('(');
        ComponentLeaf parTwoSentTwoWordOneL43 = new ComponentLeaf('5');
        ComponentLeaf parTwoSentTwoWordOneL44 = new ComponentLeaf('>');
        ComponentLeaf parTwoSentTwoWordOneL45 = new ComponentLeaf('>');
        ComponentLeaf parTwoSentTwoWordOneL46 = new ComponentLeaf('5');
        ComponentLeaf parTwoSentTwoWordOneL47 = new ComponentLeaf(')');
        ComponentLeaf parTwoSentTwoWordOneL48 = new ComponentLeaf('^');
        ComponentLeaf parTwoSentTwoWordOneL49 = new ComponentLeaf('(');
        ComponentLeaf parTwoSentTwoWordOneL410 = new ComponentLeaf('6');
        ComponentLeaf parTwoSentTwoWordOneL411 = new ComponentLeaf('<');
        ComponentLeaf parTwoSentTwoWordOneL412 = new ComponentLeaf('<');
        ComponentLeaf parTwoSentTwoWordOneL413 = new ComponentLeaf('6');
        ComponentLeaf parTwoSentTwoWordOneL414 = new ComponentLeaf(')');
        ComponentLeaf parTwoSentTwoWordOneL415 = new ComponentLeaf(')');
        ComponentLeaf parTwoSentTwoWordOneL416 = new ComponentLeaf('&');
        ComponentLeaf parTwoSentTwoWordOneL417 = new ComponentLeaf('2');
        parTwoSentTwoWordOneL4.addElement(parTwoSentTwoWordOneL41);
        parTwoSentTwoWordOneL4.addElement(parTwoSentTwoWordOneL42);
        parTwoSentTwoWordOneL4.addElement(parTwoSentTwoWordOneL43);
        parTwoSentTwoWordOneL4.addElement(parTwoSentTwoWordOneL44);
        parTwoSentTwoWordOneL4.addElement(parTwoSentTwoWordOneL45);
        parTwoSentTwoWordOneL4.addElement(parTwoSentTwoWordOneL46);
        parTwoSentTwoWordOneL4.addElement(parTwoSentTwoWordOneL47);
        parTwoSentTwoWordOneL4.addElement(parTwoSentTwoWordOneL48);
        parTwoSentTwoWordOneL4.addElement(parTwoSentTwoWordOneL49);
        parTwoSentTwoWordOneL4.addElement(parTwoSentTwoWordOneL410);
        parTwoSentTwoWordOneL4.addElement(parTwoSentTwoWordOneL411);
        parTwoSentTwoWordOneL4.addElement(parTwoSentTwoWordOneL412);
        parTwoSentTwoWordOneL4.addElement(parTwoSentTwoWordOneL413);
        parTwoSentTwoWordOneL4.addElement(parTwoSentTwoWordOneL414);
        parTwoSentTwoWordOneL4.addElement(parTwoSentTwoWordOneL415);
        parTwoSentTwoWordOneL4.addElement(parTwoSentTwoWordOneL416);
        parTwoSentTwoWordOneL4.addElement(parTwoSentTwoWordOneL417);

        CompositeParts parTwoSentTwoLex5 = new CompositeParts(TypeRegex.DELIM_LEXEME.getRegexForSplit());
        CompositeParts parTwoSentTwoWordOneL5 = new CompositeParts(TypeRegex.DELIM_SYMBOL.getRegexForSplit());
        ComponentLeaf parTwoSentTwoWordOneL51 = new ComponentLeaf('g');
        ComponentLeaf parTwoSentTwoWordOneL52 = new ComponentLeaf('o');
        parTwoSentTwoWordOneL5.addElement(parTwoSentTwoWordOneL51);
        parTwoSentTwoWordOneL5.addElement(parTwoSentTwoWordOneL52);
        CompositeParts parTwoSentTwoWordTwoL5 = new CompositeParts(TypeRegex.DELIM_SYMBOL.getRegexForSplit());
        ComponentLeaf parTwoSentTwoWordTwoL51 = new ComponentLeaf('.');
        parTwoSentTwoWordTwoL5.addElement(parTwoSentTwoWordTwoL51);

        parTwoSentTwoLexTwo.addElement(parTwoSentTwoWordOneL2);
        parTwoSentTwoLexTwo.addElement(parTwoSentTwoWordTwoL2);
        parTwoSentTwoLexThree.addElement(parTwoSentTwoWordOneL3);
        parTwoSentTwoLex4.addElement(parTwoSentTwoWordOneL4);
        parTwoSentTwoLex5.addElement(parTwoSentTwoWordOneL5);
        parTwoSentTwoLex5.addElement(parTwoSentTwoWordTwoL5);

        parTwoSentTwo.addElement(parTwoSentTwoLexOne);
        parTwoSentTwo.addElement(parTwoSentTwoLexTwo);
        parTwoSentTwo.addElement(parTwoSentTwoLexThree);
        parTwoSentTwo.addElement(parTwoSentTwoLex4);
        parTwoSentTwo.addElement(parTwoSentTwoLex5);

        CompositeParts parThreeSentOne = new CompositeParts(TypeRegex.DELIM_SENTENCE.getRegexForSplit());

        CompositeParts parThreeSentOneLexOne = new CompositeParts(TypeRegex.DELIM_LEXEME.getRegexForSplit());
        CompositeParts parThreeSentOneWordOne = new CompositeParts(TypeRegex.DELIM_SYMBOL.getRegexForSplit());
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
        CompositeParts parThreeSentOneWord1Two = new CompositeParts(TypeRegex.DELIM_SYMBOL.getRegexForSplit());
        parThreeSentOneLexTwo.addElement(parThreeSentOneWord1Two);
        ComponentLeaf parThreeSentOneWordTwo1 = new ComponentLeaf('c');
        ComponentLeaf parThreeSentOneWordTwo2 = new ComponentLeaf('a');
        ComponentLeaf parThreeSentOneWordTwo3 = new ComponentLeaf('t');
        ComponentLeaf parThreeSentOneWordTwo4 = new ComponentLeaf('s');
        parThreeSentOneWord1Two.addElement(parThreeSentOneWordTwo1);
        parThreeSentOneWord1Two.addElement(parThreeSentOneWordTwo2);
        parThreeSentOneWord1Two.addElement(parThreeSentOneWordTwo3);
        parThreeSentOneWord1Two.addElement(parThreeSentOneWordTwo4);
        CompositeParts parThreeSentOneWord2Two = new CompositeParts(TypeRegex.DELIM_SYMBOL.getRegexForSplit());
        parThreeSentOneLexTwo.addElement(parThreeSentOneWord2Two);
        ComponentLeaf parThreeSentOneWord2Two1 = new ComponentLeaf('.');
        parThreeSentOneWord2Two.addElement(parThreeSentOneWord2Two1);

        parThreeSentOne.addElement(parThreeSentOneLexOne);
        parThreeSentOne.addElement(parThreeSentOneLexTwo);

        CompositeParts parThreeSentTwo = new CompositeParts(TypeRegex.DELIM_SENTENCE.getRegexForSplit());
        CompositeParts parThreeSentTwoLexOne = new CompositeParts(TypeRegex.DELIM_LEXEME.getRegexForSplit());
        CompositeParts parThreeSentTwoWordOne = new CompositeParts(TypeRegex.DELIM_SYMBOL.getRegexForSplit());
        ComponentLeaf parThreeSentTwoWordOne1 = new ComponentLeaf('R');
        ComponentLeaf parThreeSentTwoWordOne2 = new ComponentLeaf('e');
        ComponentLeaf parThreeSentTwoWordOne3 = new ComponentLeaf('d');
        parThreeSentTwoWordOne.addElement(parThreeSentTwoWordOne1);
        parThreeSentTwoWordOne.addElement(parThreeSentTwoWordOne2);
        parThreeSentTwoWordOne.addElement(parThreeSentTwoWordOne3);
        parThreeSentTwoLexOne.addElement(parThreeSentTwoWordOne);

        CompositeParts parThreeSentTwoLexOne1 = new CompositeParts(TypeRegex.DELIM_LEXEME.getRegexForSplit());
        CompositeParts parThreeSentTwoWordOne11 = new CompositeParts(TypeRegex.DELIM_SYMBOL.getRegexForSplit());
        ComponentLeaf parThreeSentTwoWordOne111 = new ComponentLeaf('-');
        parThreeSentTwoWordOne11.addElement(parThreeSentTwoWordOne111);
        parThreeSentTwoLexOne1.addElement(parThreeSentTwoWordOne11);

        CompositeParts parThreeSentTwoLexTwo = new CompositeParts(TypeRegex.DELIM_LEXEME.getRegexForSplit());
        CompositeParts parThreeSentTwoWordOneL2 = new CompositeParts(TypeRegex.DELIM_SYMBOL.getRegexForSplit());
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
        CompositeParts parThreeSentTwoWordTwoL2 = new CompositeParts(TypeRegex.DELIM_SYMBOL.getRegexForSplit());
        ComponentLeaf parThreeSentTwoWordTwoL21 = new ComponentLeaf('.');
        parThreeSentTwoWordTwoL2.addElement(parThreeSentTwoWordTwoL21);

        parThreeSentTwoLexTwo.addElement(parThreeSentTwoWordOneL2);
        parThreeSentTwoLexTwo.addElement(parThreeSentTwoWordTwoL2);

        parThreeSentTwo.addElement(parThreeSentTwoLexOne);
        parThreeSentTwo.addElement(parThreeSentTwoLexOne1);
        parThreeSentTwo.addElement(parThreeSentTwoLexTwo);

        CompositeParts parThreeSentThree = new CompositeParts(TypeRegex.DELIM_SENTENCE.getRegexForSplit());
        CompositeParts parThreeSentThreeLexTwo = new CompositeParts(TypeRegex.DELIM_LEXEME.getRegexForSplit());
        CompositeParts parThreeSentThreeWord1Two = new CompositeParts(TypeRegex.DELIM_SYMBOL.getRegexForSplit());

        ComponentLeaf parThreeSentThreeWordTwo1 = new ComponentLeaf('B');
        ComponentLeaf parThreeSentThreeWordTwo2 = new ComponentLeaf('y');
        parThreeSentThreeWord1Two.addElement(parThreeSentThreeWordTwo1);
        parThreeSentThreeWord1Two.addElement(parThreeSentThreeWordTwo2);
        CompositeParts parThreeSentThreeWord2Two = new CompositeParts(TypeRegex.DELIM_SYMBOL.getRegexForSplit());
        ComponentLeaf parThreeSentThreeWord2Two1 = new ComponentLeaf('.');
        parThreeSentThreeWord2Two.addElement(parThreeSentThreeWord2Two1);
        parThreeSentThreeLexTwo.addElement(parThreeSentThreeWord1Two);
        parThreeSentThreeLexTwo.addElement(parThreeSentThreeWord2Two);
        parThreeSentThree.addElement(parThreeSentThreeLexTwo);

        paragraphThree.addElement(parThreeSentOne);
        paragraphThree.addElement(parThreeSentTwo);
        paragraphThree.addElement(parThreeSentThree);
        text2.addElement(parOneSentOne);
    }

    public CompositeParts getText() {
        return text;
    }

    @DataProvider(name = "Composite_parser")
    public Object[][] compositeParser() {
        String str = "One two three four. Red, green, black." +
                "\t\n One two three four five. Red, green, black ((5>>5)^(6<<6))&2 go." +
                "\n\t Three cats. Red - green. By.\n";
        return new Object[][]{
                new Object[]{text, str},
                new Object[]{text, ""},
        };
    }

    @Test(description = "Test parser",
            dataProvider = "Composite_parser")
    public void testHandleRequest(CompositeParts text, String str) {
        CompositeParts actual =
                new CompositeParts(TypeRegex.DELIM_PARAGRAPH.getRegexForSplit());
        parseTextToParagraph.handleRequest(actual, str);
        assertEquals(actual, text);
    }

    @DataProvider(name = "Composite_parser2")
    public Object[][] compositeParser2() {
        String str = "One two three four.";
        return new Object[][]{
                new Object[]{text2, str},
        };
    }

    /**
     * @param text Composite:
     *             Checking text parsing
     *             from lexemes to symbols.
     * @param str Text to parse.
     */
    @Test(description = "Test parser",
            dataProvider = "Composite_parser2")
    public void testHandleRequest2(CompositeParts text, String str) {
        ParseSentenceToLexeme parseLexemeToWords =
                new ParseSentenceToLexeme();
        ParseTextToParagraph parseTextToParagraph1 =
                new ParseTextToParagraph(parseLexemeToWords);
        CompositeParts actual =
                new CompositeParts(
                        TypeRegex.DELIM_PARAGRAPH.getRegexForSplit());
        parseTextToParagraph1.handleRequest(actual, str);
        assertEquals(actual, text);
    }
}