<#import "../layout/main.ftlh" as main>
<@main.layout "Треки">
    <h2>Музыкальная коллекция</h2>

    <form action="/tracks/search" method="get" class="mb-4">
        <div class="input-group">
            <input type="text" name="artist" class="form-control" placeholder="Поиск по исполнителю...">
            <button type="submit" class="btn btn-primary">Найти</button>
        </div>
    </form>

    <div class="row">
        <#list tracks as track>
            <div class="col-md-3 mb-4">
                <div class="card h-100">
                    <#if track.coverUrl??>
                        <img src="${track.coverUrl}" class="card-img-top" style="height: 200px; object-fit: cover;">
                    <#else>
                        <img src="https://via.placeholder.com/300" class="card-img-top" style="height: 200px;">
                    </#if>
                    <div class="card-body">
                        <h5 class="card-title">${track.title}</h5>
                        <p class="card-text">${track.artist}</p>
                        <p class="card-text"><small>${track.album!""}</small></p>
                        <a href="/tracks/${track.id}" class="btn btn-primary">Слушать</a>
                    </div>
                </div>
            </div>
        </#list>
    </div>
</@main.layout>