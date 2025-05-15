import { Routes, Route } from 'react-router-dom';
import * as React from 'react';
import RegisterPage from '../pages/RegisterPage';
import LoginPage from '../pages/login/LoginPage';

const Admin = React.lazy(() => import('../pages/admin/Admin'));
const Admin2 = React.lazy(() => import('../pages/admin/components/AbmFactura/FacturaTable'));
const Components = React.lazy(() => import('../pages/components/Components'));
const Home = React.lazy(() => import('../pages/home/Home'));

const PrivateRoute = React.lazy(() => import('./PrivateRoute'));

const Router: React.FC = () => (
  <Routes>
    <Route element={<Home />} path="/" />
    <Route element={<PrivateRoute element={<Admin />} />} path="/admin" />
    <Route element={<PrivateRoute element={<Admin2 />} />} path="/table" />
    <Route element={<Components />} path="/components" />
    <Route element={<LoginPage/>} path="/login" />
    <Route element={<RegisterPage/>} path="/register" />
  </Routes>
);

export default Router;
