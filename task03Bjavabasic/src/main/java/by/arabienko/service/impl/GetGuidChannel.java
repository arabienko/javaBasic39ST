package by.arabienko.service.impl;

import by.arabienko.entity.ProgramGuide;
import by.arabienko.service.IGetGuid;
import by.arabienko.service.ServiceException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.List;

/**
 * The method provides a channel schedule for the day upon request.
 */
public class GetGuidChannel implements IGetGuid {

    private static final Logger LOGGER = LogManager.getLogger(GetGuidAfterTime.class);
    @Override
    public HashMap<String, ProgramGuide.Program> execute
            (List<ProgramGuide> list, String channel, String day) throws ServiceException {

        if (list.isEmpty() || channel.isEmpty() || day.isEmpty()) {
            LOGGER.debug("No data for create program guid.");
            throw new ServiceException("No data for create program guid.");
        }
        HashMap<String, ProgramGuide.Program> hashMap = new HashMap<>();
        for (ProgramGuide programGuide : list) {
            if (programGuide.getNameChannel().equals(channel) &&
                    programGuide.getDayOfWeek().equals(day)){
                for (int i = 0; i < programGuide.getLengthProgram(); i++) {
                    hashMap.put(String.valueOf(i), programGuide.getProgram(i));
                }
            }
        }
        if (hashMap.isEmpty() || hashMap.size()==0){
            LOGGER.debug("There are no suitable programs for the conditions.");
            throw  new ServiceException("There are no suitable programs for the conditions.");
        }
        LOGGER.debug("The list of programs has been generated" + GetGuidChannel.class);
        return hashMap;
    }
}
