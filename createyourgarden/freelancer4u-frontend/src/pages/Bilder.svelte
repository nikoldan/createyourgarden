<script>
	import axios from "axios";
	import { user } from "../store";

	let plants = [];

	function getPlant() {
		const config = {
			method: "GET",
			url: "https://house-plants2.p.rapidapi.com/",
			headers: {
				"X-RapidAPI-Key":
					"0fec2cc3bbmshddf3bd464ba2e2cp1a99eejsn0ce4934c424d",
				"X-RapidAPI-Host": "house-plants2.p.rapidapi.com",
			},
		};
		axios(config).then(function (response) {
			plants = response.data;
		});
	}

	getPlant();
	// {JSON.stringify(plants)}

</script>

<h1>Hier findest du eine Vielzahl von Bildern</h1>

<table class="table table-striped">
	<thead>
		<tr>
			<th scope="col">ID</th>
			<th scope="col">Latin name</th>
			<th scope="col">Kategorie</th>
			<th scope="col">Bild</th>
		</tr>
	</thead>
	<tbody>
		{#each plants as plant}
			<tr>
				<td>{plant.id}</td>
				<td>{plant["Latin name"]}</td>
				<td>{plant.Categories}</td>
				<td> <img src={plant.img} alt="Link zum Bild" /></td>
			</tr>
		{/each}
	</tbody>
</table>

<style>
	:global(body) {
		background-color: #f2eee2;
		color: #0084f6;
		transition: background-color 0.3s;
	}
	:global(body.dark-mode) {
		background-color: #1d3040;
		color: #bfc2c7;
	}
</style>
