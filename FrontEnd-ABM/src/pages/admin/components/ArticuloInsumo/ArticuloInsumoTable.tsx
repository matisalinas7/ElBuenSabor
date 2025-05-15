import { useEffect, useState } from "react";
import { Button, Table } from "react-bootstrap";
import { PencilFill, ArrowUp, ArrowDown, Trash } from 'react-bootstrap-icons';
import { ArticuloInsumo } from "../../../../types/ArticuloInsumo";
import { ModalType } from "../../../../types/ModalType";
import ArticuloInsumoModal from "./ArticuloInsumoModal";
import { ArticuloInsumoService } from "../../../../services/ArticuloInsumoService";
import { toast } from 'react-toastify';
import React from "react";

const ArticuloInsumoTable = () => {
  const [articulos, setArticulos] = useState<ArticuloInsumo[]>([]);
  const [refreshData, setRefreshData] = useState(false);
  const [selectedArticulo, setSelectedArticulo] = useState<ArticuloInsumo | null>(null);
  const [showModal, setShowModal] = useState(false);
  const [modalType, setModalType] = useState<ModalType>(ModalType.NONE);
  const [title, setTitle] = useState("");

  useEffect(() => {
    const fetchArticulos = async () => {
      const data = await ArticuloInsumoService.getArticulos();
      setArticulos(data);
    };
    fetchArticulos();
  }, [refreshData]);

  const handleClick = (newTitle: string, articulo: ArticuloInsumo, modal: ModalType) => {
    setTitle(newTitle);
    setModalType(modal)
    setSelectedArticulo(articulo);
    setShowModal(true);
  };

  const handleDelete = async (newTitle: string, articulo: ArticuloInsumo, modal: ModalType) => {
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
      <Button onClick={() => handleClick("Nuevo Articulo Insumo", {
        id: 0,
        nombre: "",
        descripcion: "",
        precioCompra: 0,
        stockActual: 0,
        stockMinimo: 0,
      }, ModalType.CREATE)}>
        Nuevo Articulo Insumo
      </Button>

      <Table>
        <thead>
          <tr>
            <th>ID</th>
            <th>Nombre</th>
            <th>Descripción</th>
            <th>Precio de Compra</th>
            <th>Stock Actual</th>
            <th>Stock Minimo</th>
            <th>Actions</th>
          </tr>
        </thead>
        <tbody>
          {articulos.map((articulo) => (
            <tr key={articulo.id} className={selectedArticulo && selectedArticulo.id === articulo.id ? 'table-active' : ''}>
              <td>{articulo.id}</td>
              <td>{articulo.nombre}</td>
              <td>{articulo.descripcion}</td>
              <td>{articulo.precioCompra}</td>
              <td>{articulo.stockActual}</td>
              <td>{articulo.stockMinimo}</td>
              <td>
                <Button variant="light" onClick={() => handleClick("Editar Articulo Insumo", articulo, ModalType.UPDATE)}>
                  <PencilFill color='orange' />
                </Button>
                <Button variant="light" onClick={() => handleDelete("Eliminar Articulo Insumo", articulo, ModalType.DELETE)}>
                  <Trash color='red' />
                </Button>
              </td>
            </tr>
          ))}
        </tbody>
      </Table>

      {showModal && (
        <ArticuloInsumoModal
          show={showModal}
          onHide={() => setShowModal(false)}
          title={title}
          modalType={modalType}
          articulo={selectedArticulo || {
            id: 0,
            nombre: "",
            descripcion: "",
            precioCompra: 0,
            stockActual: 0,
            stockMinimo: 0,
          }}
          refreshData={setRefreshData}
        />
      )}
    </div>
  );
};

export default ArticuloInsumoTable;
