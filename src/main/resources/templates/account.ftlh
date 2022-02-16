<#import "parts/common.ftlh" as c>
<@c.page title="Account">
    <@c.header/>
    <@c.menu/>
    <div class="container">
        <h1>Hello, ${user.username}!</h1>
        <#if isAdmin??>
            <a href="/adminpanel/catalog">Admin Panel</a>
        </#if>
    </div>
</@c.page>