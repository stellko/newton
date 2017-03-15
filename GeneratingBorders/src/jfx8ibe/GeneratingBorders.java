package jfx8ibe;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 *
 * @author cdea
 */
public class GeneratingBorders extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Chapter 6 Generating Borders");
        BorderPane root = new BorderPane();
        Scene scene = new Scene(root, 650, 330, Color.WHITE);

        // create a grid pane
        GridPane gridpane = new GridPane();
        gridpane.setPadding(new Insets(5));
        gridpane.setHgap(10);
        gridpane.setVgap(10);
        ColumnConstraints column1 = new ColumnConstraints(100, 150, 300);
        ColumnConstraints column2 = new ColumnConstraints(300);
        column1.setHgrow(Priority.ALWAYS);
        column2.setHgrow(Priority.ALWAYS);
        gridpane.getColumnConstraints().addAll(column1, column2); 
        // label CSS Editor
        Label cssEditorLbl = new Label("CSS Editor");
        GridPane.setHalignment(cssEditorLbl, HPos.CENTER);
        gridpane.add(cssEditorLbl, 0, 0);

        // label Border View
        Label borderLbl = new Label("Border View");
        GridPane.setHalignment(borderLbl, HPos.CENTER);
        gridpane.add(borderLbl, 1, 0);

        // Text area for CSS editor
        final TextArea cssEditorFld = new TextArea();
        cssEditorFld.setPrefRowCount(10);
        cssEditorFld.setPrefColumnCount(100);
        cssEditorFld.setWrapText(true);
        cssEditorFld.setPrefWidth(150);
        GridPane.setHalignment(cssEditorFld, HPos.CENTER);
        gridpane.add(cssEditorFld, 0, 1);

        String cssDefault = "-fx-border-color: blue;\n"
                + "-fx-border-insets: 5;\n"
                + "-fx-border-width: 3;\n"
                + "-fx-border-style: dashed;\n";

        cssEditorFld.setText(cssDefault);

        // Border decorate the picture
        final ImageView imv = new ImageView();
        final Image image2 = new Image(GeneratingBorders.class.getResourceAsStream("smoke_glass_buttons1.png"));
        imv.setImage(image2);

        final HBox pictureRegion = new HBox();
        pictureRegion.setStyle(cssDefault);
        pictureRegion.getChildren().add(imv);
        gridpane.add(pictureRegion, 1, 1);

        Button apply = new Button("Bling!");
        GridPane.setHalignment(apply, HPos.RIGHT);
        gridpane.add(apply, 0, 2);
        apply.setOnAction(actionEvent -> 
            pictureRegion.setStyle(cssEditorFld.getText())
        );

        root.setCenter(gridpane);        
        primaryStage.setScene(scene);
        primaryStage.show();
        
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
