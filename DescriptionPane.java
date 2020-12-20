/*
1. Import necessary Javafx classes
2. Create DescriptionPane class that extends BorderPane
- Instantiate TextArea
- Create DescriptionPane constructor
  - Set font and font size for text area
  - Wrap text and not editable
  - Instantiate ScrollPane
  - Set scrollPane position
  - Set insets
- Create setDescription method with String text parameter
  - Text area object call setText method in Text class passing text parameter
*/

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;

public class DescriptionPane extends BorderPane
{

	private TextArea taDescription = new TextArea();

	public DescriptionPane()
	{
		taDescription.setFont(new Font("Serif", 14));

		taDescription.setWrapText(true);
		taDescription.setEditable(false);

		ScrollPane scrollPane = new ScrollPane(taDescription);

		setCenter(scrollPane);
		setPadding(new Insets(5, 5, 5, 5));
	}
	public void setDescription(String text)
	{
		taDescription.setText(text);
	}
}
