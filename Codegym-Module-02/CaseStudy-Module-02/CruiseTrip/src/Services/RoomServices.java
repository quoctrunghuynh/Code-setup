package Services;

import Entity.Cruise.Cruise;
import Entity.Cruise.Room;
import com.opencsv.*;
import com.opencsv.exceptions.CsvException;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static java.lang.Double.parseDouble;

public class RoomServices {
    private static final RoomServices instance = new RoomServices();
    public static Room currentRoom;
    static ArrayList<Room> roomList;

    public static RoomServices getInstance() {
        return instance;
    }

    //    public static void sortRoomByPrice() {
////        List<Room> rooms = CruiseServices.currentCruise.getRoomList();
//        Comparator<Room> roomComparator =Comparator.comparingDouble(Room::getRoomPrice).reversed();
////        Collections.sort(rooms,roomComparator);
////        for (Room room:rooms){
////            System.out.println(room.showRoomInfo());
////        }
//        CruiseServices.currentCruise.getRoomList().sort(Comparator.comparingDouble(Room::getRoomPrice));
//        for (Room room:CruiseServices.currentCruise.getRoomList()){
//            System.out.println(room.showRoomInfo());
//        }
//    }
    protected static void updateDateRoomPrice() {
        ArrayList<Room> sortedRoomList = new ArrayList<>();
        for (Room room : CruiseServices.currentCruise.getRoomList()) {
            room.setRoomPrice();
            sortedRoomList.add(room);
        }
        sortedRoomList.sort(Comparator.comparingDouble(Room::getRoomPrice));
        for (Room room : sortedRoomList) {
            System.out.println(room.showRoomInfo());
        }
    }

    public static String getRoomPrice_String(String room_Id, String room_Type, String room_Location) {
        String level = room_Id.substring(0, 2);
        double typeMultiplier = 0;
        double roomMultiplier = 0;
        switch (room_Type) {
            case "Junior" -> typeMultiplier = 1.2;
            case "Senior" -> typeMultiplier = 1.4;
            case "Executive" -> typeMultiplier = 1.6;
            case "President" -> typeMultiplier = 1.8;
        }
        switch (room_Location) {
            case "Front" -> roomMultiplier = 1.9;
            case "Middle" -> roomMultiplier = 1.6;
            case "Back" -> roomMultiplier = 1.4;
        }
        double levelMultiplier = parseDouble(level) * 1.1;
        double basePrice = 700000;
        double value = (basePrice * CruiseServices.currentCruise.getDuration()) * (levelMultiplier + typeMultiplier + roomMultiplier);
        DecimalFormat formatter = new DecimalFormat("#,###");
        return formatter.format(value);
    }

    public static double getRoomPrice(String room_Id, String room_Type, String room_Location) {
        String level = room_Id.substring(0, 2);
        double typeMultiplier = 0;
        double roomMultiplier = 0;
        switch (room_Type) {
            case "Junior" -> typeMultiplier = 1.2;
            case "Senior" -> typeMultiplier = 1.4;
            case "Executive" -> typeMultiplier = 1.6;
            case "President" -> typeMultiplier = 1.8;
        }
        switch (room_Location) {
            case "Front" -> roomMultiplier = 1.9;
            case "Middle" -> roomMultiplier = 1.6;
            case "Back" -> roomMultiplier = 1.4;
        }
        double levelMultiplier = parseDouble(level) * 1.1;
        double basePrice = 700000;
        double value = (basePrice * CruiseServices.currentCruise.getDuration()) * (levelMultiplier + typeMultiplier + roomMultiplier);
        return value;
    }

    public ArrayList<Room> CreateRoomList(int numberOfRoom, int cruiseLevels) {
        roomList = new ArrayList<>();
        for (int currentLevel = 1; currentLevel <= cruiseLevels; currentLevel++) {
            for (int currentRoom = 1; currentRoom <= numberOfRoom; currentRoom++) {
                Room room = Room.builder()
                        .room_Id(String.format("%02d%02d", currentLevel, currentRoom))
                        .room_Type(room_Type_Allotment(currentLevel, cruiseLevels))
                        .room_Location(room_Location_Allotment(currentRoom, numberOfRoom))
                        .available(true)
                        .build();
                roomList.add(room);
            }
            numberOfRoom -= 1; //Trừ hao do diện tích phòng ở các tầng chênh lệch nhau
        }
        return roomList;
    }

