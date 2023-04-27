$(document).ready(
		function() {

			// SUBMIT FORM
			$("#bookForm").submit(function(event) {
				// Prevent the form from submitting via the browser.
				event.preventDefault();
				ajaxPost();
				alert("hello");
			});

			function ajaxPost() {

				// PREPARE FORM DATA
				var formData = {
					country : $("#country").val(),
					institution : $("#institution").val(),
					level : $("#level").val()
					d1 : $("#d1").val(),
					d2 : $("#d2").val(),
					output : $("#output").val(),
				}

				// DO POST
				$.ajax({
					type : "POST",
					contentType : "application/json",
					url : "saveBook",
					data : JSON.stringify(formData),
					dataType : 'json',
					success : function(result) {
						if (result.status == "success") {
							$("#postResultDiv").html(
									"" + result.data.country
											+ "Post Successfully! <br>"
											+ "---> Congrats !!" + "</p>");
						} else {
							$("#postResultDiv").html("<strong>Error</strong>");
						}
						console.log(result);
					},
					error : function(e) {
						alert("Error!")
						console.log("ERROR: ", e);
					}
				});

			}

		})
