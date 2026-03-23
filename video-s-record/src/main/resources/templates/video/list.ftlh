<#import "../layout/main.ftlh" as main>
<@main.layout "Видео">
    <h2>Видеоклипы</h2>

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
                    </div>
                </div>
            </div>
        </#list>
    </div>
</@main.layout>