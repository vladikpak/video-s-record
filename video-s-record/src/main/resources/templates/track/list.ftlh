<#import "../layout/main.ftlh" as main>
<@main.layout "Треки">
    <h2>Музыкальная коллекция</h2>

    <form action="/tracks/search" method="get" class="mb-4">
        <div class="input-group">
            <input type="text" name="artist" class="form-control" placeholder="Поиск по исполнителю...">
            <button type="submit" class="btn btn-primary">Найти</button>
        </div>
    </form>

    <div class="input-group">Найдено ${count!0} шт</div>


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

                        <form action="/tracks/${track.id}/delete" method="post" style="display:inline">
                            <button type="submit" class="btn btn-sm btn-danger">Удалить</button>
                        </form>
                    </div>
                </div>
            </div>
        </#list>
    </div>

    <#if totalPages?? && totalPages gt 1>
        <div class="d-flex justify-content-between align-items-center mt-4">
            <div>
            <span class="text-muted">
                Показано ${tracks?size} из ${count} треков
            </span>
            </div>

<#--        ${tracks?size} - {это текущая страница} -->

            <div class="btn-group">
<#--                <#if currentPage gt 0> - альтернатива hasPrevious() -->
                <#if Previous>
                    <a href="?page=${currentPage - 1}" class="btn btn-outline-primary">
                        ← Назад
                    </a>
                </#if>

                <button class="btn btn-primary" disabled>
<#--                    страница [ 1 / ... ] -->
                    ${currentPage + 1} / ${totalPages}
                </button>

<#--                <#if currentPage + 1 < totalPages> - альтернатива hasNext() -->
                    <#if Next>
                    <a href="?page=${currentPage + 1}" class="btn btn-outline-primary">
                        Вперёд →
                    </a>
                </#if>
            </div>
        </div>
    </#if>

</@main.layout>