package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import validation.FieldValidationException;

public class MainPanelController implements Initializable {

	@FXML
	private ChoiceBox<String> typeChoiceBox;
	@FXML
	private TextField textFieldX;
	@FXML
	private TextField textFieldY;
	@FXML
	private TextArea outputTextArea;
	@FXML
	private Button calculateButton;
	@FXML
	Button roundButtonX;
	@FXML
	Button roundButtonY;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		typeChoiceBox.getItems().add("Substraction");
		typeChoiceBox.getItems().add("Addition");
		typeChoiceBox.getItems().add("Division");
		typeChoiceBox.getItems().add("Multiplication");
	}

	@FXML
	public void calculateOnButtonClick(ActionEvent event) {
		try {
			validate();
			double result = calculate();
			outputTextArea.setText(result + "");
		} catch (FieldValidationException e) {
			outputTextArea.setText("Empty");
		} catch (NumberFormatException e) {
			outputTextArea.setText("Invaild");
		}

	}

	private void validate() throws FieldValidationException {
		if (textFieldX.getText().isBlank()) {
			throw new FieldValidationException("Field X cannot be empty");
		}
		if (textFieldY.getText().isBlank()) {
			throw new FieldValidationException("Field Y cannot be empty");
		}
		if (typeChoiceBox.getValue() == null) {
			throw new FieldValidationException("You need to choose operation");
		}
	}

	private double calculate() throws FieldValidationException {
		double X = Double.parseDouble(textFieldX.getText());
		double Y = Double.parseDouble(textFieldY.getText());
		switch (typeChoiceBox.getValue().toString()) {
		case "Addition":
			return X + Y;
		case "Substraction":
			return X - Y;
		case "Multiplication":
			return X * Y;
		case "Division":
			return X / Y;
		default:
			throw new FieldValidationException("Something went wrong");

		}
	}
}
