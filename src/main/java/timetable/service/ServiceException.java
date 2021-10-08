package timetable.service;

public class ServiceException extends Exception {
    public ServiceException(Throwable reason) {
        super(reason);
    }
}