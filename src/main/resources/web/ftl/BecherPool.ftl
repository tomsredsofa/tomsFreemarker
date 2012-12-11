<h1>Becherpool</h1>
<#assign inventory = becherPool.simpleSortedInventory>
<#if inventory??>
    <p>Es gibt noch Becher!.</p>

    <table border="1">
        <tr>
            <th>Kaffee Groesse</th>
            <th>Anzahl</th>
        </tr>
    <#assign kaffeeGroessen = inventory?keys>
    <#list kaffeeGroessen as kaffeeGroesse>
        <tr>
            <td id="KaffeeGroesse_${kaffeeGroesse_index}">${kaffeeGroesse}</td>
            <td id="Anzahl_${kaffeeGroesse_index}">${inventory[kaffeeGroesse]}</td>
        </tr>
    </#list>
    </table>

<#else>
    <p>BecherPool ist empty.</p>
</#if>