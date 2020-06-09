import $ from 'jquery'

const loadHtmlSuccessCallback = []

export function onLoadHtmlSucess(callback) {
    if(!loadHtmlSuccessCallback.includes(callback)) {
        loadHtmlSuccessCallback.push(callback)
    }
}

function loadIncludes(parent) {
    if (!parent)
        parent = 'body'

    $(parent).find('[wm-include]').each(function (i, e) {   
        const url = $(e).attr('wm-include')
        $.ajax({
            url,
            success(data){
                $(e).html(data)
                $(e).removeAttr('wm-include')

                loadHtmlSuccessCallback.forEach(callback => callback(data))
                loadIncludes(e)
            }
        })
    })
}

loadIncludes()