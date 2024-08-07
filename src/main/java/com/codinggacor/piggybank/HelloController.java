package com.codinggacor.piggybank;

import javafx.animation.Interpolator;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

import java.util.HashMap;
import java.util.Map;

public class HelloController {
    @FXML
    public AnchorPane MainPane;

    @FXML
    public Label Label_Profile;
    @FXML
    public Label Label_Income;
    @FXML
    public Label Label_Outcome;
    @FXML
    public Label Label_Analytics;
    @FXML
    public Label Label_Dashboard;
    @FXML
    public Pane Drawer;
    @FXML
    public Pane NavigationBar;
    @FXML
    public Pane Icon_Dashboard;
    @FXML
    public Pane Icon_Profile;
    @FXML
    public Pane Icon_Income;
    @FXML
    public Pane Icon_Outcome;
    @FXML
    public Pane Icon_Analytics;

    Map<String, String> colorPalette = Map.of(
         "Deep Grape","#3e385a",
         "Dark Violet","#353058",
            "Midnight Purple","#352f55",
            "Lavender Mist", "#b582f9",
            "Orchid Bloom","#c76bd6",
            "Sky Blue","#82aae8"
    );
    Map<String, Boolean> menuIsOpen = new HashMap<>(Map.of(
            "Dashboard", true,
            "Profile", false,
            "Income", false,
            "Outcome", false,
            "Analytics", false
            ));;

    Map<String, Pane>drawerButtons;
    Map<String, Label> drawerLabels;

    @FXML
    public void initialize(){
        colorDrawerButton(colorPalette.get("Deep Grape"), Icon_Dashboard, Label_Dashboard);
        drawerButtons = new HashMap<>(
                Map.of(
                        "Dashboard", Icon_Dashboard,
                        "Profile", Icon_Profile,
                        "Income", Icon_Income,
                        "Outcome", Icon_Outcome,
                        "Analytics", Icon_Analytics

                        )
        );
        drawerLabels = new HashMap<>(
                Map.of(
                  "Dashboard", Label_Dashboard,
                  "Profile", Label_Profile,
                  "Income", Label_Income,
                  "Outcome", Label_Outcome,
                  "Analytics", Label_Analytics

                )
        );
    }

    public void openDrawer(){
        if(Drawer.getTranslateX() != 0) return;
        TranslateTransition transition = new TranslateTransition();
        transition.setNode(Drawer);
        transition.setDuration(Duration.seconds(0.2));
        transition.setInterpolator(Interpolator.EASE_OUT);
        transition.setRate(1);
        transition.setByX(205);

        transition.play();
    }
    public void closeDrawer(){
        if(Drawer.getTranslateX() != 205) return;
        TranslateTransition transition = new TranslateTransition();
        transition.setNode(Drawer);
        transition.setDuration(Duration.seconds(0.2));
        transition.setInterpolator(Interpolator.EASE_IN);
        transition.setRate(1);
        transition.setByX(-205);


        transition.play();
    }

    public void colorDrawerButton(String Color, Pane Buttons, Label Labels ) {
        Buttons.setStyle("-fx-background-color: " + Color);
        Labels.setStyle("-fx-background-color: " + Color);

    }

    public void onMouseHover(MouseEvent event) {
        Node sender = (Node) event.getSource();
        if (event.getEventType() == MouseEvent.MOUSE_ENTERED) {
            for (String option : drawerButtons.keySet()) {
                if (sender.getId().contains(option)) {
                    colorDrawerButton(
                            colorPalette.get("Deep Grape"),
                            drawerButtons.get(option),
                            drawerLabels.get(option)
                    );
                    break;
                }
            }
        } else if (event.getEventType() == MouseEvent.MOUSE_EXITED) {
            for (String option : drawerButtons.keySet()) {
                if (sender.getId().contains(option) && !menuIsOpen.get(option)) {
                    colorDrawerButton(
                            colorPalette.get("Dark Violet"),
                            drawerButtons.get(option),
                            drawerLabels.get(option)
                    );
                    break;
                }
            }
        }
    }
    public void onMouseClicked(MouseEvent event){
        Node sender = (Node) event.getSource();
            for(String key : menuIsOpen.keySet()){
                if(sender.getId().contains(key))
                    menuIsOpen.replace(key,true);

                else {
                    menuIsOpen.replace(key,false);
                    colorDrawerButton(colorPalette.get("Dark Violet"), drawerButtons.get(key), drawerLabels.get(key));
                }
            }
    }
}