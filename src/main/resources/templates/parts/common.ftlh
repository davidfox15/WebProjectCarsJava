<#macro page title>
    <!DOCTYPE html>
    <html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>${title}</title>
        <link rel="stylesheet" href="/static/style.css">
        <link rel="stylesheet" href="/static/normalize.css">
        <link rel="stylesheet" href="/static/bootstrap.css">
    </head>
    <body>
    <#nested>
    </body>
    </html>
</#macro>
<#-- Можно добавить значение которое будет храниться в этом шаблооне под названием val -->
<#-- <#assign val = "BigPig"> -->
<#macro header>
    <div class="container">
        <header class="header">
            <a href="/">
                <img src="/static/car-logo.svg" alt="Cars Market" class="logo"/>
            </a>
            <form action="/search" method="post">
                <div class="search">
                    <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                    <#if lastSearch??>
                        <input type="text" name="searchName" class="input input-search" value="${lastSearch}"/>
                    <#else>
                        <input type="text" name="searchName" class="input input-search" placeholder=""/>
                    </#if>
                    <input type="submit" class="button" value="Поиск">
                </div>
            </form>
            <form action="/account">
                <button class="button button-primary" name="">
                    <img class="button-icon" src="/static/person.svg" alt="person"/>
                    <span>Аккаунт</span>
                </button>
            </form>
        </header>
    </div>
</#macro>

<#macro menu>
    <div class="container">
        <div class="menu">
            <a href="/">Главная страница</a>
            <a href="/catalog">Каталог</a>
            <a href="/about">О нас</a>
        </div>
        <hr class="underline"/>
    </div>
</#macro>