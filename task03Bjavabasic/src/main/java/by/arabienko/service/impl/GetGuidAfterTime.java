package by.arabienko.service.impl;

import by.arabienko.entity.ProgramGuide;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import by.arabienko.service.IGetGuid;
import by.arabienko.service.ServiceException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * The method provides a schedule for the day of the week.
 * Select broadcasts for the day and time of the request.
 */
public class GetGuidAfterTime implements IGetGuid {

    private static final Logger LOGGER = LogManager.getLogger(GetGuidAfterTime.class);

    @Override
    public HashMap<String, ProgramGuide.Program> execute(List<ProgramGuide> list,
                                                         String day, String time) throws ServiceException {

        if (list.isEmpty() || day.isEmpty() || time.isEmpty()) {
            LOGGER.debug("No data for create program guid.");
            throw new ServiceException("No data for create program guid.");
        }
        HashMap<String, ProgramGuide.Program> hashMap = new HashMap<>();
        Date dateCurrentRequest;
        Date dateGuid;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm");
        try {
            dateCurrentRequest = simpleDateFormat.parse(time);
        } catch (ParseException e) {
            LOGGER.debug("Incorrect data entry (time format). "+e);
            throw new ServiceException("Incorrect data entry (time format)."+ e);
        }
        for (ProgramGuide programGuide : list) {
            for (int i = 0; i < programGuide.getLengthProgram(); i++) {
                try {
                    dateGuid = simpleDateFormat.parse(programGuide.getProgram(i).getTime());

                } catch (ParseException e) {
                    LOGGER.error("Incorrect data entry (time format)." + e);
                    throw new ServiceException("Parse Exception date format: "+ e);
                }
                if (programGuide.getDayOfWeek().equals(day)) {
                    if (dateCurrentRequest.compareTo(dateGuid) < 0) {
                        hashMap.put(programGuide.getNameChannel(), programGuide.getProgram(i));
                        break;
                    }
                }
            }
        }
        if (hashMap.isEmpty() || hashMap.size()==0) {
            LOGGER.debug("The choice is empty.");
            throw new ServiceException("The choice is empty.");
        }
        LOGGER.debug("The list of programs has been generated" + GetGuidAfterTime.class);
        return hashMap;
    }
}
