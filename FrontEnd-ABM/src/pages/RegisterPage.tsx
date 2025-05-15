import { useState } from "react"
import { AuthService } from "../services/AuthService";
import React from "react";
// import './login.css';
// import "@/login.css";

const RegisterPage = () => {
    const [userData, setUserData] = useState ({
        username: '',
        password: '',
        firstname: '',
        lastname: '',
        country: ''
    });

    const handleInputchange = (e) => {
        setUserData({
            ...userData,
            [e.target.name]: e.target.value,
        });
    };

    const handleRegister = async () => {
        try {
            const token = await AuthService.register(userData);
            console.log("Registro exitoso", token);
        } catch (error) {
            console.log("Error al registrarse:");
        }        
    };

    return (
        <div className="pantallaRegistro">
            
            <div className="formRegistro">
                <label>Nombre de usuario: 
                <input type="email" name="username" onChange={handleInputchange}/>
                </label>
                <br/>
                <label>Contraseña:
                <input type="password" name="password" onChange={handleInputchange}/>
                </label>
                <br/>
                <label>Nombre:
                <input type="text" name="firstname" onChange={handleInputchange}/>
                </label>
                <br/>
                <label>Apellido:
                <input type="text" name="lastname" onChange={handleInputchange}/>
                </label>
                <br/>
                <label>Pais:
                <input type="text" name="country" onChange={handleInputchange}/>
                </label>
                <br/>
                <button id="iniciarSesion" onClick={handleRegister}>Registrarse</button>
            </div>
        </div>
    );
};

export default RegisterPage;

