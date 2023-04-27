
function calculateDays(d3){
for (i=1; i<=d3; i++){
if (d3 < 2){
document.getElementById("myv").innerHTML=d3;
}
else{
document.getElementById("myv").innerHTML="hi";
}
 }
 }
 calculateDays(document.getElementById("d3").innerText)
function statu(days){
for (i=1; i<=days; i++)
{
document.getElementById("status").innerHTML=days<i?'<p style="background-color:yellow">'+days+'</p>':'<p style="background-color:green">'+days+'</p>';
}
 }


 const userinfo = () => {
 alert("hi");
}
