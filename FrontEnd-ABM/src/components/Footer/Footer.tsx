import React from 'react';

const Footer: React.FC = () => {
  return (
    <footer className=" text-center py-3" style={{ backgroundColor: '#EFDECD' }}>
      <div className="container">
        <img
          src="https://raw.githubusercontent.com/Zackgd/10Peso/4afad3151c6b78d01aa2f6ef544ae18974db6366/logonombre.svg"
          alt="Logo"
          width="50"
          height="50"
          className="d-inline-block align-text-center mb-2"
        />
        <p>&copy; 2023 Tu Empresa. Todos los derechos reservados.</p>
      </div>
    </footer>
  );
};

export default Footer;