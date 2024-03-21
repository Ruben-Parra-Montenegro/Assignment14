import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

public class SceneController {

    @FXML
    private Button convert;

    @SuppressWarnings("rawtypes")
    @FXML
    private ChoiceBox Units1;

    @SuppressWarnings("rawtypes")
    @FXML
    private ChoiceBox Units2;

    @FXML
    private TextField convertfrom;

    @FXML
    private TextField result;

    ObservableList<String> Units = FXCollections.observableArrayList("km", "mi", "lbs", "kg", "in", "m", "f", "c");

    @SuppressWarnings("unchecked")
    @FXML
    public void initialize() {
        Units1.setValue("Please pick Units");
        Units1.setItems(Units);
        Units2.setValue("Please pick Units");
        Units2.setItems(Units);

    }

    @FXML
    public void convert(ActionEvent event) {
        // Get the selected units and the value to convert from the UI elements.
        String previousUnit = (String) Units1.getValue();
        String convertto = (String) Units2.getValue();
        double unitlessNum = Double.parseDouble(convertfrom.getText());

        double convertedValue = 0.0;
        if ("mi".equals(previousUnit) && "km".equals(convertto)) {
            convertedValue = unitlessNum * 1.60934;
        } else if ("lbs".equals(previousUnit) && "kg".equals(convertto)) {
            convertedValue = unitlessNum * 0.453592;
        } else if ("in".equals(previousUnit) && "m".equals(convertto)) {
            convertedValue = unitlessNum * 0.0254;
        } else if ("f".equals(previousUnit) && "c".equals(convertto)) {
            convertedValue = (unitlessNum - 32) * 5 / 9;
        } else if ("km".equals(previousUnit) && "mi".equals(convertto)) {
            convertedValue = unitlessNum * .621371;
        } else if ("kg".equals(previousUnit) && "lbs".equals(convertto)) {
            convertedValue = unitlessNum * 2.20462;
        } else if ("m".equals(previousUnit) && "in".equals(convertto)) {
            convertedValue = unitlessNum * 39.3701;
        } else if ("c".equals(previousUnit) && "f".equals(convertto)) {
            convertedValue = (unitlessNum * 9 / 5) + 32;
        }

        // Display the converted value in the UI.
        result.setText(Double.toString(convertedValue));

        System.out.println("Converted value: " + convertedValue);
    }

}
