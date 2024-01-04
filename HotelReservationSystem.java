import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

class Room {
    private int roomNumber;
    private String category;
    private boolean isAvailable;
    private double price;

    public Room(int roomNumber, String category, double price) {
        this.roomNumber = roomNumber;
        this.category = category;
        this.isAvailable = true;
        this.price = price;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public String getCategory() {
        return category;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public double getPrice() {
        return price;
    }
}

class Reservation {
    private static int nextReservationId = 1;

    private int reservationId;
    private Room room;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private String guestName;

    public Reservation(Room room, LocalDate checkInDate, LocalDate checkOutDate, String guestName) {
        this.reservationId = nextReservationId++;
        this.room = room;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.guestName = guestName;
    }

    public int getReservationId() {
        return reservationId;
    }

    public Room getRoom() {
        return room;
    }

    public LocalDate getCheckInDate() {
        return checkInDate;
    }

    public LocalDate getCheckOutDate() {
        return checkOutDate;
    }

    public String getGuestName() {
        return guestName;
    }
}

class Hotel {
    private List<Room> rooms;
    private List<Reservation> reservations;

    public Hotel() {
        rooms = new ArrayList<>();
        reservations = new ArrayList<>();
        rooms.add(new Room(101, "Standard", 100.0));
        rooms.add(new Room(102, "Deluxe", 150.0));
        rooms.add(new Room(103, "Suite", 200.0));
    }

    public List<Room> searchAvailableRooms(String category, LocalDate checkInDate, LocalDate checkOutDate) {
        List<Room> availableRooms = new ArrayList<>();
        for (Room room : rooms) {
            if (room.getCategory().equalsIgnoreCase(category) && room.isAvailable()) {
                availableRooms.add(room);
            }
        }
        return availableRooms;
    }

    public boolean makeReservation(Room room, LocalDate checkInDate, LocalDate checkOutDate, String guestName) {
        if (room.isAvailable()) {
            room.setAvailable(false);
            Reservation reservation = new Reservation(room, checkInDate, checkOutDate, guestName);
            reservations.add(reservation);
            return true;
        } else {
            System.out.println("Room not available for the specified dates.");
            return false;
        }
    }

    public Reservation viewBookingDetails(int reservationId) {
        for (Reservation reservation : reservations) {
            if (reservation.getReservationId() == reservationId) {
                return reservation;
            }
        }
        return null;
    }
}

class PaymentProcessing {
    public boolean processPayment(Reservation reservation) {
        System.out.println("Payment processed successfully for Reservation ID: " + reservation.getReservationId());
        return true;
    }
}

public class HotelReservationSystem {
    public static void main(String[] args) {
        Hotel hotel = new Hotel();
        List<Room> availableRooms = hotel.searchAvailableRooms("Standard", LocalDate.now(), LocalDate.now().plusDays(3));
        System.out.println("Available Standard Rooms: " + availableRooms);

        if (!availableRooms.isEmpty()) {
            Room selectedRoom = availableRooms.get(0);
            boolean reservationSuccess = hotel.makeReservation(selectedRoom, LocalDate.now(), LocalDate.now().plusDays(3), "John Doe");

            if (reservationSuccess) {
                Reservation reservation = hotel.viewBookingDetails(1);

                if (reservation != null) {
                    PaymentProcessing paymentProcessing = new PaymentProcessing();
                    paymentProcessing.processPayment(reservation);
                }
            }
        }
    }
}
