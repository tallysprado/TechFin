/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login.controller;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.DialogPane;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import login.view.UsuarioForm;
import pagamentos.model.Cliente;
import principal.view.Principal;

/**
 * FXML Controller class
 *
 * @author root
 */
public class LoginFXMLController implements Initializable {

    @FXML
    TextField usuarioField;
    @FXML
    PasswordField senhaField;

    /**
     * Initializes the controller class.
     */
    List<Cliente> list;
    EntityManager entityManager;
    Query query;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        entityManager = java.beans.Beans.isDesignTime() ? null : javax.persistence.Persistence.createEntityManagerFactory("Fintech_SwingPU").createEntityManager();
        query = java.beans.Beans.isDesignTime() ? null : entityManager.createQuery("SELECT u FROM Cliente u");
        list = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : org.jdesktop.observablecollections.ObservableCollections.observableList(query.getResultList());

    }

    private void refresh() {
        //entityManager.getTransaction().rollback();
        entityManager.getTransaction().begin();
        java.util.Collection data = query.getResultList();
        for (Object entity : data) {
            entityManager.refresh(entity);
        }
        list.clear();
        list.addAll(data);
    }

    @FXML
    private void cadastro() {
        new UsuarioForm().run();
    }
   
    @FXML
    private void login() throws IOException {
        refresh();
        for (Cliente u : list) {
            if (usuarioField.getText().equals(u.getUser()) && senhaField.getText().equals(u.getSenha())) {

                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("TechFin");
                alert.setHeaderText("TechFin - Seu dinheiro, nossa felicidade!");
                alert.setContentText("Seja bem vindo " + u.getNome());
                alert.showAndWait();
                
                /*Parent root = FXMLLoader.load(getClass().getResource("/principal/view/PrincipalFXML.fxml"));

                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.setScene(scene);

                stage.show();

                stage = (Stage) usuarioField.getScene().getWindow();
                stage.close();
                
                System.out.println(u.getNome());
                FileWriter fw = new FileWriter("cliente.txt");
                PrintWriter pw = new PrintWriter(fw);
                pw.print(u.getNome());
                fw.close();
                */
                
                Stage stage = (Stage) usuarioField.getScene().getWindow();
                stage.close();
                Principal p = new Principal(u);
                p.run();
                break;
            }
        }
    }

}
