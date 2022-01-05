package by.arabienko.view;

import by.arabienko.controller.Controller;
import by.arabienko.entity.MessageManager;
import by.arabienko.service.ServiceException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.*;

public class ViewGuid {
    private static final Logger LOGGER = LogManager.getLogger(ViewGuid.class);

    public static void viewGuid() throws ServiceException, IOException, ViewException {
        InputOutputData inputOutputData = new InputOutputData();
        Controller controller = new Controller();
        List list = new ArrayList();
        System.out.println("1 — eng; 2 — bel; 3 — rus; any — default");
        char select = 0;
        try {
            select = (char) System.in.read();

        } catch (IOException e) {
            e.printStackTrace();
        }
        MessageManager messageManager = MessageManager.EN;
        switch (select) {
            case '1':
                messageManager = MessageManager.EN;
                break;
            case '2':
                messageManager = MessageManager.BY;
                break;
            case '3':
                messageManager = MessageManager.RU;
                break;
        }
        String start_menu = messageManager.getString("start_menu");
        String purpose_day = messageManager.getString("purpose_day");
        String purpose_time = messageManager.getString("purpose_time");
        String purpose_channel = messageManager.getString("purpose_channel");
        String channel_word = messageManager.getString("channel_word");
        String word_day = messageManager.getString("word_day");
        String wrong_select = messageManager.getString("wrong_select");
        Scanner scanner = new Scanner(System.in);
        inputOutputData.output(start_menu);
        int number = scanner.nextInt();
        switch (number) {
            case 1:
                inputOutputData.output(purpose_day);
                String day = scanner.next();
                inputOutputData.output(purpose_time);
                String time = scanner.next();
                list.add("programGuid");
                list.add(day.trim().toUpperCase());
                list.add(time);
                HashMap hashMapTime = controller.executeTask(number, list);
                inputOutputData.output(hashMapTime, word_day+ day.trim().toUpperCase(), time);
                break;
            case 2:
                inputOutputData.output(purpose_channel);
                String channel = scanner.next();
                inputOutputData.output(purpose_day);
                String dayWeek = scanner.next();
                list.add("programGuid");
                list.add(channel.trim().toUpperCase());
                list.add(dayWeek.trim().toUpperCase());
                HashMap hashMapChannel = controller.executeTask(number, list);
                inputOutputData.output(hashMapChannel, channel_word+channel.trim().toUpperCase());
                break;
            default:
                inputOutputData.output(wrong_select);
                LOGGER.debug("Wrong select task.");
                throw new ViewException("Wrong select task.");
        }
    }
}
