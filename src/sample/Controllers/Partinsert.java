package sample.Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import sample.DB.DatabaseHandler;
import sample.Part;

import java.net.URL;
import java.util.ResourceBundle;

public class Partinsert {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label int_id;

    @FXML
    private Label int_article;

    @FXML
    private Label int_name;

    @FXML
    private Label int_stock;

    @FXML
    private Button int_enter;

    @FXML
    void initialize() {
        int_enter.setOnAction(event ->
                {
                    String idWr = int_id.getText().trim();
                    String artWr = int_article.getText().trim();
                    String namWr = int_name.getText();
                    String stWr = int_stock.getText().trim();
                    if (!idWr.equals("") && !artWr.equals("") && !namWr.equals("") && !stWr.equals("")) {
                        insertPart(idWr, artWr, namWr, stWr);
                    } else
                        System.out.println("Введите все данные");
                }
        );
    }

    private void insertPart(String idPart, String idArticle, String idName, String idStock) {

        DatabaseHandler ins = new DatabaseHandler();
        Part part = new Part();
        part.setIdPart(idPart);
        part.setIdArticle(idArticle);
        part.setIdName(idName);
        part.setIdStock(idStock);
        //ResultSet res=ins.dbPart(part);

    }
}