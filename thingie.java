import java.util.Scanner;
public class thingie {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        OccupancyInfo info = new OccupancyInfo(null);
        info.addRoom(1);
        info.addRoom(2, true, "yes");
        info.addRoom(3, false, "PersonWhoShouldntBeThere");
        System.out.println(info);
        System.out.println("Hurry up and give a method: ");
        switch(scan.nextLine()) {
            case "":
        }
    }
}
