import java.util.ArrayList;

public class OccupancyInfo {
  private ArrayList<Room> rooms;
  // no two Room objects in rooms have the same room number

  /**
   * Attempts to check-in a new guest into a given room number. If a room exists
   * in
   * the database with the room number requested, and the room is unoccupied, a
   * guest
   * with the name given is checked-in to that room: the room is marked as
   * occupied,
   * and the guestName variable in the Room object is set to the name given.
   * 
   * @param name   the name of the guest attempting to check-in
   * @param number the room number into which the guest is to be checked-in
   * @return -1 if no room with the requested number exists;
   *         0 if the room requested is occupied;
   *         1 if the check-in is successful
   */
  public int checkIn(String name, int number) {
    for (Room r : rooms) {
      if (r.getNumber() == number && !r.isOccupied()) {
        r.checkInNewGuest(name);
        return 1;
      } else {
        if (r.getNumber() == number) {
          return 0;

        }
      }
    }
    return -1;
  }

  public ArrayList<Integer> availableRoomNumbers() {
    ArrayList<Integer> things = new ArrayList<Integer>();
    for (Room r : rooms) {
      if (!r.isOccupied()) {
        things.add(r.getNumber());
      }
    }
    return things;
  }

  public boolean addRoom(int number) {
        for (Room r : rooms) {
          if (r.getNumber() == number) {
            return false;
          }
        }
    rooms.add(new Room(number, false, "Nobody"));
    return true;
  }

  public boolean addRoom(int number, boolean occupancy, String name) {
    for (Room r : rooms) {
      if (r.getNumber() == number) {
        return false;
      }
    }
    rooms.add(new Room(number, occupancy, name));
    return true;
  }

  public boolean RemoveRoom(int number) {
    for (Room r : rooms) {
      if (r.getNumber() == number) {
        rooms.remove(r);
        return true;
      }
    }
    return false;
  }

  /* Methods for subsequent parts of this question are not shown */

  /* CLASS MEMBERS FOR TESTING */
  /* DO NOT MODIFY ANY OF THE CONSTRUCTORS OR METHODS BELOW */

  public OccupancyInfo(ArrayList<Room> r) {
    rooms = r;
  }

  public ArrayList<Room> getRooms() {
    return rooms;
  }

  public String toString() {
    String thing = "";
    for (Room r : rooms) {
      thing += r + "\n";
    }
    return thing;
  }

}
