<?xml version="1.0" encoding="UTF-8"?>
<document>
    <title>${title}</title>
    <author>${author.name} (${author.email})</author>

    <description>${description}</description>

    <items>
        <#list items as item>
        <item>
            <name>${item.name}</name>
            <quantity>${item.quantity}</quantity>
            <price>${item.price}</price>
        </item>
        </#list>
    </items>
</document>