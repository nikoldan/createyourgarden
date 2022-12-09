<script>

import axios from "axios";

    import { user } from "../store";
    import { jwt_token } from "../store";

    const api_root = "http://localhost:8080";


let bestellungen = [];
let bestellung = {};

function getBestellungen() {

        var config = {
            method: "get",
            url: api_root + "/api/bestellung?",
            headers: {},
        };

        axios(config).then(function (response) {
            bestellungen = response.data.content;
        });
        
    }

function statusAendern() {

}




    getBestellungen();

</script>

<h1>Übersicht aller Bestellungen inkl. Status</h1>

<table class="table table-striped">
    <thead>
        <tr>
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
                <td>{bestellung.vornameName}</td>
                <td>{bestellung.wunschDatum}</td>
                <td>{bestellung.gesamtPreis}</td>
                <td>{bestellung.bestellungState}</td>
                <td
                    ><button
                        type="button"
                        class="btn btn-secondary"
                        on:click={() => statusAendern(bestellung)}
                        >Status aendern</button
                    ></td
                >
            </tr>
        {/each}
    </tbody>
</table>


