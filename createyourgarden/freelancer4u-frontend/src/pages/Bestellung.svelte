<script>
    import axios from "axios";
    import { querystring } from "svelte-spa-router";
    import { user } from "../store";
    import { jwt_token } from "../store";


    const api_root = "http://localhost:8080";

    let currentPage;
    let nrOfPages = 0;
    let stand;
    $: {
        let searchParams = new URLSearchParams($querystring);
        if (searchParams.has("page")) {
            currentPage = searchParams.get("page");
        } else {
            currentPage = "1";
        }
        getArtikel();
    }

    let artikels = [];
    let artikel = {};

    let warenkorb = [];

    function getArtikel() {
        let query = "pageSize=6&page=" + currentPage;
        if (stand != "empty" && stand != null && stand != "") {
            query += "&wo=" + stand;
        }

        var config = {
            method: "get",
            url: api_root + "/api/artikel?" + query,
            headers: {},
        };

        axios(config).then(function (response) {
            artikels = response.data.content;
            nrOfPages = response.data.totalPages;
        });
        
    }

    function artikelWarenkorbHinzufuegen() {
        var config = {
            method: "post",
            url: api_root + "/api/bestellung",
            headers: {
                Authorization: "Bearer " + $jwt_token,
                "Content-Type": "application/json",
            },
            data: {wunschDatum: wunschDatum, vornameName: vornameName, gesamtPreis: gesamtPreis, artikels: warenkorb},
        };

        axios(config)
            .then(function (response) {
                alert("Vielen Dank für deine Bestellung ");
            })
            .catch(function (error) {
                alert("Hat leider nicht funktioniert");
                console.log(error);
            });
    }
    const artikelHinzufuegen = (artikels) => {
      warenkorb = [...warenkorb, artikels];
      anzahlArtikel += 1;
      gesamtPreis = anzahlArtikel * 8;
    };

    function artikelEntfernen(korb) {
    if (warenkorb.length == 1) {
        warenkorb = [];
    } else {
  //      console.log(warenkorb);
        console.log(warenkorb.indexOf(korb));
        let w = warenkorb.splice(warenkorb.indexOf(korb), 1);

        warenkorb = [...warenkorb];
        console.log(warenkorb);
        console.log(w);
 //       warenkorb = warenkorb.splice(warenkorb.indexOf(korb)-1, 1);
    }
    anzahlArtikel -= 1;
    gesamtPreis -= 8;
}

    getArtikel();
let vornameName;
let wunschDatum;
let gesamtPreis = 0;
let anzahlArtikel = 0;
// 
</script>
{JSON.stringify(warenkorb)}
<h1>Hier kannst du deine Bestellung aufgeben</h1>

<form>
    <div class="mb-3">
        <label for="" class="form-label">Vor- und Nachname</label>
        <input class="form-control" type="text" bind:value={vornameName} />
    </div>
    <div class="mb-3">
        <label for="" class="form-label">Dein Wunschlieferdatum</label>
        <input class="form-control" type="text" bind:value={wunschDatum} />
    </div>
</form>

<button
    type="button"
    class="btn btn-primary"
    on:click={artikelWarenkorbHinzufuegen}>Bestellen</button
>
<br><br><br>
<div>Hier kannst du nach deinem Standort für eine einfache Bestellung filtern: <br> Heute alle Pflanzen im Sonderangebot für 8 CHF erhältlich!

</div>
<form class="mb-5">
    <div class="row mb-3" />
    <div class="row mb-3">
        <div class="col">
            <label class="form-label" for="type">Standort</label>
            <select
                bind:value={stand}
                class="form-select"
                id="type"
                type="text"
            >
                <option value="empty" />
                <option value="Sonnig">Sonnig</option>
                <option value="Halbschatten">Halbschatten</option>
                <option value="Schatten">Schatten</option>
            </select>
        </div>
    </div>
    <button type="button" class="btn btn-primary" on:click={getArtikel}
        >Suchen</button
    >
</form>

<table class="table table-striped">
    <thead>
        <tr>
            <th scope="col">Name</th>
            <th scope="col">Deutscher Name</th>
            <th scope="col">Standort</th>
            <th scope="col">Blütemonat</th>
            <th scope="col">Höhe</th>
            <th scope="col">Warenkorb hinzufügen</th>
        </tr>
    </thead>
    <tbody>
        {#each artikels as artikel}
            <tr>
                <td>{artikel.name}</td>
                <td>{artikel.dname}</td>
                <td>{artikel.standort}</td>
                <td>{artikel.bluetemonat}</td>
                <td>{artikel.hoehe}</td>
                <td
                    ><button
                        type="button"
                        class="btn btn-secondary"
                        on:click={() => artikelHinzufuegen(artikel)}
                        >Hinzufügen</button
                    ></td
                >
            </tr>
        {/each}
    </tbody>
</table>

<nav>
    <ul class="pagination">
        {#each Array(nrOfPages) as _, i}
            <li class="page-item">
                <a
                    class="page-link"
                    class:active={currentPage == i + 1}
                    href={"#/bestellung?page=" + (i + 1)}
                    >{i + 1}
                </a>
            </li>
        {/each}
    </ul>
</nav>

<div>Deine ausgewählte Artikel:</div>

<table class="table table-striped">
    <thead>
        <tr>
            <th scope="col">Name</th>
            <th scope="col">Entfernen</th>
        </tr>
    </thead>
    <tbody>
        {#each warenkorb as korb}
            <tr>
                <td>{korb.name}</td>
                <td
                ><button
                    type="button"
                    class="btn btn-secondary"
                    on:click={() => artikelEntfernen(korb)}
                    >Entfernen</button
                ></td>
        {/each}
    </tbody>
    <div>Gesamtpreis in CHF aller Artikeln aus dem Warenkorb: </div><h2>{gesamtPreis}</h2>
</table>

