<#assign unauthorized='Bob'>
<#if person.name == unauthorized>
    Unauthorized person
<#else>
    Welcome ${person.name?upper_case}

    E-mail: ${person.email}
    Domain: ${person.email?split('@')[1]}
    Length of Name: ${person.name?length}
    Is Mature: <#if (person.age > 18) >true<#else>false</#if>
    Registration Date: ${person.registrationDate?string("dd.MM.yyyy, HH:mm")}
</#if>

<#assign count = 5>
<#list 1..count as number>
    <#if number == 3>
        ${number}: ${number?switch(number, "letter")}
    <#else>
        ${number}: ${number?upper_abc}
    </#if>
</#list>
