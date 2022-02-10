<#macro page title>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>${title}</title>
</head>
<body>
<#nested>
</body>
</html>
</#macro>
<#-- Можно добавить значение которое будет храниться в этом шаблооне под названием val -->
<#-- <#assign val = "BigPig"> -->