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

        if (this.isNotNull(stringVehicle)) {
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
        } else {

        }
    }

    @Override
    public void displaySave(String json) {
        if (this.isNotNull(json)) {
            ViewModel viewModel = new ViewModel();
            JSONObject jsonObjectResponse = null;
            String message = null;

            try {
                jsonObjectResponse = new JSONObject(json);
            } catch (JSONException e) {
                e.printStackTrace();
            }

            try {
                if (jsonObjectResponse.has("message") == true) {
                    message = jsonObjectResponse.getString("message");
                }
            } catch (Exception exc) {
                exc.printStackTrace();
            }

            viewModel.setMessage(message);
            view.displaySaveMessage(viewModel);
        }
    }

    private Boolean isNotNull(String response) {
        return response != null;
    }
}
