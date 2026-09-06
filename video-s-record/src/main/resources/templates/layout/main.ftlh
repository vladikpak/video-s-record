<#macro layout pageTitle>
    <!DOCTYPE html>
    <html lang="ru">
    <head>
        <meta charset="UTF-8">
        <title>${pageTitle} | MusicSite</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css">
    </head>
    <body style="background-color: sandybrown;">
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <div class="container">
            <a class="navbar-brand" href="/">MusicSite</a>
            <div class="collapse navbar-collapse">
                <ul class="navbar-nav me-auto">
                    <li class="nav-item"><a class="nav-link" href="/tracks">Треки</a></li>
                    <li class="nav-item"><a class="nav-link" href="/videos">Видео</a></li>
                    <li class="nav-item"><a class="nav-link" href="/tracks/upload">Загрузить трек</a></li>
                    <li class="nav-item"><a class="nav-link" href="/videos/upload">Загрузить видео</a></li>
                </ul>
            </div>
        </div>
    </nav>

    <div class="container mt-4">
        <#if error??>
            <div class="alert alert-danger">${error}</div>
        </#if>
        <#if success??>
            <div class="alert alert-success">${success}</div>
        </#if>
        <#nested>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js"></script>
    </body>
    </html>
</#macro>