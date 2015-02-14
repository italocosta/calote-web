function alterarFontClass(){
	$("font").attr("class","linkVermelho");
}
$("button").on("click",function(e){
	alterarFontClass();
});