module br.edu.fesa.teladelogin {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;
    requires javafx.graphics;
    requires java.sql;
//    requires mysql.connector.java;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;
    requires java.desktop;
    requires junit;
    requires fontawesomefx;

    opens br.edu.fesa.teladelogin to javafx.fxml;
    exports br.edu.fesa.teladelogin;
    exports database;
    exports br.edu.fesa.teladelogin.funcionarioData;

    exports salaoDataOutput;
    exports salaoDataOutput.mapDB;

    exports salaoDataProcess.modeloDeDados;

    exports salaoDataProcess.transactions;
    exports salaoDataProcess.transactions.atendimentoTransactions;
    exports salaoDataProcess.transactions.clienteTransactions;
    exports salaoDataProcess.transactions.comandaTransactions;
    exports salaoDataProcess.transactions.pagamentoTransactions;
    exports salaoDataProcess.transactions.profissionalTransactions;
    exports salaoDataProcess.transactions.servicoTransactions;

    exports br.edu.fesa.teladelogin.comandaData;
}