import { createBrowserRouter } from "react-router-dom";
import App from "../App";
import HomeUi from "../../features/home/HomeUi";
import Catalogo from "../../features/catalogo/Catalogo";
import ContactUi from "../../features/contact/ContactUi";
import ProductDetails from "../../features/catalogo/ProductDetails";
import LoginUi from "../../features/login/LoginUi";
import RegisterUi from "../../features/register/RegisterUi";

export const router = createBrowserRouter([
    {
        path: '/',
        element: <App />,
        children: [
            { path: '', element: <HomeUi /> },
            { path: 'store', element: <Catalogo /> },
            { path: 'store/:id', element: <ProductDetails /> },
            { path: 'contact', element: <ContactUi /> },
            { path: 'login', element: <LoginUi /> },
            { path: 'register', element: <RegisterUi /> }
        ]
    }
])