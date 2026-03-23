<#import "../layout/main.ftlh" as main>
<@main.layout "${video.title}">
    <div class="row">
        <div class="col-md-8 mx-auto">
            <h2>${video.title}</h2>
            <h4>${video.artist}</h4>

            <div class="ratio ratio-16x9 mt-3">
                <iframe src="${video.embedUrl}"
                        frameborder="0"
                        allowfullscreen>
                </iframe>
            </div>

            <a href="/videos" class="btn btn-secondary mt-3">Назад</a>
        </div>
    </div>
</@main.layout>