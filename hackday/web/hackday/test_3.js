/**
 * Created by yifan on 16/1/31.
 */
 /*   var xmlhttprequest = new XMLHttpRequest();
xmlhttprequest.onreadystatechange=function()
{
    if (xmlhttprequest.readyState==4 && xmlhttprequest.status==200)
    {
        var a = xmlhttprequest.responseText;
        var b = a.split(";");


        //document.getElementById("subject_1").innerHTML = b[0].split(":")[1];
        //document.getElementById("people_1").innerHTML = b[1].split(":")[1];
        //document.getElementById("tel_1").innerHTML = b[2].split(":")[1];
        //document.getElementById("area_1").innerHTML = b[3].split(":")[1];
        //document.getElementById("dead_time_1").innerHTML = b[4].split(":")[1];
    }
}

xmlhttprequest.open("GET","#",true);//   #  要替换
xmlhttprequest.send();
*/
var color_ = new Array(20);

for(var i = 0;i < 20;i++){
    color_[i] = 0;
}

function change_color1(){

    if(color_[0] == 0){
        document.getElementById("choose1").style.backgroundColor="#01a4fc";
        color_[0] = 1;
    }else if(color_[0] == 1){
        document.getElementById("choose1").style.backgroundColor="#fec5bc";
        color_[0] = 2;
    }else {
        document.getElementById("choose1").style.backgroundColor="#ecf8ff";
        color_[0] = 0;
    }


}

function change_color2(){

    if(color_[1] == 0){
        document.getElementById("choose2").style.backgroundColor="#01a4fc";
        color_[1] = 1;
    }else if(color_[1] == 1){
        document.getElementById("choose2").style.backgroundColor="#fec5bc";
        color_[1] = 2;
    }else {
        document.getElementById("choose2").style.backgroundColor="#ecf8ff";
        color_[1] = 0;
    }

}

function change_color3(){

    if(color_[2] == 0){
        document.getElementById("choose3").style.backgroundColor="#01a4fc";
        color_[2] = 1;
    }else if(color_[2] == 1){
        document.getElementById("choose3").style.backgroundColor="#fec5bc";
        color_[2] = 2;
    }else {
        document.getElementById("choose3").style.backgroundColor="#ecf8ff";
        color_[2] = 0;
    }

}

function change_color4(){

    if(color_[3] == 0){
        document.getElementById("choose4").style.backgroundColor="#01a4fc";
        color_[3] = 1;
    }else if(color_[3] == 1){
        document.getElementById("choose4").style.backgroundColor="#fec5bc";
        color_[3] = 2;
    }else {
        document.getElementById("choose4").style.backgroundColor="#ecf8ff";
        color_[3] = 0;
    }

}

function change_color5(){

    if(color_[4] == 0){
        document.getElementById("choose5").style.backgroundColor="#01a4fc";
        color_[4] = 1;
    }else if(color_[4] == 1){
        document.getElementById("choose5").style.backgroundColor="#fec5bc";
        color_[4] = 2;
    }else {
        document.getElementById("choose5").style.backgroundColor="#ecf8ff";
        color_[4] = 0;
    }

}

function change_color6(){

    if(color_[5] == 0){
        document.getElementById("choose6").style.backgroundColor="#01a4fc";
        color_[5] = 1;
    }else if(color_[5] == 1){
        document.getElementById("choose6").style.backgroundColor="#fec5bc";
        color_[5] = 2;
    }else {
        document.getElementById("choose6").style.backgroundColor="#ecf8ff";
        color_[5] = 0;
    }

}

function change_color7(){

    if(color_[6] == 0){
        document.getElementById("choose7").style.backgroundColor="#01a4fc";
        color_[6] = 1;
    }else if(color_[6] == 1){
        document.getElementById("choose7").style.backgroundColor="#fec5bc";
        color_[6] = 2;
    }else {
        document.getElementById("choose7").style.backgroundColor="#ecf8ff";
        color_[6] = 0;
    }

}

function change_color8(){

    if(color_[7] == 0){
        document.getElementById("choose8").style.backgroundColor="#01a4fc";
        color_[7] = 1;
    }else if(color_[7] == 1){
        document.getElementById("choose8").style.backgroundColor="#fec5bc";
        color_[7] = 2;
    }else {
        document.getElementById("choose8").style.backgroundColor="#ecf8ff";
        color_[7] = 0;
    }

}

function change_color9(){

    if(color_[8] == 0){
        document.getElementById("choose9").style.backgroundColor="#01a4fc";
        color_[8] = 1;
    }else if(color_[8] == 1){
        document.getElementById("choose9").style.backgroundColor="#fec5bc";
        color_[8] = 2;
    }else {
        document.getElementById("choose9").style.backgroundColor="#ecf8ff";
        color_[8] = 0;
    }

}

