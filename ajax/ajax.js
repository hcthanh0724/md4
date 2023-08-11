$(document).ready(function (){
    $("button").click(function (){
        let div = $("div");
        div.animate({left: '100px'}, "slow");
        div.animate({bottom: '100px'}, "slow");
        div.animate({fontSize: '100px'},"slow");

    });
});