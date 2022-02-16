<#import "parts/common.ftlh" as c>

<@c.page title="Login">
    <@c.header/>
    <@c.menu/>

    <div class="container">
        <!-- Catalog -->
        <#list cars as car>
        <a class="card" href="catalog/${car.id}">
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
                <h2 class="text-center">${car.year?string.computer}</h2>
                <div class="text-center">Новая</div>
            </div>
        </a>
        </#list>
    </div>
</@c.page>
