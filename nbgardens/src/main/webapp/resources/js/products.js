$(document).ready(function() {
    
    $('.horizontal .stock-fill span').each(function() {
        var percent = $(this).html();
        $(this).parent().css('width', percent);
    });
    
    
    $('.vertical .stock-fill span').each(function(){
        var percent = $(this).html();
        var pTop = 100 - ( percent.slice(0, percent.length - 1) ) + "%";
        $(this).parent().css({
            'height' : percent,
            'top' : pTop
        });
    });
    
    var acc = document.getElementsByClassName("accordion");
    var i;

    for (i = 0; i < acc.length; i++) {
        acc[i].onclick = function(){
            this.classList.toggle("active");
            this.nextElementSibling.classList.toggle("show");
        }
    }
});
