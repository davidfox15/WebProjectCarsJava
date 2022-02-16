<#import "parts/common.ftlh" as c>
<#import "parts/login.ftlh" as l>

<@c.page title="Login">
    <@c.header/>
    <@c.menu/>
    <div class="container">
        <h1>Login</h1>
        <@l.login path="/login"/>
        <a href="/registration">Registration</a>
    </div>
</@c.page>
