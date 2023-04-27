
const toggleSidebar = () => {
if ($(".sidebar").is(":visible")){
$(".sidebar").css("display", "none");
$(".content").css("margin-left", "0%");
} else{
$(".sidebar").css("display", "block");
$(".content").css("margin-left", "20%");
}
};
//<10?'<p style="background-color:yellow">'+days+'</p>':'<p style="color:green">'+days+'</p>';

/*
  <div class="row mt-5">
                <div class="col-6 mx-auto">
                    <h1>User Details</h1>
                    <div class="mt-2">Username: <span sec:authentication="principal.username"/></div>
                    <div class="mt-2"> Roles: <span sec:authentication="principal.authorities"/></div>

                    <div class="mt-5"><a class="btn btn-info" th:href="@{/registration}">Edit</a></div>
                </div>
            </div>
            */






