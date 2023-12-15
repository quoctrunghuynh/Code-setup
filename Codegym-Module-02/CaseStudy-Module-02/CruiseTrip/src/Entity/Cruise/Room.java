package Entity.Cruise;

import Entity.Users.Customer;
import Services.CruiseServices;
import Services.RoomServices;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class Room {
    private final String room_Type; //Loại phòng thuyền có: Junior / Senior / Executive / President
    private final String room_Id; // room_Id = xxyy, trong đó xx là số tầng, yy là số thứ tự phòng ví dụ: 1149-tầng 11 phòng 49
    private final String room_Location; //Bao gồm Đầu thuyền, giữa thuyền, cuối thuyền
    private boolean available;
    private Customer customerInfo;
    private double roomPrice;

    @Override
    public String toString() {
        return "Room:" + room_Id + ":" + room_Type + ":" + room_Location + ": Status:" + available + "\n";
    }

//    public double setRoomPrice() {
//        this.roomPrice = Double.parseDouble(RoomServices.getRoomPrice(room_Id,room_Type,room_Location));
//    }

    public void setRoomPrice() {
        this.roomPrice = RoomServices.getRoomPrice(room_Id, room_Type, room_Location);
    }

    public String showRoomInfo() {
        String status = available ? "Available" : "Not available";
        return "Room " + room_Id + "\t\t" + "Type: " + room_Type + "\n" + "\t\t\t\t" +
                "Room located at: " + room_Location + "\n" + "\t\t\t\t" +
                "Time On Cruise: \t From:  " + CruiseServices.currentCruise.getDepartDate_String() + "\n" + "\t\t\t\t" + "\t\t\t\t\t" +
                " To:\t" + CruiseServices.currentCruise.getReturnDate_String() + "\n" + "\t\t\t\t" +
                "Price: " + RoomServices.getRoomPrice_String(room_Id, room_Type, room_Location) + "\n" + "\t\t\t\t" +
                "Room currently: " + status + "\n\n";
    }
}
