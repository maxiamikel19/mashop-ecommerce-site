import { useEffect, useState } from "react"

function App() { 
  const [products, setProducts] = useState([]);

// useEffect( () => {
//   const fetchData = async () =>{
//     try{
//       const response = await fetch('http://localhost:9098/api/products');
//       if(!response.ok){
//           throw new Error('Error ao conectar com o banco');
//       }
//       const data = await response.json();
//       setProducts(data.content);
//     }catch(error){
//       console.error("Error: ", error)
//     }
//   };
//   fetchData();
// }, []);

useEffect( () => {
  fetch('http://localhost:9098/api/products')
  .then(response => response.json())
  .then(data => setProducts(data.content))
},[]);
  return (
    <div>
        <h1>MaShop, your choice</h1>
        {products.map(products => (
          <div key={products.id}>
            <p>Name: {products.name}</p>
            <p>Description: {products.Description}</p>
            <p>Price: {products.price}</p>
            <p>Price: {products.brand}</p>
            <p>Price: {products.type}</p>
          </div>
        ))}

        <button onClick={ () => setProducts}>TEste</button>
        <div>
          
        </div>
    </div>
  )
}

export default App
