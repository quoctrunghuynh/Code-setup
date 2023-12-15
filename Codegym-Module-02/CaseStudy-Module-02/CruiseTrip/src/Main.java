import Entity.Menus;
import Services.CruiseServices;
import Services.CustomerServices;

public class Main {
    public static void main(String[] args) {
//        CruiseServices.getInstance().ExportCruiseList();
        CruiseServices.getInstance().updateCruiseList();
        Menus.showBasicMenu();
        CustomerServices.userSelect();
    }
}