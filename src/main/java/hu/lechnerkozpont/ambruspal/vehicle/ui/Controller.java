package hu.lechnerkozpont.ambruspal.vehicle.ui;

import hu.lechnerkozpont.ambruspal.vehicle.interactor.VehicleInteractor;
import hu.lechnerkozpont.ambruspal.vehicle.interactor.entity.Vehicle;
import hu.lechnerkozpont.ambruspal.vehicle.interactor.interfaces.VehicleRequestInterface;

public class Controller implements VehicleRequestInterface {

    VehicleInteractor vehicleInteractor;

    public VehicleInteractor getVehicleInteractor() {
        return vehicleInteractor;
    }

    public void setVehicleInteractor(VehicleInteractor vehicleInteractor) {
        this.vehicleInteractor = vehicleInteractor;
    }

    @Override
    public void findVehicleByRegistrationNumber(String id) {
        vehicleInteractor.findVehicleByRegistrationNumber(id);
    }

    @Override
    public void saveVehicle(String json) {
        vehicleInteractor.saveVehicle(json);
    }
}
