package by.arabienko.controller.impl;

import by.arabienko.bean.Component;
import by.arabienko.bean.ComponentLeaf;
import by.arabienko.bean.CompositeParts;
import by.arabienko.bean.TypeRegex;
import by.arabienko.controller.Command;
import by.arabienko.controller.ServiceFactory;
import by.arabienko.controller.factory.CompositeCreator;
import by.arabienko.controller.factory.Creator;
import by.arabienko.controller.factory.LeafCreator;
import by.arabienko.service.*;

import java.util.List;

public class CommandSortLexemesBySymbolCount implements Command {
    @Override
    public void execute(List list) {
        String nameFileRead = (String) list.get(0);
        String searchSymbol = (String) list.get(1);
        ServiceFactory serviceFactory =
                ServiceFactory.getInstance();
        IReader reader =
                serviceFactory.getReader();
        IWriter writer =
                serviceFactory.getWriter();
        IParse parse =
                serviceFactory.getParseToParagraph();
        Creator composite =
                new CompositeCreator();
        CompositeParts compositeParts =
                (CompositeParts) composite.factoryMethod(
                        TypeRegex.DELIM_PARAGRAPH.getRegexForSplit());
        Creator leafCreator = new LeafCreator();
        ComponentLeaf leaf = (ComponentLeaf) leafCreator.factoryMethod(searchSymbol);
        parse.handleRequest(compositeParts,
                reader.readFromFile(nameFileRead));
        compositeParts.addElement(leaf);
        Sort sort = serviceFactory.getSortBySymbolCount();
        sort.sort(compositeParts);
        Collect collect = serviceFactory.getCollectToText();
        writer.writeToFile(collect.collect(compositeParts));
    }
}
