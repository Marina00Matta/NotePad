package notepad;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Optional;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.IndexRange;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.layout.BorderPane;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCombination;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

public class Note extends BorderPane {

    protected final MenuBar MBar;
    protected final Menu MFile;
    protected final MenuItem MINew;
    protected final MenuItem MIOpen;
    protected final MenuItem MISave;
    protected final MenuItem MIExit;
    protected final Menu MEdit;
    protected final MenuItem MIUndo;
    protected final MenuItem MICut;
    protected final MenuItem MICopy;
    protected final MenuItem MIPaste;
    protected final MenuItem MIDelete;
    protected final MenuItem MISelectAll;
    protected final Menu MHelp;
    protected final MenuItem MIAbout;
    protected final TextArea Textarea;
    private Stage myStage;
    public Note(Stage stage) {
        myStage  = stage;
        MBar = new MenuBar();
        MFile = new Menu();
        MINew = new MenuItem();
        MIOpen = new MenuItem();
        MISave = new MenuItem();
        MIExit = new MenuItem();
        MEdit = new Menu();
        MIUndo = new MenuItem();
        MICut = new MenuItem();
        MICopy = new MenuItem();
        MIPaste = new MenuItem();
        MIDelete = new MenuItem();
        MISelectAll = new MenuItem();
        MHelp = new Menu();
        MIAbout = new MenuItem();
        Textarea = new TextArea();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(692.0);
        setPrefWidth(866.0);

        BorderPane.setAlignment(MBar, javafx.geometry.Pos.CENTER);

        MFile.setMnemonicParsing(false);
        MFile.setText("File");

        MINew.setMnemonicParsing(false);
        MINew.setText("New");
        MINew.setAccelerator(new KeyCodeCombination(KeyCode.N, KeyCombination.CONTROL_DOWN));

        MIOpen.setMnemonicParsing(false);
        MIOpen.setText("Open");
        MIOpen.setAccelerator(new KeyCodeCombination(KeyCode.O, KeyCombination.CONTROL_DOWN));

        MISave.setMnemonicParsing(false);
        MISave.setText("Save");
        MISave.setAccelerator(new KeyCodeCombination(KeyCode.S, KeyCombination.CONTROL_DOWN));

        MIExit.setMnemonicParsing(false);
        MIExit.setText("Exit");
        MIExit.setAccelerator(new KeyCodeCombination(KeyCode.X, KeyCombination.CONTROL_DOWN));

        MEdit.setMnemonicParsing(false);
        MEdit.setText("Edit");

        MIUndo.setMnemonicParsing(false);
        MIUndo.setText("Undo");
        MIUndo.setAccelerator(new KeyCodeCombination(KeyCode.Z, KeyCombination.CONTROL_DOWN));

        MICut.setMnemonicParsing(false);
        MICut.setText("Cut");
        MICut.setAccelerator(new KeyCodeCombination(KeyCode.X, KeyCombination.CONTROL_DOWN));

        MICopy.setMnemonicParsing(false);
        MICopy.setText("Copy");
        MICopy.setAccelerator(new KeyCodeCombination(KeyCode.C, KeyCombination.CONTROL_DOWN));

        MIPaste.setMnemonicParsing(false);
        MIPaste.setText("Paste");
        MIPaste.setAccelerator(new KeyCodeCombination(KeyCode.V, KeyCombination.CONTROL_DOWN));

        MIDelete.setMnemonicParsing(false);
        MIDelete.setText("Delete");

        MISelectAll.setMnemonicParsing(false);
        MISelectAll.setText("SelectAll");
        MISelectAll.setAccelerator(new KeyCodeCombination(KeyCode.A, KeyCombination.CONTROL_DOWN));

        MHelp.setMnemonicParsing(false);
        MHelp.setText("Help");

        MIAbout.setMnemonicParsing(false);
        MIAbout.setText("About");
        setTop(MBar);

        BorderPane.setAlignment(Textarea, javafx.geometry.Pos.CENTER);
        Textarea.setPrefHeight(563.0);
        Textarea.setPrefWidth(677.0);
        setCenter(Textarea);

        MFile.getItems().add(MINew);
        MFile.getItems().add(MIOpen);
        MFile.getItems().add(MISave);
        MFile.getItems().add(MIExit);
        MBar.getMenus().add(MFile);
        MEdit.getItems().add(MIUndo);
        MEdit.getItems().add(MICut);
        MEdit.getItems().add(MICopy);
        MEdit.getItems().add(MIPaste);
        MEdit.getItems().add(MIDelete);
        MEdit.getItems().add(MISelectAll);
        MBar.getMenus().add(MEdit);
        MHelp.getItems().add(MIAbout);
        MBar.getMenus().add(MHelp);

        MICopy.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent t) {
                Textarea.copy();
            }
        });

        MICut.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent t) {
                Textarea.cut();
            }
        });

        MIPaste.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent t) {
                Textarea.paste();

            }
        });

        MIUndo.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent t) {
                Textarea.undo();

            }
        });

        MISelectAll.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent t) {
                Textarea.selectAll();

            }
        });

        MIDelete.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent t) {
                IndexRange range = Textarea.getSelection();
                Textarea.deleteText(range);

            }
        });

        MINew.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent t) {
                if (Textarea.getText().isEmpty()) {
                    Textarea.clear();
                } else {
                    Alert alert = new Alert(AlertType.CONFIRMATION);

                    alert.setTitle("Confirmation");
                    alert.setHeaderText(" Do you Want to save changes?");
                    alert.setContentText("Choose your option.");

                    ButtonType buttonTypeOne = new ButtonType("Save");
                    ButtonType buttonTypeTwo = new ButtonType("Don't Save");
                    ButtonType buttonTypeCancel = new ButtonType("Cancel", ButtonData.CANCEL_CLOSE);

                    alert.getButtonTypes().setAll(buttonTypeOne, buttonTypeTwo, buttonTypeCancel);

                    Optional<ButtonType> result = alert.showAndWait();
                    if (result.get() == buttonTypeOne) {
                        showSaveDialog();
                    } else if (result.get() == buttonTypeTwo) {
                        Textarea.clear();
                    } else {
                        alert.close();
                    }
                }
            }

        });

        MIAbout.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent t) {
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Information Dialog");
                alert.setHeaderText(null);
                alert.setContentText("This is The Notepad Help ");
                alert.showAndWait();

            }
        });

        MIOpen.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent t) {
                FileChooser fileChooser = new FileChooser();
                fileChooser.setTitle("Open Resource File");
                fileChooser.getExtensionFilters().addAll(
                        new ExtensionFilter("Text Files", "*.txt"));
                File selectedFile = fileChooser.showOpenDialog(stage);
                if (selectedFile != null) {
                    Textarea.setText(readFile(selectedFile));
                }
            }

            private String readFile(File file) {
                StringBuilder stringBuffer = new StringBuilder();
                BufferedReader bufferedReader = null;

                try {

                    bufferedReader = new BufferedReader(new FileReader(file));

                    String text;
                    while ((text = bufferedReader.readLine()) != null) {
                        stringBuffer.append(text + "\n");
                    }

                } catch (FileNotFoundException ex) {
                    ex.printStackTrace();
                } catch (IOException ex) {
                    ex.printStackTrace();
                } finally {
                    try {
                        bufferedReader.close();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }

                return stringBuffer.toString();
            }
        });

        MISave.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent t) {
                showSaveDialog();

            }
        });

        MIExit.setOnAction((ActionEvent t) -> {
            Alert alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("Warning Dialog");
            alert.setHeaderText("Warning");
            alert.setContentText("Are You Sure You Want To Exit");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
                Platform.exit();
            } else {

                alert.close();
            }
        });
    }
    private void SaveFile(String content, File file) {
                try {
                    FileWriter fileWriter;
                    fileWriter = new FileWriter(file);
                    fileWriter.write(content);
                    fileWriter.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
    public void showSaveDialog() {
                FileChooser fileChooser = new FileChooser();
                fileChooser.setTitle("Save Resource File");
                fileChooser.getExtensionFilters().addAll(
                        new ExtensionFilter("Text Files", "*.txt"));
                File selectedFile = fileChooser.showSaveDialog(myStage);
                if (selectedFile != null) {
                    SaveFile(Textarea.getText(), selectedFile);
                }
            }
}

