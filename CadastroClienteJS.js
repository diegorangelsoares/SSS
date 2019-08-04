function exibeNome(){
	//x = 10; //inteiro
	//x = "OI"; //String
	//x = {}; //objeto
	//x = []; //vetor
	//x="Oi";
	var elNome = document.getElementById('txtNome');
	//document.write(elNome.value);
	var StringNome = elNome.value;
	var ElDisplay = document.getElementById("display");
	ElDisplay.innerText = StringNome;
	console.log(StringNome);	
				
}

//Funcao para adicionar novos campos
function novoContato(){
	var elListaContatos = document.getElementById("listaContatos");
	var inputContato = document.createElement("input");
	inputContato.setAttribute ('name', 'txtContato');
	
	//<label> Contato: <label/>
	var labelContato = document.createElement("label");
	labelContato.innerText="Contato: ";
	
	//<br>
	var br = document.createElement("br");
	
	//<input type="button">
	var botaoExcluir = document.createElement("input");
	botaoExcluir.setAttribute("value","-");
	botaoExcluir.setAttribute("type", "button");
	
	//Funcao do botao remover os elementos ao clicar
	botaoExcluir.onclick = function(){
		//window.alert("Clicou no botao remover!");
		elListaContatos.removeChild(divLinha);
	};
	
	//<div> ... <div/>
	var divLinha = document.createElement("div");				
	divLinha.appendChild(labelContato);
	divLinha.appendChild(inputContato);
	divLinha.appendChild(botaoExcluir);
	divLinha.appendChild(br);
	
	elListaContatos.appendChild(divLinha);
			
}


function imprimirDados(){
	//window.alert("Clicou");
	var arrayInputsContatos = document.frmContatos.txtContato;
	//var contato = ??
	var saidaContatos = document.getElementById("saidaContatos");
	var saida = "";
	for (i=0; i<arrayInputsContatos.length; i++){
		//window.alert(arrayInputsContatos[i].value);
		saida += arrayInputsContatos[i].value + "<br>";
		
	}
	saidaContatos.innerHTML = saida;
	
	
	
}

