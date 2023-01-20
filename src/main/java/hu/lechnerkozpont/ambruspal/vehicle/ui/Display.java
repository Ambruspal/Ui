package hu.lechnerkozpont.ambruspal.vehicle.ui;


import hu.lechnerkozpont.ambruspal.vehicle.interactor.Vehicle;
import hu.lechnerkozpont.ambruspal.vehicle.interactor.VehicleDisplayInterface;

public class Display implements VehicleDisplayInterface {

    @Override
    public void view(Vehicle vehicle) {
        System.out.println(vehicle.getModel());
    }
}