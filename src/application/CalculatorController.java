package application;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class CalculatorController {

	@FXML
	private Button number1Button;

	@FXML
	private Button number2Button;

	@FXML
	private Button number3Button;

	@FXML
	private Button number4Button;

	@FXML
	private Button number5Button;

	@FXML
	private Button number6Button;

	@FXML
	private Button number7Button;

	@FXML
	private Button number8Button;

	@FXML
	private Button number9Button;

	@FXML
	private Button number0Button;

	@FXML
	private Button dotButton;

	@FXML
	private Button substractionButton;

	@FXML
	private Button additionButton;

	@FXML
	private Button divisionButton;

	@FXML
	private Button multiplicationButton;

	@FXML
	private TextArea outputTextField;

	@FXML
	private TextArea historyTextArea;

	private List<String> calculations = new ArrayList<String>();

	@FXML
	Button clearButton;

	@FXML
	Button clearHistoryButton;

	public void onCalculatorButtonClick(ActionEvent event) {

		if (outputTextField.getText().startsWith("0")) {
			if (event.getSource().equals(number0Button)) {
				outputTextField.setText("0");
			} else if (event.getSource().equals(number1Button)) {
				outputTextField.setText("1");
			} else if (event.getSource().equals(number2Button)) {
				outputTextField.setText("2");
			} else if (event.getSource().equals(number3Button)) {
				outputTextField.setText("3");
			} else if (event.getSource().equals(number4Button)) {
				outputTextField.setText("4");
			} else if (event.getSource().equals(number5Button)) {
				outputTextField.setText("5");
			} else if (event.getSource().equals(number6Button)) {
				outputTextField.setText("6");
			} else if (event.getSource().equals(number7Button)) {
				outputTextField.setText("7");
			} else if (event.getSource().equals(number8Button)) {
				outputTextField.setText("8");
			} else if (event.getSource().equals(number9Button)) {
				outputTextField.setText("9");
			} else if (event.getSource().equals(dotButton)) {
				outputTextField.setText("0.");
			}
		} else {
			if (event.getSource().equals(number0Button)) {
				outputTextField.setText(outputTextField.getText() + "0");
			} else if (event.getSource().equals(number1Button)) {
				outputTextField.setText(outputTextField.getText() + "1");
			} else if (event.getSource().equals(number2Button)) {
				outputTextField.setText(outputTextField.getText() + "2");
			} else if (event.getSource().equals(number3Button)) {
				outputTextField.setText(outputTextField.getText() + "3");
			} else if (event.getSource().equals(number4Button)) {
				outputTextField.setText(outputTextField.getText() + "4");
			} else if (event.getSource().equals(number5Button)) {
				outputTextField.setText(outputTextField.getText() + "5");
			} else if (event.getSource().equals(number6Button)) {
				outputTextField.setText(outputTextField.getText() + "6");
			} else if (event.getSource().equals(number7Button)) {
				outputTextField.setText(outputTextField.getText() + "7");
			} else if (event.getSource().equals(number8Button)) {
				outputTextField.setText(outputTextField.getText() + "8");
			} else if (event.getSource().equals(number9Button)) {
				outputTextField.setText(outputTextField.getText() + "9");
			} else if (event.getSource().equals(dotButton)) {
				outputTextField.setText(outputTextField.getText() + ".");
			}
		}

	}

	public void onClearButtonClick(ActionEvent event) {
		if (event.getSource().equals(clearButton)) {
			calculations.clear();
			outputTextField.clear();
		} else if (event.getSource().equals(clearHistoryButton)) {
			calculations.clear();
			outputTextField.clear();
			historyTextArea.clear();
		}
	}

	public void onCalculatorEquationTypeButtonClick(ActionEvent event) {
		if (!outputTextField.getText().isBlank()) {
			if (event.getSource().equals(additionButton)) {
				calculations.add(outputTextField.getText());
				calculations.add("+");
				outputTextField.setText("");
			} else if (event.getSource().equals(substractionButton)) {
				calculations.add(outputTextField.getText());
				calculations.add("-");
				outputTextField.setText("");
			} else if (event.getSource().equals(divisionButton)) {
				calculations.add(outputTextField.getText());
				calculations.add("/");
				outputTextField.setText("");
			} else if (event.getSource().equals(multiplicationButton)) {
				calculations.add(outputTextField.getText());
				calculations.add("*");
				outputTextField.setText("");
			}
		}
	}

	public void onEnterButtonClick(ActionEvent event) {
		if (!outputTextField.getText().isBlank()) {
			calculations.add(outputTextField.getText());
			String result = calculate().toString();
			for (int i = 0; i < calculations.size(); i++) {
				historyTextArea.appendText(calculations.get(i));
			}
			historyTextArea.appendText("=" + result + "\n");
			outputTextField.setText(result);
			calculations.clear();
		}
	}

	private BigDecimal calculate() {
		BigDecimal result = new BigDecimal(calculations.get(0));
		MathContext mc = new MathContext(3, RoundingMode.HALF_EVEN);
		for (int i = 1; i < calculations.size() - 1; i++) {
			if (calculations.get(i).equals("+")) {
				result = result.add(new BigDecimal(calculations.get(i + 1)));
				i++;
			} else if (calculations.get(i).equals("-")) {
				result = result.subtract(new BigDecimal(calculations.get(i + 1)));
				i++;
			} else if (calculations.get(i).equals("/")) {
				result = result.divide(new BigDecimal(calculations.get(i + 1)), mc);
				i++;
			} else if (calculations.get(i).equals("*")) {
				result = result.multiply(new BigDecimal(calculations.get(i + 1)));
				i++;
			}
		}
		return result;
	}

}
