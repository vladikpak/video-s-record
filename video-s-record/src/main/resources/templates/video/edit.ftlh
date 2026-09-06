<#import "../layout/main.ftlh" as main>
<@main.layout "Редактирование видео">
    <h2>Добавить видео</h2>

    <form action="/videos/${video.id}/edit" method="post">
        <div class="mb-3">
            <label>Название</label>
            <input type="text" name="title" class="form-control" value="${video.title}" >
        </div>
        <div class="mb-3">
            <label>Исполнитель</label>
            <input type="text" name="artist" class="form-control" value="${video.artist}">
        </div>
        <div class="mb-3">
            <label>Ссылка на видео (YouTube / Vimeo)</label>
            <input type="url" name="videoUrl" class="form-control" placeholder="https://www.youtube.com/watch?v=...">
        </div>
        <div class="mb-3">
            <label>Ссылка на обложку (опционально)</label>
            <input type="url" name="thumbnailUrl" class="form-control" value="${video.thumbnailUrl}">
        </div>
        <button type="submit" class="btn btn-primary">Сохранить</button>
        <a href="/videos" class="btn btn-secondary">Отмена</a>
    </form>
</@main.layout>