/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function(){
    $("#login").click(function(){
        
        $("#row2").slideUp();
        $("#row1").slideDown();
    });
     $("#register").click(function(){
        $("#row1").slideUp();
        $("#row2").slideDown();
    });
});