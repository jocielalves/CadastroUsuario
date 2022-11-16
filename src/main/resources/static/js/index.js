let bancoRecados = [ ]

function salvarRecado(){


    let dados = {
        nome :  document.getElementById('nome').value,
        email : document.getElementById('email').value,
        contato : document.getElementById('contato').value,
        numero : document.getElementById('numero').value,
        recado : document.getElementById('recado').value 
       
    }

    bancoRecados.push( dados )

    document.getElementById('nome').value =""
    document.getElementById('email').value =""
    document.getElementById('contato').value =""
    document.getElementById('numero').value =""
    document.getElementById('recado').value ="" 

}

console.log( bancoRecados)



