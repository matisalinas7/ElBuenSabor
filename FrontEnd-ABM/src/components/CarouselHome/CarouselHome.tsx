import React from "react";
import { Carousel } from "react-bootstrap";

const CarouselHome = () => {
  return (
    <Carousel>
      <Carousel.Item>
        <img
          className="d-block w-100"
          style={{ maxHeight: "500px", objectFit: "cover" }}
          src="https://github.com/Zackgd/10Peso/blob/main/FrontEnd/Historias%20Julian/FONDO.png?raw=true"
          alt="perritos1"
        />
        <Carousel.Caption>
          <h3>First slide label</h3>
          <p>Nulla vitae elit libero, a pharetra augue mollis interdum.</p>
        </Carousel.Caption>
      </Carousel.Item>

      <Carousel.Item>
        <img
          className="d-block w-100"
          style={{ maxHeight: "500px", objectFit: "cover" }}
          src="https://www.bhmpics.com/downloads/wallpaper-food/57.top-view-fast-food-black-background-mock-up_23-2148321326.jpg"
          alt="perritos2"
        />
        <Carousel.Caption>
          <h3>Second slide label</h3>
          <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
        </Carousel.Caption>
      </Carousel.Item>

      <Carousel.Item>
        <img
          className="d-block w-100"
          style={{ maxHeight: "500px", objectFit: "cover" }}
          src="https://github.com/Zackgd/10Peso/blob/main/FrontEnd/Historias%20Julian/FONDO.png?raw=true"
          alt="perritos3"
        />
        <Carousel.Caption>
          <h3>Third slide label</h3>
          <p>
            Praesent commodo cursus magna, vel scelerisque nisl consectetur.
          </p>
        </Carousel.Caption>
      </Carousel.Item>
    </Carousel>
  );
};

export default CarouselHome;
