$(document).ready(function() {

});

async function registrarUsuario() {
let datos={};
datos.nombre=document.getElementById('nombre').value;
datos.apellido=document.getElementById('apellido').value;
datos.email=document.getElementById('email').value;
datos.telefono=document.getElementById('telefono').value;
datos.password=document.getElementById('password').value;

let repetirpassword = document.getElementById('repetirpassword').value

    if(repetirpassword!=datos.password){
        alert('La contraseña es incorrecta')
        return;
}

    const request = await fetch("/usuarios", {
        method: "POST",
        headers: {
            "Accept": "application/json",
            "Content-Type": "application/json"
        },
        body: JSON.stringify(datos)
    });

    if (request.ok) {
        alert('Registro realizado con éxito!')
    }
 const usuarios = await request.json();

 }
