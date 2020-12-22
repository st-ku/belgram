<#include "security.ftlh">

<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="/">Belgram</a>
        <ul class="navbar-nav mr-auto">
            <#if user??>
                <li class="nav-item">
                    <a class="nav-link" href="/add">Create new Record</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/logout">Logout</a>
                </li>

            <#else>
                <li class="nav-item">
                    <a class="nav-link" href="/registration">Register</a>
                </li>
                <li class="nav-item">
                    <a class="btn btn-primary" href="/login" role="button">Login</a>
                </li>

            </#if>
        </ul>

    <#if user??>

        <details>
            <summary>${name}</summary>
                <ul>
                    <li><a href="/${name}/">My profile</a></li>
                </ul>
        </details>
    </#if>

</nav>