    public String room_Type_Allotment(int currentLevel, int cruiseLevel) {
        double percentage_Of_Junior = 0.4;
        double percentage_Of_Senior = 0.3;
        double percentage_Of_Executive = 0.2;
        double percentage_Of_President = 0.1;
        double magic_Number = 0.01D;

        double number_Of_Junior = (percentage_Of_Junior * cruiseLevel);
        double number_Of_Senior = (percentage_Of_Senior * cruiseLevel) + number_Of_Junior;
        double number_Of_Executive = (percentage_Of_Executive * cruiseLevel) + number_Of_Senior;
        double number_Of_President = (percentage_Of_President * cruiseLevel) + number_Of_Executive + magic_Number;

        if ((number_Of_Junior >= 0) && (currentLevel <= number_Of_Junior)) {
            return "Junior";
        } else if ((currentLevel >= number_Of_Junior) && currentLevel <= number_Of_Senior) {
            return "Senior";
        } else if ((currentLevel >= number_Of_Senior) && currentLevel <= number_Of_Executive) {
            return "Executive";
        } else if ((currentLevel >= number_Of_Executive) && currentLevel <= number_Of_President) {
            return "President";
        }
        return "null";
    }

    public String room_Location_Allotment(int currentRoom, int totalRoomOnLevel) {
        int percentage_Of_Front = 20;
        int percentage_Of_Middle = 30;
        int percentage_Of_Back = 50;
        double magic_Number = 0.01D;

        double number_Of_Front_Rooms = (double) (percentage_Of_Front * totalRoomOnLevel) / 100;
        double number_Of_Middle_Rooms = (double) (percentage_Of_Middle * totalRoomOnLevel) / 100 + number_Of_Front_Rooms;
        double number_Of_Back_Rooms = (double) (percentage_Of_Back * totalRoomOnLevel) / 100 + number_Of_Middle_Rooms + magic_Number;

        if ((currentRoom >= 0) && (currentRoom <= number_Of_Front_Rooms)) {
            return "Front";
        } else if ((currentRoom >= number_Of_Front_Rooms) && currentRoom <= number_Of_Middle_Rooms) {
            return "Middle";
        } else if ((currentRoom >= number_Of_Middle_Rooms) && currentRoom <= number_Of_Back_Rooms) {
            return "Back";
        }
        return "null";
    }

    public void setAvailableOnList(int index, String room_ID) {
        for (Room room : CruiseServices.cruiseList.get(index).getRoomList()) {
            if (room.getRoom_Id().equals(room_ID)) {
                if (room.isAvailable()) {
                    room.setAvailable(false);
                } else {
                    System.out.println("This room has been ordered by other customer...");
                    return;
                }
            }
        }
    }

    public void updateRoomListOnCSV(int shipId) {
        Cruise cruise = CruiseServices.cruiseList.get(shipId);
        int numberInCSVFile = shipId + 1;
        try {
            File inputFile = new File("CruiseList.csv");
            CSVParser parser = new CSVParserBuilder().withSeparator(',').build();
            CSVReader reader = new CSVReaderBuilder(new FileReader(inputFile)).withCSVParser(parser).build();
            List<String[]> cruiseInfo = reader.readAll();
            cruiseInfo.get(numberInCSVFile)[7] = cruise.getRoomList().toString();
            CSVWriter writer = new CSVWriter(new FileWriter(inputFile));
            writer.writeAll(cruiseInfo);
            writer.flush();
        } catch (IOException ioe) {
            System.out.println("Cant find the source");
        } catch (CsvException e) {
            throw new RuntimeException(e);
        }
    }

    public void showRoomListByType(String type) {
        for (Room room : CruiseServices.currentCruise.getRoomList()) {
            if (room.getRoom_Type().contains(type)) {
                System.out.println(room.showRoomInfo());
            }
        }
    }
}