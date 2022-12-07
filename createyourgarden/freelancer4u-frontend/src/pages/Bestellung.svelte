<script>
    import axios from "axios";
    import { querystring } from "svelte-spa-router";
    import { user } from "../store";
    import { jwt_token } from "../store";
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

/* 

    let warenkorb = {
    korb: [
        {
            id: "8888",
            name: "mitPostman",
            beschreibung: "bescheeee",
            preis: 4,
            standort: "Sonnig",
            bluetemonat: 2,
            hoehe: 33,
            dname: "dmiiii",
        },
    ]};

    let korb = [];
*/

    let warenkorb = {
        korb: [],
    }
    function getArtikel() {
        let query = "pageSize=2&page=" + currentPage;
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
        // .catch gelöscht!
    }

    function artikelWarenkorbHinzufügen() {
        var config = {
            method: "post",
            url: api_root + "/api/warenkorb",
            headers: {
                Authorization: "Bearer " + $jwt_token,
                "Content-Type": "application/json",
            },
            data: warenkorb,
        };

        axios(config)
            .then(function (response) {
                alert("in Warenkorb hinzugefügt");
            })
            .catch(function (error) {
                alert("Hat leider nicht funktioniert");
                console.log(error);
            });
    }
    const artikelHinzufügen = (artikels) => {
      warenkorb.korb.push(artikels);
    };

    getArtikel();

  
</script>

<h1>Hier kannst du deine Bestellung aufgeben</h1>

<button
    type="button"
    class="btn btn-primary"
    on:click={artikelWarenkorbHinzufügen}>Bestellen</button
>

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
                        on:click={() => artikelHinzufügen(artikel)}
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


<button
    type="button"
    class="btn btn-success"
    on:click={artikelWarenkorbHinzufügen}>Warenkorb</button
>

