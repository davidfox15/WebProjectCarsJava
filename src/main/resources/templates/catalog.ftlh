<#import "parts/common.ftlh" as c>
<#import "parts/login.ftlh" as l>
<@c.page title="Catalog">
    HI MY NAYBORS
    <@l.logout/>
    <div>
        <a href="/add-car">ADD</a>
    </div>
    Catalog
    <div class="car-info">
        <#list cars as car>
        <ul class="car-list">
            <li><span>Марка:</span><span>${car.brand}</span></li>
            <li><span>Модель:</span><span>${car.model}</span></li>
            <li><span>Год выпуска:</span><span>${car.year}</span></li>
<#--            <li><span>Цена:</span><span>${price}</span></li>-->
<#--            <li><span>Пробег:</span><span>${run}</span></li>-->
<#--            <li><span>Кузов:</span><span>${body}</span></li>-->
<#--            <li><span>Цвет:</span><span>${color}</span></li>-->
<#--            <li><span>Двигаетль:</span><span>${engineType} ${engineVolume} ${engineHp}</span></li>-->
<#--            <li><span>Комплектация:</span><span>${equipment}</span></li>-->
<#--            <li><span>Коробка:</span><span>${gear}</span></li>-->
<#--            <li><span>Привод:</span><span>${drive}</span></li>-->
<#--            <li><span>Руль:</span><span>${wheel}</span></li>-->
<#--            <li><span>Состояние:</span><span>${condition}</span></li>-->
<#--            <li><span>Владельцы:</span><span>${numberOfOwners}</span></li>-->
            <li><span>Загрузить изображение:</span><span>${car.imageName}</span></li>
            <li><span>Дата публикациии:</span><span>${car.date}</span></li>
<#--            <li>-->
<#--                <span>Комментарий:</span>-->
<#--                <p>${comment}</p>-->
<#--            </li>-->
            </#list>
        </ul>
    </div>
</@c.page>