import { Divider, Grid, Table, TableBody, TableCell, TableContainer, TableRow, Typography } from "@mui/material";
import axios from "axios";
import { useEffect, useState } from "react";
import { Product } from "../../models/product";
import { useParams } from "react-router-dom";
import NotFound from "../../errors/NotFoundError";


export default function ProductDetails(){

    const extractImageName = (item: Product): string  | null => {
        if(item && item.pictureUrl){
            const partUrl = item.pictureUrl.split('/');
            if(partUrl.length > 0){
                return partUrl[partUrl.length-1];
            }
        }
        return null;
    }

    const formatarPrice = (price: number): string =>{
        return new Intl.NumberFormat('pt-Br',{
            minimumFractionDigits:2
        }).format(price)
    }

    const {id} = useParams<{id: string}>();
    const [product, setProduct] = useState<Product | null>();
    const [loading, setLoading] = useState(true);


    useEffect( () => {
        axios.get(`http://localhost:9098/api/products/${id}`)
        .then(response => setProduct(response.data))
        .catch(error => console.error(error))
        .finally( () => setLoading(false));
    }, [id])
    if(loading) return <h3>Loading...</h3>
    if((!product)) return <NotFound />
    return(
        <Grid container spacing={6}>
            <Grid item xs={6}>
                <img src={"/images/product/"+extractImageName(product)} alt={product.name} style={{width:'100%'}} />
            </Grid>
            <Grid item xs={6}>
                <Typography>{product.name}</Typography>
                <Divider sx={{mb:2}} />
                <Typography gutterBottom color='secondary' variant="h4">R$, {formatarPrice(product.price)}</Typography>
                <TableContainer>
                    <Table>
                        <TableBody>
                            <TableRow>
                                <TableCell>Name</TableCell>
                                <TableCell>{product.name}</TableCell>
                            </TableRow>
                            <TableRow>
                                <TableCell>Description</TableCell>
                                <TableCell>{product.description}</TableCell>
                            </TableRow>
                            <TableRow>
                                <TableCell>Type</TableCell>
                                <TableCell>{product.type}</TableCell>
                            </TableRow>
                            <TableRow>
                                <TableCell>Brand</TableCell>
                                <TableCell>{product.brand}</TableCell>
                            </TableRow>
                        </TableBody>
                    </Table>
                </TableContainer>
            </Grid>
        </Grid>
    );
}