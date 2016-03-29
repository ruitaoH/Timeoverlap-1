/**
 * Created by yifan on 16/1/30.
 */
$(document).ready(function(){
    $("#flip").click(function(){
        $("#slide").slideToggle("1000");

    });
});
var oDiv = document.getElementById("slide");
var a = 0;

function length(){
a =  a +1;
if (a % 2 != 0) {
    document.getElementById("flip").style.color = "#626262";
    document.getElementById("imgid").src = "musion/more_grey.png";
}else{
    document.getElementById("flip").style.color= "#48bfff";
    document.getElementById("imgid").src = "musion/more.png";
}

  //  var a =document.getElementById("wire").style.height;

   // if(document.getElementById("wire").style.height>=1300){
   //     document.getElementById("wire").style.height="1100px";
   // }else{
    //    document.getElementById("wire").style.height="1400px"
//    }

}