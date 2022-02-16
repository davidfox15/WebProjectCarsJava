<#import "parts/common.ftlh" as c>
<@c.page title="${car.brand}">
    <@c.header/>
    <@c.menu/>

    <div class="container">
        <!-- Car Page -->
        <div class="car-header">
            <div>
                <h1>${car.brand} ${car.model}</h1>
                <div>${car.date}</div>
            </div>
            <div>
                <h1>Временная цена</h1>
            </div>
        </div>
        <div class="car-info">
            <ul class="car-list">
                <li><span>Год выпуска</span><span>${car.year?string.computer}</span></li>
                <li><span>Пробег</span><span>${car.run}</span></li>
                <li><span>Кузов</span><span>${car.body}</span></li>
                <li><span>Цвет</span><span>${car.color}</span></li>
                <li>
                    <span>Двигаетль</span><span>${car.engineVolume}л. / ${car.engineHp} л.с. / ${car.engineType}</span>
                </li>
                <li><span>Коробка</span><span>${car.transmission}</span></li>
                <li><span>Привод</span><span>${car.drive}</span></li>
                <li><span>Руль</span><span>${car.wheel}</span></li>
            </ul>
            <#if car.imageName??>
            <img class="car-img" src="/img/${car.imageName}" alt="Car Img"/>
            </#if>
        </div>
        <div class="car-comment">
            <h2>Комментарий продавца</h2>
            ${car.comment}
        </div>
    </div>
</@c.page>