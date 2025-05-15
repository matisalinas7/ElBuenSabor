
import { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import React from 'react';
import './login.css';
import { AuthService } from '../../services/AuthService';

const LoginPage: React.FC = () => {
  const [loginData, setLoginData] = useState({
    username: '',
    password: '',
  });

  const navigate = useNavigate();

  const handleInputChange = (e) => {
    setLoginData({
      ...loginData,
      [e.target.name]: e.target.value,
    });
  };

  const handleLogin = async () => {
    try {
      const token = await AuthService.login(loginData);
      console.log("Inicio de sesión exitoso!", token);
      navigate('/');
      // Almacenar información de inicio de sesión en localStorage
      window.localStorage.setItem('isLoggedIn', 'true');
    } catch (error) {
      console.log("Error al iniciar sesión:", error);
    }
  };

  return (
    <div className="pantallaLogin">
      
      <br />
      <div className="formLogin">
      INICIAR SESION
        <label>
          <input
          className="inputLogin" type="email" name="username" placeholder='  Username  ' onChange={handleInputChange} />
        </label>
        <br />
        <label>
          <input
          className="inputLogin"
          type="password" name="password" placeholder='  Contraseña '  onChange={handleInputChange} />
        </label>
        <br />
        <button id="iniciarSesion" onClick={handleLogin}>
          Iniciar sesión
        </button>
      </div>
    </div>
  );
};

export default LoginPage;

// Componente Login no es necesario
