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
let state = [];
getBestellState();
function getBestellungen() {
        var config = {
            method: "get",
            url: api_root + "/api/bestellung/bystate",
            headers: {Authorization: "Bearer " + $jwt_token,
                "Content-Type": "application/json",},
        };

        axios(config).then(function (response) {
            state = response.data;
        });
    }


    function getBestellState() {
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


function getBestaetigen() {
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
                alert("Hat leider nicht funktioniert. Versuche es nochmals");
                console.log(error);
            });
    }
    function getBereitgestellt() {
    var config = {
            method: "post",
            url: api_root + "/api/service/bBereitgestellt",
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

const idZumUpdaten  = (bestellung, stati) => {
    if(stati === "NEU") {
       bestellungId = bestellung;
    getBestaetigen(); 
    } else if(stati === "BESTAETIGT") {
        bestellungId = bestellung;
        getBereitgestellt();
    } else {
        alert("Status kann nicht mehr geändert werden. Falls du Hilfe brauchst, wende dich an den Admin");
    }
    
}
    getBestellungen();

    //  {JSON.stringify(state)}

</script>

<h1>Übersicht aller Bestellungen inkl. Status</h1><br>
<h3>Statusupgrades kannst du mit nur einem Klick upgraden</h3><br>
<h3>Mögliche Änderungen:</h3>

<table>
    <tr>
      <th>Status</th>
      <th>Neuer Status</th>
    </tr>
    <tr>
      <td>NEU</td>
      <td>BESTÄTIGT</td>
    </tr>
    <tr>
      <td>BESTÄTIGT</td>
      <td>BEREITGESTELLT</td>
    </tr>
  </table><br>


<ul>
{#each state as s}
    <li>Zur Zeit haben <strong>{s.count}</strong> Bestellungen den Status: {s.id}</li>
{/each}
</ul>

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
                        on:click={() => idZumUpdaten(bestellung.id, bestellung.bestellungState)}
                        >Status aendern</button
                    >
                </td>
            </tr>
        {/each}
    </tbody>
</table>


<style>
    table {
      border-collapse: collapse;
      width: 100%;
    }
    
    th, td {
      padding: 8px;
      text-align: left;
      border-bottom: 1px solid #00ACC1;
    }
    
    tr:hover {background-color: #00ACC1;}

   

    </style>
