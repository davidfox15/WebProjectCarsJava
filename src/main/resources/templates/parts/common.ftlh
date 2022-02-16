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
            <div class="search">
                    <input type="text" name="" class="input input-search" placeholder=""/>
                    <button class="button" id="search-button">
                        <span>Поиск</span>
                    </button>
            </div>
            <form action="/login">
                <button class="button button-primary" name="">
                    <img class="button-icon" src="/static/person.svg" alt="person"/>
                    <span>Войти</span>
                </button>
            </form>
        </header>
    </div>
</#macro>