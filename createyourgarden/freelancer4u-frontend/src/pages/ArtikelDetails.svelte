<script>
    import axios from "axios";
    const api_root = "http://localhost:8080";

    export let params = {};

    let id;

    $: {
        id = params.id;
        getArtikel();
    }

    let artikels = {};

    function getArtikel() {
        var config = {
            method: "get",
            url: api_root + "/api/artikel/" + id,
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

</script>

<body>
    <style>
    body {background-color: #D7EFF2;}

.faa-btn {
    background-color: none;
    color: darkblue;
    padding: 15px 25px;
    text-decoration: none;
}

    </style>
<div class="mb-5">
    <h1 class="mt-3">Detailansicht für: {artikels.name}</h1>
    <p><b>Deutscher Name:</b> {artikels.dname}</p>
    <p><b>Beschreibung:</b> {artikels.beschreibung}</p>
    <p><b>Standort:</b> {artikels.standort}</p>
    <p><b>Blütemonat:</b> {artikels.bluetemonat}</p>
    <p><b>Höhe in Zentimeter:</b> {artikels.hoehe}</p>
</div>



</body>