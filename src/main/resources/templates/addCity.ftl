${response!}
<form action="/cities/add" method="post">
    <label>City:
        <div>
            <input type="text" name="name"/>
        </div>
    </label>
    <label>Город:
        <div>
            <input type="text" name="subName"/>
        </div>
    </label>
    <label>Описание:
        <div>
            <input type="text" size="100" name="description"/>
        </div>
    </label>
    <br/>
    <div>
        <button type="submit">Add city</button>
    </div>
</form>

<div>
    <a href="/cities">Города</a>
</div>