import { LoginRequest } from "../types/LoginTypes";
import { RegisterRequest } from "../types/RegisterTypes";

import { BASE_URL } from "../Config";

export const AuthService = {

    login: async (loginRequest: LoginRequest): Promise<string> => {

        try {
            const response = await fetch(`${BASE_URL}/auth/login`, {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify(loginRequest)
            });

            if (!response.ok) {
                throw new Error('Inicio de sesion fallido');
            }

            // Recuperar el token del cuerpo de la respuesta JSON
            const { token } = await response.json();

            if (!token) {
                throw new Error('No se encontro el token en las cabeceras de la respuesta');
            }

            // Almacena el token en localStorage
            localStorage.setItem('token', token);

            // Puedes tambien almacenar otros datos relacionados con la sesion si es necesario
            // localStorage.setItem('username', loginRequest.username);

            // Devolver el token como un string
            return token;

        } catch (error) {
            console.log('Error al iniciar sesion:');
            throw error; // Re-lanza el error para que pueda ser manejado por el codigo que llama a esta funcion
        }
    },

    register: async (registerRequest: RegisterRequest): Promise<string> => {

        try {
            const response = await fetch(`${BASE_URL}/auth/register`, {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify(registerRequest)
            });

            if (!response.ok) {
                throw new Error('Registro fallido');
            }

            // Recuperar el token del cuerpo de la respuesta JSON
            const { token } = await response.json();

            if (!token) {
                throw new Error('No se encontro el token en las cabeceras de la respuesta');
            }

            // Almacena el token en localStorage
            localStorage.setItem('token', token);

            // Puedes tambien almacenar otros datos relacionados con la sesion si es necesario
            // localStorage.setItem('username', loginRequest.username);

            // Devolver el token como un string
            return token;

        } catch (error) {
            console.log('Error al registrarse:');
            throw error; // Re-lanza el error para que pueda ser manejado por el codigo que llama a esta funcion
        }
    }
};