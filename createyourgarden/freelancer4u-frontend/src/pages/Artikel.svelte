<script>
  import axios from "axios";

  const api_root = "http://localhost:8080";

  let artikels = [];
  let artikel = {};
  let standort;

  function getArtikel() {
    if (standort) {
      query += "&standort=" + standort;
    }
    var config = {
      method: "get",
      url: api_root + "/api/artikel",
      headers: {},
    };

    axios(config)
      .then(function (response) {
        artikels = response.data;
      })
      .catch(function (error) {
        alert("Could not get artikels");
        console.log(error);
      });
  }

  getArtikel();
</script>

<h1>Übersicht aller Artikel mit verschiedenen Merkmalen</h1>
<h3>Hier gibt es eine Übersicht aus unserer vielfälltigen Datenbank</h3>

<div class="row my-3">
  <div class="col">
    <label class="form-label" for="type">Standort</label>
    <select
    bind:value={artikel.standort}
    class="form-select"
    id="type"
    type="text"
>
    <option value="Sonning">Sonning</option>
    <option value="Halbschatten">Halbschatten</option>
    <option value="Schatten">Schatten</option>
</select>
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
