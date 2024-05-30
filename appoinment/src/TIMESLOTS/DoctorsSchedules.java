package TIMESLOTS;

import db.timeslotManager;

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
        timeslotManager.registerTimeSlot(doctorId, date, startTime, endTime);
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
                timeslotManager.updateTimeSlotAvailability(timeSlot.getId(), false);
                break;
            }
        }
    }

    public void cancelAppointment(LocalTime time) {
        for (TimeSlots timeSlot : timeSlots) {
            if (timeSlot.getStartTime().equals(time)) {
                timeSlot.setAvailable(true);
                timeslotManager.updateTimeSlotAvailability(timeSlot.getId(), true);
                break;
            }
        }
    }

    // Load time slots from the database using the timeslotManager
    public void loadTimeSlots() {
        timeSlots.clear(); // Clear the existing time slots
        List<TimeSlots> availableSlots = timeslotManager.getAvailableTimeSlotsForDoctorAndDate(doctorId, date);
        timeSlots.addAll(availableSlots);
    }
}