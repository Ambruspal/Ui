package hu.lechnerkozpont.ambruspal.vehicle.ui;

import hu.lechnerkozpont.ambruspal.vehicle.exception.InvalidJsonException;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Scanner;

public class View {
    Presenter presenter;
    Controller controller;
    Scanner inputScanner = new Scanner(System.in);
    String input;

    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }

    public void run() {
        System.out.print("Milyen műveletet szeretnél végezni? (C/F): ");
        input = inputScanner.next();

        if ("C".equals(input)) createVehicle();
        if ("F".equals(input)) controller.findVehicleByRegistrationNumber("333");
    }

    private void createVehicle() {
        try {
            JSONObject jsonVehicle = new JSONObject();

            System.out.print("Az autó rendszáma: ");
            input = inputScanner.next();
            jsonVehicle.put("registrationNumber", input);

            System.out.print("Az autó gyártmánya: ");
            input = inputScanner.next();
            jsonVehicle.put("make", input);

            System.out.print("Az autó modelje: ");
            input = inputScanner.next();
            jsonVehicle.put("model", input);

            System.out.print("Ülések száma: ");
            input = inputScanner.next();
            jsonVehicle.put("numberOfSeats", input);

            System.out.print("Az autó típusa: ");
            input = inputScanner.next();
            jsonVehicle.put("vehicleType", input);

            controller.saveVehicle(jsonVehicle.toString());
        } catch (JSONException exc) {
            throw new InvalidJsonException();
        }
    }
}
