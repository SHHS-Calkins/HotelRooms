import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.ArrayList;
public class thingie {
    public static void main(String[] args) {
        boolean exceptionChecker;
        Scanner scan = new Scanner(System.in);
        ArrayList<Room> thing = new ArrayList<Room>();
        thing.add(new Room(1, false, "me"));
        thing.add(new Room(2, false, "me"));
        thing.add(new Room(3, false, "me"));
        OccupancyInfo info = new OccupancyInfo(thing);
        info.addRoom(4);
        info.addRoom(5, true, "yes");
        info.addRoom(6, false, "PersonWhoShouldntBeThere");
        System.out.println(info);
        System.out.println("Hurry up and give a method: ");
        switch(scan.nextLine()) {
            case "addRoom":
                System.out.println("1: AddNumber(Number)\n2: AddNumber(Number, Occupied?, Name)");
                switch(scan.nextInt()) {
                    case 1: 
                        exceptionChecker = false;
                        do {
                            try{
                            System.out.println("Number?");
                            info.addRoom(scan.nextInt());
                            exceptionChecker = true;
                            } catch(InputMismatchException e) {
                                scan.next();
                                System.out.println("Not a number, Stupid.");
                            }
                        } while (!exceptionChecker);
                        
                        
                }
        }
        scan.close();
    }
}