function change_color10(){

    if(color_[9] == 0){
        document.getElementById("choose10").style.backgroundColor="#01a4fc";
        color_[9] = 1;
    }else if(color_[9] == 1){
        document.getElementById("choose10").style.backgroundColor="#fec5bc";
        color_[9] = 2;
    }else {
        document.getElementById("choose10").style.backgroundColor="#ecf8ff";
        color_[9] = 0;
    }

}


function change_color11(){

    if(color_[10] == 0){
        document.getElementById("choose11").style.backgroundColor="#01a4fc";
        color_[10] = 1;
    }else if(color_[10] == 1){
        document.getElementById("choose11").style.backgroundColor="#fec5bc";
        color_[10] = 2;
    }else {
        document.getElementById("choose11").style.backgroundColor="#ecf8ff";
        color_[10] = 0;
    }

}

function change_color12(){

    if(color_[11] == 0){
        document.getElementById("choose12").style.backgroundColor="#01a4fc";
        color_[11] = 1;
    }else if(color_[11] == 1){
        document.getElementById("choose12").style.backgroundColor="#fec5bc";
        color_[11] = 2;
    }else {
        document.getElementById("choose12").style.backgroundColor="#ecf8ff";
        color_[11] = 0;
    }

}


function change_color13(){

    if(color_[12] == 0){
        document.getElementById("choose13").style.backgroundColor="#01a4fc";
        color_[12] = 1;
    }else if(color_[12] == 1){
        document.getElementById("choose13").style.backgroundColor="#fec5bc";
        color_[12] = 2;
    }else {
        document.getElementById("choose13").style.backgroundColor="#ecf8ff";
        color_[12] = 0;
    }

}


function change_color14(){

    if(color_[13] == 0){
        document.getElementById("choose14").style.backgroundColor="#01a4fc";
        color_[13] = 1;
    }else if(color_[13] == 1){
        document.getElementById("choose14").style.backgroundColor="#fec5bc";
        color_[13] = 2;
    }else {
        document.getElementById("choose14").style.backgroundColor="#ecf8ff";
        color_[13] = 0;
    }

}


function change_color15(){

    if(color_[14] == 0){
        document.getElementById("choose15").style.backgroundColor="#01a4fc";
        color_[14] = 1;
    }else if(color_[14] == 1){
        document.getElementById("choose15").style.backgroundColor="#fec5bc";
        color_[14] = 2;
    }else {
        document.getElementById("choose15").style.backgroundColor="#ecf8ff";
        color_[14] = 0;
    }

}


function change_color16(){

    if(color_[15] == 0){
        document.getElementById("choose16").style.backgroundColor="#01a4fc";
        color_[15] = 1;
    }else if(color_[15] == 1){
        document.getElementById("choose16").style.backgroundColor="#fec5bc";
        color_[15] = 2;
    }else {
        document.getElementById("choose16").style.backgroundColor="#ecf8ff";
        color_[15] = 0;
    }

}


function change_color17(){

    if(color_[16] == 0){
        document.getElementById("choose17").style.backgroundColor="#01a4fc";
        color_[16] = 1;
    }else if(color_[16] == 1){
        document.getElementById("choose17").style.backgroundColor="#fec5bc";
        color_[16] = 2;
    }else {
        document.getElementById("choose17").style.backgroundColor="#ecf8ff";
        color_[16] = 0;
    }

}


function change_color18(){

    if(color_[17] == 0){
        document.getElementById("choose18").style.backgroundColor="#01a4fc";
        color_[17] = 1;
    }else if(color_[17] == 1){
        document.getElementById("choose18").style.backgroundColor="#fec5bc";
        color_[17] = 2;
    }else {
        document.getElementById("choose18").style.backgroundColor="#ecf8ff";
        color_[17] = 0;
    }

}

function change_color19(){

    if(color_[18] == 0){
        document.getElementById("choose19").style.backgroundColor="#01a4fc";
        color_[18] = 1;
    }else if(color_[18] == 1){
        document.getElementById("choose19").style.backgroundColor="#fec5bc";
        color_[18] = 2;
    }else {
        document.getElementById("choose19").style.backgroundColor="#ecf8ff";
        color_[18] = 0;
    }

}


function change_color20(){

    if(color_[19] == 0){
        document.getElementById("choose20").style.backgroundColor="#01a4fc";
        color_[19] = 1;
    }else if(color_[19] == 1){
        document.getElementById("choose20").style.backgroundColor="#fec5bc";
        color_[19] = 2;
    }else {
        document.getElementById("choose20").style.backgroundColor="#ecf8ff";
        color_[19] = 0;
    }

}