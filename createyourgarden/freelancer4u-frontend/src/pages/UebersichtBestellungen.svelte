<script>

import axios from "axios";
    import { get } from "svelte/store";

    import { user } from "../store";
    import { jwt_token } from "../store";
    import Bestellung from "./Bestellung.svelte";

    const api_root = "http://localhost:8080";


let bestellungen = [];
let bestellung = {};
let status;
let bestellungId = [];

function getBestellungen() {

        var config = {
            method: "get",
            url: api_root + "/api/bestellung",
            headers: {Authorization: "Bearer " + $jwt_token,
                "Content-Type": "application/json",},
        };

        axios(config).then(function (response) {
            bestellungen = response.data;
        });
        
    }

function getStatusUpdate() {
    var config = {
            method: "post",
            url: api_root + "/api/service/bBestaetigung",
            headers: {
                Authorization: "Bearer " + $jwt_token,
                "Content-Type": "application/json",
            },
            data: {bestellungId: bestellungId},
        };

        axios(config)
            .then(function (response) {
                alert("Glückwunsch! Die Bestellung wurde aktualisiert");
            })
            .catch(function (error) {
                alert("Hat leider nicht funktioniert");
                console.log(error);
            });
    }

function statusAendern(inputStatus) {
    if(inputStatus === "NEU") {
        status = "BESTAETIGT"
        getStatusUpdate();
    } else if (inputStatus === "BESTAETIGT") {
        status = "BEREITGESTELLT";
        getStatusUpdate();
    } else {
        alert("Status kann nicht mehr geändert werden. Falls du Hilfe brauchst, wende dich an den Admin");
    }
}
const idZumUpdaten  = (bestellung) => {
    bestellungId = bestellung;
    getStatusUpdate();
}
    getBestellungen();

    // {JSON.stringify(bestellungId)}

</script>

<h1>Übersicht aller Bestellungen inkl. Status</h1><br>
<h3>Statusupgrades kannst du mit nur einem Klick upgraden</h3><br>
<h3>Mögliche Änderungen:</h3>

<table class="table table-sm">
    <thead>
        <tr class="table-info">
          <th scope="col">Status</th>
          <th scope="col">Neuer Status</th>
        </tr>
      </thead>
      <tbody>
        <tr>
        <th scope="row">NEU</th>
          <td>BESTÄTIGT</td>
        </tr>
        <tr>
            <th scope="row">BESTÄTIGT</th>
            <td>BEREITGESTELLT</td>
          </tr>
        </tbody>
</table><br>

<table class="table table-striped">
    <thead>
        <tr>
            <th scope="col">ID</th>
            <th scope="col">Vorname Nachname</th>
            <th scope="col">Wunschlieferdatum</th>
            <th scope="col">Gesamtpreis</th>
            <th scope="col">Status</th>
            <th scope="col">Status ändern</th>
        </tr>
    </thead>
    <tbody>
        {#each bestellungen as bestellung}
            <tr>
                <td>{bestellung.id}</td>
                <td>{bestellung.vornameName}</td>
                <td>{bestellung.wunschDatum}</td>
                <td>{bestellung.gesamtPreis}</td>
                <td>{bestellung.bestellungState}</td>
                <td
                    ><button
                        type="button"
                        class="btn btn-info"
                        on:click={() => idZumUpdaten(bestellung.id)}
                        >Status aendern</button
                    >
                </td>
            </tr>
        {/each}
    </tbody>
</table>


