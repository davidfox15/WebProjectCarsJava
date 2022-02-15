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
<#--            <ul class="car-list">-->
<#--                <li><span>Марка:</span><span>${car.brand}</span></li>-->
<#--                <li><span>Модель:</span><span>${car.model}</span></li>-->
<#--                <li><span>Год выпуска:</span><span>${car.year}</span></li>-->
<#--                            <li><span>Цена:</span><span>${price}</span></li>-->
<#--                            <li><span>Пробег:</span><span>${run}</span></li>-->
<#--                            <li><span>Кузов:</span><span>${body}</span></li>-->
<#--                            <li><span>Цвет:</span><span>${color}</span></li>-->
<#--                            <li><span>Двигаетль:</span><span>${engineType} ${engineVolume} ${engineHp}</span></li>-->
<#--                            <li><span>Комплектация:</span><span>${equipment}</span></li>-->
<#--                            <li><span>Коробка:</span><span>${gear}</span></li>-->
<#--                            <li><span>Привод:</span><span>${drive}</span></li>-->
<#--                            <li><span>Руль:</span><span>${wheel}</span></li>-->
<#--                            <li><span>Состояние:</span><span>${condition}</span></li>-->
<#--                            <li><span>Владельцы:</span><span>${numberOfOwners}</span></li>-->
<#--                <li><span>Загрузить изображение:</span><span>${car.imageName}</span></li>-->
<#--                <li><span>Дата публикациии:</span><span>${car.date}</span></li>-->
<#--                            <li>-->
<#--                                <span>Комментарий:</span>-->
<#--                                <p>${comment}</p>-->
<#--                            </li>-->
<#--                <form id="${car}" action="/delete" method="POST">-->
<#--                    <input id="id" name="id" type="hidden" value="${car.id}"/>-->
<#--                    <input type="hidden" name="_csrf" value="${_csrf.token}"/>-->
<#--                    <input class="btn" type="submit" value="Удалить машину"/>-->
<#--                </form>-->
<#--            </ul>-->
        <table>
            <thead>
            <tr>
                <th>ID</th>
                <th>Марка</th>
                <th>Модель</th>
                <th>Год</th>
                <th>Дата</th>
                <th>Пробег</th>
                <th>Двигаетль</th>
                <th>Привод</th>
                <th>Коробка</th>
                <th>Руль</th>
                <th>Кузов</th>
                <th>Картинка</th>
                <th>Цвет</th>
                <th>Комментарий</th>
            </tr>
            </thead>
            <tbody>
            <#list cars as car>
            <tr>
                <td>${car.id}</td>
                <td>${car.brand}</td>
                <td>${car.model}</td>
                <td>${car.year}</td>
                <td>${car.date}</td>
                <td>${car.run}</td>
                <td>${car.engineType}, ${car.engineVolume}л., ${car.engineHp}л.с.</td>
                <td>${car.drive}</td>
                <td><img src="images/${car.imageName}" alt="Image"></td>
                <td>${car.transmission}</td>
                <td>${car.wheel}</td>
                <td>${car.body}</td>
                <td>${car.color}</td>
                <td>${car.comment}</td>
                <td>
                    <form id="${car}" action="/delete" method="POST">
                        <input id="id" name="id" type="hidden" value="${car.id}"/>
                        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                        <input class="btn" type="submit" value="Удалить машину"/>
                    </form>
                </td>
            </tr>
            </#list>
            </tbody>
        </table>
    </div>
</@c.page>