package by.arabienko.controller;

import by.arabienko.service.IFile;
import by.arabienko.service.IGetGuid;
import by.arabienko.service.impl.GetGuidAfterTime;
import by.arabienko.service.impl.GetGuidChannel;
import by.arabienko.service.impl.ReadFile;

public class ServiceFactory {

    private static final ServiceFactory INSTANCE = new ServiceFactory();

    public ServiceFactory() {
    }

    public static ServiceFactory getInstance(){return INSTANCE;}

    private final IFile fileInterface = new ReadFile();

    public IFile getFileInterface() {
        return fileInterface;
    }

    private final IGetGuid getGuidAfterTime = new GetGuidAfterTime();
    private final IGetGuid getGuidChannel = new GetGuidChannel();

    public IGetGuid getGetGuidAfterTime() {
        return getGuidAfterTime;
    }

    public IGetGuid getGetGuidChannel() {
        return getGuidChannel;
    }


}
