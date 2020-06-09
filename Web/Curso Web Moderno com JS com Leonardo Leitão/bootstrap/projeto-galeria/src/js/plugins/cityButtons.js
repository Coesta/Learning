import $ from 'jquery'

import { onLoadHtmlSucess } from '../core/includes'

const durantion = 300

function filterByCity(city) {
    $('[wm-city]').each(function (i, e) {
        const isTarget = $(this).attr('wm-city') == city
            || city === null

        if (isTarget) {
            $(this).parent().removeClass('d-none')
            $(this).fadeIn(durantion)
        } else {
            $(this).fadeOut(durantion, () => {
                $(this).parent().addClass('d-none')
            })
        }
    })
}

$.fn.cityButtons = function () {
    const cities = new Set /* Ele escolheu SET pq esse tipo de conjunto não permite repetição. */
    $('[wm-city]').each(function (i, e) {
        cities.add($(e).attr('wm-city'))
    })
    
    const btns = Array.from(cities).map(city => {
        const btn = $('<button>').addClass(['btn', 'btn-info']).html(city)
        btn.click(e => filterByCity(city))
        return btn
    })
    
    const btnAll = $('<button>').addClass(['btn', 'btn-info', 'active']).html('Todas')
    btnAll.click(e => filterByCity(city))
    btns.push(btnAll)
    
    const btnGroup = $('<div>').addClass(['btn-group'])
    btnGroup.append(btns)
    
    $(this).html(btnGroup)
    return this
}

onLoadHtmlSucess(function() {
    $('[wm-city-buttons]').cityButtons()
})