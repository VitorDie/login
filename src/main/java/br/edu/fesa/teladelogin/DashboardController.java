package br.edu.fesa.teladelogin;

import br.edu.fesa.teladelogin.comandaData.ComandaDTO;
import br.edu.fesa.teladelogin.comandaData.ComandaModel;
import br.edu.fesa.teladelogin.funcionarioData.FuncionarioDTO;
import br.edu.fesa.teladelogin.funcionarioData.FuncionarioModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.AreaChart;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.ArrayList;
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
    private TableView<ComandaModelModificada> agenda_tableView;

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
    private TableView<FuncionarioModel> funcionarios_tableView;

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

        listarFuncionarios();
        listarComandas();
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

    // Funcionario Form

    private FuncionarioDTO funcionarioDTO = new FuncionarioDTO();
    private ObservableList<FuncionarioModel> funcionariosListData;

    private ObservableList<FuncionarioModel> funcionariosDataList() {
        ArrayList<FuncionarioModel> listaFuncionarios = funcionarioDTO.read();
        ObservableList<FuncionarioModel> listData = FXCollections.observableArrayList();

        for (FuncionarioModel f : listaFuncionarios) {
            listData.add(f);
        }

        return listData;
    }

    public void listarFuncionarios() {
        funcionariosListData = funcionariosDataList();

        funcionarios_col_id.setCellValueFactory(new PropertyValueFactory<>("id"));
        funcionarios_col_nome.setCellValueFactory(new PropertyValueFactory<>("nome"));

        funcionarios_tableView.setItems(funcionariosListData);
    }

    public void adicionarFuncionario() {
        funcionarioDTO.create(Integer.parseInt(fucnionarios_id.getText()), funcionarios_nome.getText());
    }

    public void atualizarFuncionario() {
        funcionarioDTO.update(Integer.parseInt(fucnionarios_id.getText()), funcionarios_nome.getText());
    }

    public void deletarFuncionario() {
        funcionarioDTO.delete(Integer.parseInt(fucnionarios_id.getText()));
    }

    public void clearFuncionario() {
        listarFuncionarios();
    }

    // Comanda Form
    private ComandaDTO comandaDTO = new ComandaDTO();
    private ObservableList<ComandaModelModificada> comandaListData;

    public class ComandaModelModificada {
        private Integer id;
        private String data;
        private String cliente;
        private String profissional;
        private String servico;
        private String pagamento;

        public ComandaModelModificada(Integer id, LocalDateTime data, String cliente, String profissional, String servico, String pagamento) {
            this.id = id;
            this.data = String.valueOf(data);
            this.cliente = cliente;
            this.profissional = profissional;
            this.servico = servico;
            this.pagamento = pagamento;
        }

        public String getPagamento() {
            return pagamento;
        }

        public Integer getId() {
            return id;
        }

        public String getData() {
            return data;
        }

        public String getCliente() {
            return cliente;
        }

        public String getProfissional() {
            return profissional;
        }

        public String getServico() {
            return servico;
        }
    }

    public ComandaModelModificada CmToComandaModificada(ComandaModel cm) {
        return new ComandaModelModificada(cm.getId(), cm.getData_comanda(), cm.getCliente(), cm.getProfissional(), cm.getServico(), cm.getPagamento());
    }

    private ObservableList<ComandaModelModificada> comandaDataList() {
        ArrayList<ComandaModel> listaComadas = comandaDTO.read();
        ObservableList<ComandaModelModificada> listData = FXCollections.observableArrayList();

        for (ComandaModel c : listaComadas) {
            listData.add(CmToComandaModificada(c));
        }

        return listData;
    }

    public void listarComandas() {
        comandaListData = comandaDataList();

        agenda_col_id.setCellValueFactory(new PropertyValueFactory<>("Id"));
        agenda_col_data.setCellValueFactory(new PropertyValueFactory<>("Data"));
        agenda_col_cliente.setCellValueFactory(new PropertyValueFactory<>("Cliente"));
        agenda_col_profissional.setCellValueFactory(new PropertyValueFactory<>("Profissional"));
        agenda_col_servico.setCellValueFactory(new PropertyValueFactory<>("Servico"));
        agenda_col_pagamento.setCellValueFactory(new PropertyValueFactory<>("Pagamento"));

        agenda_tableView.setItems(comandaListData);
    }

    public void criarComanda() {
        Integer id = Integer.parseInt(agenda_id.getText());
        LocalDateTime dt = agenda_data.getValue().atStartOfDay();
        String cliente = agenda_cliente.getText();
        String profissional = agenda_profissional.getText();
        String servico = agenda_servico.getText();
        String pagamento = agenda_pagamento.getText();
        Double valor = Double.valueOf(agenda_valor.getText());

        comandaDTO.create(id, dt, cliente, profissional, servico, pagamento, valor);
    }

    public void excluirComanda() {
        Integer id = Integer.parseInt(agenda_id.getText());

        comandaDTO.delete(id);
    }

    public void alterarComanda() {
        Integer id = Integer.parseInt(agenda_id.getText());
        LocalDateTime dt = agenda_data.getValue().atStartOfDay();
        String cliente = agenda_cliente.getText();
        String profissional = agenda_profissional.getText();
        String servico = agenda_servico.getText();
        String pagamento = agenda_pagamento.getText();
        Double valor = Double.valueOf(agenda_valor.getText());

        comandaDTO.update(id, dt, cliente, profissional, servico, pagamento, valor);
    }
}
