package hu.lechnerkozpont.ambruspal.vehicle.ui;

import hu.lechnerkozpont.ambruspal.vehicle.interactor.VehicleInteractor;
import hu.lechnerkozpont.ambruspal.vehicle.interactor.interfaces.VehicleResponseInterface;
import org.json.JSONObject;

public class Presenter implements VehicleResponseInterface {

    VehicleInteractor vehicleInteractor;

    View view;

    public void setVehicleInteractor(VehicleInteractor vehicleInteractor) {
        this.vehicleInteractor = vehicleInteractor;
    }

    public void setView(View view) {
        this.view = view;
    }

    @Override
    public void viewVehicleByRegistrationNumber(String json) {
//        System.out.println();
    }

    @Override
    public void displaySave(JSONObject jsonObject) {
        ViewModel viewModel = new ViewModel();

        try {
            if (jsonObject.has("message") == true) {
                String successMessage = this.jsonObjectParser(jsonObject, "message");

                viewModel.setMessage(successMessage);
            }
        } catch (Exception exc) {
            exc.printStackTrace();
        }

        try {
            if (jsonObject.has("error") == true) {
                String errorMessage = this.jsonObjectParser(jsonObject, "error");

                viewModel.setMessage(errorMessage);
            }
        } catch (Exception exc) {
            exc.printStackTrace();
        }

        view.displaySaveMessage(viewModel);
    }

    private String jsonObjectParser(JSONObject jsonObject, String keyOfMessage) {
        String message = null;

        try {
            message = jsonObject.getString(keyOfMessage);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return message;
    }
}
