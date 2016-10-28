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
    
    
    $('.accordion').click(function(){
    	$('.panel').slideToggle();
    });
});
