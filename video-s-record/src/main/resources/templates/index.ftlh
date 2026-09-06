<#import "layout/main.ftlh" as main>
<@main.layout "Главная">
    <style>
        .aw {
            margin: 0 10px;
        }
    </style>
    <h1>Добро пожаловать в MusicSite!</h1>
    <div style="display: flex">
    <a href="/tracks" style="color: aqua; text-decoration: none" class="aw">Музыка</a> |
    <a href="/videos" style="color: aqua; text-decoration: none" class="aw">Видео</a> |
    <a class="nav-link aw" href="/tracks/upload" style="color: aqua; text-decoration: none">Загрузить трек</a> |
    <a class="nav-link aw" href="/videos/upload" style="color: aqua; text-decoration: none">Загрузить видео</a>
    </div>
</@main.layout>