package hu.lechnerkozpont.ambruspal.vehicle.ui;

public class ViewModel {
    private String messageFromStorageAccessGateway;
    private String registrationNumber;
    private String make;
    private String model;
    private String numberOfSeats;
    private String vehicleType;

    public String getMessage() {
        return messageFromStorageAccessGateway;
    }

    public void setMessage(String message) {
        this.messageFromStorageAccessGateway = message;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(String numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }
}
