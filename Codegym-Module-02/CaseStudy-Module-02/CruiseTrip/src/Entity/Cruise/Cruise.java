package Entity.Cruise;

import Services.CruiseServices;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;

@Setter
@Getter
@Builder
public class Cruise {
    private String name;
    private String title;
    private String captainName;
    private ArrayList<Room> roomList;
    private LocalDateTime departDate;
    private LocalDateTime returnDate;
    private String departDate_String;
    private String returnDate_String;
    private String start_Destination;
    private String end_Destination;
    private int duration;

    public static void showCurrentCruiseRoomList() {
        for (Room room : CruiseServices.currentCruise.getRoomList()) {
            System.out.println(room.showRoomInfo());
        }
    }

    public ArrayList<Room> getRoomList() {
        return roomList;
    }

    @Override
    public String toString() {
        return "Cruise{" +
                "name='" + name + '\n' +
                ", title='" + title + '\n' + ", captainName='" + captainName + '\n' +
                ", departDate= " + departDate_String + '\n' +
                ", returnDate= " + returnDate_String + '\n' +
                ", start_Destination= " + start_Destination + '\n' +
                ", end_Destination= " + end_Destination + '\n' +
                ", duration= " + duration + '\n' +
                ", roomList=" + roomList + '\n' +
                '}';
    }
}
