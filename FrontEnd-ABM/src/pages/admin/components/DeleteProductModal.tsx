import Button from 'react-bootstrap/Button';
import Modal from 'react-bootstrap/Modal';
import * as React from 'react';

import { ArticuloManufacturado } from '../../../types/ArtuculoManufacturado';

type DeleteProductModalProps = {
  onDelete: () => void;
  onHide: () => void;
  ArticuloManufacturado: ArticuloManufacturado | null;
  show: boolean;
};


const DeleteProductModal: React.FC<DeleteProductModalProps> = ({ onDelete, onHide, ArticuloManufacturado, show }) => (
  <Modal show={show} onHide={onHide}>
    <Modal.Header closeButton>
      <Modal.Title>Delete Product</Modal.Title>
    </Modal.Header>
    <Modal.Body>Are you sure you want to delete the following product: <strong>{ArticuloManufacturado?.nombre}</strong>?</Modal.Body>
    <Modal.Footer>
      <Button variant="secondary" onClick={onHide}>
        Close
      </Button>
      <Button variant="danger" onClick={onDelete}>
        Delete
      </Button>
    </Modal.Footer>
  </Modal>
);

export default DeleteProductModal;
