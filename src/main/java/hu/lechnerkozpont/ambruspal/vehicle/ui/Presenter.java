package hu.lechnerkozpont.ambruspal.vehicle.ui;

import hu.lechnerkozpont.ambruspal.vehicle.interactor.VehicleInteractor;
import hu.lechnerkozpont.ambruspal.vehicle.interactor.interfaces.VehicleResponseInterface;
import org.json.JSONException;
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
    public void viewVehicleByRegistrationNumber(String stringVehicle) {
        ViewModel viewModelVehicle = new ViewModel();

        try {
            JSONObject jsonObjectVehicle = new JSONObject(stringVehicle);

            viewModelVehicle.setRegistrationNumber(jsonObjectVehicle.getString("registrationNumber"));
            viewModelVehicle.setMake(jsonObjectVehicle.getString("make"));
            viewModelVehicle.setModel(jsonObjectVehicle.getString("model"));
            viewModelVehicle.setNumberOfSeats(jsonObjectVehicle.getString("numberOfSeats"));
            viewModelVehicle.setVehicleType(jsonObjectVehicle.getString("vehicleType"));


        } catch (JSONException e) {
            throw new RuntimeException(e);
        }

        view.displayVehicle(viewModelVehicle);
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
