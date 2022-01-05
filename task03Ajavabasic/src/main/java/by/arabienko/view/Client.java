package by.arabienko.view;

import by.arabienko.controller.command.ServiceFactory;
import by.arabienko.service.ServiceException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * A class for working with a client request.
 */
public class Client {

    /**
     * Logging events.
     */
    private static final Logger LOGGER = LogManager.getLogger(Client.class);

    public static void client() {

        InputOutputData ioDate = new InputOutputData();

        String purposeLoan;
        int loanAmount;
        int number;
        int number_borrower;


        List listWithCreditsFromBank = new ArrayList();
        List listNameFile = new ArrayList();
        List listWithOffer = new ArrayList();

        ServiceFactory serviceFactory = ServiceFactory.getInstance();

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
        String purpose_credit = messageManager.getString("purpose_credit");
        String loan_credit = messageManager.getString("loan_credit");
        String wrong_select = messageManager.getString("wrong_select");
        String optimal_credit = messageManager.getString("optimal_credit");
        String borrower = messageManager.getString("borrower");
        String wrong_term = messageManager.getString("wrong_term");
        String borrower_general = messageManager.getString("borrower_general");

        ioDate.output(start_menu);

        try (Scanner scanner = new Scanner(System.in)) {

            ioDate.output(purpose_credit);
            number = scanner.nextInt();

            switch (number) {

                case 1:
                    purposeLoan = "purchase of products";
                    ioDate.output(borrower_general);
                    number_borrower = scanner.nextInt();
                    if (number_borrower!=4 & number_borrower!=5 & number_borrower!=6) {
                        ioDate.output(wrong_select);
                        LOGGER.debug("Incorrect select <borrower>.");
                        throw new Exception("Incorrect select <borrower>.");
                    }
                    ioDate.output(loan_credit);
                    loanAmount = scanner.nextInt();

                    if (loanAmount > 5800 || loanAmount < 1) {
                        ioDate.output(wrong_term);
                        LOGGER.debug("There are no loan offers for this loan amount.");
                        throw new ServiceException("There are no loan offers for this loan amount.");
                    }

                    break;

                case 2:
                    purposeLoan = "home purchase";
                    ioDate.output(borrower);
                    number_borrower = scanner.nextInt();

                    if (number_borrower!=1 & number_borrower!=2 & number_borrower!=3) {
                        ioDate.output(wrong_select);
                        LOGGER.debug("Incorrect select <borrower>.");
                        throw new ViewException("Incorrect select <borrower>.");
                    }
                    ioDate.output(loan_credit);
                    loanAmount = scanner.nextInt();
                    break;
                default:
                    ioDate.output(wrong_select);
                    LOGGER.debug("Incorrect select purpose.");
                    throw new ViewException("Incorrect select purpose.");
            }

            listNameFile.add("dataCredits");
            //read file with bank offers
            listWithCreditsFromBank.add(serviceFactory.getParseFile().
                    execute(listNameFile));
            //OFFERS
            listWithCreditsFromBank.add(purposeLoan);
            listWithCreditsFromBank.add(loanAmount);
            listWithCreditsFromBank.add(number_borrower);

            //getting suitable offers
            listWithOffer.add(serviceFactory.getSelectOffers().
                    execute(listWithCreditsFromBank));

            //add file name to save result offers
            listWithOffer.add("save_result.json");

            //writing result offers
            serviceFactory.getWriteToFile().execute(listWithOffer);
            //OPTIMAL OFFER
            listWithOffer.remove(1);
            listWithOffer.add(purposeLoan);
            listWithOffer.add(number_borrower);
            listWithOffer.add(loanAmount);


            listWithCreditsFromBank.clear();
            //getting optimal offer
            listWithCreditsFromBank.add(serviceFactory.getSelectOptimal().
                    execute(listWithOffer));

            ioDate.output(optimal_credit + listWithCreditsFromBank.get(0));

            //add file name to save result
            listWithCreditsFromBank.add("save_optimal.json");

            //writing result optimal offer
            serviceFactory.getWriteToFile().execute(listWithCreditsFromBank);

        } catch (Exception e) {
            LOGGER.error("Error input dates. " + e);
            e.printStackTrace();

        }
    }
}



