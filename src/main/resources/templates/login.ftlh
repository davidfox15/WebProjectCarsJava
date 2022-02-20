<#import "parts/common.ftlh" as c>
<#import "parts/login.ftlh" as l>

<@c.page title="Login">
    <@c.header/>
    <@c.menu/>
    <div class="container">
        <div class="user-form">
            <h1>Login</h1>
            <@l.login/>
            <a href="/registration">Registration</a>
        </div>
    </div>
</@c.page>
