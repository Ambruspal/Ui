package hu.lechnerkozpont.ambruspal.vehicle.ui;

import hu.lechnerkozpont.ambruspal.vehicle.interactor.VehicleInteractor;
import hu.lechnerkozpont.ambruspal.vehicle.interactor.interfaces.VehicleResponseInterface;

public class Presenter implements VehicleResponseInterface {

    VehicleInteractor vehicleInteractor;

    public void setVehicleInteractor(VehicleInteractor vehicleInteractor) {
        this.vehicleInteractor = vehicleInteractor;
    }

    @Override
    public void viewVehicleByRegistrationNumber(String json) {

    }

    @Override
    public void displaySuccessfullSave(String responseSuccessfull) {
        System.out.println(responseSuccessfull);
    }

    @Override
    public void displayError(String responseError) {
        System.out.println(responseError);
    }
}
