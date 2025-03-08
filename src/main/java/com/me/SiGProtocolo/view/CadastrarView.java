package com.me.SiGProtocolo.view;

import com.me.SiGProtocolo.model.Natureza;
import com.me.SiGProtocolo.model.Protocolo;
import com.me.SiGProtocolo.service.ProtocoloService;
import com.vaadin.flow.component.Html;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.confirmdialog.ConfirmDialog;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Menu;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;


@Route("cadastrar-protocolos")
@Menu(order = 0, icon = "PENCIL")
@PageTitle("Cadastrar Protocolos")
public class CadastrarView extends VerticalLayout {

    private final ProtocoloService service;

    private Span status;

    public CadastrarView(ProtocoloService service) {
        this.service = service;


        ComboBox<Natureza> comboBox = new ComboBox<>("Natureza do Protocolo");
        comboBox.setItems(Natureza.values());
        add(comboBox);




        status = new Span();
        status.setVisible(false);

        ConfirmDialog dialog = new ConfirmDialog();
        dialog.setConfirmText("OK");

        add(status);


        Button button = new Button("Enviar");
        button.addClickListener(clickEvent -> {
            Protocolo novoProtocolo = new Protocolo(comboBox.getValue());
            Protocolo p  = service.cadatrar(novoProtocolo);
            comboBox.clear();
            dialog.setText(confirmacaoProtocolo(p));
            dialog.open();
            status.setVisible(false);
        });

        add(button);

    }

    private Html confirmacaoProtocolo(Protocolo protocolo){
       return new Html("<p> O Protocolo " + protocolo.getNumero() + " foi cadastrado com sucesso.</p>");
    }




}