<#import "parts/common.ftlh" as c>
<#import "parts/login.ftlh" as l>

<@c.page title="Login">
    <@c.header/>
    <@c.menu/>
    <div class="container">
        <div class="user-form">
            <h1>Registration</h1>
            <@l.registration/>
        </div>
    </div>
</@c.page>
