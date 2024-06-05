package br.edu.fesa.teladelogin;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.AreaChart;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class DashboardController implements Initializable {
    @FXML
    private Button agenda_addBtn;

    @FXML
    private Button agenda_btn;

    @FXML
    private TextField agenda_cliente;

    @FXML
    private TableColumn<?, ?> agenda_col_cliente;

    @FXML
    private TableColumn<?, ?> agenda_col_data;

    @FXML
    private TableColumn<?, ?> agenda_col_id;

    @FXML
    private TableColumn<?, ?> agenda_col_pagamento;

    @FXML
    private TableColumn<?, ?> agenda_col_profissional;

    @FXML
    private TableColumn<?, ?> agenda_col_servico;

    @FXML
    private DatePicker agenda_data;

    @FXML
    private Button agenda_deleteBtn;

    @FXML
    private AnchorPane agenda_form;

    @FXML
    private TextField agenda_id;

    @FXML
    private ImageView agenda_imageView;

    @FXML
    private ImageView agenda_imageView2;

    @FXML
    private TextField agenda_pagamento;

    @FXML
    private TextField agenda_profissional;

    @FXML
    private Button agenda_resetBtn;

    @FXML
    private TextField agenda_servico;

    @FXML
    private TableView<?> agenda_tableView;

    @FXML
    private Button agenda_updateBtn;

    @FXML
    private TextField agenda_valor;

    @FXML
    private Button close;

    @FXML
    private Button dashboard_btn;

    @FXML
    private AnchorPane dashboard_form;

    @FXML
    private AreaChart<?, ?> dashboard_incomeChart;

    @FXML
    private Label dashboard_qtdClientes;

    @FXML
    private ImageView dashboard_qtdClientes_imageView;

    @FXML
    private Label dashboard_qtdFuncionarios;

    @FXML
    private ImageView dashboard_qtdFuncionarios_imageView;

    @FXML
    private Label dashboard_receita;

    @FXML
    private ImageView dashboard_receita_imgView;

    @FXML
    private TextField fucnionarios_id;

    @FXML
    private Button funcionarios_addBtn;

    @FXML
    private Button funcionarios_btn;

    @FXML
    private Button funcionarios_clearBtn;

    @FXML
    private TableColumn<?, ?> funcionarios_col_id;

    @FXML
    private TableColumn<?, ?> funcionarios_col_nome;

    @FXML
    private Button funcionarios_deleteBtn;

    @FXML
    private AnchorPane funcionarios_form;

    @FXML
    private ImageView funcionarios_imageView;

    @FXML
    private ImageView funcionarios_imageView1;

    @FXML
    private TextField funcionarios_nome;

    @FXML
    private TableView<?> funcionarios_tableView;

    @FXML
    private Button funcionarios_updateBtn;

    @FXML
    private AnchorPane main_form;

    @FXML
    private Button minimize;

    @FXML
    private ImageView welcome_imageView;


    public void minimize() {
        Stage stage = (Stage)main_form.getScene().getWindow();
        stage.setIconified(true);
    }

    public void close() {
        javafx.application.Platform.exit();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        File brandingFile = new File("images/imagemRegistro.jpg");
        Image brandingImage = new Image(brandingFile.toURI().toString());
        welcome_imageView.setImage(brandingImage);
        funcionarios_imageView.setImage(brandingImage);
        funcionarios_imageView1.setImage(brandingImage);
        agenda_imageView.setImage(brandingImage);
        agenda_imageView2.setImage(brandingImage);
        dashboard_qtdClientes_imageView.setImage(brandingImage);
        dashboard_qtdFuncionarios_imageView.setImage(brandingImage);
        dashboard_receita_imgView.setImage(brandingImage);
    }

    public void showDashboard() {
        dashboard_form.setVisible(true);
        agenda_form.setVisible(false);
        funcionarios_form.setVisible(false);
    }

    public void showAgenda() {
        dashboard_form.setVisible(false);
        agenda_form.setVisible(true);
        funcionarios_form.setVisible(false);
    }

    public void showFuncionarios() {
        dashboard_form.setVisible(false);
        agenda_form.setVisible(false);
        funcionarios_form.setVisible(true);
    }
}
