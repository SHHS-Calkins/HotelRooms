import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.ArrayList;
public class thingie {
    public static void main(String[] args) {
        boolean exceptionChecker;
        int num = 0;
        Boolean oc = false;
        String name = "";
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
                exceptionChecker = false;
                        do {
                            try{
                            System.out.println("1: AddNumber(Number)\n2: AddNumber(Number, Occupied?, Name)");
                            num = scan.nextInt();
                            exceptionChecker = true;
                            } catch(InputMismatchException e) {
                                scan.next();
                                System.out.println("Not a number, Stupid.");
                            }
                        } while (!exceptionChecker);
                switch(num) {
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
                        break;
                    case 2:
                        exceptionChecker = false;
                        do {
                            try{
                            System.out.println("Number?");
                            num = scan.nextInt();
                            exceptionChecker = true;
                            } catch(InputMismatchException e) {
                                scan.next();
                                System.out.println("Not a number, Stupid.");
                            }
                        } while (!exceptionChecker);
                        exceptionChecker = false;
                        do {
                            try{
                            System.out.println("Number?");
                            oc = scan.nextBoolean();
                            exceptionChecker = true;
                            } catch(InputMismatchException e) {
                                scan.next();
                                System.out.println("Not a true/false, try again.");
                            }
                        } while (!exceptionChecker);
                        name = scan.nextLine();
                        info.addRoom(num, oc, name);
                        break;
                    default:
                        System.out.println("So, like, I said a 1 or a 2, and you put that.");
                        break;
                        
                }
            case "toString":
                System.out.println(info);
                break;
            case "RemoveRoom":
                exceptionChecker = false;
                        do {
                            try{
                            System.out.println("Number?");
                            num = scan.nextInt();
                            exceptionChecker = true;
                            } catch(InputMismatchException e) {
                                scan.next();
                                System.out.println("Room# to erase from Existence: ");
                            }
                        } while (!exceptionChecker);
                info.RemoveRoom(num);
                break;
            case "availableRoomNumbers":
                System.out.println(info.availableRoomNumbers());
                break;
            case "checkIn":
                System.out.println("Name: ");
                name = scan.nextLine();
                exceptionChecker = false;
                        do {
                            try{
                            System.out.println("Room#");
                            num = scan.nextInt();
                            exceptionChecker = true;
                            } catch(InputMismatchException e) {
                                scan.next();
                                System.out.println("Not a number, try again.");
                            }
                        } while (!exceptionChecker);
                info.checkIn(name, num);
        }
        scan.close();
    }
}
