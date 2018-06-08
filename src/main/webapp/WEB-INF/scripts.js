$(document).ready(function(){
    $(".balloon").on("click", function(){
        $(this).hide();
        $(".modal").css("display", "block")
    })

    $(".close").on("click", function(){
        $(".modal").hide();
    })

    $("#close").on("click", function(){
        $(".modal").hide();
    })

    $(".title-box").on("click", function(){
        $(this).hide("fast");
        $(".board").show();
        $(".form-page").show();
        $(".balloons-page").slideDown("slow");
    })

    function submitForm(){
        $(".form-page").hide();
    }
})


