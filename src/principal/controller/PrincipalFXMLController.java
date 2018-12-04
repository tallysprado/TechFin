/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.embed.swing.SwingNode;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.Pane;
import javax.swing.SwingUtilities;
import login.view.UsuarioForm;
import pagamentos.view.TransacaoForm;

/**
 * FXML Controller class
 *
 * @author root
 */
public class PrincipalFXMLController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }   
    @FXML
    Pane panePagamentos;
    @FXML
    TabPane tabPane;
    @FXML
    Tab tabPagamentos;
    
    @FXML
    private void pagar(){
        final SwingNode swingNode = new SwingNode();
        tabPagamentos = new Tab();
        panePagamentos = new Pane();
        //createSwingContent(swingNode);
        swingNode.setFocusTraversable(true);
        swingNode.setDisable(false);
        panePagamentos.getChildren().add(swingNode);
        swingNode.setVisible(true);
        tabPagamentos.setText("Pagamentos");
        tabPagamentos.setContent(swingNode);
        
        tabPane.getTabs().addAll(tabPagamentos);
        tabPagamentos.setDisable(false);
        panePagamentos.setDisable(false);
        panePagamentos.setVisible(true);
        tabPane.setVisible(true);
    }
    /*
    private void createSwingContent(final SwingNode swingNode) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                //swingNode.setContent(new UsuarioForm());
               swingNode.setContent(new TransacaoForm(u));
                
            }
        });
    }
    */
    
    
}
