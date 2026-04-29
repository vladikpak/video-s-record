<#import "../layout/main.ftlh" as main>
<@main.layout "Видео">
    <h2>Видеоклипы</h2>

    <form action="/videos/search" method="get" class="mb-4">
        <div class="input-group">
            <input type="text" name="title" class="form-control" placeholder="Поиск по названию...">
            <button type="submit" class="btn btn-primary">Найти</button>
        </div>
    </form>

    <div class="input-group">Найдено ${count!0} шт</div>

    <div class="row">
        <#list videos as video>
            <div class="col-md-4 mb-4">
                <div class="card h-100">
                    <#if video.thumbnailUrl??>
                        <img src="${video.thumbnailUrl}" class="card-img-top" style="height: 200px; object-fit: cover;">
                    <#else>
                        <img src="https://img.youtube.com/vi/${video.embedUrl?split('/')?last}/0.jpg" class="card-img-top" style="height: 200px;">
                    </#if>
                    <div class="card-body">
                        <h5 class="card-title">${video.title}</h5>
                        <p class="card-text">${video.artist}</p>
                        <a href="/videos/${video.id}" class="btn btn-primary">Смотреть</a>
                        <a href="/tracks/${video.id}/edit" class="btn btn-primary">Редактировать</a>
                        <form action="/videos/${video.id}/delete" method="post" style="display:inline">
                            <button type="submit" class="btn btn-sm btn-danger">Удалить</button>
                        </form>
                    </div>
                </div>
            </div>
        </#list>
    </div>
</@main.layout>