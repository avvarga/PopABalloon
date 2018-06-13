$(document).ready(function(){
	
    $(".title-box").on("click", function(){
        $(this).slideUp("fast");
        $(".enterCodeBox").slideDown("slow");
    })
    
    $("#claim").on("click", function(){
    	$.ajax({
            type: 'POST',
            url: "/validate",
            data: $("#loginForm").serialize(),
            success: function (response) {
            	if(response=="Granted"){
            		$(".board").show();
            		$(".enterCodeBox").slideUp("fast");
            		$(".balloons-page").slideDown("fast");            		
            	}
            	else{
            		$(".modal").css("display", "block");
            		$("#loginError").show();
            	}
            	console.log(response);
            },
            error: function (response) {
                console.log("An error ocurred");
            },
        });
    	
        return false;
    })
    
    $(".balloon").on("click", function(){
        $(this).hide();
        $.ajax({
            type: 'GET',
            url: "/prize",
            data: {},
            success: function (response) {
                $(".modal").css("display", "block");
                $("#prizeBox").show();
                $(".modal-content div").html("<img alt='"+response.name+"' src='resources/"+response.image+"'>");
                $("#prize span").text(response.name);
            },
            error: function (response) {
                console.log('An error occurred.');
            },
        });
    })

    $(".close").on("click", function(){
        $(".modal").hide();
        $(".board").hide();
        $(".balloons-page").slideUp("fast");
        
    })

    $("#close").on("click", function(){
        $(".modal").hide();
        $(".board").hide();
        $(".balloons-page").slideUp("fast");
    })
    
    $(".closeFinal").on("click", function(){
	    $(".modal").hide();
	    $(".board").hide();
	    $(".balloons-page").slideUp("fast");
	    $(".title-box").show();
    })

    $("#closeFinal").on("click", function(){
        $(".modal").hide();
        $(".board").hide();
        $(".balloons-page").slideUp("fast");
        $(".title-box").show();
    })
    



    function submitForm(){
        $(".form-page").hide();
    }
})


