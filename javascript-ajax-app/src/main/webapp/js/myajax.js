function loadXMLDoc(){
var xmlhttp;
if (window.XMLHttpRequest)  {// code for IE7+, Firefox, Chrome, Opera, Safari
  xmlhttp=new XMLHttpRequest();
  }
  
xmlhttp.onreadystatechange=function()
  {
  if (xmlhttp.readyState==4 && xmlhttp.status==200)
    {
    document.getElementById("myDiv").innerHTML=xmlhttp.responseText;
    }
  }
xmlhttp.open("GET","ajax_info.txt",true);
xmlhttp.send();
}


function loadXMLDoc1(){
var xmlhttp;
if (window.XMLHttpRequest)  {// code for IE7+, Firefox, Chrome, Opera, Safari
  xmlhttp=new XMLHttpRequest();
  }

xmlhttp.onreadystatechange=function()
  {
  if (xmlhttp.readyState==4 && xmlhttp.status==200)
    {
    document.getElementById("myDiv").innerHTML=xmlhttp.responseText;
    }
  }
xmlhttp.open("GET","es?empno=1012",true);
xmlhttp.send();
}

function showEmployees(deptno){
	var xmlhttp;    
	console.log("deptno="+deptno)
	if (deptno=="")	  {
	  document.getElementById("txtHint").innerHTML="";
	  return;
	  }
	if (window.XMLHttpRequest)	  {// code for IE7+, Firefox, Chrome, Opera, Safari
	  xmlhttp=new XMLHttpRequest();
	  }
	
	xmlhttp.onreadystatechange=function()
	  {
	  if (xmlhttp.readyState==4 && xmlhttp.status==200)
	    {
		let data=xmlhttp.responseText;
		console.log(data);
	    document.getElementById("txtHint").innerHTML=data;
	    }
	  }
	
	xmlhttp.open("GET","ge?deptno="+deptno,true);
	xmlhttp.send();
}
