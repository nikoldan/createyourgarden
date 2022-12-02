<script>
  import axios from "axios";
  import { querystring } from "svelte-spa-router";

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
    let query = "pageSize=6&page=" + currentPage;
    if (stand) {
      query += "&wo=" + stand;
    }
    var config = {
      method: "get",
      url: api_root + "/api/artikel?" + query,
      headers: {},
    };

    axios(config)
      .then(function (response) {
        artikels = response.data.content;
        nrOfPages = response.data.totalPages;
      })
      // .catch gelöscht!
  }

  getArtikel();
</script>

<h1>Übersicht aller Artikel mit verschiedenen Merkmalen</h1>
<h3>Hier gibt es eine Übersicht aus unserer vielfälltigen Datenbank</h3>

<div class="row my-3">
  <div class="col-auto">
    <label for="" class="col-form-label">Standort: </label>
  </div>
  <div class="col-3">
    <input
      class="form-control"
      type="text"
      placeholder="Sonnig"
      bind:value={stand}
    />
  </div>
  <div class="col-3">
    <button class="btn btn-primary" on:click={getArtikel}>Suchen</button>
  </div>
</div>

<table class="table table-striped">
  <thead>
    <tr>
      <th scope="col">ID</th>
      <th scope="col">Name</th>
      <th scope="col">Deutscher Name</th>
      <th scope="col">Standort</th>
      <th scope="col">Blütemonat</th>
      <th scope="col">Höhe</th>
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
          href={"#/artikel?page=" + (i + 1)}
          >{i + 1}
        </a>
      </li>
    {/each}
  </ul>
</nav>

