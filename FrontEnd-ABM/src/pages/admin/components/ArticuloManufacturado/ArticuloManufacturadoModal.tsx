import { Button, Form, Modal } from "react-bootstrap";
import { useFormik } from "formik";
import { toast } from "react-toastify";
import { ArticuloManufacturado } from "./../../../../types/ArtuculoManufacturado";
import { ModalType } from "../../../../types/ModalType";
import { ArticuloManufacturadoService } from "../../../../services/ArticuloManufacturadoService";
import React from "react";

type ArticuloManufacturadoModalProps = {
  show: boolean;
  onHide: () => void;
  title: string;
  modalType: ModalType;
  articulo: ArticuloManufacturado;
  refreshData: React.Dispatch<React.SetStateAction<boolean>>;
};

const ArticuloManufacturadoModal: React.FC<ArticuloManufacturadoModalProps> = ({
  show,
  onHide,
  title,
  modalType,
  articulo,
  refreshData,
}) => {
  const formik = useFormik({
    initialValues: articulo,
    validateOnChange: true,
    validateOnBlur: true,
    onSubmit: (formData: ArticuloManufacturado) => handleSave(formData),
  });

  const handleSave = async (formData: ArticuloManufacturado) => {
    try {
      if (modalType === ModalType.CREATE) {
        await ArticuloManufacturadoService.addArticulo(formData);
      } else if (modalType === ModalType.UPDATE) {
        await ArticuloManufacturadoService.updateArticulo(
          formData.id,
          formData
        );
      } else if (modalType === ModalType.DELETE) {
        handleDelete();
        return;
      }

      toast.success(
        modalType === ModalType.CREATE
          ? "Articulo Manufacturado Creado"
          : "Articulo Manufacturado Actualizado",
        {
          position: "top-center",
        }
      );

      onHide();
      refreshData((prevState) => !prevState);
    } catch (error) {
      console.error("Error saving Articulo Manufacturado:", error);
      toast.error("Ha ocurrido un error");
    }
  };
  const handleDelete = async () => {
    try {
      if (articulo.id) {
        await ArticuloManufacturadoService.deleteArticulo(articulo.id);
        toast.success("Artículo eliminado con éxito", {
          position: "top-center",
        });
        onHide();
        refreshData((prevState) => !prevState);
      }
    } catch (error) {
      console.error("Error al eliminar artículo:", error);
      toast.error("Error al eliminar artículo");
    }
  };
  return (
    <Modal show={show} onHide={onHide} centered backdrop="static">
      <Modal.Header closeButton>
        <Modal.Title>{title}</Modal.Title>
      </Modal.Header>
      <Modal.Body>
        <Form onSubmit={formik.handleSubmit}>
          <Form.Group controlId="formNombre">
            <Form.Label>Nombre</Form.Label>
            <Form.Control
              name="nombre"
              type="text"
              value={formik.values.nombre || ""}
              onChange={formik.handleChange}
              onBlur={formik.handleBlur}
              isInvalid={Boolean(formik.errors.nombre && formik.touched.nombre)}
            />
            <Form.Control.Feedback type="invalid">
              {formik.errors.nombre}
            </Form.Control.Feedback>
          </Form.Group>

          <Form.Group controlId="formDescripcion">
            <Form.Label>Descripción</Form.Label>
            <Form.Control
              name="descripcion"
              as="textarea"
              rows={3}
              value={formik.values.descripcion || ""}
              onChange={formik.handleChange}
              onBlur={formik.handleBlur}
              isInvalid={Boolean(
                formik.errors.descripcion && formik.touched.descripcion
              )}
            />
            <Form.Control.Feedback type="invalid">
              {formik.errors.descripcion}
            </Form.Control.Feedback>
          </Form.Group>

          <Form.Group controlId="formPrecioVenta">
            <Form.Label>Precio de Venta</Form.Label>
            <Form.Control
              name="precioVenta"
              type="number"
              value={formik.values.precioVenta || ""}
              onChange={formik.handleChange}
              onBlur={formik.handleBlur}
              isInvalid={Boolean(
                formik.errors.precioVenta && formik.touched.precioVenta
              )}
            />
            <Form.Control.Feedback type="invalid">
              {formik.errors.precioVenta}
            </Form.Control.Feedback>
          </Form.Group>

          <Form.Group controlId="formTiempoEstimadoCocina">
            <Form.Label>Tiempo Estimado de Cocina</Form.Label>
            <Form.Control
              name="tiempoEstimadoCocina"
              type="number"
              value={formik.values.tiempoEstimadoCocina || ""}
              onChange={formik.handleChange}
              onBlur={formik.handleBlur}
              isInvalid={Boolean(
                formik.errors.tiempoEstimadoCocina &&
                  formik.touched.tiempoEstimadoCocina
              )}
            />
            <Form.Control.Feedback type="invalid">
              {formik.errors.tiempoEstimadoCocina}
            </Form.Control.Feedback>
          </Form.Group>

          <Modal.Footer>
            <Button variant="secondary" onClick={onHide}>
              Cancelar
            </Button>
            <Button variant="primary" type="submit" disabled={!formik.isValid}>
              Guardar
            </Button>
            {modalType === ModalType.DELETE && (
              <Button variant="danger" onClick={handleDelete}>
                Eliminar
              </Button>
            )}
          </Modal.Footer>
        </Form>
      </Modal.Body>
    </Modal>
  );
};

export default ArticuloManufacturadoModal;
