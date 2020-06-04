const gulp = require('gulp')
const webserver = require('gulp-webserver')
const watch = require('gulp-watch')

function servidor() {
    return gulp.src('build')
        .pipe(webserver({
            port:8080,
            open: true,
            livereload: true
        }))
}

function monitorarArquivos(callback) {
    watch('src/paginas/inicio.html', () => gulp.series('appHTML')())
    watch('src/**/*.scss', () => gulp.series('appCSS')())
    watch('src/**/*.js', () => gulp.series('appJS')())
    watch('src/assets/imgs/**/*.*', () => gulp.series('appIMG')())
    return callback()
}

module.exports = {
    monitorarArquivos,
    servidor
}
