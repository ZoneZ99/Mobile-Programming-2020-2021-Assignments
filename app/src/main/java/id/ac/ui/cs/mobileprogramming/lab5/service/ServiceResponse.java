package id.ac.ui.cs.mobileprogramming.lab5.service;

public class ServiceResponse {

    private boolean success;

    public ServiceResponse(boolean success) {
        this.success = success;
    }

    public boolean isSuccess() {
        return success;
    }
}
