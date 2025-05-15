import Button from 'react-bootstrap/Button';
import Col from 'react-bootstrap/Col';
import Form from 'react-bootstrap/Form';
import Modal from 'react-bootstrap/Modal';
import * as React from 'react';
import Row from 'react-bootstrap/Row';

import { ArticuloManufacturado } from '../../../types/ArtuculoManufacturado';

type DeleteProductModalProps = {
  onHide: () => void;
  onSave: (p: ArticuloManufacturado) => void;
  ArticuloManufacturado: ArticuloManufacturado | null;
  show: boolean;
};

const DeleteProductModal: React.FC<DeleteProductModalProps> = ({ onSave, onHide, ArticuloManufacturado, show }) => {
  // State
  const [validated, setValidated] = React.useState<boolean>(false);

  // Handlers
  const handleSubmit = (event: React.FormEvent<HTMLFormElement>) => {
    const form = event.currentTarget;

    event.preventDefault();
    event.stopPropagation();

    if (form.checkValidity() === false) {
      setValidated(true);

      return;
    }

    const data = Object.fromEntries(new FormData(form));
    onSave({ ...ArticuloManufacturado!, ...data });
  };

  // Render
  return (
    <Modal show={show} onHide={onHide}>
      <Form noValidate onSubmit={handleSubmit} validated={validated}>
        <Modal.Header closeButton>
          <Modal.Title>{ArticuloManufacturado?.id === 0 ? 'Create' : 'Edit'} ArticuloManufacturado</Modal.Title>
        </Modal.Header>
        <Modal.Body>
          <Row className="mb-3">
            <Form.Group as={Col}>
              <Form.Label>Titulo</Form.Label>
              <Form.Control
                defaultValue={ArticuloManufacturado?.nombre}
                name="title"
                placeholder="Title"
                required
                type="text"
              />
            </Form.Group>
          </Row>
          <Row className="mb-3">
            <Form.Group as={Col}>
              <Form.Label>Descripcion</Form.Label>
              <Form.Control
                defaultValue={ArticuloManufacturado?.descripcion}
                name="description"
                placeholder="Description"
                required
                type="text"
              />
            </Form.Group>
          </Row>
         
          <Row className="mb-3">
            <Form.Group as={Col}>
              <Form.Label>Precio Venta</Form.Label>
              <Form.Control
                defaultValue={ArticuloManufacturado?.precioVenta}
                name="price"
                placeholder="Price"
                required
                type="text"
              />
            </Form.Group>
          </Row>
        </Modal.Body>
        <Modal.Footer>
          <Button variant="secondary" onClick={onHide}>
            Close
          </Button>
          <Button type="submit" variant="primary">
            Save
          </Button>
        </Modal.Footer>
      </Form>
    </Modal>
  );
};

export default DeleteProductModal;
