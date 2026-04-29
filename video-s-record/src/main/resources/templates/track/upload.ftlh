<#import "../layout/main.ftlh" as main>
<@main.layout "Загрузка трека">
    <h2>Загрузить новый трек</h2>

    <form action="/tracks/upload" method="post" enctype="multipart/form-data">
        <div class="mb-3">
            <label>Название трека</label>
            <input type="text" name="title" class="form-control" required>
        </div>
        <div class="mb-3">
            <label>Исполнитель</label>
            <input type="text" name="artist" class="form-control" required>
        </div>
        <div class="mb-3">
            <label>Альбом</label>
            <input type="text" name="album" class="form-control">
        </div>
        <div class="mb-3">
            <label>Жанр</label>
            <input type="text" name="genre" class="form-control">
        </div>
        <div class="mb-3">
            <label>Длительность (секунд)</label>
            <input type="number" name="duration" class="form-control" min="1">
        </div>
        <div class="mb-3">
            <label>Аудиофайл (MP3)</label>
            <input type="file" name="audioFile" class="form-control" accept="audio/*">
        </div>
        <div class="mb-3">
            <label>Обложка (картинка)</label>
            <input type="file" name="coverFile" class="form-control" accept="image/*">
        </div>
        <button type="submit" class="btn btn-primary">Загрузить</button>
        <a href="/tracks" class="btn btn-secondary">Отмена</a>
    </form>
</@main.layout>