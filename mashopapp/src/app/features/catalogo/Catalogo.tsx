import { useEffect, useState } from "react";
import { Product } from "../../models/product";
import ProductList from "./ProductList";

export default function Catalogo(){

const [products, setProducts] = useState<Product[]>([]);
    useEffect( () => {
        fetch('http://localhost:9098/api/products')
        .then(response => response.json())
        .then(data => setProducts(data.content))
     },[]);
    return(
        <>
            <ProductList products={products} />
        </>
    )
}