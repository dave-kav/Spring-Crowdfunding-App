 $("#login-button").click(function(event){
		 event.preventDefault();
	 
	 $('form').fadeOut(500);
	 $('.wrapper').addClass('form-success');
	 
	 $(document).ready(function () {
		    // Handler for .ready() called.
		    window.setTimeout(function () {
		        location.href = "https://www.google.com";
		    }, 5000);
		});

});