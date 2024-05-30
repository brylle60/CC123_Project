package TIMESLOTS;

import java.time.LocalTime;

public class TimeSlots {
    private int id;
    private LocalTime startTime;
    private LocalTime endTime;
    private boolean isAvailable;

    // Getters and setters
    // ...

    // Constructor
    public TimeSlots(int id, LocalTime startTime, LocalTime endTime, boolean isAvailable) {
        this.id = id;
        this.startTime = startTime;
        this.endTime = endTime;
        this.isAvailable = isAvailable;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }
}
