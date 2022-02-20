<#import "parts/common.ftlh" as c />
<#import "parts/login.ftlh" as l>
<@c.page title="Add Car">
    <@c.menu/>
    <div class="container">
        <a class="add-btn" href="/adminpanel/catalog">
            <button class="button">
                Catalog
            </button>
        </a>
        <div class="car-info">
            <form action="/adminpanel/add" enctype="multipart/form-data" method="post">
                <ul class="car-list">
                    <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                    <li><span>Марка</span>
                        <select name="brand" id="brand">
                            <#list CarBrand as brand>
                                <option value="${brand}">${brand}</option>
                            </#list>
                        </select>
                    </li>
                    <li><span>Модель</span><input required class="spec-input input" type="text" name="carModel"/></li>
                    <li><span>Год выпуска</span><input required class="spec-input input" type="number" name="year"
                                                       min="1900"
                                                       max="2022"/></li>
                    <li><span>Цена</span><input required class="spec-input input" type="number" name="price" min="0"
                                                max="90000000"/>
                    </li>
                    <li><span>Пробег</span><input required class="spec-input input" type="number" name="run" min="0"
                                                  max="1000000"/>
                    </li>
                    <li>
                        <span>Кузов</span>
                        <select name="body" id="body">
                            <#list CarBody as body>
                                <option value="${body}">${body}</option>
                            </#list>
                        </select>
                    </li>
                    <li><span>Цвет</span><input required class="spec-input input" type="text" name="color"/></li>
                    <li>
                        <span>Тип Двигаетль</span>
                        <select name="engineType" id="engineType">
                            <#list CarEngineType as engineType>
                                <option value="${engineType}">${engineType}</option>
                            </#list>
                        </select>
                    </li>
                    <li><span>Обьем Двигаетля</span><input required class="spec-input input" type="number"
                                                           name="engineVolume"
                                                           min="0" max="10"/></li>
                    <li><span>Лошадиные силы</span><input required class="spec-input input" type="number"
                                                          name="engineHp" min="0"
                                                          max="9000"/></li>
                    <li>
                        <span>Коробка</span>
                        <select name="transmission" id="transmission">
                            <#list CarTransmission as transmission>
                                <option value="${transmission}">${transmission}</option>
                            </#list>
                        </select>
                    </li>
                    <li>
                        <span>Привод</span>
                        <select name="drive" id="drive">
                            <#list CarDrive as drive>
                                <option value="${drive}">${drive}</option>
                            </#list>
                        </select>
                    </li>
                    <li>
                        <span>Руль</span>
                        <select name="wheel" id="wheel">
                            <#list CarWheel as wheel>
                                <option value="${wheel}">${wheel}</option>
                            </#list>
                        </select>
                    </li>
                    <li><span>Загрузить изображение</span><input class="input" type="file" name="file"/></li>
                    <li>
                        <h2>Комментарий</h2>
                        <textarea name="comment" id="comment" cols="100" rows="10"></textarea>
                    </li>
                </ul>
                <input class="btn" type="submit" value="Добавить машину"/>
            </form>
        </div>
    </div>
</@c.page>