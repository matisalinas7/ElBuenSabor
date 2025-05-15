import React from "react";
import "./../../assets/styles/aboutUs.css";
import { Card } from "react-bootstrap";

const AboutUs = () => {
  return (
    <section id="about-us" className="about-us-section">
      <div className="container">
        <div className="titulo">
          <h2>MENU</h2>
          <p>
            
          </p>
        </div>

        <div className="card-container">
          <Card className="card" style={{ width: "18rem" }}>
            <Card.Img
              variant="top"
              src="https://resizer.glanacion.com/resizer/v2/hamburguesa-blt-de-john-john-burger-bacon-lettuce-RHVGX3MHVRB7VGEXBEVCCZHW5I.jpg?auth=53776ee5a203ae1fbe457df3473f7c2d9470016ad51a458c73c5b950966a4f57&width=880&height=586&quality=70&smart=true"
              alt="boyero"
            />
            <Card.Body>
              <Card.Title>HAMBURGUESAS</Card.Title>
              <Card.Text>
                Some quick example text to build on the card title and make up
                the bulk of the card's content.
              </Card.Text>
            </Card.Body>
          </Card>

          <Card className="card" style={{ width: "18rem" }}>
            <Card.Img
              variant="top"
              src="https://cdn2.cocinadelirante.com/sites/default/files/images/2017/11/pizzacorrecta.jpg"
              alt="cocker"
            />
            <Card.Body>
              <Card.Title>PIZZAS</Card.Title>
              <Card.Text>
                Some quick example text to build on the card title and make up
                the bulk of the card's content.
              </Card.Text>
            </Card.Body>
          </Card>

          <Card className="card" style={{ width: "18rem" }}>
            <Card.Img
              variant="top"
              src="https://img.freepik.com/foto-gratis/bebidas-gaseosas-coloridas-macro-disparo_53876-18225.jpg"
              alt="golden"
            />
            <Card.Body>
              <Card.Title>BEBIDAS</Card.Title>
              <Card.Text>
                Some quick example text to build on the card title and make up
                the bulk of the card's content.
              </Card.Text>
            </Card.Body>
          </Card>
        </div>
      </div>
    </section>
  );
};

export default AboutUs;
