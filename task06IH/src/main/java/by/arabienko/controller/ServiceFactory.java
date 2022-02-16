package by.arabienko.controller;

import by.arabienko.service.*;
import by.arabienko.service.impl.ReaderFromFile;
import by.arabienko.service.impl.WriterToFile;
import by.arabienko.service.impl.collect.CollectText;
import by.arabienko.service.impl.parse.ParseTextToParagraph;
import by.arabienko.service.impl.sort.SortLexemesBySymbolCount;
import by.arabienko.service.impl.sort.SortParagraphsByNumberOfSentences;
import by.arabienko.service.impl.sort.SortWordsInSentencesByLength;

public class ServiceFactory {
    private static final ServiceFactory INSTANCE = new ServiceFactory();

    private ServiceFactory() {
    }

    public static ServiceFactory getInstance() {
        return INSTANCE;
    }

    private final IParse parseToParagraph = new ParseTextToParagraph();
    public IParse getParseToParagraph() {
        return parseToParagraph;
    }
    private final Collect collectToText = new CollectText();
    public Collect getCollectToText() {
        return collectToText;
    }
    private final IReader reader = new ReaderFromFile();
    public IReader getReader(){
        return reader;
    }
    private final IWriter writer = new WriterToFile();
    public IWriter getWriter(){
        return writer;
    }
    private final Sort sortBySymbolCount = new SortLexemesBySymbolCount();
    public Sort getSortBySymbolCount(){
        return sortBySymbolCount;
    }
    private final Sort sortByNumberOfSentences = new SortParagraphsByNumberOfSentences();
    public  Sort getSortByNumberOfSentences(){
        return sortByNumberOfSentences;
    }
    private final Sort sortByWordsLength = new SortWordsInSentencesByLength();
    public Sort getSortByWordsLength(){
        return sortByWordsLength;
    }
}
