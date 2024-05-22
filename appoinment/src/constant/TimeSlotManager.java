package constant;

import java.io.*;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

public class TimeSlotManager {
    private static final int MAX_APPOINTMENTS_PER_SLOT = 1;
    public static final Map<LocalTime, Integer> timeSlots = new HashMap<>();

    private static final Map<LocalTime, Integer> bookedTimeSlots = new HashMap<>();


    static {
        // Initialize time slots
        for (int hour = 8; hour <= 11; hour++) {
            timeSlots.put(LocalTime.of(hour, 0), 0);
        }
        for (int hour = 13; hour <= 16; hour++) {
            timeSlots.put(LocalTime.of(hour, 0), 0);
        }
    }

    public static void removeTimeSlot(LocalTime time) {
        timeSlots.remove(time);
    }

    public static void addTimeSlot(LocalTime time) {
        if (!timeSlots.containsKey(time)) {
            timeSlots.put(time, 0);
        }
    }

        public static boolean isTimeSlotAvailable(LocalTime time) {
            if (!bookedTimeSlots.containsKey(time)) {
                return true; // Time slot is available
            }
            int currentAppointments = bookedTimeSlots.get(time);
            return currentAppointments < MAX_APPOINTMENTS_PER_SLOT;
        }
    public static boolean bookTimeSlot(LocalTime time) {
        if (!bookedTimeSlots.containsKey(time)) {
            bookedTimeSlots.put(time, 1);
        } else {
            int currentCount = bookedTimeSlots.get(time);
            if (currentCount >= MAX_APPOINTMENTS_PER_SLOT) {
                return false; // Time slot is already fully booked
            }
            bookedTimeSlots.put(time, currentCount + 1);
        }
        return true;
    }

    public static void cancelTimeSlot(LocalTime time) {
        if (bookedTimeSlots.containsKey(time)) {
            int currentCount = bookedTimeSlots.get(time);
            if (currentCount > 1) {
                bookedTimeSlots.put(time, currentCount - 1);
            } else {
                bookedTimeSlots.remove(time); // Remove the time slot from the map if the count becomes 0
            }
        }
    }
    public static void resetBookedTimeSlots() {
        bookedTimeSlots.clear();
    }



    public static void freeTimeSlot(LocalTime time) {
        TimeSlotManager.timeSlots.replace(time, bookedTimeSlots.get(time)); // Mark the time slot as available
    }

    public static void saveBookedTimeSlots() {
        try {
            FileOutputStream fileOut = new FileOutputStream("bookedTimeSlots.dat");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(bookedTimeSlots);
            out.close();
            fileOut.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void loadBookedTimeSlots() {
        try {
            FileInputStream fileIn = new FileInputStream("bookedTimeSlots.dat");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            bookedTimeSlots.clear();
            bookedTimeSlots.putAll((Map<LocalTime, Integer>) in.readObject());
            in.close();
            fileIn.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}