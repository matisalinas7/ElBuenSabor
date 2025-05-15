import CarouselHome from "../../components/CarouselHome/CarouselHome";
import AboutUs from "../../components/About Us/AboutUs";
import React from "react";
import Footer from "../../components/Footer/Footer";

const Home: React.FC = () => {
  return (
    <div>
       {/* Ahora, añade los componentes CarouselHome y AboutUs */}
      <CarouselHome />
      <AboutUs />
    </div>
  );
};

export default Home;