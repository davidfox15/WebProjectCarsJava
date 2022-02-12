<#import "parts/common.ftlh" as c />
<#import "parts/login.ftlh" as l>
<@c.page title="Add Car">
    <@l.logout/>
    <div>
        <a href="/catalog">Catalog</a>
    </div>
    <div class="car-info">
        <form action="add-car" enctype="multipart/form-data" method="post">
            <ul class="car-list">
                <input type="hidden" name="_csrf" value="${_csrf.token}" />
                <li><span>Марка</span><input class="spec-input input" type="text" name="brand"/></li>
                <li><span>Модель</span><input class="spec-input input" type="text" name="carModel"/></li>
                <li><span>Год выпуска</span><input class="spec-input input" type="number" name="year"/></li>
<#--                <li><span>Цена</span><input class="spec-input input" type="number" name="price"/></li>-->
<#--                <li><span>Пробег</span><input class="spec-input input" type="text" name="run"/></li>-->
<#--                <li><span>Кузов</span><input class="spec-input input" type="text" name="body"/></li>-->
<#--                <li><span>Цвет</span><input class="spec-input input" type="text" name="color"/></li>-->
<#--                <li><span>Тип Двигаетль</span><input class="spec-input input" type="text" name="engineType"/></li>-->
<#--                <li><span>Обьем Двигаетля</span><input class="spec-input input" type="number" name="engineVolume"/></li>-->
<#--                <li><span>Лошадиные силы</span><input class="spec-input input" type="number" name="engineHp"/></li>-->
<#--                <li><span>Комплектация</span><input class="spec-input input" type="number" name="equipment"/></li>-->
<#--                <li><span>Коробка</span><input class="spec-input input" type="text" name="gear"/></li>-->
<#--                <li><span>Привод</span><input class="spec-input input" type="text" name="drive"/></li>-->
<#--                <li><span>Руль</span><input class="spec-input input" type="text" name="wheel"/></li>-->
<#--                <li><span>Состояние</span><input class="spec-input input" type="text" name="condition"/></li>-->
<#--                <li><span>Владельцы</span><input class="spec-input input" type="number" name="numberOfOwners"/></li>-->
                <li><span>Загрузить изображение</span><input class="input" type="file" name="file"/></li>
<#--                <li>-->
<#--                    <h2>Комментарий</h2>-->
<#--                    <textarea name="comment" id="comment" cols="100" rows="10"></textarea>-->
<#--                </li>-->
            </ul>
            <input class="btn" type="submit" value="Добавить машину"/>
        </form>
    </div>
</@c.page>