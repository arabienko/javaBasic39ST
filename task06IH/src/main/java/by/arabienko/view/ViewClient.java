package by.arabienko.view;

import by.arabienko.controller.Command;
import by.arabienko.controller.impl.CommandSortByNumberOfSentences;
import by.arabienko.controller.impl.CommandSortByWordsLength;
import by.arabienko.controller.impl.CommandSortLexemesBySymbolCount;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ViewClient {
    private static final Logger LOGGER =
            LogManager.getLogger(ViewClient.class);
    public static void select(){
        Command command;
        InputOutputData dateIO = new InputOutputData();
        int selectClient;
        dateIO.output("Select number : \n" +
                "1. Sort Words In Sentences By Length from files. \n" +
                "2. Sort Paragraphs By Number Of Sentences from files.\n" +
                "3. Sort Lexemes By Symbol Count from files. ");
       try (Scanner scanner = new Scanner(System.in)){

        selectClient = scanner.nextInt();
        switch (selectClient) {
            case 1:
                LOGGER.debug("Sort Words In Sentences By Length from files.");
                command = new CommandSortByWordsLength();
                List list1 = new ArrayList<>();
                list1.add("text");
                command.execute(list1);
                break;
            case 2:
                LOGGER.debug("Sort Paragraphs By Number Of Sentences from files.");
                command = new CommandSortByNumberOfSentences();
                List list2 = new ArrayList<>();
                list2.add("text");
                command.execute(list2);
                break;
            case 3:
                LOGGER.debug("Sort Lexemes By Symbol Count from files.");
                dateIO.output("Input symbol for sorting: ");
                String ch = scanner.next();
                command = new CommandSortLexemesBySymbolCount();
                List list3 = new ArrayList<>();
                list3.add("text");
                list3.add(ch);
                command.execute(list3);
                break;
            default:
                LOGGER.debug("Invalid value entered (WRONG_COMMAND) " + selectClient);
                dateIO.output("WRONG_COMMAND - " + selectClient);
                break;
        }
        }catch (Exception e){
           LOGGER.error("Incorrect input.  " + e);
           e.printStackTrace();
       }
    }
}
