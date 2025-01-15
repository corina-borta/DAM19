package org.scrum.restaurant.vaadin;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.Route;
import org.scrum.restaurant.meniu.Meniu;
import org.scrum.restaurant.persoane.Angajat;
import org.scrum.restaurant.persoane.Client;
import org.scrum.restaurant.management.Comenzi;
import org.scrum.restaurant.service.MeniuService;
import org.scrum.restaurant.service.ClientService;
import org.scrum.restaurant.service.AngajatService;
import org.scrum.restaurant.service.ComenziService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Route("") // Ruta principală pentru această interfață
public class MainView extends Div {

    private final MeniuService meniuService;
    private final ClientService clientService;
    private final AngajatService angajatService;
    private final ComenziService comenziService;

    private final Grid<Meniu> meniuGrid = new Grid<>(Meniu.class);
    private final Grid<Client> clientGrid = new Grid<>(Client.class);
    private final Grid<Angajat> angajatGrid = new Grid<>(Angajat.class);
    private final Grid<Comenzi> comenziGrid = new Grid<>(Comenzi.class);

    @Autowired
    public MainView(MeniuService meniuService, ClientService clientService, AngajatService angajatService, ComenziService comenziService) {
        this.meniuService = meniuService;
        this.clientService = clientService;
        this.angajatService = angajatService;
        this.comenziService = comenziService;

        // Configurează grilele
        configureGrids();

        // Creează layout-uri și adaugă în UI
        HorizontalLayout layout = new HorizontalLayout(createMeniuSection(), createClientSection(), createAngajatSection(), createComenziSection());
        layout.setWidthFull();
        add(layout);
    }

    private void configureGrids() {
        // Configurare grilă Meniu
        meniuGrid.setColumns("idMeniu", "numeMeniu");
        meniuGrid.setItems(getAllMeniuri());

        // Configurare grilă Client
        clientGrid.setColumns("idClient", "numeClient", "email", "telefon");
        clientGrid.setItems(getAllClients());

        // Configurare grilă Angajat
        angajatGrid.setColumns("idAngajat", "numeAngajat", "rolAngajat", "email", "telefon");
        angajatGrid.setItems(getAllAngajati());

        // Configurare grilă Comenzi
        comenziGrid.setColumns("idComanda", "status", "totalComanda", "dataComenzii");
        comenziGrid.setItems(getAllComenzi());
    }

    private Div createMeniuSection() {
        Div meniuDiv = new Div();
        meniuDiv.add(meniuGrid);

        Button adaugaMeniu = new Button("Adaugă Meniu", click -> Notification.show("Funcționalitate de adăugare Meniu"));
        Button stergeMeniu = new Button("Șterge Meniu", click -> Notification.show("Funcționalitate de ștergere Meniu"));
        meniuDiv.add(new HorizontalLayout(adaugaMeniu, stergeMeniu));

        return meniuDiv;
    }

    private Div createClientSection() {
        Div clientDiv = new Div();
        clientDiv.add(clientGrid);

        Button adaugaClient = new Button("Adaugă Client", click -> Notification.show("Funcționalitate de adăugare Client"));
        Button stergeClient = new Button("Șterge Client", click -> Notification.show("Funcționalitate de ștergere Client"));
        clientDiv.add(new HorizontalLayout(adaugaClient, stergeClient));

        return clientDiv;
    }

    private Div createAngajatSection() {
        Div angajatDiv = new Div();
        angajatDiv.add(angajatGrid);

        Button adaugaAngajat = new Button("Adaugă Angajat", click -> Notification.show("Funcționalitate de adăugare Angajat"));
        Button stergeAngajat = new Button("Șterge Angajat", click -> Notification.show("Funcționalitate de ștergere Angajat"));
        angajatDiv.add(new HorizontalLayout(adaugaAngajat, stergeAngajat));

        return angajatDiv;
    }

    private Div createComenziSection() {
        Div comenziDiv = new Div();
        comenziDiv.add(comenziGrid);

        Button adaugaComanda = new Button("Adaugă Comandă", click -> Notification.show("Funcționalitate de adăugare Comandă"));
        Button stergeComanda = new Button("Șterge Comandă", click -> Notification.show("Funcționalitate de ștergere Comandă"));
        comenziDiv.add(new HorizontalLayout(adaugaComanda, stergeComanda));

        return comenziDiv;
    }

    private List<Meniu> getAllMeniuri() {
        return meniuService.getAllMeniuri();
    }

    private List<Client> getAllClients() {
        return clientService.getAllClienti();
    }

    private List<Angajat> getAllAngajati() {
        return angajatService.getAllAngajati();
    }

    private List<Comenzi> getAllComenzi() {
        return comenziService.getAllComenzi();
    }
}
