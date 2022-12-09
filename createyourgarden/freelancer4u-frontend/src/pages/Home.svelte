<script>
import axios from "axios";
import { user } from "../store";
import { jwt_token } from "../store";

const token = "Epyern6KKYyXOZq3BwkFeROaOqExOV";

let plants = [];

function getPlant() {
    var config = {
      method: "get",
      url: "https://open.plantbook.io/api/v1/plant/detail/acer buergerianum/",
      headers: {Authorization: token},
    };

    axios(config)
      .then(function (response) {
        plants = response.data.content;
      })
	}

getPlant();

// <video src="Apfelmp4.mp4" muted autoplay loop />

</script>

<h1>Welcome to Create Your Garden</h1>

{JSON.stringify(plants)}



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

	video {
		max-width: 1200px;

	}

</style>
