package Entity;

import Services.CruiseServices;
import Services.CustomerServices;
import Services.RoomServices;
import Services.TicketServices;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Ticket {
    private static String price = (RoomServices.getRoomPrice_String(RoomServices.currentRoom.getRoom_Id(),
            RoomServices.currentRoom.getRoom_Type(),
            RoomServices.currentRoom.getRoom_Location()));

    public Ticket() {
    }

    public static String setPriceFree() {
        return price = "Free";
    }

    @Override
    public String toString() {
        return "Ticket ID: " + TicketServices.getInstance().getTicketID() + " " +
                "Customer: " + CustomerServices.currentCustomer.getFirstName() + " " +
                CustomerServices.currentCustomer.getLastName() + '\n' +
                "Ship_name='" + CruiseServices.currentCruise.getName() + '\n' +
                "Room_id='" + RoomServices.currentRoom.getRoom_Id() + '\n' +
                "DepartDate='" + CruiseServices.currentCruise.getDepartDate_String() + '\n' +
                "ReturnDate='" + CruiseServices.currentCruise.getReturnDate_String() + '\n' +
                "Price=" + price + "\n\n\n";
    }
}
