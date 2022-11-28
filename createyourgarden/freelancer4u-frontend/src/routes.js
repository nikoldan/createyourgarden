
import Home from "./pages/Home.svelte";
import Freelancers from "./pages/Artikel.svelte";
import Bestellung from "./pages/Bestellung.svelte";
import Artikel from "./pages/Artikel.svelte";

export default {
    '/': Home,
    '/home': Home,
    '/artikel': Artikel,

    '/bestellung': Bestellung,
}