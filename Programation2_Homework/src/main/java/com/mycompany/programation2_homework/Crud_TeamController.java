package com.mycompany.programation2_homework;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
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

public class Crud_TeamController implements Initializable {

    @FXML private ListView<String> ID_LISTVIEW_SPORT_TEAM;
    @FXML private ListView<String> ID_TEAM_LIST;
    @FXML private Button ID_ADD_TEAM;
    @FXML private TextField ID_WRITE_TEAM;
    @FXML private Button ID_UPDATE_TEAM; // Añade la lógica si la necesitas
    @FXML private Button ID_ELIMINATE_TEAM;
    @FXML private Button ID_PREVIOUS;

    private ObservableList<String> sportsList = FXCollections.observableArrayList();
    private ObservableList<String> teamsList = FXCollections.observableArrayList();
    private Map<String, ObservableList<String>> sportTeamsMap = new HashMap<>();
    private String selectedSport = null;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ID_LISTVIEW_SPORT_TEAM.setItems(sportsList);
        ID_TEAM_LIST.setItems(teamsList);

        ID_LISTVIEW_SPORT_TEAM.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> {
            if (newVal != null) {
                selectedSport = newVal;
                updateTeamsList();
            }
        });

        ID_ADD_TEAM.setOnAction(event -> {
            String teamName = ID_WRITE_TEAM.getText().trim();
            if (selectedSport != null && !teamName.isEmpty()) {
                if (!sportTeamsMap.containsKey(selectedSport)) {
                    sportTeamsMap.put(selectedSport, FXCollections.observableArrayList());
                }
                if (!sportTeamsMap.get(selectedSport).contains(teamName)) {
                    sportTeamsMap.get(selectedSport).add(teamName);
                    ID_WRITE_TEAM.clear();
                    updateTeamsList();
                    showAlert("Éxito", "Equipo agregado", teamName + " agregado a " + selectedSport);
                } else {
                    showAlert("Error", "Equipo duplicado", "El equipo ya existe para este deporte.");
                }
            } else {
                showAlert("Error", "Datos incompletos", "Seleccione un deporte e ingrese un nombre válido.");
            }
        });

        ID_ELIMINATE_TEAM.setOnAction(event -> {
            String selectedTeam = ID_TEAM_LIST.getSelectionModel().getSelectedItem();
            if (selectedSport != null && selectedTeam != null) {
                sportTeamsMap.get(selectedSport).remove(selectedTeam);
                updateTeamsList();
                showAlert("Éxito", "Equipo eliminado", selectedTeam + " eliminado de " + selectedSport);
            } else {
                showAlert("Error", "Selección requerida", "Seleccione un deporte y un equipo.");
            }
        });

        // Lógica para el botón de actualización (si quieres implementarla)
        ID_UPDATE_TEAM.setOnAction(event -> {
            String selectedTeam = ID_TEAM_LIST.getSelectionModel().getSelectedItem();
            String newTeamName = ID_WRITE_TEAM.getText().trim();

            if (selectedSport != null && selectedTeam != null && !newTeamName.isEmpty()) {
                ObservableList<String> currentTeams = sportTeamsMap.get(selectedSport);
                if (currentTeams != null && !currentTeams.contains(newTeamName)) {
                    int selectedIndex = currentTeams.indexOf(selectedTeam);
                    if (selectedIndex != -1) {
                        currentTeams.set(selectedIndex, newTeamName);
                        ID_WRITE_TEAM.clear();
                        updateTeamsList();
                        showAlert("Éxito", "Equipo actualizado", selectedTeam + " actualizado a " + newTeamName);
                    }
                } else {
                    showAlert("Error", "Error al actualizar", "Seleccione un equipo, ingrese un nuevo nombre válido o el nuevo nombre ya existe.");
                }
            } else {
                showAlert("Error", "Datos incompletos", "Seleccione un deporte y un equipo, e ingrese un nuevo nombre.");
            }
        });


        ID_PREVIOUS.setOnAction(event -> {
            navigateBackToSports();
        });
    }

    // Nuevo método para recibir ambos datos (deportes y sus equipos)
    public void setSportsAndTeamsData(ObservableList<String> sports, Map<String, ObservableList<String>> teamsMap) {
        this.sportsList.setAll(sports); // Carga los deportes
        this.sportTeamsMap.clear(); // Limpia el mapa actual
        // Copia los equipos del mapa pasado
        for (Map.Entry<String, ObservableList<String>> entry : teamsMap.entrySet()) {
            this.sportTeamsMap.put(entry.getKey(), FXCollections.observableArrayList(entry.getValue()));
        }

        // Seleccionar el primer deporte por defecto para mostrar sus equipos si los hay
        if (!sportsList.isEmpty()) {
            ID_LISTVIEW_SPORT_TEAM.getSelectionModel().selectFirst();
        }
    }

    private void updateTeamsList() {
        if (selectedSport != null) {
            teamsList.setAll(sportTeamsMap.get(selectedSport));
        } else {
            teamsList.clear();
        }
    }

    private void navigateBackToSports() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Crud.fxml")); // Asegúrate que este FXML es el correcto para la pantalla principal
            Parent root = loader.load();

            CrudController mainController = loader.getController();
            // Pasa la lista de deportes Y el mapa de equipos DE VUELTA
            mainController.receiveSportsAndTeamsData(sportsList, sportTeamsMap);

            Stage stage = (Stage) ID_PREVIOUS.getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            showAlert("Error", "Error de navegación", "No se pudo volver a la pantalla principal.");
        }
    }

    private void showAlert(String title, String header, String content) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();
    }
}