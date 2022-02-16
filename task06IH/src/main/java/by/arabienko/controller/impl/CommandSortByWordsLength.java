package by.arabienko.controller.impl;

import by.arabienko.bean.CompositeParts;
import by.arabienko.bean.TypeRegex;
import by.arabienko.controller.Command;
import by.arabienko.controller.ServiceFactory;
import by.arabienko.controller.factory.CompositeCreator;
import by.arabienko.controller.factory.Creator;
import by.arabienko.service.*;

import java.util.List;

public class CommandSortByWordsLength implements Command {
    @Override
    public void execute(List list) {
        String nameFileRead = (String) list.get(0);
        ServiceFactory serviceFactory =
                ServiceFactory.getInstance();
        IReader reader =
                serviceFactory.getReader();
        IWriter writer =
                serviceFactory.getWriter();
        IParse parse =
                serviceFactory.getParseToParagraph();
        Creator creator = new CompositeCreator();
        CompositeParts compositeParts =
                (CompositeParts) creator.factoryMethod(
                        TypeRegex.DELIM_PARAGRAPH.getRegexForSplit());
        parse.handleRequest(compositeParts, reader.readFromFile(nameFileRead));
        Sort sort = serviceFactory.getSortByWordsLength();
        sort.sort(compositeParts);
        Collect collect = serviceFactory.getCollectToText();
        writer.writeToFile(collect.collect(compositeParts));
    }
}
