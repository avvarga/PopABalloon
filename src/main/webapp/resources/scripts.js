$(document).ready(function(){
	
    $(".title-box").on("click", function(){
        $(this).slideUp("fast");
        $(".enterCodeBox").slideDown("slow");
    })
    
    $("#loginAsAdmin").on("click", function(){
        $(this).parent().slideUp("fast");
        $("#adminLoginForm").slideDown("slow");
        return false;
    })
    
    $(".claim").on("click", function(){
    	$(".board").show();
        $(".enterCodeBox").slideUp("fast");
        $(".balloons-page").slideDown("fast");
        return false;
    })
    
    
    
    $(".balloon").on("click", function(){
        $(this).hide();
        $(".modal").css("display", "block")
    })

    $(".close").on("click", function(){
        $(".modal").hide();
        $(".board").hide();
        $(".balloons-page").slideUp("fast");
        $(".title-box").show();
    })

    $("#close").on("click", function(){
        $(".modal").hide();
        $(".board").hide();
        $(".balloons-page").slideUp("fast");
        $(".title-box").show();
    })
    
    



    function submitForm(){
        $(".form-page").hide();
    }
})


