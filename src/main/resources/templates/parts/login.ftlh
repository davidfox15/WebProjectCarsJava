<#macro login>
    <form class="user-form" action="/login" method="post">
        <label> User Name : <input type="text" name="username"/> </label>
        <label> Password: <input type="password" name="password"/> </label>
        <input type="hidden" name="_csrf" value="${_csrf.token}" />
        <input type="submit" value="Log In"/>
    </form>
</#macro>

<#macro registration>
    <form class="user-form" action="/registration" method="post">
        <label> User Name : <input type="text" name="username"/> </label>
        <label> Password: <input type="password" name="password"/> </label>
        <label> Name: <input type="text" name="firstName"/> </label>
        <label> Last Name: <input type="text" name="lastName"/> </label>
        <label> Age: <input type="number" name="age"/> </label>
        <label> Mail: <input type="email" name="mail"/> </label>
        <input type="hidden" name="_csrf" value="${_csrf.token}" />
        <input type="submit" value="Sign In"/>
    </form>
</#macro>

<#macro logout>
    <form action="/logout" method="post">
        <input type="hidden" name="_csrf" value="${_csrf.token}" />
        <input class="btn" type="submit" value="Sign Out"/>
    </form>
</#macro>