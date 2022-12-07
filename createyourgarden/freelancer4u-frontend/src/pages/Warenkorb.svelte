<script>
    import axios from "axios";
    import { querystring } from "svelte-spa-router";
    import { user } from "../store";

    const api_root = "http://localhost:8080";

    let warenkorbs = [];
    let warenkorb = {};

    function getWarenkorb() {
        if (warenkorb.korb != null) {
        var config = {
            method: "get",
            url: api_root + "/api/warenkorb",
            headers: {},
        }};

        axios(config)
            .then(function (response) {
                warenkorbs = response.data;
                
            })

    }

    getWarenkorb();


</script>

<h1>Hallo {$user.nickname}</h1>
<h2>Hier findest du deinen aktueller Warenkorb</h2>



<table class="table">
    <thead>
        <tr>
            <th scope="col">Artikel</th>
            <th scope="col">KundenId</th>
            <th scope="col">Anzahl Artikel</th>
            <th scope="col">Gesamtpreis in CHF</th>
        </tr>
    </thead>
    <tbody>
        {#each warenkorbs as warenkorb}
            <tr>
                <td>{warenkorb.korb}</td>
                <td>{warenkorb.kundenId}</td>
                <td>{warenkorb.anzahlArtikel}</td>
                <td>{warenkorb.gesamtPreis}</td>
            </tr>
        {/each}
    </tbody>
</table>