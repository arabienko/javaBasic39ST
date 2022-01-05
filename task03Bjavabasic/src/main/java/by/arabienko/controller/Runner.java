package by.arabienko.controller;

import by.arabienko.entity.ProgramGuide;
import by.arabienko.service.*;
import by.arabienko.service.impl.GetGuidAfterTime;
import by.arabienko.service.impl.GetGuidChannel;
import by.arabienko.service.impl.ReadFile;
import by.arabienko.view.InputOutputData;
import by.arabienko.view.ViewException;
import by.arabienko.view.ViewGuid;

import java.io.IOException;
import java.util.HashMap;

import java.util.List;

public class Runner {
    public static void main(String[] args) throws IOException, ServiceException, ViewException {
        /*ReadFile readFile = new ReadFile();
        InputOutputData inputOutputData = new InputOutputData();
        HashMap list = readFile.read(" ");
        //System.out.println(list);
        GetGuidAfterTime getGuid = new GetGuidAfterTime();
        HashMap<String, ProgramGuide.Program> hashMap = getGuid.execute((List<ProgramGuide>) list.get(0),
                "monday","15:00");
        inputOutputData.output(hashMap, "Channel: ");
        GetGuid getGuid1 = new GetGuidChannel();
        HashMap<String, ProgramGuide.Program> hashMap2 = getGuid1.execute((List<ProgramGuide>) list.get(0),
                "Nature","monday");
                inputOutputData.output(hashMap2, "Program: ");*/

        ViewGuid.viewGuid();

    }
}
