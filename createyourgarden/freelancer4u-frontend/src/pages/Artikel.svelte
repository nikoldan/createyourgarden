<script>
    import axios from "axios";

    const api_root = "http://localhost:8080";

    
  let artikels = [];
  let artikel = {
    
  }

    function getArtikel() {
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
              <td>
                <a href={"#/artikel/" + artikel.id}> {artikel.id}</a></td>
                <td>{artikel.name}</td>
                <td>{artikel.dname}</td>
                <td>{artikel.standort}</td>
                <td>{artikel.bluetemonat}</td>
                <td>{artikel.hoehe}</td>
            </tr>
        {/each}
    </tbody>
</table>


