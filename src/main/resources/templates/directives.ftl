<#list persons as person>
    <#if (person.age >= 18)>
        Description: You are mature
        Person name: ${person.name}
        Person age: ${person.age}
    <#else>
        Description: You are minor at age ${person.age}
    </#if>
</#list>
