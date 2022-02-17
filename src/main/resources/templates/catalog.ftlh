<#import "parts/common.ftlh" as c>

<@c.page title="Catalog">
    <@c.header/>
    <@c.menu/>

    <div class="container">
        <#--Filter-->
        <form action="/catalog" method="post">
            <div class="filter">
                <div class="filter-params">
                    <div class="filter-col">
                        Тип двигателя
                        <#list carEngineTypes as carEngineType>
                            <div>
                                <input type="checkbox" id="${carEngineType}" name="${carEngineType}"/>
                                <label for="${carEngineType}">${carEngineType}</label>
                            </div>
                        </#list>
                    </div>
                    <div class="filter-col">
                        Тип привода
                        <#list carDrives as carDrive>
                            <div>
                                <input type="checkbox" id="${carDrive}" name="${carDrive}">
                                <label for="${carDrive}">${carDrive}</label>
                            </div>
                        </#list>
                    </div>
                    <div class="filter-col">
                        Мощность двигателя
                        <div>от <input type="number" name="engineHPmin" min="50" max="1000"/></div>
                        <div>до <input type="number" name="engineHPmax" min="50" max="1000"/></div>
                    </div>
                    <div class="filter-col">
                        Год выпуска
                        <div>с <input type="number" name="yearMin" min="1900" max="2022"/></div>
                        <div>по <input type="number" name="yearMax" max="2022" min="1900"/></div>
                    </div>
                    <div class="filter-col">
                        Цвет
                        <input type="text" name="color"/>
                    </div>
                </div>
                <input type="hidden" name="_csrf" value="${_csrf.token}" />
                <input class="btn" type="submit" value="Применить"/>
            </div>
        </form>
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
