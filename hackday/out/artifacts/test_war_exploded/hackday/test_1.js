/**
 * Created by yifan on 16/1/29.
 */

window.onload = function(){
    document.getElementById("next").style.width=window.innerWidth+"px";
    document.getElementById("next").style.height=window.innerHeight-"41"+"px";
    document.getElementById("header").style.width=window.innerWidth+"px";
}

/*function load(){
    document.getElementById("div1").onclick();

}
*/
$(document).ready(function(){
    $("#div1").click(function(){
        $(this).animate({
            color:'red',
            opacity:'0.5',
            height:'150px',
            width:'150px'
        });
    });
});