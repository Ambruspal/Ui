package hu.lechnerkozpont.ambruspal.vehicle.ui;

import org.json.JSONObject;

import java.util.HashMap;
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

        if ("F".equals(input)) {
            JSONObject jsonObject = new JSONObject();

            try {
                System.out.print("Adja meg a rendszámot: ");
                input = inputScanner.next();
                jsonObject.put("registrationNumber", input);
            } catch (Exception e) {
                e.printStackTrace();
            }

            controller.findVehicle(jsonObject);
        }
    }

    private void createVehicle() {
        HashMap inputs = new HashMap();

        System.out.print("Az autó rendszáma: ");
        input = inputScanner.next();
        inputs.put(1, input);

        System.out.print("Az autó gyártmánya: ");
        input = inputScanner.next();
        inputs.put(2, input);

        System.out.print("Az autó modelje: ");
        input = inputScanner.next();
        inputs.put(3, input);

        System.out.print("Ülések száma: ");
        input = inputScanner.next();
        inputs.put(4, input);

        System.out.print("Az autó típusa: ");
        input = inputScanner.next();
        inputs.put(5, input);

        JSONObject jsonObject = new JSONObject();

        try {
            jsonObject.put("registrationNumber", inputs.get(1).toString());
            jsonObject.put("make", inputs.get(2).toString());
            jsonObject.put("model", inputs.get(3).toString());
            jsonObject.put("numberOfSeats", inputs.get(4).toString());
            jsonObject.put("vehicleType", inputs.get(5).toString());
        } catch (Exception e) {
            e.printStackTrace();
        }

        controller.saveVehicle(jsonObject);
    }

    public void displaySaveMessage(ViewModel viewModel) {
        String message = viewModel.getMessage();

        System.out.println("View: " + message);
    }

    public void displayVehicle(ViewModel viewModelVehicle) {
        System.out.println("Rendszám " + viewModelVehicle.getRegistrationNumber());
        System.out.println("Gyártmány " + viewModelVehicle.getMake());
        System.out.println("Modell " + viewModelVehicle.getModel());
        System.out.println("Ülések száma " + viewModelVehicle.getNumberOfSeats());
        System.out.println("Jármű típusa: " + viewModelVehicle.getVehicleType());
    }
}
