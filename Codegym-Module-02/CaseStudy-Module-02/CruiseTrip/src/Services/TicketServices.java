package Services;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TicketServices {
    private final static TicketServices instance = new TicketServices();
    static String ticketID;

    public static TicketServices getInstance() {
        return instance;
    }

    public static String createTicketId() {
        String ticketP1 = LocalDateTime.now().format(DateTimeFormatter.ofPattern("ddMMyyyyHHmm"));
        ticketID = ticketP1.concat(String.valueOf(CustomerServices.currentCustomer.getTelephone().hashCode()));
        try {
            FileOutputStream fos = new FileOutputStream("TicketList.txt", true);
            DataOutputStream dot = new DataOutputStream(fos);
            dot.writeBytes(ticketID + "\n\n\n");
            fos.close();
            dot.close();
        } catch (IOException ioe) {
            System.err.println("createTicketId function got problem");
        }
        return ticketID;
    }

    public static void getCurrentCustomerTicket() {
        String customerTicket_URL = "CustomerTicket/Customer" + CustomerServices.currentCustomer.getTelephone() + ".txt";
        try {
            BufferedReader br = new BufferedReader((new FileReader(customerTicket_URL)));
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
            br.close();
        } catch (IOException e) {
            System.err.println("Ticket not found!");
        }
        CustomerServices.browse();
    }

    public String getTicketID() {
        return ticketID = createTicketId();
    }
}
