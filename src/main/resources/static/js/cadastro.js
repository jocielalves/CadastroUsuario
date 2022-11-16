const formulario = document.getElementById('form')
const iNome  = document.getElementById("nome")
const iUsuario = document.getElementById("usuario")
const iEmail = document.getElementById("email")
const iSenha = document.getElementById("senha")

function cadastrar() {

    //Metodos que vai enviar os dados e acessar nossa api
    fetch("http://localhost:8080/cadastrar",   //enpoint de acesso
        {          //cabeçalho dizendo que vou enviar o tipo json 
                method: 'POST',    
                headers: {
                    'Accept' : 'application/json',
                    'Content-Type' : 'application/json'
                },
                
                body: JSON.stringify({
                    nome : iNome.value,
                    usuario : iUsuario.value,
                    email : iEmail.value,
                    senha : iSenha.value
                }) // conversor para json 
        })
        .then( function( res ) { console.log(res) })
        .catch( function(res){ console.log(res)})


        limpar()
}



function limpar( ){
    iNome.value = "",
    iUsuario.value = "",
    iEmail.value = "",
    iSenha.value = ""
}




