package Services;

import Entity.Cruise.Cruise;
import Entity.Cruise.Room;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class CruiseServices {
    private static final CruiseServices instance = new CruiseServices();
    public static Cruise currentCruise;
    static ArrayList<Cruise> cruiseList;
    FileReader fr;
    BufferedReader br;
    Random random = new Random();
    LocalDateTime departDate;
    String formattedDepartDate;
    List<String> captainNameList;
    ArrayList<String> titleList;
    ArrayList<String> destinationList;
    ArrayList<Cruise> searchedCruiseList;
    String cruiseList_URL = "CruiseList.csv";
    String captainNameList_URL = "DataScrap/Captain.txt";
    String cruiseName_URL = "DataScrap/Name.txt";
    String cruiseTitle_URL = "DataScrap/Titles.txt";
    String cruiseDestination = "DataScrap/Destination.txt";
    Scanner scannerString = new Scanner(System.in);
    int randomDuration;

    private CruiseServices() {
    }

    public static CruiseServices getInstance() {
        return instance;
    }

    public String createCruiseName() {
        final int NameListLength = 334;
        final int origin = 1;
        try {
            fr = new FileReader(cruiseName_URL);
            br = new BufferedReader(fr);
            String name;
            int randomName = random.nextInt(origin, NameListLength);
            int begin = 0;
            while ((name = br.readLine()) != null) {
                begin++;
                if (begin == randomName) {
                    return name;
                }
            }
        } catch (IOException ioe) {
            System.out.println("The name file not exist");
        }
        return "Null";
    }

    public String createCruiseTitle() {
        titleList = new ArrayList<>();
        try {

            fr = new FileReader(cruiseTitle_URL);
            br = new BufferedReader(fr);

            String title;
            while ((title = br.readLine()) != null) {
                titleList.add(title);
            }
            int randomTitle = random.nextInt(0, titleList.size());
            return titleList.get(randomTitle);
        } catch (IOException ioe) {
            System.out.println("The name file not exist");
        }
        return "NULL";
    }

    public LocalDateTime createCruiseDepartDate() {
        int currentMonth = LocalDateTime.now().getMonthValue();
        int currentDay = LocalDateTime.now().getDayOfMonth();

        int randomMonth = random.nextInt(currentMonth, 12);
        int randomDaysOfMonth = random.nextInt(currentDay, 30);
        int randomHour = random.nextInt(0, 24);
        int randomMinute = random.nextInt(0, 60);

        LocalDateTime departDate = LocalDateTime.of(2023, randomMonth, randomDaysOfMonth, randomHour, randomMinute);
        formattedDepartDate = departDate.format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm"));
        return departDate;
    }

    public LocalDateTime createCruiseReturnDate() {
        if (formattedDepartDate != null) {
            LocalDateTime ArrivalDate = LocalDateTime.parse(formattedDepartDate, DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm"));
            randomDuration = random.nextInt(1, 14);
            return ArrivalDate.plusDays(randomDuration);
        } else {
            System.out.println("Cannot create ReturnDate");
        }
        return null;
    }

    public ArrayList<Cruise> createRandomCruiseList(int quantity) {
        RoomServices roomServices = new RoomServices();
        cruiseList = new ArrayList<>();
        for (int i = 0; i < quantity; i++) {
            int randomRoom = random.nextInt(7, 20);
            int randomLevel = random.nextInt(5, 15);
            Cruise cruise = Cruise.builder()
                    .name(createCruiseName())
                    .title(createCruiseTitle())
                    .captainName(getCaptain())
                    .roomList(roomServices.CreateRoomList(randomRoom, randomLevel))
                    .departDate(createCruiseDepartDate())
                    .returnDate(createCruiseReturnDate())
                    .duration(randomDuration)
                    .start_Destination(getStart_Destination())
                    .end_Destination(getEnd_Destination())
                    .build();
            cruiseList.add(cruise);
        }
        return cruiseList;
    }

    public String getStart_Destination() {
        final int TEXT_STRING_lINE = 20;
        try {
            fr = new FileReader(cruiseDestination);
            br = new BufferedReader(fr);
            int randomDestination = random.nextInt(1, TEXT_STRING_lINE);
            int begin = 0;
            String startDestination;
            while ((startDestination = br.readLine()) != null) {
                begin++;
                if (begin == randomDestination) {
                    return startDestination;
                }
            }
        } catch (IOException e) {
            System.err.println("Ối giồi ôi");
        }
        return "Hâu ly sịt";
    }

    public String getEnd_Destination() {
        try {
            fr = new FileReader(cruiseDestination);
            br = new BufferedReader(fr);
            int randomDestination = random.nextInt(2, 20);
            int begin = 0;
            String returnDestination;
            while ((returnDestination = br.readLine()) != null) {
                begin++;
                if (begin == randomDestination) {
                    return returnDestination;
                }
            }
        } catch (IOException e) {
            System.err.println("Ối giồi ôi");
        }
        return "Hâu ly sịt";
    }

    public String getCaptain() {

        final int nameListLength = 14;
        int randomeName = random.nextInt(nameListLength);
        try {
            if (captainNameList == null) {
                captainNameList = new ArrayList<>();
                fr = new FileReader(captainNameList_URL);
                br = new BufferedReader(fr);
                String name;
                while ((name = br.readLine()) != null) {
                    captainNameList.add(name);
                }
                return captainNameList.get(randomeName);
            }
        } catch (IOException e) {
            System.out.println("Something wrong at getCaptainName! ");
        }
        return captainNameList.get(randomeName);
    }

    public void ExportCruiseList() {

        int quantity = random.nextInt(40, 90);
        try {
            CSVWriter writer = new CSVWriter(new FileWriter(cruiseList_URL));

            cruiseList = createRandomCruiseList(quantity);
            String[] header = {"Name", "Captain", "Depart Date", "Return Date", "Duration", "Start Destination", "End Destination", "Room List"};
            writer.writeNext(header);
            for (Cruise cruise : cruiseList) {
                String[] row = {
                        cruise.getName() + " " + cruise.getTitle()
                        , cruise.getCaptainName()
                        , cruise.getDepartDate().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm"))
                        , cruise.getReturnDate().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm"))
                        , String.valueOf(cruise.getDuration())
                        , cruise.getStart_Destination()
                        , cruise.getEnd_Destination()
                        , cruise.getRoomList().toString()
                };
                writer.writeNext(row);
            }
            writer.close();
            System.out.println("Created Cruise List success");
        } catch (IOException e) {
            System.err.println("ExportCruiseList got a problem");
        }
    }

    public void updateCruiseList() {
        CSVReader reader;
        cruiseList = new ArrayList<>();
        ArrayList<Room> roomList;
        try {
            reader = new CSVReader(new FileReader("CruiseList.csv"));
            String[] columm;
            String[] headerSkipper = reader.readNext(); // this line using to skip the header
            while ((columm = reader.readNext()) != null) {
                String[] roomInfo = columm[7].split(",");
                roomList = new ArrayList<>();
                for (String e : roomInfo) {
                    String[] roomSplit = e.split(":");
                    Room room = Room.builder()
                            .room_Id(roomSplit[1])
                            .room_Type(roomSplit[2])
                            .room_Location(roomSplit[3])
                            .available(Boolean.parseBoolean(roomSplit[5].replace("\n", "").replace("]", "")))
                            .build();
                    roomList.add(room);
                }

                Cruise cruise = Cruise.builder()
                        .name(columm[0])
                        .captainName(columm[1])
                        .departDate_String(columm[2])
                        .returnDate_String(columm[3])
                        .duration(Integer.parseInt(columm[4]))
                        .start_Destination(columm[5])
                        .end_Destination(columm[6])
                        .roomList(roomList)
                        .build();
                cruiseList.add(cruise);
            }
        } catch (CsvValidationException | IOException e) {
            System.err.println("Can not find file");
        }
    }

    public void showCruiseList() {
        int id = 1;
        for (Cruise cruise : cruiseList) {
            System.out.printf("%-5s %-35s %-30s \n%-40s %-40s \n%-30s %-40s \n \n", //%-30s add vào sau \n để in ra roomL
                    "ID: " + id
                    , "Name: " + cruise.getName()
                    , "Captain: " + cruise.getCaptainName()
                    , "Depart Date: " + cruise.getDepartDate_String()
                    , "Return date: " + cruise.getReturnDate_String()
                    , "From: " + cruise.getStart_Destination()
                    , "To: " + cruise.getEnd_Destination()
            );
            id++;
        }
    }

    public void showDestination() { //not done to use
        int id = 1;
        if (destinationList == null) {
            destinationList = new ArrayList<>();
            try {
                BufferedReader reader = new BufferedReader(new FileReader("DataScrap/Destination.txt"));
                String line;
                while ((line = reader.readLine()) != null) {
                    destinationList.add(line);
                }
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        for (String line : destinationList) {
            System.out.println(id + ": " + line);
            id++;
        }
    }

    public void searchTripByName() {
        System.err.println("Enter the destination's name you want to find");
        searchedCruiseList = new ArrayList<>();
        String name = scannerString.nextLine();
        ArrayList<Cruise> cruiseArrayList;
        cruiseArrayList = cruiseList;
        int number = 0;
        for (Cruise cruise : CruiseServices.cruiseList) {
            if (cruise.toString().contains(name)) {
                searchedCruiseList.add(cruise);
                number++;
            }
        }
        System.out.println("Found: " + number + " matches");
        cruiseArrayList.retainAll(searchedCruiseList);
        for (Cruise cruise : cruiseArrayList) {
            System.out.printf("""
                            Cruise name: %s
                            Captain: %s
                            DepartDate: %s
                            ReturnDate: %s
                            Start From: %s
                                  To  : %s
                            Duration  : %s days \n \n""",
                    cruise.getName(),
                    cruise.getCaptainName(),
                    cruise.getDepartDate_String(),
                    cruise.getReturnDate_String(),
                    cruise.getStart_Destination(),
                    cruise.getEnd_Destination(),
                    cruise.getDuration());
        }

    }
}