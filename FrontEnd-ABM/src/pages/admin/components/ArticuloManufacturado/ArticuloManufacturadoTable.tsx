import { useEffect, useState } from "react";
import { Button, Table } from "react-bootstrap";
import { PencilFill, ArrowUp, ArrowDown, Trash } from 'react-bootstrap-icons';
import { ArticuloManufacturado } from "../../../../types/ArtuculoManufacturado";
import { ModalType } from "../../../../types/ModalType";
import ArticuloManufacturadoModal from "./ArticuloManufacturadoModal";
import { ArticuloManufacturadoService } from "../../../../services/ArticuloManufacturadoService";
import { toast } from 'react-toastify';
import React from "react";

const ArticuloManufacturadoTable = () => {
  const [articulos, setArticulos] = useState<ArticuloManufacturado[]>([]);
  const [refreshData, setRefreshData] = useState(false);
  const [selectedArticulo, setSelectedArticulo] = useState<ArticuloManufacturado | null>(null);
  const [showModal, setShowModal] = useState(false);
  const [modalType, setModalType] = useState<ModalType>(ModalType.NONE);
  const [title, setTitle] = useState("");

  useEffect(() => {
    const fetchArticulos = async () => {
      const data = await ArticuloManufacturadoService.getArticulos();
      setArticulos(data);
    };
    fetchArticulos();
  }, [refreshData]);

  const handleClick = (newTitle: string, articulo: ArticuloManufacturado, modal: ModalType) => {
    setTitle(newTitle);
    setModalType(modal)
    setSelectedArticulo(articulo);
    setShowModal(true);
  };

  const handleDelete = async (newTitle: string, articulo: ArticuloManufacturado, modal: ModalType) => {
    try {
      setTitle(newTitle);
      setModalType(modal);
      setSelectedArticulo(articulo);
      setShowModal(true);
    } catch (error) {
      console.error("Error al eliminar artículo:", error);
      toast.error("Error al eliminar artículo");
    }
  };

  return (
    <div className="m-3">
      <Button onClick={() => handleClick("Nuevo Articulo Manufacturado", {
        id: 0,
        nombre: "",
        descripcion: "",
        precioVenta: 0,
        tiempoEstimadoCocina: 0,
      }, ModalType.CREATE)}>
        Nuevo Articulo Manufacturado
      </Button>

      <Table>
        <thead>
          <tr>
            <th>ID</th>
            <th>Nombre</th>
            <th>Descripción</th>
            <th>Precio de Venta</th>
            <th>Tiempo Estimado de Cocina</th>
            <th>Actions</th>
          </tr>
        </thead>
        <tbody>
          {articulos.map((articulo) => (
            <tr key={articulo.id} className={selectedArticulo && selectedArticulo.id === articulo.id ? 'table-active' : ''}>
              <td>{articulo.id}</td>
              <td>{articulo.nombre}</td>
              <td>{articulo.descripcion}</td>
              <td>{articulo.precioVenta}</td>
              <td>{articulo.tiempoEstimadoCocina}</td>
              <td>
                <Button variant="light" onClick={() => handleClick("Editar Articulo Manufacturado", articulo, ModalType.UPDATE)}>
                  <PencilFill color='orange' />
                </Button>
                <Button variant="light" onClick={() => handleDelete("Eliminar Articulo Manufacturado", articulo, ModalType.DELETE)}>
                  <Trash color='red' />
                </Button>
              </td>
            </tr>
          ))}
        </tbody>
      </Table>

      {showModal && (
        <ArticuloManufacturadoModal
          show={showModal}
          onHide={() => setShowModal(false)}
          title={title}
          modalType={modalType}
          articulo={selectedArticulo || {
            id: 0,
            nombre: "",
            descripcion: "",
            precioVenta: 0,
            tiempoEstimadoCocina: 0,
          }}
          refreshData={setRefreshData}
        />
      )}
    </div>
  );
};

export default ArticuloManufacturadoTable;
