
<#if city??>
    <div>City: ${city.name}</div>
    <div>Город: ${city.subName}</div>
    <div>Описание: ${city.description}</div>
    <br/>

    <form action="/cities/${city.id}" method="post">
        <label>
            <div><input type="hidden" name="id"/></div>
        </label>
        <label>Enter city:
            <div>
                <input type="text" name="name"/>
            </div>
        </label>
        <label>Введите город:
            <div>
                <input type="text" name="subName"/>
            </div>
        </label>
        <label>Введите новое описание:
            <div>
                <input type="text" size="100" name="description"/>
            </div>
        </label>
        <br/>
        <div>
            <button type="submit">Edit city</button>
        </div>
    </form>
    <form action="/cities/${city.id}/delete" method="post">
        <button type="submit">Delete</button>
    </form>
</#if>

<div>
    <a href="/cities">Города</a>
</div>