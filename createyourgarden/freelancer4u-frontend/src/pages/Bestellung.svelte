<script>
    import axios from "axios";
    import { querystring } from "svelte-spa-router";
    import { user } from "../store";
    // TODO: Auth0 hinzufügen: nur für registrierte Benutzer und Admin!

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

    function getArtikel() {
        let query = "pageSize=2&page=" + currentPage;
        if ((stand != "empty") && (stand != null) && (stand != "")) {
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
        // .catch gelöscht!
    }

    function artikelHinzufügen() {
        // create Warenkorb with POST Request
        var config = {
            method: "post",
            url: api_root + "/api/warenkorb?",
            headers: {},
        }
    }

    getArtikel();
</script>

<h1>Hier kannst du deine Bestellung aufgeben</h1>
<h3>
    Für eine bessere Übersicht, filtere nach dem gewünschten Standort - viel
    Spass :-)
</h3>

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
                <option value="empty"></option>
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
            <th scope="col">ID</th>
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
                <td> <a href={"#/artikel/" + artikel.id}> {artikel.id}</a></td>
                <td>{artikel.name}</td>
                <td>{artikel.dname}</td>
                <td>{artikel.standort}</td>
                <td>{artikel.bluetemonat}</td>
                <td>{artikel.hoehe}</td>
                <td><button type="button" class="btn btn-secondary" on:click={artikelHinzufügen}>Hinzufügen</button></td>
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

<div>Text Bestellungen</div>
