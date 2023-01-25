package hu.lechnerkozpont.ambruspal.vehicle.ui;

import hu.lechnerkozpont.ambruspal.vehicle.interactor.VehicleInteractor;
import hu.lechnerkozpont.ambruspal.vehicle.interactor.interfaces.VehicleRequestInterface;
import org.json.JSONObject;

public class Controller implements VehicleRequestInterface {

    VehicleInteractor vehicleInteractor;

    public void setVehicleInteractor(VehicleInteractor vehicleInteractor) {
        this.vehicleInteractor = vehicleInteractor;
    }

    @Override
    public void findVehicleByRegistrationNumber(JSONObject jsonObject) {
        vehicleInteractor.findVehicleByRegistrationNumber(jsonObject);
    }

    @Override
    public void saveVehicle(JSONObject jsonObject) {
        vehicleInteractor.saveVehicle(jsonObject);
    }
}
