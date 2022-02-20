<#import "parts/common.ftlh" as c>
<#import "parts/login.ftlh" as l>
<@c.page title="Account">
    <@c.header/>
    <@c.menu/>
    <div class="container">
        <div class="user-form">
            <h1>Hello, ${user.username}!</h1>
            <labe>Name: ${user.firstName}</labe>
            <labe>Last Name: ${user.lastName}</labe>
            <labe>Age: ${user.age}</labe>
            <labe>Mail: ${user.mail}</labe>
            <labe>Role: <#list user.roles as role>${role}<#sep><br></#list></labe>
            <@l.logout/>
            <#if isAdmin>
                <a href="/adminpanel/catalog">Admin Panel</a>
            </#if>
        </div>
    </div>
</@c.page>