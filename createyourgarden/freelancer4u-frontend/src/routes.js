
import Home from "./pages/Home.svelte";
// import Freelancers from "./pages/Artikel.svelte";
import Bestellung from "./pages/Bestellung.svelte";
import Artikel from "./pages/Artikel.svelte";
import ArtikelDetails from "./pages/ArtikelDetails.svelte"
import Accounts from "./pages/Account.svelte";
import UebersichtBestellungen from "./pages/UebersichtBestellungen.svelte";

export default {
    '/': Home,
    '/home': Home,
    '/artikel': Artikel,
    '/artikel/:id': ArtikelDetails,

    '/bestellung': Bestellung,
    '/account': Accounts,
    '/uebersichtbestellungen': UebersichtBestellungen,
}