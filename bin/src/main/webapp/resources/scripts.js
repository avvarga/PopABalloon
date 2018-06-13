$(document).ready(function(){
	
    $(".title-box").on("click", function(){
        $(this).slideUp("fast");
        $(".enterCodeBox").slideDown("slow");
    })
    
    $(".claim").on("click", function(){
    	$.ajax({
            type: 'POST',
            url: "/validate",
            data: $("#loginForm").serialize(),
            success: function (response) {
                console.log('Submission was successful.');
                console.log(response);
            },
            error: function (response) {
                console.log('An error occurred.');
                console.log(response);
            },
        });
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


