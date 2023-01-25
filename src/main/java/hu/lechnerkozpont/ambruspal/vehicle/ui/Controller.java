package hu.lechnerkozpont.ambruspal.vehicle.ui;

import hu.lechnerkozpont.ambruspal.vehicle.interactor.VehicleInteractor;
import org.json.JSONObject;

public class Controller {

    VehicleInteractor vehicleInteractor;

    public void setVehicleInteractor(VehicleInteractor vehicleInteractor) {
        this.vehicleInteractor = vehicleInteractor;
    }

    public void findVehicle(JSONObject jsonObject) {
        vehicleInteractor.findVehicleByRegistrationNumber(jsonObject.toString());
    }

    public void saveVehicle(JSONObject jsonObject) {
        vehicleInteractor.saveVehicle(jsonObject);
    }
}
