package TIMESLOTS;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class DoctorsSchedules {
    private int doctorId;
    private LocalDate date;
    private List<TimeSlots> timeSlots;

    public DoctorsSchedules(int doctorId, LocalDate date) {
        this.doctorId = doctorId;
        this.date = date;
        this.timeSlots = new ArrayList<>();
    }

    public void addTimeSlot(LocalTime startTime, LocalTime endTime) {
        TimeSlots timeSlot = new TimeSlots(0, startTime, endTime, true);
        timeSlots.add(timeSlot);
        // Call the timeRegister method from timeslotManager to save the time slot in the database
    }

    public List<TimeSlots> getAvailableTimeSlots() {
        List<TimeSlots> availableSlots = new ArrayList<>();
        for (TimeSlots timeSlot : timeSlots) {
            if (timeSlot.isAvailable()) {
                availableSlots.add(timeSlot);
            }
        }
        return availableSlots;
    }

    public void bookAppointment(LocalTime time) {
        for (TimeSlots timeSlot : timeSlots) {
            if (timeSlot.getStartTime().equals(time)) {
                timeSlot.setAvailable(false);
                // Call the updateTimeSlot method from timeslotManager to update the time slot in the database
                break;
            }
        }
    }

    public void cancelAppointment(LocalTime time) {
        for (TimeSlots timeSlot : timeSlots) {
            if (timeSlot.getStartTime().equals(time)) {
                timeSlot.setAvailable(true);
                // Call the updateTimeSlot method from timeslotManager to update the time slot in the database
                break;
            }
        }
    }

    // Load time slots from the database using the timeslotManager
    public void loadTimeSlots() {
        // Implement database logic to load time slots for the specific doctor and date
        // Call the timeRegister method from timeslotManager to save the loaded time slots
    }
}