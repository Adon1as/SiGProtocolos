package com.me.SiGProtocolo.view;

import com.me.SiGProtocolo.model.Protocolo;
import com.me.SiGProtocolo.service.ProtocoloService;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.data.renderer.LocalDateRenderer;
import com.vaadin.flow.router.Menu;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import java.time.LocalDate;
import java.util.List;


@Route("listar-protocolos")
@Menu(order = 1, icon = "BOOK")
@PageTitle("Listar Protocolos")
public class ListaView extends VerticalLayout {

    private final ProtocoloService service;


    public ListaView(ProtocoloService service) {
        this.service = service;
        Grid<Protocolo> grid = new Grid<>(Protocolo.class, false);
        grid.addColumn(Protocolo::getNumero).setHeader("Número do Protocolo").setSortable(true);
        grid.addColumn(new LocalDateRenderer<>(protocolo -> protocolo.getCriacao().toLocalDate(), "dd/MM/yyyy"))
                .setHeader("Data de Criação").setSortable(true);
        grid.addColumn(Protocolo::getNatureza).setHeader("Natureza do Protocolo").setSortable(true);
        grid.addColumn(new LocalDateRenderer<>(protocolo -> protocolo.getVencimento().toLocalDate(), "dd/MM/yyyy"))
                .setHeader("Data de Vencimento").setSortable(true);


        List<Protocolo> protocolos = service.listarTodos();
        grid.setItems(protocolos);
        grid.setAllRowsVisible(true);
        add(grid);
    }

    private LocalDate getCriacao(Protocolo protocolo){
        return protocolo.getCriacao().toLocalDate();
    }

}