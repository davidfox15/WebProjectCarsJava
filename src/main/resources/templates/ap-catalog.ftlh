<#import "parts/common.ftlh" as c>
<#import "parts/login.ftlh" as l>
<@c.page title="Catalog">
    <@c.menu/>
    <div class="container">
        <h1 class="h1-catalog">Catalog</h1>
        <div class="car-info">
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
                    <th>Цвет</th>
                    <th>Картинка</th>
                    <th>Комментарий</th>
                </tr>
                </thead>
                <tbody>
                <#list cars as car>
                    <tr>
                        <td>${car.id}</td>
                        <td>${car.brand}</td>
                        <td>${car.model}</td>
                        <td>${car.year?string.computer}</td>
                        <td>${car.date}</td>
                        <td>${car.run}</td>
                        <td>${car.engineType}, ${car.engineVolume}л., ${car.engineHp}л.с.</td>
                        <td>${car.drive}</td>
                        <td>${car.transmission}</td>
                        <td>${car.wheel}</td>
                        <td>${car.body}</td>
                        <td>${car.color}</td>
                        <td>
                            <#if car.imageName??>
                                <img class="ap-catalog-img" src="/img/${car.imageName}" alt="Image">
                            </#if>
                        </td>
                        <td>${car.comment}</td>
                        <td>
                            <form id="${car}" action="/adminpanel/delete" method="POST">
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
        <a class="add-btn" href="/adminpanel/add">
            <button class="btn">
                Add car
            </button>
        </a>
    </div>
</@c.page>