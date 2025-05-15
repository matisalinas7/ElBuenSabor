import { Factura } from "../types/Factura";


const BASE_URL = 'http://localhost:8080';

export const FacturaService = {


    getFacturas: async (): Promise<Factura[]> => {

        const response = await fetch(`${BASE_URL}/elbuensabor/v1/facturas`);
        const data = await response.json();
        return data;
    },

    getFactura: async (id:number): Promise<Factura> => {

        const response = await fetch (`${BASE_URL}/elbuensabor/v1/facturas/${id}`);
        const data = await response.json();
        return data;

    },

    createFactura:async (factura:Factura):Promise<Factura> => {

        const response = await fetch(`${BASE_URL}/elbuensabor/v1/facturas`, {
            method: "POST",
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(factura)
        });

        const data = await response.json();
        return data;

    },

    updateFactura: async (id: number, factura: Factura): Promise<Factura> => {

        const response = await fetch(`${BASE_URL}/elbuensabor/v1/facturas/${id}`, {
            method: "PUT",
            headers: {
                'Content-Type':'application/json'
            },
            body: JSON.stringify(factura)
        });

        const data = await response.json();
        return data;
    },

    deleteFactura: async (id:number): Promise<void> => {
        await fetch(`${BASE_URL}/elbuensabor/v1/facturas/${id}`, {
            method: "DELETE"
        });
    },

}

