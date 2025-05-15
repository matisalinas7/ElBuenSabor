import Container from 'react-bootstrap/Container';
import { Link } from 'react-router-dom';
import Nav from 'react-bootstrap/Nav';
import Navbar from 'react-bootstrap/Navbar';
import { useNavigate } from 'react-router-dom';
import useIsLoggedIn from '../../hooks/useIsLoggedIn';
import DropdownButton from 'react-bootstrap/esm/DropdownButton';
import { Button, Dropdown } from 'react-bootstrap';
import React from 'react';



const NavBar: React.FC = () => {
  const navigate = useNavigate();
  const isLoggedIn: boolean = useIsLoggedIn();
  console.log('isLoggedIn in NavBar:', isLoggedIn);

  function onLogOut() {
    console.log('Logging out...');
    // Remover información de inicio de sesión del localStorage
    window.localStorage.removeItem('isLoggedIn');
    navigate('/');
  }

  // Render
  return (
    <Navbar expand="lg" className="bg-body-tertiary" style={{ backgroundColor: '#EFDECD' }}>
      <Container>
        <Navbar.Brand as={Link} to="/">
          <img
            src="https://raw.githubusercontent.com/Zackgd/10Peso/dc50ea0fc67d0a106b1dd56267827eb0b88d5d32/logonombre.svg"
            width="30"
            height="30"
            className="d-inline-block align-top"
            alt="Logo"/> EL BUEN SABOR
        </Navbar.Brand>
        <Navbar.Toggle aria-controls="basic-navbar-nav" />
        <Navbar.Collapse id="basic-navbar-nav">
          <Nav className="ml-auto me-auto align-items-center">
            <Nav.Link as={Link} to="/">Home</Nav.Link>
            <DropdownButton id="dropdown-basic-button" title="Admin" Button variant="secondary">
              <Dropdown.Item as={Link} to="/admin">Articulos</Dropdown.Item>
              <Dropdown.Item as={Link} to="/table">Facturas</Dropdown.Item>
              <Dropdown.Item as={Link} to="/admin#action-3">Something else</Dropdown.Item>
            </DropdownButton>
            <Nav.Link as={Link} to="/login" className="ml-auto">
              <Button variant="secondary">
                Iniciar Sesión
              </Button>
            </Nav.Link>
            <Nav.Link as={Link} to="/register" className="ml-auto">
              <Button variant="secondary">
                Registrarse
              </Button>
            </Nav.Link>
            {isLoggedIn && (
              <Button variant="danger" onClick={onLogOut} className="ml-auto">
                Cerrar Sesión
              </Button>
            )}
          </Nav>
        </Navbar.Collapse>
      </Container>
    </Navbar>
  );
};

export default NavBar; 