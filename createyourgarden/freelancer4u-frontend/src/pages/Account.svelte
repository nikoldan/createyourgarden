<script>

    import { user } from "../store";

</script>
<h1>Account Details</h1>

<img src={$user.picture} alt="Profilbild">

<ul>
    <li>Name: {$user.name}</li>
    <li>Dein Nickname: {$user.nickname}</li>
    <li>Deine E-Mail: {$user.email}</li>
</ul>

