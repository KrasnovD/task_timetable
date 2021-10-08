package timetable.service;

public class ServiceException extends Exception {
    public ServiceException(String reason) {
        super(reason);
    }
}