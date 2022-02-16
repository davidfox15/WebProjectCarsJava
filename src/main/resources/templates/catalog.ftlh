<#import "parts/common.ftlh" as c>

<@c.page title="Login">
    <!-- Header  -->
    <@c.header/>
    <div class="container">
        <!-- Navigation anf Filter -->
        <div class="menu">
            <a href="/main">Главная страница</a>
            <a href="/catalog">Каталог</a>
            <a href="/info">О нас</a>
        </div>
        <hr class="underline"/>
        <!-- Catalog -->
        <#list cars as car>
        <a class="card" href="">
            <#if car.imageName??>
                <img class="card-img" src="/img/${car.imageName}" alt="Image">
            </#if>
            <div class="card-info">
                <h2>${car.brand} ${car.model}</h2>
                <div class="card-specs">
                    <div class="card-specs-column">
                        <div>${car.engineVolume} л. / ${car.engineHp} л.с. / ${car.engineType}</div>
                        <div>${car.body}</div>
                        <div>${car.transmission}</div>
                    </div>
                    <div class="card-specs-column">
                        <div>${car.run}</div>
                        <div>${car.drive}</div>
                    </div>
                </div>
            </div>
            <div class="card-info">
                <h2 class="text-center">${car.year}</h2>
                <div class="text-center">Новая</div>
            </div>
        </a>
        </#list>
    </div>
</@c.page>
