import { Button, Form, Modal } from "react-bootstrap";
import { useFormik } from "formik";
import { toast } from "react-toastify";
import { ArticuloInsumo } from "../../../../types/ArticuloInsumo";
import { ModalType } from "../../../../types/ModalType";
import { ArticuloInsumoService } from "../../../../services/ArticuloInsumoService";
import React from "react";

type ArticuloInsumoModalProps = {
  show: boolean;
  onHide: () => void;
  title: string;
  modalType: ModalType;
  articulo: ArticuloInsumo;
  refreshData: React.Dispatch<React.SetStateAction<boolean>>;
};

const ArticuloInsumoModal: React.FC<ArticuloInsumoModalProps> = ({
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
    onSubmit: (formData: ArticuloInsumo) => handleSave(formData),
  });

  const handleSave = async (formData: ArticuloInsumo) => {
    try {
      if (modalType === ModalType.CREATE) {
        await ArticuloInsumoService.addArticulo(formData);
      } else if (modalType === ModalType.UPDATE) {
        await ArticuloInsumoService.updateArticulo(formData.id, formData);
      } else if (modalType === ModalType.DELETE) {
        handleDelete();
        return;
      }

      toast.success(
        modalType === ModalType.CREATE
          ? "Articulo Insumo Creado"
          : "Articulo Insumo Actualizado",
        {
          position: "top-center",
        }
      );

      onHide();
      refreshData((prevState) => !prevState);
    } catch (error) {
      console.error("Error saving Articulo Insumo:", error);
      toast.error("Ha ocurrido un error");
    }
  };
  const handleDelete = async () => {
    try {
      if (articulo.id) {
        await ArticuloInsumoService.deleteArticulo(articulo.id);
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

          <Form.Group controlId="formPrecioCompra">
            <Form.Label>Precio de Compra</Form.Label>
            <Form.Control
              name="precioCompra"
              type="number"
              value={formik.values.precioCompra || ""}
              onChange={formik.handleChange}
              onBlur={formik.handleBlur}
              isInvalid={Boolean(
                formik.errors.precioCompra && formik.touched.precioCompra
              )}
            />
            <Form.Control.Feedback type="invalid">
              {formik.errors.precioCompra}
            </Form.Control.Feedback>
          </Form.Group>

          <Form.Group controlId="formStockActual">
            <Form.Label>Stock Actual</Form.Label>
            <Form.Control
              name="stockActual"
              type="number"
              value={formik.values.stockActual || ""}
              onChange={formik.handleChange}
              onBlur={formik.handleBlur}
              isInvalid={Boolean(
                formik.errors.stockActual && formik.touched.stockActual
              )}
            />
            <Form.Control.Feedback type="invalid">
              {formik.errors.stockActual}
            </Form.Control.Feedback>
          </Form.Group>

          <Form.Group controlId="formStockMinimo">
            <Form.Label>Stock Mínimo</Form.Label>
            <Form.Control
              name="stockMinimo"
              type="number"
              value={formik.values.stockMinimo || ""}
              onChange={formik.handleChange}
              onBlur={formik.handleBlur}
              isInvalid={Boolean(
                formik.errors.stockMinimo && formik.touched.stockMinimo
              )}
            />
            <Form.Control.Feedback type="invalid">
              {formik.errors.stockMinimo}
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

export default ArticuloInsumoModal;
