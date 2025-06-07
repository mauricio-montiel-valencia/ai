package com.mycompany.programation2_homework;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap; // Necesitas esta importación
import java.util.Map;     // Necesitas esta importación
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class CrudController implements Initializable {

    private Button ID_CREATE_SPORT;
    private Button ID_UPDATE_SPORT;
    private Button ID_ELIMINATE_SPORT;
    private TextField ID_TEXT_SPORT;
    private ListView<String> ID_LISTVIEW_SPORT;
    private Button ID_NEXT;

    private ObservableList<String> sportList = FXCollections.observableArrayList();
    // Añade el mapa para guardar los equipos asociados a cada deporte
    private Map<String, ObservableList<String>> sportTeamsData = new HashMap<>();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ID_LISTVIEW_SPORT.setItems(sportList);

        ID_CREATE_SPORT.setOnAction(event -> {
            String sportName = ID_TEXT_SPORT.getText().trim();
            if (!sportName.isEmpty() && !sportList.contains(sportName)) {
                sportList.add(sportName);
                // Cuando se crea un deporte, inicializa su lista de equipos en el mapa
                if (!sportTeamsData.containsKey(sportName)) {
                    sportTeamsData.put(sportName, FXCollections.observableArrayList());
                }
                ID_TEXT_SPORT.clear();
                showAlert("Éxito", "Deporte agregado", sportName + " fue agregado correctamente.");
            } else {
                showAlert("Error", "Error al agregar", "El deporte ya existe o el campo está vacío.");
            }
        });

        ID_ELIMINATE_SPORT.setOnAction(event -> {
            String selected = ID_LISTVIEW_SPORT.getSelectionModel().getSelectedItem();
            if (selected != null) {
                sportList.remove(selected);
                sportTeamsData.remove(selected); // También elimina sus equipos asociados
                showAlert("Éxito", "Deporte eliminado", selected + " fue eliminado correctamente.");
            } else {
                showAlert("Error", "Error al eliminar", "Ningún deporte seleccionado.");
            }
        });

        ID_NEXT.setOnAction(event -> {
            navigateToTeams();
        });

        // Lógica para el botón de actualización (si quieres implementarla)
        ID_UPDATE_SPORT.setOnAction(event -> {
            String selectedSport = ID_LISTVIEW_SPORT.getSelectionModel().getSelectedItem();
            String newSportName = ID_TEXT_SPORT.getText().trim();

            if (selectedSport != null && !newSportName.isEmpty() && !sportList.contains(newSportName)) {
                int selectedIndex = sportList.indexOf(selectedSport);
                if (selectedIndex != -1) {
                    // Actualiza el nombre del deporte en la lista
                    sportList.set(selectedIndex, newSportName);

                    // Transfiere los equipos al nuevo nombre de deporte
                    ObservableList<String> teams = sportTeamsData.remove(selectedSport);
                    if (teams != null) {
                        sportTeamsData.put(newSportName, teams);
                    } else {
                        sportTeamsData.put(newSportName, FXCollections.observableArrayList()); // Si no tenía equipos
                    }

                    ID_TEXT_SPORT.clear();
                    showAlert("Éxito", "Deporte actualizado", selectedSport + " actualizado a " + newSportName);
                }
            } else {
                showAlert("Error", "Error al actualizar", "Seleccione un deporte, ingrese un nuevo nombre válido o el nuevo nombre ya existe.");
            }
        });

    }

    private void navigateToTeams() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("crud_Team.fxml"));
            Parent root = loader.load();

            Crud_TeamController teamsController = loader.getController();
            // Pasa la lista de deportes Y el mapa de equipos
            teamsController.setSportsAndTeamsData(sportList, sportTeamsData); // Nuevo método en Crud_TeamController

            Stage stage = (Stage) ID_NEXT.getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            showAlert("Error", "Error de navegación", "No se pudo cargar la pantalla de Teams.");
        }
    }

    // Nuevo método para recibir datos cuando se vuelve de Crud_TeamController
    public void receiveSportsAndTeamsData(ObservableList<String> updatedSports, Map<String, ObservableList<String>> updatedSportTeamsMap) {
        // Limpia y actualiza la lista de deportes
        this.sportList.clear();
        this.sportList.addAll(updatedSports);

        // Limpia y actualiza el mapa de equipos
        this.sportTeamsData.clear();
        this.sportTeamsData.putAll(updatedSportTeamsMap);

        // Asegura que la ListView se actualice con los datos recibidos
        ID_LISTVIEW_SPORT.setItems(this.sportList);
    }

    private void showAlert(String title, String header, String content) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();
    }
}