<#import "../layout/main.ftlh" as main>
<@main.layout "${track.title}">
    <div class="row">
        <div class="col-md-4">
            <#if track.coverUrl??>
                <img src="${track.coverUrl}" class="img-fluid">
            <#else>
                <img src="https://via.placeholder.com/300" class="img-fluid">
            </#if>
        </div>
        <div class="col-md-8">
            <h2>${track.title}</h2>
            <h4>${track.artist}</h4>
            <p><strong>Альбом:</strong> ${track.album!""}</p>
            <p><strong>Жанр:</strong> ${track.genre!""}</p>
            <p><strong>Длительность:</strong> ${(track.duration!0)/60} мин ${(track.duration!0)%60} сек</p>

            <h4 class="mt-4">Аудиоплеер</h4>
            <audio controls class="w-100">
                <source src="${track.audioUrl}" type="audio/mpeg">
                Ваш браузер не поддерживает аудио
            </audio>

            <a href="/tracks" class="btn btn-secondary mt-3">Назад</a>
        </div>
    </div>
</@main.layout>