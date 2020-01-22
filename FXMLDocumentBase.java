package notepad;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.layout.BorderPane;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCombination;

public abstract class FXMLDocumentBase extends BorderPane {

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

    public FXMLDocumentBase() {

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
        MICut.setAccelerator(new KeyCodeCombination(KeyCode.M, KeyCombination.CONTROL_DOWN));

        MICopy.setMnemonicParsing(false);
        MICopy.setText("Copy");
        MICopy.setAccelerator(new KeyCodeCombination(KeyCode.C, KeyCombination.CONTROL_DOWN));

        MIPaste.setMnemonicParsing(false);
        MIPaste.setText("Paste");
        MIPaste.setAccelerator(new KeyCodeCombination(KeyCode.V, KeyCombination.CONTROL_ANY));

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

    }
}
