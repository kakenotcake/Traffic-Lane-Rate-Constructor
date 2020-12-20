import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import java.math.RoundingMode;
import java.text.DecimalFormat;


public class RateConstructor extends Application
{
	int weight;
	int directionSelection;
	int countrySelection;
	double total;

	private String[] direction = {"Export", "Import"};
	private String[] country = {"Argentina", "China", "UAE"};

	Button btCalculate = new Button("Calculate");

	private ComboBox<String> cboDirection = new ComboBox<>();
	private ComboBox<String> cboCountry = new ComboBox<>();

	//private TextField textFieldLastName = new TextField();
	//private TextField textFieldFirstName = new TextField();
	private TextField textFieldWeight = new TextField();

	private DescriptionPane calculated = new DescriptionPane();

	private ObservableList<String> itemsDirection;
	private ObservableList<String> itemsCountry;

	private static DecimalFormat df = new DecimalFormat("#.00");


	@Override
	public void start(Stage primaryStage)
	{
		FlowPane pane = new FlowPane();
		pane.setPadding(new Insets(11, 12, 13, 14));
		pane.setHgap(5);
		pane.setVgap(5);

		pane.getChildren().addAll(new Label("Weight in lbs."), textFieldWeight, new Label("Direction"), cboDirection, new Label("Country"),cboCountry, new Label("Calculated"), calculated, btCalculate);


		itemsDirection = FXCollections.observableArrayList(direction);
		itemsCountry = FXCollections.observableArrayList(country);
		cboDirection.getItems().addAll(itemsDirection);
		cboCountry.getItems().addAll(itemsCountry);

		btCalculate.setOnAction(e -> calculate(calculated));

		Scene scene = new Scene(pane, 200, 250);
		primaryStage.setTitle("RateConstructor");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	private void calculate(DescriptionPane calc)
	{
		weight = Integer.parseInt(textFieldWeight.getText());
		directionSelection = itemsDirection.indexOf(cboDirection.getValue());
		countrySelection = itemsCountry.indexOf(cboCountry.getValue());
		System.out.println(weight + " " + directionSelection + " " + countrySelection);

		if (countrySelection == 0)
		{
			Argentina argentina = new Argentina();
			total = (argentina.getCalculation(directionSelection, weight))/100;
		}
		df.setRoundingMode(RoundingMode.UP);
		String strTotal = String.valueOf(df.format(total));
		calc.setDescription("Traffic lane total: $" + strTotal);
		System.out.println(total);
	}
}
