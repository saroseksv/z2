package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import javax.swing.*;

public class Controller {
    private ObservableList<Record> usersData = FXCollections.observableArrayList();

    @FXML
    private TableView<Record> tvTable;

    @FXML
    private TableColumn<Record, Double> tcK;

    @FXML
    private TableColumn<Record, String> tcY;

    private void initData() {
        Massiv mas=new Massiv(3,4);
        mas.FillY();
        for(int i=0;i<10;i++)
        {
            usersData.add(new Record(mas.K[i],mas.Y[i]));
        }
    }

    @FXML
    private TextField tfA;

    @FXML
    private TextField tfB;

    public void bFillClick(ActionEvent actionEvent) {
        Double a=Math.random()*10;
        Double b=Math.random()*10;

        tfA.setText(String.valueOf(a));
        tfB.setText(String.valueOf(b));
    }

    public void bProcessClick(ActionEvent actionEvent) {
        String sa= tfA.getText();
        String sb= tfB.getText();
        Double a,b;
        try {
            a=Double.valueOf(sa);
            b=Double.valueOf(sb);
            if(a==0 && b==0)
                JOptionPane.showMessageDialog(null, "a и b не могут быть одновременно равны нулю");
            else{
                initData();
                tcK.setCellValueFactory(new PropertyValueFactory<Record, Double>("K"));
                tcY.setCellValueFactory(new PropertyValueFactory<Record, String>("Y"));

                tvTable.setItems(usersData);


            }
        }
        catch (NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Вы ввели недопустимое числовое значение");
        }

    }

    public void bClearClick(ActionEvent actionEvent) {
        tfA.setText("");
        tfB.setText("");
    }

    public void bExitClick(ActionEvent actionEvent) {
        System.exit(0);
    }
}
