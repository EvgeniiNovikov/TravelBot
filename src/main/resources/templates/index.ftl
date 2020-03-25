<h10>Города:</h10>
<#list cities! as city>
    <div><a href="/cities/${city.id}">${city.name}</a></div>
</#list>
<br/>
<div>
    <a href="/cities/add">Add city</a>
</div>
